/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.profile;

import base.profile.IProfileRepository;
import entity.Perfil;
import infraestructure.profile.ProfileRepository;
import java.util.ArrayList;

/**
 *
 * @author dabarca
 */
public class ProfileApplication {
    private IProfileRepository profileRepository;
    
    public ProfileApplication(){
        this.profileRepository=new ProfileRepository();
    }
    
    public ArrayList<Perfil> getAllProfiles(){
        ArrayList<Perfil> profiles=null;
        try{
            profiles=profileRepository.queryAll();
        }catch(Exception e){
            e.printStackTrace();
        }
        return profiles;
    }
    
    public void saveProfile(Perfil profile){        
        try{
            profileRepository.update(profile);
        }catch(Exception e){
            e.printStackTrace();
        }       
    }
}