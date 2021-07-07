/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import static DTO.FormatForm.StringInput;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author  * @author SE151045

 */
public class Staff implements Comparable<Staff>{

    protected int ID;
    protected String Name;
    protected String Gender;
    protected double BasicSalary;
    Manager mng;
    private boolean Flag = false; // control errow
    

    public Staff() {
        ID = 0;
        Name = "";
        Gender = "";
        BasicSalary = 0;
        mng = null;
    }

    public Staff(int ID, String Name, String Gender, double BasicSalary, Manager mng) {
        this.ID = ID;
        this.Name = Name;
        this.Gender = Gender;
        this.BasicSalary = BasicSalary;
        this.mng =mng;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getGender() {
        return Gender;
    }

    public Manager getMng() {
        return mng;
    }

    public void setMng(Manager mng) {
        this.mng = mng;
    }
    

    public double getBasicSalary() {
        return BasicSalary;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public void setBasicSalary(double BasicSalary) {
        this.BasicSalary = BasicSalary;
    }

    public void addID() {
        do{
            Flag=false;
            Scanner sc = new Scanner(System.in);
            System.out.println("input ID");
            String S=sc.next();
            try {
                if (Integer.parseInt(S) <= 0) throw new Exception();                
                this.ID = Integer.parseInt(S);
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
        } while(Flag);
    }

    public void addStaff() {
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
                System.out.println("Input Staff Name");
                this.Name=FormatForm.toTitleCase(sc.nextLine());
                if(Name.matches(StringInput)==false || Name.isEmpty()) throw new Exception();
            }
            catch(Exception e){
                System.out.println("Wrong Format Name" + "\n" + "Please Try Agian");
                Flag=true;
            }
        } while(Flag);
                do {
            Flag=false;
            sc =new Scanner(System.in);
            try{
                System.out.println("What is Staff gender, male of female?");
                this.Gender=sc.nextLine();
                Gender=Gender.toLowerCase();
                if(Gender.matches(StringInput)==false || Gender.isEmpty()|| Gender.equalsIgnoreCase("male")==false ){
                if(Gender.equalsIgnoreCase("female")==false ) throw new Exception();
                }
                this.Gender=FormatForm.toTitleCase(Gender);
            }
            catch(Exception e){
                System.out.println("Wrong Format Gender" + "\n" + "Please Try Agian");
                Flag=true;
            }
        } while(Flag);
                do {
            sc = new Scanner(System.in);
            Flag = false;
            try {
                System.out.println("Input Basic Salary for Staff");
                String S = sc.next();
                if (Double.parseDouble(S) <= 0) {
                    throw new Exception();
                }
                this.BasicSalary = Double.parseDouble(S);
            } catch (NumberFormatException e) {
                System.out.println("Check agian Format Salary(Salary is munber)");
                Flag = true;
            } catch (NullPointerException e1) {
                System.out.println("Salary is Interger Number");
                Flag = true;
            } catch (Exception e2) {
                System.out.println("Wrong Format Salary" + "\n" + "Please Try Agian");
                Flag = true;
            } 
        } while (Flag);
    }
    public void OutPutStaff(){
        System.out.println("");
        System.out.println("Staff's id: " + ID);
        System.out.println("Staff's name: " + Name);
        System.out.println("Staff'gender: " + Gender);
        System.out.println("Staff'BasucSalary: " +BasicSalary);
        if (mng != null) {
            System.out.println("Thong tin quan li");
            mng.OutputMangaer();
        }
       
    }

    @Override
    public String toString() {
        return "Staff{" + "ID=" + ID + ", Name=" + Name + ", Gender=" + Gender + ", BasicSalary=" + BasicSalary + ", mng=" + mng + '}';
    }


    @Override
    public int compareTo(Staff o) {
        if(this.ID > o.ID) return 1;
        if(this.ID < o.ID) return -1;
        return 0;
    }

}
