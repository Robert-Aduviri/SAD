/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base.pallet;

import base.IRepository;
import entity.Pallet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author prote_000
 */
public interface IPalletRepository extends IRepository<Pallet>{
    ArrayList<Pallet> queryPalletsByRack(int rackId);
}