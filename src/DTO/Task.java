/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import static DTO.FormatForm.IsDateValid;
import static DTO.FormatForm.StringInput;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Phạm Thanh Tân
 */
public class Task implements Comparable<Task>{
    protected int ID;
    protected String Tilte;
    protected String StartDate;
    protected String EndDate;
    protected double ToltalHours;
    private boolean Flag = false; 
        public Task(){
            ID=0;
            Tilte="";
            StartDate="";
            EndDate="";
            ToltalHours=0;
        }

    public Task(int id, String Tilte, String StartDate, String EndDate, double ToltalHours) {
        this.ID = id;
        this.Tilte = Tilte;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
        this.ToltalHours = ToltalHours;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public boolean isFlag() {
        return Flag;
    }

    public void setFlag(boolean Flag) {
        this.Flag = Flag;
    }


    public String getTilte() {
        return Tilte;
    }

    public void setTilte(String Tilte) {
        this.Tilte = Tilte;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String StartDate) {
        this.StartDate = StartDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String EndDate) {
        this.EndDate = EndDate;
    }

    public double getToltalHours() {
        return ToltalHours;
    }

    public void setToltalHours(double ToltalHours) {
        this.ToltalHours = ToltalHours;
    }
    public void AddID(){
             do{
                 Flag=false;
                 try{
                 Scanner sc = new Scanner(System.in);
                 System.out.println("Input ID");
                 String S = sc.next();
                 this.ID = Integer.parseInt(S);
                
                if (Integer.parseInt(S) == 0) {
                    
                    throw new Exception();
                }
            } catch (NumberFormatException e1) {
                System.out.println("Check agian Format ID(ID is munber)");
                Flag=true;
              
            } catch (InputMismatchException e2) {
                System.out.println("ID is Interger Number");  
                Flag=true;
            } catch (Exception e) {
                System.out.println("Wrong Format ID" + "\n" + "Please Try Agian");
                Flag=true;
            }
             }while (Flag);
    }
        public void addTask() {
//        do {
//            sc = new Scanner(System.in);
//            Flag = false;
//            try {
//                System.out.println("Input ID for Staff");
//                String S = sc.next();
//                if (Integer.parseInt(S) <= 0) {
//                    throw new Exception();
//                }
//                this.ID = Integer.parseInt(S);
//            } catch (NumberFormatException e) {
//                System.out.println("Check agian Format ID(ID is munber)");
//                Flag = true;
//            } catch (InputMismatchException e1) {
//                System.out.println("ID is Interger Number");
//                Flag = true;
//            } catch (Exception e2) {
//                System.out.println("Wrong Format ID" + "\n" + "Please Try Agian");
//                Flag = true;
//            }
//        } while (Flag);
        Scanner sc = new Scanner(System.in);
        do {
            Flag=false;
            sc =new Scanner(System.in);
            try{
                System.out.println("Input Tilte Task");
                this.Tilte=FormatForm.toTitleCase(sc.nextLine());
                if(Tilte.matches(StringInput)==false || Tilte.isEmpty()) throw new Exception();
            }
            catch(Exception e){
                System.out.println("Wrong Format Name" + "\n" + "Please Try Agian");
                Flag=true;
            }
        } while(Flag);
         do {
            Flag=false;
            try{
            sc = new Scanner(System.in);
            System.out.println("input StartDate for task: dd-mm-yyyy");
            StartDate = sc.nextLine();
            if (!IsDateValid(StartDate)) throw new Exception();
            sc = new Scanner(System.in);
            System.out.println("input EndDate for task: dd-mm-yyyy");
            EndDate = sc.nextLine();
            if (!IsDateValid(EndDate)) throw new Exception();
            } catch(Exception e){
                System.out.println("Date Invaild");
                Flag = true;
            }
        } while (Flag);
                do {
            sc = new Scanner(System.in);
            Flag = false;
            try {
                System.out.println("Input Total Hour for task");
                String S = sc.next();
                if (Double.parseDouble(S) <= 0) {
                    throw new Exception();
                }
                this.ToltalHours = Double.parseDouble(S);
            } catch (NumberFormatException e) {
                System.out.println("Check agian Format Salary(Salary is munber)");
                Flag = true;
            } catch (NullPointerException e1) {
                System.out.println("Salary is Interger Number");
                Flag = true;
            } catch (Exception e2) {
                System.out.println("Wrong Format ToltalHours" + "\n" + "Please Try Agian");
                Flag = true;
            }
        } while (Flag);
        
    }
        public void DisplayTask(){
        System.out.println("");
        System.out.println("Task's Id: " + ID);
        System.out.println("Task's Tilte: " + Tilte);
        System.out.println("StarDate: " + StartDate +"\n" +"EndDate: " +EndDate);
        System.out.println("ToltalHours: " +ToltalHours);
        }

    @Override
    public String toString() {
        return "Task{" + "id=" + ID + ", Tilte= " + Tilte + ", StartDate=" + StartDate + ", EndDate=" + EndDate + ", ToltalHours=" + ToltalHours + '}';
    }

    @Override
    public int compareTo(Task o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
}
