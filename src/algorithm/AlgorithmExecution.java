/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import algorithm.operators.Selection;
import algorithm.operators.Crossover;
import algorithm.operators.LocalSearch;
import algorithm.operators.Mutation;
import algorithm.operators.ObjectiveFunction;
import algorithm.operators.Repair;
import application.order.OrderApplication;
import application.pallet.PalletApplication;
import entity.Cliente;
import entity.Despacho;
import entity.GuiaRemision;
import entity.Pallet;
import entity.PedidoParcial;
import entity.PedidoParcialXProducto;
import entity.Producto;
import entity.UnidadTransporte;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import util.EntityState;

/**
 *
 * @author robert
 */
public class AlgorithmExecution {
    Problem problem;
    
    public Solution start(double maxTravelTime){
        long ini = System.currentTimeMillis();
        
        Algorithm algorithm = new Algorithm();
        algorithm.setNumberOfGenerations(0);
        algorithm.setPopulationSize(1);
        algorithm.setTournamentSelectionKValue(50);
        algorithm.setOvercapPenalty(10000);
        algorithm.setOvertimePenalty(10000);
        algorithm.setOverstockPenalty(10000);
        algorithm.setMutationRate(0.5f);
        algorithm.setMaxPriority(100);
        algorithm.setBasePriority(1.09);
        algorithm.setMaxTravelTime(maxTravelTime); 
        algorithm.setGraspAlpha(0.3);
        
        problem = new Problem();
        
        Population population = new Population(algorithm, problem);
        System.out.println("Se creo la población");
        
        Solution bestSolution = population.getBestSolution();
        System.out.println("bestSolution: " + bestSolution.getCost());
        
        //displayRoutes(bestSolution);
        
        
        
        for (int i = 0; i < algorithm.getNumberOfGenerations(); i++) {
            System.out.println("Generación: " + i);
            Solution[] parents = new Solution[2];
            parents[0] = population.getSolutions()[Selection.tournamentSelection(
                        algorithm.getTournamentSelectionKValue(), population, 
                        Selection.Options.BEST)];
            parents[1] = population.getSolutions()[Selection.tournamentSelection(
                        algorithm.getTournamentSelectionKValue(), population, 
                        Selection.Options.BEST)];
            Arrays.sort(parents);
            
            Solution child = Crossover.uniformCrossover(parents, algorithm, problem);
            
            //displayRoute(child);
            
            //child = Mutation.mutation(child, algorithm, problem);            
            child = LocalSearch.opt2Improvement(child, algorithm, problem);  
            
            
            
            double cost = ObjectiveFunction.getSolutionCost(child, algorithm, problem,
                problem.getProductsStock());
            if(cost>algorithm.getOvercapPenalty() || cost>algorithm.getOvertimePenalty() ||
                    cost>algorithm.getOverstockPenalty()){
                //child = Repair.repair(child, algorithm, problem);
                child.setCost(ObjectiveFunction.getSolutionCost(child, algorithm, problem, 
                        problem.getProductsStock()));
            }
            else
                child.setCost(cost);
            
            
            int replacedSolution = Selection.tournamentSelection(
                    algorithm.getTournamentSelectionKValue(), population, 
                    Selection.Options.WORST);
            
            System.out.println(child.getCost());
            
            population.getSolutions()[replacedSolution] = child;
        }
        long end = System.currentTimeMillis();
        System.out.println("Execution time: " + (end-ini) + "ms");
        
        bestSolution = population.getBestSolution();
        System.out.println("");
        System.out.println(displayRoutes(bestSolution));
        System.out.println("");
        System.out.println(displayDemand(bestSolution));
        
        /*for (int i = 0; i < bestSolution.getNodes().length; i++) {
            System.out.println("Costo de ruta: " + i + " : " + ObjectiveFunction.getRouteCost(null, route, null, null));            
        }*/
        
        //System.out.println("");
        //System.out.println(displayOrders(bestSolution));
        
        /*AlgorithmView algorithmView = new AlgorithmView(bestSolution);
        algorithmView.setBounds(0, 0, 700, 700);
        algorithmView.setVisible(true);*/
        
        
        return bestSolution;  
        
        
        
        //Here we can show the solution and the user can decide to run again the algorithm
        /*AlgorithmView window = new AlgorithmView(bestSolution);
        window.setBounds(0, 0, 700, 700);
        window.setVisible(true);*/
        
        //processOrders(bestSolution, problem);
        
    }
    
    public AlgorithmReturnValues processOrders(Solution solution){
        ArrayList<UnidadTransporte> vehicles = problem.getVehicles();               
        
        ArrayList<PedidoParcial> orders = problem.getOrders();
        ArrayList<ArrayList<PedidoParcialXProducto>> partialOrdersXProducts = problem.getPartialOrdersXProducts();        
        
        Node[][] nodes = solution.getNodes();
        ArrayList<PedidoParcial> rejectedOrders = new ArrayList<>();
        ArrayList<PedidoParcial> acceptedOrders = new ArrayList<>();
        ArrayList<Despacho> despachos = new ArrayList<>();
        for (int i = 0; i < nodes.length; i++) {
            Despacho despacho = new Despacho();
            despacho.setEstado(1); // <-- set estado
            despacho.setFechaDespacho(new Date());
            despacho.setUnidadTransporte(vehicles.get(i));
            //HashSet<Cliente> customers = new HashSet<>();
            HashSet<GuiaRemision> guiasRemision = new HashSet<>();
            HashMap<Cliente,GuiaRemision> customers = new HashMap<>();
            HashMap<PedidoParcial,PedidoParcial> toNewOrder = new HashMap<>();
            HashMap<PedidoParcialXProducto,PedidoParcialXProducto> toNewOrderXProduct = new HashMap<>();
            for (int j = 0; j < nodes[i].length; j++) {
                PedidoParcialXProducto orderXProduct = nodes[i][j].getOrderXProduct();
                PedidoParcial partialOrder = nodes[i][j].getPartialOrder();
                Cliente customer = partialOrder.getPedido().getCliente();
                if(!customers.containsKey(customer)){                     
                    GuiaRemision guia = new GuiaRemision();
                    guia.setCliente(customer);
                    guia.setDespacho(despacho);
                    guia.setEstado(1); // <-- set estado
                    guia.setPedidoParcials(new HashSet<>());
                    guiasRemision.add(guia);
                    customers.put(customer, guia); //para no perder la referencia a la guia
                }
                HashSet<PedidoParcial> partialOrders = (HashSet<PedidoParcial>) 
                        customers.get(customer).getPedidoParcials();
                if(!toNewOrder.containsKey(partialOrder)){
                    PedidoParcial newPartialOrder = new PedidoParcial();
                    newPartialOrder.setEstado(EntityState.PartialOrders.ATENDIDO.ordinal());
                    newPartialOrder.setGuiaRemision(customers.get(customer));
                    newPartialOrder.setPedido(partialOrder.getPedido());
                    newPartialOrder.setPedidoParcialXProductos(new HashSet<>());
                    acceptedOrders.add(newPartialOrder);
                    partialOrders.add(newPartialOrder);                    
                    toNewOrder.put(partialOrder,newPartialOrder); //para no perder la referencia al nuevo pedido parcial
                }
                PedidoParcial newPartialOrder = toNewOrder.get(partialOrder); //aqui se anhadiran los productos
                HashSet<PedidoParcialXProducto> orderXProducts = (HashSet<PedidoParcialXProducto>) 
                        newPartialOrder.getPedidoParcialXProductos();
                if(!toNewOrderXProduct.containsKey(orderXProduct)){
                    PedidoParcialXProducto newOrderXProduct = new PedidoParcialXProducto();
                    newOrderXProduct.setPedidoParcial(newPartialOrder);
                    newOrderXProduct.setProducto(nodes[i][j].getProduct());
                    newOrderXProduct.setCantidad(0);
                    orderXProducts.add(newOrderXProduct);
                    toNewOrderXProduct.put(orderXProduct, newOrderXProduct);
                }
                PedidoParcialXProducto newOrderXProduct = toNewOrderXProduct.get(orderXProduct);
                int newDemand = newOrderXProduct.getCantidad() +
                        nodes[i][j].getDemand();
                newOrderXProduct.setCantidad(newDemand);
            }
            despacho.setGuiaRemisions(guiasRemision);
            despachos.add(despacho);
        }
        
        //Primero se crea un par de hashmaps para almacenar la demanda de cada pedido parcial x producto
        //demand y demand2 tendra la demanda total y original del pedido parcial x producto        
        HashMap<PedidoParcial,HashMap<Producto,Integer>> demand = new HashMap<>();
        HashMap<PedidoParcial,HashMap<Producto,Integer>> demand2 = new HashMap<>();
        for (int i = 0; i < orders.size(); i++) {                        
            for (int j = 0; j < partialOrdersXProducts.get(i).size(); j++) {
                PedidoParcialXProducto pedParXProd = partialOrdersXProducts.get(i).get(j);
                Producto product = pedParXProd.getProducto();
                HashMap<Producto,Integer> hm = demand.get(orders.get(i));
                if(hm==null)
                    hm = new HashMap<>();
                hm.put(product, pedParXProd.getCantidad());
                demand.put(orders.get(i),hm);
                demand2.put(orders.get(i),hm);
            }
        }
        
        //ahora, a demand se le va disminuyendo la demanda debido a la solucion del algoritmo:
        //si hay locales que son atendidos por el algoritmo, se reduce el valor de la demanda original
        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < nodes[i].length; j++) {
                HashMap<Producto,Integer> hm = demand.get(nodes[i][j].getPartialOrder());
                int curDemand = hm.get(nodes[i][j].getProduct());
                hm.put(nodes[i][j].getProduct(), curDemand-nodes[i][j].getDemand());
                demand.put(nodes[i][j].getPartialOrder(), hm);
            }
        }
        
        //se crea un par de estructuras que representaran los pedidos parciales que se aceptan 
        //por el algoritmo y las ordenes que se rechazan
        //aqui es donde se dividen los pedidos parciales en mas pedidos parciales        
        /*for (int i = 0; i < orders.size(); i++) {
            PedidoParcial pedido = new PedidoParcial();
            pedido.setPedido(orders.get(i).getPedido());
            pedido.setEstado(EntityState.PartialOrders.ATENDIDO.ordinal());              
            acceptedOrders.add(pedido);
        }*/
        
        HashMap<PedidoParcial, PedidoParcial> toPedidoParcial = new HashMap<>();
        for (int i = 0; i < orders.size(); i++) {
            PedidoParcial pedido = new PedidoParcial();            
            pedido.setPedido(orders.get(i).getPedido());
            pedido.setEstado(EntityState.PartialOrders.NO_ATENDIDO.ordinal());              
            pedido.setPedidoParcialXProductos(new HashSet<>());
            rejectedOrders.add(pedido);
            toPedidoParcial.put(orders.get(i), pedido);
        }        
        
        //ahora se crea un par de estructuras mas que almacenaran
        //el detalle de los pedidos parciales que se crearon arriba
        //ArrayList<ArrayList<PedidoParcialXProducto>> acceptedOrdersXProd = new ArrayList<>();
        //ArrayList<ArrayList<PedidoParcialXProducto>> rejectedOrdersXProd = new ArrayList<>();
        for (int i = 0; i < orders.size(); i++) {
            //ArrayList<PedidoParcialXProducto> acceptedOrdersXProdOfOrder = new ArrayList<>();
            HashSet<PedidoParcialXProducto> rejectedOrdersXProdOfOrder = 
                    (HashSet<PedidoParcialXProducto>) toPedidoParcial.get(orders.get(i)).getPedidoParcialXProductos();
            HashMap<Producto,Integer> hm = demand.get(orders.get(i));
            HashMap<Producto,Integer> hm2 = demand2.get(orders.get(i));
            for (Map.Entry<Producto, Integer> entry : hm.entrySet()) {
                PedidoParcialXProducto row = new PedidoParcialXProducto();
                row.setProducto(entry.getKey());
                int totalDemand = hm2.get(entry.getKey());
                int servedDemand = totalDemand - entry.getValue();
                if(servedDemand==0){ //no atendida
                    row.setCantidad(totalDemand);
                    row.setPedidoParcial(rejectedOrders.get(i));
                    rejectedOrdersXProdOfOrder.add(row);
                }
                else if(servedDemand==totalDemand){ //atendida totalmente
                    /*row.setCantidad(totalDemand);
                    row.setPedidoParcial(acceptedOrders.get(i));
                    acceptedOrdersXProdOfOrder.add(row);*/
                }
                else{ //atendida parcialmente
                    /*PedidoParcialXProducto row2 = new PedidoParcialXProducto();//atendida
                    row2.setProducto(entry.getKey());
                    row2.setCantidad(servedDemand);
                    row2.setPedidoParcial(acceptedOrders.get(i));
                    acceptedOrdersXProdOfOrder.add(row2);*/
                    
                    row.setCantidad(totalDemand-servedDemand);//no atendida
                    row.setPedidoParcial(rejectedOrders.get(i));
                    rejectedOrdersXProdOfOrder.add(row);
                }
            }                       
            //acceptedOrdersXProd.add(acceptedOrdersXProdOfOrder);
            //rejectedOrdersXProd.add(rejectedOrdersXProdOfOrder);
        }
        
        Iterator<PedidoParcial> it = rejectedOrders.iterator();
        while(it.hasNext()){
            PedidoParcial rejectedOrder = it.next();
            HashSet<PedidoParcialXProducto> rejectedOrdersXProdOfOrder
                    = (HashSet<PedidoParcialXProducto>) rejectedOrder.getPedidoParcialXProductos();
            if (rejectedOrdersXProdOfOrder.isEmpty()) {
                it.remove();
            }
        }
        
        
        return new AlgorithmReturnValues(despachos, acceptedOrders, rejectedOrders);
    }

    public StringBuffer displayRoutes(Solution bestSolution) {
        StringBuffer buf = new StringBuffer();
        Node[][]nodes = bestSolution.getNodes();
        for (int i = 0; i < nodes.length; i++) {            
            buf.append("Ruta ").append(i).append("\n") ;           
            for (int j = 0; j < nodes[i].length; j++) {
                buf.append(nodes[i][j].getX()).append("/").append(nodes[i][j].getY()).
                        append("  ");                
            }
            buf.append("\n");
        }
        return buf;
    }
    
    public StringBuffer displayDemand(Solution bestSolution) {
        StringBuffer buf = new StringBuffer();
        Node[][]nodes = bestSolution.getNodes();
        for (int i = 0; i < nodes.length; i++) {  
            buf.append("Ruta ").append(i).append("\n") ;           
            int cap = 0; double time = 0;
            for (int j = 0; j < nodes[i].length; j++) {
                buf.append(nodes[i][j].getProduct().getId()).append("/").append(nodes[i][j].getDemand()).
                        append("/").append(nodes[i][j].getPartialOrder().getPedido().getId()).append("  ");
                cap += nodes[i][j].getDemand();
                if(j>0) time += ObjectiveFunction.distance(nodes[i][j-1].getIdx(), nodes[i][j].getIdx());
            }
            if(nodes[i].length>0) {
                time += ObjectiveFunction.distance(Problem.getLastNode(), nodes[i][0].getIdx());
                time += ObjectiveFunction.distance(nodes[i][nodes[i].length-1].getIdx(), Problem.getLastNode());
            }
            time /= 15;
            buf.append(cap + " " + time + "\n");
        }
        return buf;
    }
    
    public StringBuffer displayOrders(Solution bestSolution) {
        StringBuffer buf = new StringBuffer();
        Node[][]nodes = bestSolution.getNodes();
        for (int i = 0; i < nodes.length; i++) {            
            buf.append("Ruta ").append(i).append("\n") ;           
            for (int j = 0; j < nodes[i].length; j++) {
                buf.append(nodes[i][j].getPartialOrder().getPedido().getId()).
                        append("  ");                
            }
            buf.append("\n");
        }
        return buf;
    }
    
}
