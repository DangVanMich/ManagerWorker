/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import DataAccess.WorkerDao;
import java.util.ArrayList;
import model.Worker;

/**
 *
 * @author admin
 */
public class WorkRepository implements IWorkerRepository{
     private ArrayList<Worker> worker;
     
    public WorkRepository(){
        worker= new ArrayList<>();
    }

     @Override
    public void addWorker() {
        WorkerDao.Instance().CreateWorker(worker);
    }

    @Override
    public void changeSalary(String status) {
        WorkerDao.Instance().ChangeSalary(worker,status);
    }
    
     @Override
    public void displaySalary(){
        WorkerDao.Instance().displayInformationSalary();
    }
}
