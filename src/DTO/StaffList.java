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
 * @author  SE151045

 */
public class StaffList {
    ArrayList<Staff> ArrayStaff;
    public StaffList(){
        ArrayStaff= new ArrayList();
        
    }
    public boolean AddStaffIntoList(Staff S){
        return ArrayStaff.add(S);
    }
    public boolean DisplayStaffList(){
        if(ArrayStaff.isEmpty()) return false;
        for(int i=0; i<ArrayStaff.size(); i++) ArrayStaff.get(i).OutPutStaff();
        return true;
    }
    /// find staff by id
    public int FindStaff(int id){
        for(int i=0; i<ArrayStaff.size(); i++ ) if ( ArrayStaff.get(i).getID() == id) return i;
            return -1;
    }
    /// SearchStaff by ID tra ve Staff
    public Staff SearchStaff(int id){
        for(int i=0; i<ArrayStaff.size(); i++ ) if ( ArrayStaff.get(i).getID() == id) return ArrayStaff.get(i);
        return null;
    }
    
    //Update by ID Staff
    public boolean UpdateStaff(int id){
        Staff tmp = SearchStaff(id);
        if (tmp==null) return false;
        tmp.setID(id);
        tmp.addStaff();
        tmp.setMng(null);
     return true;   
    }
    public boolean RemoveStaff(int id){
        Staff tmp= SearchStaff(id);
        if(tmp==null) return false;
        return ArrayStaff.remove(tmp);
    }
    public boolean SortByID(){
        if(ArrayStaff.isEmpty()) return false;
        Collections.sort(ArrayStaff);
        return true;
    }
}
