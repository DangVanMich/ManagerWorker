/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import DataAccess.WorkerDao;
import java.util.ArrayList;
import model.History;
import model.Worker;

/**
 *
 * @author admin
 */
public class WorkRepository implements IWorkerRepository{
     private ArrayList<Worker> worker;
     private ArrayList<History> history;
    public WorkRepository(){
        worker= new ArrayList<>();
        history = new ArrayList<>();
    }

     @Override
    public void addWorker() {
        WorkerDao.Instance().CreateWorker(worker);
    }

    @Override
    public void changeSalary1() {
        WorkerDao.Instance().ChangeSalary(worker, history, 1);
    }
    
     @Override
    public void changeSalary2() {
        WorkerDao.Instance().ChangeSalary(worker, history, 2);
    }
    
     @Override
    public void displaySalary(){
        WorkerDao.Instance().printListHistory(history);
    }
}
