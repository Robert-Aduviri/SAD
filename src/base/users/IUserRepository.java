/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base.users;

import base.IRepository;
import Domain.Usuario;

/**
 *
 * @author dabarca
 */
public interface IUserRepository extends IRepository{
   Usuario getUser(String email, String password); 
}
