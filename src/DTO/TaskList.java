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
public class TaskList {
    ArrayList<Task> TaskList;
    public TaskList(){
    TaskList= new ArrayList();
}
        public boolean AddTaskList(Task T){
        return TaskList.add(T);
    }
    public boolean DisplayTaskList(){
        if(TaskList.isEmpty()) return false;
        for(int i=0; i<TaskList.size(); i++) TaskList.get(i).DisplayTask();
        return true;
    }
    /// find staff by id
    public int FindTask(int id){
        for(int i=0; i<TaskList.size(); i++ ) if ( TaskList.get(i).getID() == id) return i;
            return -1;
    }
    /// SearchStaff by ID tra ve Staff
    public Task SearchTask(int id){
        for(int i=0; i<TaskList.size(); i++ ) if ( TaskList.get(i).getID() == id) return TaskList.get(i);
        return null;
    }
    //Update by ID Staff
    public boolean UpdateTask(int id){
        Task tmp = SearchTask(id);
        if (tmp==null) return false;
        tmp.setID(id);
        tmp.addTask();
     return true;   
    }
    public boolean RemoveTask(int id){
        Task tmp= SearchTask(id);
        if(tmp==null) return false;
        return TaskList.remove(tmp);
    }
    public boolean SortByID(){
        if(TaskList.isEmpty()) return false;
        Collections.sort(TaskList);
        return true;
    }
}
