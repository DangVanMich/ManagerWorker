/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import java.util.ArrayList;
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
    private ArrayList<History> his_salary;

    public WorkerDao() {
        validation = new Validation();
        his_salary = new ArrayList<>();
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
                validation.checkInputDate(worklocation);
                list_worker.add(new Worker(id, name, age, salary, worklocation));
                System.err.println("Add success.");
            }
            System.err.println("Do you want to continue (Y/N)? Choose Y to continue, N to return main screen");
            if (!validation.checkInputYesNo()) {
                return;
            }
        }
    }

//     public void ChangeSalary(ArrayList<Worker> lw, String status) {
//        if (lw.isEmpty()) {
//            System.err.println("List empty.");
//            return;
//        }
//        String id = validation.checkInputString("Enter code: ");
//        Worker worker = getWorkerByCode(lw, id);
//        if (worker == null) {
//            System.err.println("Not exist worker.");
//        } else {
//            double salaryCurrent = worker.getSalary();
//            double salaryUpdate;
//                if(status.equalsIgnoreCase("UP")){
//                while (true) {     
//                    salaryUpdate = validation.checkInputSalary("Enter Salary: ");
//                    if (salaryUpdate <= salaryCurrent) {
//                        System.err.println("Must be greater than current salary.");
//                        System.out.print("Enter again: ");
//                    } else {
//                        break;
//                    }
//                }
//                lh.add(new History(worker.getId(),
//                        worker.getName(), worker.getAge(), salaryUpdate
//                        ,worker.getWorkLocation(),getCurrentDate()));
//                 worker.getSalary()
//                }else if(status.equalsIgnoreCase("DOWN"){
//                    while (true) {
//                    salaryUpdate = validation.checkInputSalary("Enter Salary: ");
//                    //check user input salary update < salary current
//                    if (salaryUpdate >= salaryCurrent) {
//                        System.err.println("Must be smaller than current salary.");
//                        System.out.print("Enter again: ");
//                    } else {
//                        break;
//                    }
//                }
//                lh.add(new History("Down", worker.getId(),
//                        worker.getName(), worker.getAge(), salaryUpdate
//                        ,worker.getWorkLocation(),getCurrentDate()));
//                }
//                worker.setSalary(salaryUpdate);
//                
//                System.out.println("Update Successful!!");
//        }
//        
//    }
    public void ChangeSalary(ArrayList<Worker> workers, String status) {
        if (workers.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        String id = validation.checkInputString("Enter ID : ");
        validation.checkIdExist(workers, id);
        Worker work_new = null;
        for (Worker worker : workers) {
            if (worker.getId().equalsIgnoreCase(id)) {
                double salary = validation.checkInputSalary("Enter Salary : ");
                if (status.equalsIgnoreCase("UP")) {
                    if (salary <= worker.getSalary()) {
                        System.err.println("Must be greater than current salary.");
                        System.out.print("Enter again: ");
                        return;
                    }
                    work_new = new Worker(worker.getId(), worker.getName(), worker.getAge(), (worker.getSalary() + salary), worker.getWorkLocation());
                    worker.setSalary(work_new.getSalary());
                } else if (status.equalsIgnoreCase("DOWN")) {
                    if (salary >= worker.getSalary()) {
                        System.err.println("Must be smaller than current salary.");
                        System.out.print("Enter again: ");
                        return;
                    }
                    work_new = new Worker(worker.getId(), worker.getName(), worker.getAge(), (worker.getSalary() - salary), worker.getWorkLocation());
                    worker.setSalary(work_new.getSalary());
                }
                Date date = new Date();
                History hs = new History(work_new, status, date);
                his_salary.add(hs);
                break;
            }
              System.out.println("Change Successfull !!");
        }
    }

    public void displayInformationSalary() {
        System.out.println("--------Display Information Salary--------");
        System.out.println(String.format("%-13s%-13s%-13s%-13s%-13s%-13s", "Code", "Name", "Age", "Salary", "Status", "Date"));
        for (History historySalary : his_salary) {
            System.out.println(historySalary);
        }
    }
}
