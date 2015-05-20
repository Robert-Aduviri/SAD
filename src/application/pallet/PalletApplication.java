/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.pallet;

import base.pallet.IPalletRepository;
import entity.Pallet;
import infraestructure.pallet.PalletRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author prote_000
 */
public class PalletApplication {
    private IPalletRepository palletRepository;
    
    public PalletApplication(){
        this.palletRepository = new PalletRepository();
    }
    
    public ArrayList<Pallet> queryPalletsByRack(int rackId){
        ArrayList<Pallet> pallets = null;
        try {
            pallets = palletRepository.queryPalletsByRack(rackId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pallets;
    }
}
