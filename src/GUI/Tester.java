/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.Manager;
import DTO.ManagerList;
import DTO.Staff;
import DTO.StaffList;
import DTO.Task;
import DTO.TaskList;
import DTO.TimeSheet;
import DTO.TimeSheetList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author phamt
 */
public class Tester {
    public static void main(String[] args) {
        int ChoiceMain=0;
        int Choice=0;
        StaffList ListStaff = new StaffList();
        ManagerList ListManager = new ManagerList();
        TaskList ListTask = new TaskList();
        TimeSheetList ListTimeSheet = new TimeSheetList();
        Scanner sc = new Scanner(System.in);
        boolean Flag,FlagNemu;
        do{
            Flag = true;
        System.out.println("---Nemu---");
        System.out.println("1.Staff Manager");
        System.out.println("2.Manager");
        System.out.println("3.Task Nemu");
        System.out.println("4.Control Set Manager");
        System.out.println("5.Time Sheet");
        System.out.println("0.Out");
        System.out.println("------------------");
        try{
        sc = new Scanner(System.in);
        ChoiceMain = sc.nextInt();
        if(ChoiceMain==0){
            System.out.println("Thank for use my services");
            Flag=false;
        }
        if(ChoiceMain<0 || ChoiceMain>6) throw new Exception();
        }
        catch(InputMismatchException e1){
            System.out.println("Wrong Format");
            
        }
        catch(Exception e){
            System.out.println("Wrong choice, please choice agian");
           
        }
        switch(ChoiceMain){
            case 1:
                do{
                    FlagNemu=true;
                    try{
                    sc=new Scanner(System.in);
                    System.out.println("-Nemu Staff-");
                    System.out.println("1.Add Staff");
                    System.out.println("2.Display Staff");
                    System.out.println("3.Update Staff");
                    System.out.println("4.Remove Staff");
                    System.out.println("5.Sort");
                    System.out.println("0.Out");
                    Choice = sc.nextInt();
                    if(Choice==0){
                        System.out.println("Thank!!! back to Main Nemu");
                        FlagNemu=false;
                        
                    }
                    if(Choice<0 || Choice>6) throw new Exception();
                    } catch(InputMismatchException e1){
                        System.out.println("Wrong Format");
                        
                    } catch(Exception e){
                        System.out.println("Wrong choice, Please choice agian");
                    }
                    switch(Choice){
                        case 1: 
                             try{
                            Staff S = new Staff();
                            S.addID();
                            if(ListStaff.FindStaff(S.getID()) != -1 ) throw new Exception();
                            S.addStaff();
//                                System.out.println("Input your Manager ID");
//                                 Staff S1 = new Staff();
//                                 S1.addID(sc.next());
//                               Manager M = (Manager) ListStaff.SearchStaff(S1.getID());
//                                 if(ListStaff.FindStaff(S1.getID()) == -1 ) S.setMng(null);
//                                 else S.setMng(M);
                             ListStaff.AddStaffIntoList(S);
                             }
                            catch(Exception e){
                                 System.out.println("ID already exists");
                             }
                            
                            break;
                        case 2: 
                                if (ListStaff.DisplayStaffList() == true) System.out.println("Successfull");
                                 else if (ListStaff.DisplayStaffList() == false) System.out.println("Empty array");
                            
                            break;
                        case 3: 
                                System.out.println("input ID you want to update");
                                Staff S = new Staff();
                                S.addID();
                                if (ListStaff.FindStaff(S.getID()) != -1) {
                                    ListStaff.UpdateStaff(S.getID());
                                    System.out.println("Successfull Update");
                                } else {
                                    System.out.println("There's no Staff id");
                                }
                            break;
                        case 4: 
                            System.out.println("input ID you want to remove");
                                S = new Staff();
                                S.addID();
                                if (ListStaff.FindStaff(S.getID()) != -1) {
                                    ListStaff.RemoveStaff(S.getID());
                                    System.out.println("Successfull Update");
                                } else {
                                    System.out.println("There's no Staff id");
                                }
                            break;    
                        case 5: 
                                System.out.println("Sort Fuction");
                                if (ListStaff.SortByID()) {
                                    System.out.println("Successfull Sort");
                                } else {
                                    System.out.println("Empty array");
                                }
                            break;    
                    }
                }while(FlagNemu);
                break;
            case 2:
                                do{
                    FlagNemu=true;
                    try{
                    sc=new Scanner(System.in);
                    System.out.println("-Nemu Manager-");
                    System.out.println("1.Add Manager");
                    System.out.println("2.Display Manager");
                    System.out.println("3.Update Manager");
                    System.out.println("4.Remove Manager");
                    System.out.println("5.Sort");
                    System.out.println("0.Out");
                    Choice = sc.nextInt();
                    if(Choice==0){
                        System.out.println("Thank!!! back to Main Nemu");
                        FlagNemu=false;
                        
                    }
                    if(Choice<0 || Choice>6) throw new Exception();
                    } catch(InputMismatchException e1){
                        System.out.println("Wrong Format");
                        
                    } catch(Exception e){
                        System.out.println("Wrong choice, Please choice agian");
                        
                    }
                    switch(Choice){
                        case 1: 
                             try{
                            Manager M = new Manager();
                            System.out.println("Put Manager ID: ");
                            M.addID();
                            if(ListManager.FindManager(M.getID()) != -1 ) throw new Exception();
                             
                            M.AddManager();
                             ListManager.AddManager(M);
                             }
                            catch(Exception e){
                                 System.out.println("ID already exists");
                             }
                           
                            break;
                        case 2: 
                                if (ListManager.DisplayManager()== true) System.out.println("Successfull");
                                 else if (ListManager.DisplayManager()== false) System.out.println("Empty array");
                            break;
                        case 3: 
                                System.out.println("input ID you want to update");
                                Manager M = new Manager();
                               
                                try{
                                M.setID(sc.nextInt());
                                if (ListManager.FindManager(M.getID()) != -1) {
                                    ListManager.UpdateManager(M.getID());
                                    System.out.println("Successfull Update");
                                } else {
                                    System.out.println("There's no Staff id");
                                }
                                }catch(InputMismatchException e){
                                    System.out.println("Wrong");
                                }
                            break;
                        case 4: 
                            System.out.println("input ID you want to remove");
                                M = new Manager();
                                M.addID();
                                if (ListStaff.FindStaff(M.getID()) != -1) {
                                    ListStaff.RemoveStaff(M.getID());
                                    System.out.println("Successfull Update");
                                } else {
                                    System.out.println("There's no Staff id");
                                }
                            break;    
                        case 5: 
                                System.out.println("Sort Fuction");
                                if (ListManager.SortByID()) {
                                    System.out.println("Successfull Sort");
                                } else {
                                    System.out.println("Empty array");
                                }
                            break;    
                    }
                }while(FlagNemu);
                break;
            case 3: do{
                    FlagNemu=true;
                    try{
                    sc=new Scanner(System.in);
                    System.out.println("-Nemu Task-");
                    System.out.println("1.Add Task");
                    System.out.println("2.Display Task");
                    System.out.println("3.Update Task");
                    System.out.println("4.Remove Task");
                    System.out.println("5.Sort");
                    System.out.println("0.Out");
                    Choice = sc.nextInt();
                    if(Choice==0){
                        System.out.println("Thank!!! back to Main Nemu");
                        FlagNemu=false;
                    }
                    if(Choice<0 || Choice>6) throw new Exception();
                    } catch(InputMismatchException e1){
                        System.out.println("Wrong Format");
                        
                    } catch(Exception e){
                        System.out.println("Wrong choice, Please choice agian");
                        
                    }
                    switch(Choice){
                        case 1: 
                            
                             try{
                            Task T = new Task();
                            System.out.println("Put Task ID: ");
                            T.AddID();
                            if(ListTask.FindTask(T.getID()) != -1 ) throw new Exception();
                            T.addTask();
                             ListTask.AddTaskList(T);
                             }
                            catch(Exception e){
                                 System.out.println("ID already exists");
                                 
                             }
                            
                            break;
                        case 2: 
                                if (ListTask.DisplayTaskList()== true) System.out.println("Successfull");
                                 else if (ListTask.DisplayTaskList()== false) System.out.println("Empty array");
                            break;
                        case 3: 
                                System.out.println("input ID you want to update");
                                Task T = new Task();
                                T.AddID();
                                if (ListTask.FindTask(T.getID()) != -1) {
                                    ListTask.UpdateTask(T.getID());
                                    System.out.println("Successfull Update");
                                } else {
                                    System.out.println("There's no task id");
                                }
                            break;
                        case 4: 
                            System.out.println("input ID you want to remove");
                                T = new Task();
                                T.AddID();
                                if (ListTask.FindTask(T.getID()) != -1) {
                                    ListTask.RemoveTask(T.getID());
                                    System.out.println("Successfull Update");
                                } else {
                                    System.out.println("There's no task id");
                                }
                            break;    
                        case 5: 
                                System.out.println("Sort Fuction");
                                if (ListTask.SortByID()) {
                                    System.out.println("Successfull Sort");
                                } else {
                                    System.out.println("Empty array");
                                }
                            break;
                    }
                }while(FlagNemu);
                break;
            case 4 : 
                try{
                System.out.println("---Set Manager for Staff----");
                sc=new Scanner(System.in);
                    System.out.println("input Staff ID");
                Staff S = ListStaff.SearchStaff(sc.nextInt());
                if(S==null) throw new Exception();
                    System.out.println("Input Manager");
                Manager M = ListManager.SearchManager(sc.nextInt());
                if(M==null) throw new Exception();
                S.setMng(M);
                System.out.println("successfull");
                }catch(InputMismatchException e1){
                        System.out.println("Wrong choice");
                    } 
                catch(Exception e){
                    System.out.println("id does not exist");
                }
                break;
            case 5 : 
                do{
                    FlagNemu=true;
                    try{
                    System.out.println("--Sheet Time Nemu--");
                    System.out.println("1.Input Sheet Time");
                    System.out.println("2.Output Sheet Time");
                    System.out.println("3.Update Sheet Time");
                    System.out.println("4.Remove Sheet Time");
                    System.out.println("0.Out");
                    Choice=sc.nextInt();
                    if(Choice==0){
                        System.out.println("Thank!!! back to Main Nemu");
                        FlagNemu=false;
                    }
                    
                    if(Choice <0 || Choice>5 ) throw  new Exception();
                    }
                    catch(InputMismatchException e1){
                        System.out.println("Wrong choice");
                    }
                    catch(Exception e){
                        System.out.println("Wrong chocie, please choice agian");
                    }
                    switch(Choice){
                        case 1:
                           
                            try{
                            System.out.println("SheetTime input");
                            sc=new Scanner(System.in);
                            TimeSheet TS = new TimeSheet();
                            Staff S = new Staff();
                            System.out.println("Input ID Staff accpect Task");
                            S.addID();
                            S= ListStaff.SearchStaff(S.getID());
                            Task T = new Task();
                            System.out.println("Input ID Task");
                            T.AddID();
                            T= ListTask.SearchTask(T.getID());
                            if(T==null) throw new Exception();
                            TS.setS(S);
                            TS.setT(T);
                            TS.InputWorkHours();
                            ListTimeSheet.Add(TS);
                            }
                             catch(Exception e1){
                                    System.out.println("Id does not exit");
                                    }
                          
                            break;
                        case 2:
                            if (ListTimeSheet.OutputTimeSheetList()== true) System.out.println("Successfull");
                                 else if (ListTimeSheet.OutputTimeSheetList()== false) System.out.println("Empty array");
                            break;    
                        case 3:
                            try{
                            sc=new Scanner(System.in);
                            TimeSheet TS = new TimeSheet();
                            Staff S = new Staff();
                            System.out.println("Input ID Staff accpect Task");
                            S.addID();
                            S= ListStaff.SearchStaff(S.getID());
                            Task T = new Task();
                            System.out.println("Input ID Task");
                            T.AddID();
                            T= ListTask.SearchTask(T.getID());
                            if(T==null) throw new Exception();
                            ListTimeSheet.UpdateTimeSheet(S, T);
                            } catch(Exception e1){
                                System.out.println("ID does not exit");
                            }
                            break;    
                        case 4:
                            try{
                            System.out.println("Input Task ID you want to remove");
                            sc=new Scanner(System.in);
                            Task T=ListTask.SearchTask(sc.nextInt());
                            System.out.println("Input Task ID you want to remove");
                            sc=new Scanner(System.in);
                            Staff S=ListStaff.SearchStaff(sc.nextInt());
                            if(T==null) throw new Exception();
                            if(ListTimeSheet.RemoveLog(T,S)) System.out.println("Successfull");
                            }
                            catch(InputMismatchException e){
                                System.out.println("Wrong format");
                            }
                            catch(Exception e){
                                System.out.println("ID does not exit");
                            }
                            break;   
                    }
                }while(FlagNemu);
                
                break;
        }
        }while(Flag);
    }
    
}
