/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.ArrayList;

/**
 *
 * @author phamt
 */
public class TimeSheetList {
    ArrayList<TimeSheet> TimeSheetList;
    public TimeSheetList(){
        TimeSheetList=new ArrayList();
    }
    public void Add(TimeSheet T){
        TimeSheetList.add(T);
    }
        public boolean OutputTimeSheetList() {
        if(TimeSheetList.isEmpty()||TimeSheetList==null) return false; 
        for (int i = 0; i < TimeSheetList.size(); i++) {
                TimeSheetList.get(i).OutPutTimeSheet();
        }
        return true;
    }
    public int FindLog(Task T) {
        for (int i = 0; i < TimeSheetList.size(); i++) {
            if (TimeSheetList.get(i).getT().getID()== T.getID()) {
                return i;
            }

        }
        return -1;
    }

    public TimeSheet SearchTimeSheet(Task P, Staff S) {
        for (int i = 0; i < TimeSheetList.size(); i++) {
            if(TimeSheetList.get(i).getT().getID()== P.getID())
                if(TimeSheetList.get(i).getS().getID()== S.ID) return TimeSheetList.get(i);
        }
        return null;
    }
    public boolean UpdateTimeSheet(Staff S, Task T){
        TimeSheet TS = SearchTimeSheet(T,S);
        if(TS==null ) return false;
        TS.setS(S);
        TS.setT(T);
        TS.InputWorkHours();
        return true;
    }
        public boolean RemoveLog(Task p, Staff S){
        TimeSheet T = SearchTimeSheet(p,S);
                if (T == null) {
            return false;
        } 
        return TimeSheetList.remove(T);
    }
}
