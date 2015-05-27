/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base.client;

import base.IRepository;
import entity.Cliente;
import java.util.ArrayList;

/**
 *
 * @author prote_000
 */
public interface IClientRepository extends IRepository<Cliente>{
    public ArrayList<Cliente> queryAll();
    public Boolean delete(int clientId);
}
