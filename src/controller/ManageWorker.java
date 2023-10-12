/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DataAccess.WorkerDao;
import java.util.ArrayList;
import model.Worker;
import repository.IWorkerRepository;
import repository.WorkRepository;
import view.Menu;

/**
 *
 * @author admin
 */
public class ManageWorker extends Menu<String> {

    private IWorkerRepository workerrepository = new WorkRepository();
    static String title = "PROGRAM MANAGEMENT WORKER";
    static String[] s = new String[]{"Add Worker ", "UP Salary","Down Salary", "Display Information salary", "Exit"};

    public ManageWorker() {
        super(title, s);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                workerrepository.addWorker();
                break;
            case 2:
                workerrepository.changeSalary("UP");
                break;
            case 3:
                workerrepository.changeSalary("DOWN");
                break;
            case 4:
                workerrepository.displaySalary();
                break;    
            case 5:
                System.exit(0);
            default:
                System.out.println("Your choice invalid! Pls input another choice");
        }

    }

}
