 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infraestructure.order;

import application.order.OrderApplication;
import base.order.IOrderRepository;
import entity.Cliente;
import entity.GuiaRemision;
import entity.Pallet;
import entity.Pedido;
import entity.PedidoParcial;
import entity.PedidoParcialXProducto;
import entity.PedidoParcialXProductoId;
import entity.Producto;
import java.util.ArrayList;
import java.util.Iterator;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.EntityState;
import util.Tools;

/**
 *
 * @author Alonso
 */
public class OrderRepository implements IOrderRepository{
    
    @Override
    public Boolean createOrder(Pedido order, PedidoParcial partialOrder, ArrayList<PedidoParcialXProducto> products){
        Session session = Tools.getSessionInstance();
        Transaction trns = null; 
        try {            
            trns=session.beginTransaction();
            session.save(order);     
            int partialId = (int)session.save(partialOrder);
            for(int i=0;i<products.size();i++){
                products.get(i).getId().setIdPedidoParcial(partialId);
                Integer stock = products.get(i).getProducto().getStockLogico();
                products.get(i).getProducto().setStockLogico(stock - products.get(i).getCantidad());
                session.update(products.get(i).getProducto());
                session.save(products.get(i));
            }
            session.getTransaction().commit();
            return true;
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public Boolean createRemissionGuides(ArrayList<PedidoParcial> acceptedOrders, ArrayList<GuiaRemision> remissionGuides) {
        Session session = Tools.getSessionInstance();
        Transaction trns = null; 
        try {            
            trns=session.beginTransaction();
            for(int i=0;i<acceptedOrders.size();i++){
                session.save(acceptedOrders.get(i));
                session.save(remissionGuides.get(i));
            }
            session.getTransaction().commit();
            return true;
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public Boolean createPartialOrders(ArrayList<PedidoParcial> acceptedOrders, ArrayList<PedidoParcial> rejectedOrders) {
        Session session = Tools.getSessionInstance();
        Transaction trns = null; 
        try {            
            trns=session.beginTransaction();
            System.out.println("Cantidad de Acepted Orders " + acceptedOrders.size());
            ArrayList<Integer>previousAcceptedOrdersId = new ArrayList<>();
            for(int i=0;i<acceptedOrders.size();i++){
                if(!previousAcceptedOrdersId.contains(acceptedOrders.get(i).getPedido().getId())){
                    previousAcceptedOrdersId.add(acceptedOrders.get(i).getPedido().getId());
                    ArrayList<PedidoParcial> oldOrders = queryAllLocalPendingPartialOrdersById(acceptedOrders.get(i).getPedido().getId(),session, trns);
                    for(int j=0;j<oldOrders.size();j++){
                        oldOrders.get(j).setEstado(EntityState.PartialOrders.ANULADO.ordinal());
                        session.update(oldOrders.get(j));
                    }
                }
                Integer partialOrderId = (Integer)session.save(acceptedOrders.get(i));
                for(Iterator<PedidoParcialXProducto> partialOrderDetail = acceptedOrders.get(i).getPedidoParcialXProductos().iterator(); partialOrderDetail.hasNext();){
                    PedidoParcialXProducto p = partialOrderDetail.next();          
                    PedidoParcialXProductoId id = new PedidoParcialXProductoId();
                    id.setIdPedidoParcial(partialOrderId);
                    id.setIdProducto(p.getProducto().getId());
                    p.setId(id);
                    session.save(p);
                                               
                    ArrayList<Pallet> pallets = getAvailablePalletsByProductId(p.getProducto().getId(), session, trns);
                    ArrayList<Pallet> selectedPallets = new ArrayList<>();
                    System.out.println("CODIGO PEDIDO " + p.getPedidoParcial().getPedido().getId());
                    System.out.println("PRODUCTOS PEDIDO  " + p.getProducto().getId() + " " + p.getProducto().getNombre());
                    System.out.println("CANTIDAD DE PALLETSPEDIDOS " + p.getCantidad());
                    for(int j=0;j<p.getCantidad();j++){
                        Pallet selectedPallet;
                        selectedPallet = pallets.get(j);
                        selectedPallet.setEstado(EntityState.Pallets.DESPACHADO.ordinal());                  
                        selectedPallet.setPedidoParcial(p.getPedidoParcial());
                        selectedPallets.add(selectedPallet);
                    }
                    updatePallets(selectedPallets, session, trns);
                }
            }
            System.out.println("Cantidad de Rejected Orders " + rejectedOrders.size());
            ArrayList<Integer>previousRejectedOrdersId = new ArrayList<>();
            for(int i=0;i<rejectedOrders.size();i++){
                if(!previousRejectedOrdersId.contains(rejectedOrders.get(i).getPedido().getId())){
                    previousRejectedOrdersId.add(rejectedOrders.get(i).getPedido().getId());
                    ArrayList<PedidoParcial> oldOrders = queryAllLocalPendingPartialOrdersById(rejectedOrders.get(i).getPedido().getId(),session, trns);
                    for(int j=0;i<oldOrders.size();i++){
                        oldOrders.get(j).setEstado(EntityState.PartialOrders.ANULADO.ordinal());
                        session.update(oldOrders.get(j));
                    }
                }
                Integer partialOrderId = (Integer)session.save(rejectedOrders.get(i));
                for(Iterator<PedidoParcialXProducto> partialOrderDetail = rejectedOrders.get(i).getPedidoParcialXProductos().iterator(); partialOrderDetail.hasNext();){
                    PedidoParcialXProducto p = partialOrderDetail.next();          
                    PedidoParcialXProductoId id = new PedidoParcialXProductoId();
                    id.setIdPedidoParcial(partialOrderId);
                    id.setIdProducto(p.getProducto().getId());
                    p.setId(id);
                    session.save(p);
                }
            }
            session.getTransaction().commit();
            return true;
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }
    
    
    @Override
    public Boolean updateOrder(Pedido order){
        Session session = Tools.getSessionInstance();
        Transaction trns = null;
        try {            
            trns=session.beginTransaction();
            for(Iterator<PedidoParcial> partialOrder = order.getPedidoParcials().iterator(); partialOrder.hasNext();){
                PedidoParcial p = partialOrder.next();
                p.setEstado(EntityState.PartialOrders.ANULADO.ordinal());
                session.update(p);
            }
            session.update(order);                      
            session.getTransaction().commit();
            return true;
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
            return false;
        }     
    }
    
    @Override
    public Cliente queryOrderClientById(Integer clientId){
        Cliente client = new Cliente();
        Session session = Tools.getSessionInstance();
        String hql = "from Cliente where id=:id";
        Transaction trns = null;
        try{
            trns = session.beginTransaction();
            Query q = session.createQuery(hql);
            q.setParameter("id", clientId);
            client = (Cliente) q.uniqueResult();
            session.getTransaction().commit();
        }
        catch (RuntimeException e){
            if(trns != null){
                trns.rollback();
            }
            e.printStackTrace();
        }
        return client;
    }
    
    @Override
    public ArrayList<PedidoParcial> queryAllPendingPartialOrders(){
                Session session = Tools.getSessionInstance();
        String hql = "from PedidoParcial where estado=1";
        ArrayList<PedidoParcial> partialOrders = new ArrayList<>();
        Transaction trns = null;
        try{
            trns = session.beginTransaction();
            Query q = session.createQuery(hql);
            partialOrders = (ArrayList<PedidoParcial>) q.list();
            session.getTransaction().commit();
        }
        catch (RuntimeException e){
            if(trns != null){
                trns.rollback();
            }
            e.printStackTrace();
        }
        return partialOrders;
    }
    
    @Override
    public ArrayList<PedidoParcialXProducto> queryAllProductsByOrderId(Integer id){
        Session session = Tools.getSessionInstance();
        String hql = "from PedidoParcialXProducto where id_pedido_parcial in (select id from PedidoParcial where id_pedido=:id)";
        ArrayList<PedidoParcialXProducto> partialOrders = new ArrayList<>();
        Transaction trns = null;
        try{
            trns = session.beginTransaction();
            Query q = session.createQuery(hql);
            q.setParameter("id", id);
            partialOrders = (ArrayList<PedidoParcialXProducto>) q.list();
            session.getTransaction().commit();
        }
        catch (RuntimeException e){
            if(trns != null){
                trns.rollback();
            }
            e.printStackTrace();
        }
        return partialOrders;
    }
    
    public ArrayList<PedidoParcial> queryAllLocalPendingPartialOrdersById(Integer id, Session session,Transaction trns){
        //Session session = Tools.getSessionInstance();
        String hql = "from PedidoParcial where (estado=1 or estado=0) and id_pedido=:id";
        ArrayList<PedidoParcial> partialOrders = new ArrayList<>();
        //Transaction trns = null;
        try{
            //trns = session.beginTransaction();
            Query q = session.createQuery(hql);
            q.setParameter("id", id);
            partialOrders = (ArrayList<PedidoParcial>) q.list();
            //session.getTransaction().commit();
        }
        catch (RuntimeException e){
            if(trns != null){
                trns.rollback();
            }
            e.printStackTrace();
        }
        return partialOrders;
    }
    
    @Override
    public ArrayList<PedidoParcial> queryAllPendingPartialOrdersById(Integer id){
        Session session = Tools.getSessionInstance();
        String hql = "from PedidoParcial where (estado=1 or estado=0) and id_pedido=:id";
        ArrayList<PedidoParcial> partialOrders = new ArrayList<>();
        Transaction trns = null;
        try{
            trns = session.beginTransaction();
            Query q = session.createQuery(hql);
            q.setParameter("id", id);
            partialOrders = (ArrayList<PedidoParcial>) q.list();
            session.getTransaction().commit();
        }
        catch (RuntimeException e){
            if(trns != null){
                trns.rollback();
            }
            e.printStackTrace();
        }
        return partialOrders;
    }
    
    @Override
    public ArrayList<PedidoParcialXProducto> queryAllPartialOrderProducts(Integer partialOrderId){
                Session session = Tools.getSessionInstance();
        String hql = "from PedidoParcialXProducto where id_pedido_parcial=:partialId";
        ArrayList<PedidoParcialXProducto> partialProducts = new ArrayList<>();
        Transaction trns = null;
        try{
            trns = session.beginTransaction();
            Query q = session.createQuery(hql);
            q.setParameter("partialId", partialOrderId);
            partialProducts = (ArrayList<PedidoParcialXProducto>) q.list();
            session.getTransaction().commit();
        }
        catch (RuntimeException e){
            if(trns != null){
                trns.rollback();
            }
            e.printStackTrace();
        }
        return partialProducts;
    }
    
    public ArrayList<Pedido> searchOrder(Pedido order){
        String hql="from Pedido "
                + "where (:id is null or id=:id) and (:id_local is null or id_local=:id_local)"
                + "and (:status is null or estado=:status) and (:id_cliente is null or id_cliente=:id_cliente) order by id desc";
        ArrayList<Pedido> orders=null;
        
        Transaction trns = null;
        Session session = Tools.getSessionInstance();
        try {            
            trns=session.beginTransaction();
            Query q = session.createQuery(hql);
            q.setParameter("id", order.getId());
            q.setParameter("id_local", order.getLocal().getId());
            q.setParameter("status", order.getEstado());
            q.setParameter("id_cliente", order.getCliente().getId());
            orders = (ArrayList<Pedido>) q.list();             
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } 
        return orders;
    }
    
    @Override
    public int insert(Pedido object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Pedido object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Pedido> queryAll() {
        Session session = Tools.getSessionInstance();
        String hql = "from Pedido where estado=1 order by id desc";
        ArrayList<Pedido> orders = new ArrayList<>();
        Transaction trns = null;
        try{
            trns = session.beginTransaction();
            Query q = session.createQuery(hql);
            orders = (ArrayList<Pedido>) q.list();
            session.getTransaction().commit();
        }
        catch (RuntimeException e){
            if(trns != null){
                trns.rollback();
            }
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public int update(Pedido object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pedido queryById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pedido queryById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Pedido> queryAllOrders() {
        Session session = Tools.getSessionInstance();
        String hql = "from Pedido order by id desc";
        ArrayList<Pedido> orders = new ArrayList<>();
        Transaction trns = null;
        try{
            trns = session.beginTransaction();
            Query q = session.createQuery(hql);
            orders = (ArrayList<Pedido>) q.list();
            session.getTransaction().commit();
        }
        catch (RuntimeException e){
            if(trns != null){
                trns.rollback();
            }
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public Boolean updatePartialOrder(PedidoParcial p, ArrayList<Pallet> pallets) {
        Session session = Tools.getSessionInstance();
        Transaction trns = null;
        try {            
            trns=session.beginTransaction();
            for(int i=0;i<pallets.size();i++){
                session.update(pallets.get(i));
            }
            System.out.println(p.getPedido().getEstado());
            session.update(p.getPedido());
            session.update(p);                      
            session.getTransaction().commit();
            return true;
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
            return false;
        }  
    }
    
    public ArrayList<Pallet> getAvailablePalletsByProductId(Integer productId, Session session, Transaction trns){
        String hql="FROM Pallet WHERE id_producto=:productId and estado=1";
        ArrayList<Pallet> pallets= new ArrayList<>();  
        try {            
            Query q = session.createQuery(hql);
            q.setParameter("productId", productId);
            pallets = (ArrayList<Pallet>) q.list();          
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
        return pallets;  
    }
    
    public Boolean updatePallets(ArrayList<Pallet> pallets, Session session, Transaction trns) {
        try {            
            for(int i=0;i<pallets.size();i++){
                session.update(pallets.get(i));
            }                  
            return true;
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

}
