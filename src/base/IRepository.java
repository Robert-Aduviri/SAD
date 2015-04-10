/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import java.util.ArrayList;

/**
 *
 * @author dabarca
 */
public interface IRepository<T> {
    void insert();
    void delete();
    ArrayList<T> queryAll();
    void update(T object);
    T queryById(int id);
    T queryById(String id);
}
