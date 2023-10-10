/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import model.History;
import model.Worker;
import view.Validation;

/**
 *
 * @author admin
 */
public class WorkerDao {

    private static WorkerDao instance = null;
    private Validation validation;

    public WorkerDao() {
        validation = new Validation();
    }

    public static WorkerDao Instance() {
        if (instance == null) {
            synchronized (WorkerDao.class) {
                if (instance == null) {
                    instance = new WorkerDao();
                }
            }
        }
        return instance;
    }

    public void CreateWorker(ArrayList<Worker> list_worker) {
        System.out.println("--------------Create Worker-------------");
        while (true) {
            String id = validation.checkInputString("Enter ID Worker: ");
            if (!validation.checkIdExist(list_worker, id)) {
                String name = validation.checkInputString("Enter Name Worker: ");
                System.out.print("Enter Age Work: ");
                int age = validation.checkInputIntLimit(18, 50);
                double salary = validation.checkInputSalary("Enter Salary Worker: ");
                String worklocation = validation.checkInputString("Enter Date Work: ");
                list_worker.add(new Worker(id, name, age, salary, worklocation));
                System.err.println("Add success.");
            }
            System.err.println("Do you want to continue (Y/N)? Choose Y to continue, N to return main screen");
            if (!validation.checkInputYesNo()) {
                return;
            }
        }
    }

   // public void Update(ArrayList<Worker> list_worker)
     public void UpSalary(ArrayList<Worker> lw, ArrayList<History> lh, int status) {
        if (lw.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        String id = validation.checkInputString("Enter code: ");
        Worker worker = getWorkerByCode(lw, id);
        if (worker == null) {
            System.err.println("Not exist worker.");
        } else {
            double salaryCurrent = worker.getSalary();
            double salaryUpdate;
            //check user want to update salary
                //System.out.print("Enter salary: ");
                //loop until user input salary update > salary current
                if(status==1){
                while (true) {     
                    salaryUpdate = validation.checkInputSalary("Enter Salary: ");
                    //check user input salary update > salary current
                    if (salaryUpdate <= salaryCurrent) {
                        System.err.println("Must be greater than current salary.");
                        System.out.print("Enter again: ");
                    } else {
                        break;
                    }
                }
                lh.add(new History("UP", worker.getId(),
                        worker.getName(), worker.getAge(), salaryUpdate
                        ,worker.getWorkLocation(),getCurrentDate()));
                 worker.setSalary(salaryUpdate);
                }
             //   worker.setSalary(salaryUpdate);
        }
         printListHistory(lh);
           
         System.err.println("Up Salary success");
    }

      public void DownSalary(ArrayList<Worker> lw, ArrayList<History> lh, int status) {
        if (lw.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        String id = validation.checkInputString("Enter code: ");
        Worker worker = getWorkerByCode(lw, id);
        if (worker == null) {
            System.err.println("Not exist worker.");
        } else {
            double salaryCurrent = worker.getSalary();
            double salarydown;
            //check user want to update salary          
               // System.out.print("Enter salary: ");
                //loop until user input salary update < salary current
                if(status==2){
                while (true) {
                    salarydown = validation.checkInputSalary("Enter Salary: ");
                    //check user input salary update < salary current
                    if (salarydown >= salaryCurrent) {
                        System.err.println("Must be smaller than current salary.");
                        System.out.print("Enter again: ");
                    } else {
                        break;
                    }
                }
                lh.add(new History("Down", worker.getId(),
                        worker.getName(), worker.getAge(), salarydown
                        ,worker.getWorkLocation(),getCurrentDate()));
                worker.setSalary(salarydown);
            }
        }
         printListHistory(lh);
            System.err.println("Down Salary success");
        }
 

     
   
    //allow user print history
    public void printListHistory(ArrayList<History> lh) {
        if (lh.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        System.out.printf("%-5s%-15s%-5s%-10s%-10s%-20s\n", "Code", "Name", "Age",
                "Salary", "Status", "Date");
        Collections.sort(lh);
        //print history from first to last list
        for (History history : lh) {
            Displayinfor(history);
        }
    }

    //get worker by code
    public  Worker getWorkerByCode(ArrayList<Worker> lw, String id) {
        for (Worker worker : lw) {
            if (id.equalsIgnoreCase(worker.getId())) {
                return worker;
            }
        }
        return null;
    }

    //get current date 
    public  String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        return dateFormat.format(calendar.getTime());
    }

    //print history
//    public  void printHistory(History history) {
//        System.out.printf("%-5s%-15s%-5d%-10d%-10s%-20s\n", history.getId(),
//                history.getName(), history.getAge(), history.getSalary(),
//                history.getStatus(), history.getDate());
//    }
//    
    public void Displayinfor(History history){
         System.out.printf("%-5s%-15s%-5d%-10d%-10s%-20s\n", history.getId(),
                history.getName(), history.getAge(), history.getSalary(),
                history.getStatus(), history.getDate());
    }
}

