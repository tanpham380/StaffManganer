/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author phamt
 */
public class ManagerList   {
    ArrayList<Manager> ManagerList;
    public ManagerList(){
       
        ManagerList = new ArrayList();
    }
    public boolean AddManager(Manager M){
        return ManagerList.add(M);
    }
    public boolean DisplayManager(){
        if(ManagerList.isEmpty()) return false;
        for(int i=0; i<ManagerList.size(); i++) ManagerList.get(i).OutputMangaer();
        return true;
    }
    /// find staff by id
    public int FindManager(int id){
        for(int i=0; i<ManagerList.size(); i++ ) if ( ManagerList.get(i).getID() == id) return i;
            return -1;
    }
    /// SearchStaff by ID tra ve Staff
    public Manager SearchManager(int id){
        for(int i=0; i<ManagerList.size(); i++ ) if ( ManagerList.get(i).getID() == id) return ManagerList.get(i);
        return null;
    }
    //Update by ID Staff
    public boolean UpdateManager(int id){
        Manager tmp = SearchManager(id);
        if (tmp==null) return false;
        tmp.setID(id);
        tmp.AddManager();
     return true;   
    }
    public boolean RemoveManager(int id){
        Manager tmp= SearchManager(id);
        if(tmp==null) return false;
        return ManagerList.remove(tmp);
    }
    public boolean SortByID( ){
        if(ManagerList.isEmpty()) return false;
        Collections.sort(ManagerList);
        return true;
    }
    
}
