/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.order;

import base.order.IOrderRepository;
import entity.Cliente;
import entity.Pedido;
import entity.PedidoParcial;
import entity.PedidoParcialXProducto;
import infraestructure.order.OrderRepository;
import java.util.ArrayList;
import util.EntityType;

/**
 *
 * @author Alonso
 */
public class OrderApplication {
    
    IOrderRepository orderRepository;
    
    public OrderApplication(){
        this.orderRepository = new OrderRepository();
    }
    
    public ArrayList<Pedido> getAllOrders(){
        ArrayList<Pedido> orders=null;
        try{
            orders=orderRepository.queryAll();
        }catch(Exception e){
            e.printStackTrace();
        }
        return orders;
    }
    
    public Cliente getOrderClient(Integer clientId){
        Cliente client = null;
        try{
            client = orderRepository.queryOrderClientById(clientId);
        }catch(Exception e){
            e.printStackTrace();
        }
        return client;
    }
    
    public Boolean CreateOrder(Pedido order, PedidoParcial p, ArrayList<PedidoParcialXProducto> pp){
        Boolean response = false;
        try {
            response = orderRepository.createOrder(order, p, pp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
    
    public Boolean updateOrder(Pedido order){
        Boolean response = false;
        try {
            response = orderRepository.updateOrder(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
    
    public void refreshOrders(){
        EntityType.ORDERS = getAllOrders();
    }

    public ArrayList<PedidoParcial> getPendingPartialOrders() {
        ArrayList<PedidoParcial> partialOrders = new ArrayList<>();
        try{
            partialOrders = orderRepository.queryAllPendingPartialOrders();
        }catch(Exception e){
            e.printStackTrace();
        }
        return partialOrders;
    }
    
    public ArrayList<PedidoParcial> getPendingPartialOrdersById(Integer id) {
        ArrayList<PedidoParcial> partialOrders = new ArrayList<>();
        try{
            partialOrders = orderRepository.queryAllPendingPartialOrdersById(id);
        }catch(Exception e){
            e.printStackTrace();
        }
        return partialOrders;
    }
    
    public ArrayList<PedidoParcialXProducto> queryAllPartialOrderProducts(Integer partialOrderId){
        ArrayList<PedidoParcialXProducto> partialProducts = new ArrayList<>();
        try{
            partialProducts = orderRepository.queryAllPartialOrderProducts(partialOrderId);
        }catch(Exception e){
            e.printStackTrace();
        }
        return partialProducts;
    }
    
    public ArrayList<Pedido> searchOrders(Pedido o){
        ArrayList<Pedido> order=null;
        try{
            order=orderRepository.searchOrder(o);
        }catch(Exception e){
            e.printStackTrace();
        }
        return order;
    }
        
}