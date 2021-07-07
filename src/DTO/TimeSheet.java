/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author phamt
 */
public class TimeSheet {
    Staff S;
    Task T;
    protected double WorkHours;
    public TimeSheet(){
        S=null;
        T=null;
        WorkHours=0;
    }

    public TimeSheet(Staff S, Task T, double WorkHours) {
        this.S = S;
        this.T = T;
        this.WorkHours = WorkHours;
    }

    public Staff getS() {
        return S;
    }

    public void setS(Staff S) {
        this.S = S;
    }

    public Task getT() {
        return T;
    }

    public void setT(Task T) {
        this.T = T;
    }

    public double getWorkHours() {
        return WorkHours;
    }

    public void setWorkHours(double WorkHours) {
        this.WorkHours = WorkHours;
    }
    public void InputWorkHours(){
        Scanner sc = new Scanner(System.in);
        boolean Flag=false;
        do{ 
            Flag=false;
        try{
            System.out.println(" Input WorkHours:");
        WorkHours=sc.nextInt();
        if(WorkHours<= 0 ) throw  new Exception();  
        }
        catch(InputMismatchException e){
            System.out.println("Wrong Format");
            Flag=true;
        }
        catch(NoSuchElementException e1){
            System.out.println("Wrong Format");
            Flag=true;
        }
        catch(Exception e2){
            System.out.println("input >0 please");
            Flag=true;
        }
        }while(Flag);
    }
    public void OutPutTimeSheet(){
        System.out.println("Thong Tin task");
        S.OutPutStaff();
        T.DisplayTask();
        System.out.println("WorkHours: "+WorkHours);
    }
    
    
    
}
