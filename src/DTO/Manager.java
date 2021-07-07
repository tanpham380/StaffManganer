/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Scanner;

/**
 *
 * @author Se151045
 */
public class Manager extends Staff   {
     protected double BonusSalary;
     private boolean Flag;
     
    public Manager(){
        super();
        BonusSalary=0;
    }
    public Manager(long bonusSalary, int id, String name, String gender, long basicSalary, Manager mng) {
        super(id, name, gender, basicSalary, mng);
        this.BonusSalary=bonusSalary;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public double getBasicSalary() {
        return BasicSalary;
    }

    public void setBasicSalary(double BasicSalary) {
        this.BasicSalary = BasicSalary;
    }
    public double getBonusSalary() {
        return BonusSalary;
    }

    public void setBonusSBalary(double BonnusSalary) {
        this.BonusSalary = BonnusSalary;
    }
        public void AddManager(){
           Scanner sc=new Scanner(System.in);
        super.addStaff();
      do {
            sc = new Scanner(System.in);
            Flag = false;
            try {
                System.out.println("Input Bonus Slary for Manager");
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
        public void OutputMangaer(){
            super.OutPutStaff();
            System.out.println("Bonus Salary: "+BonusSalary);
        }

    @Override
    public String toString() {
        return "Manager{" + "BonusSalary=" + BonusSalary + '}';
    }
        
}


    
    

