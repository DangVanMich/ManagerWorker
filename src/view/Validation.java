package view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import model.Worker;

public class Validation {

    private final static Scanner sc = new Scanner(System.in);

    public int checkInputIntLimit(int min, int max) {
        while (true) {
            try {
                int check = Integer.parseInt(sc.nextLine().trim());
                if (check < min || check > max) {
                    throw new Exception();
                } else {
                    return check;
                }
            } catch (Exception e) {
                System.err.println("Please input number in range [" + min + ", " + max + "]!");
                System.out.print("Enter again: ");
            }
        }
    }

    public String checkInputString(String name) {
        while (true) {
            System.out.print(name);
            String string = sc.nextLine().trim();
            if (string.isEmpty()) {
                System.err.println("Not allowed empty!");
                System.out.print("Enter again: ");
            } else {
                return string;
            }
        }
    }

    public String checkInputString1() {
        while (true) {
            String string = sc.nextLine();
            if (string.isEmpty()) {
                System.err.println("Not allowed empty!");
                System.out.println("Enter again: ");
            } else {
                return string;
            }
        }
    }

    public int checkInputAge(String name) {
        while (true) {
            System.out.print(name);
            System.out.println("");
            try {
                int number = sc.nextInt();
                if(number<18 || number>50){
                    throw new Exception("Age Invalid!!");
                }
                return number;
            } catch (Exception e) {
                System.err.println("Range of Age must be 18 to 50");
               // sc.nextLine();
            }
        }
    }
    
    public double checkInputSalary(String name) {
        while (true) {
            System.out.print(name);
            try {
                double number = Double.parseDouble(sc.nextLine().trim());
                if(number<0){
                    throw new NumberFormatException();
                }
                return number;
            } catch (NumberFormatException e) {
                System.err.println("Salary must be greater than 0");
               // sc.nextLine();
            }
        }
    }

    public boolean checkInputYesNo() {
        while (true) {
            String result = checkInputString1();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            } else if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            // System.out.println("Enter again: ");
        }
    }

    public boolean checkInputUpdateDelete() {
        while (true) {
            String result = checkInputString1();
            if (result.equalsIgnoreCase("U")) {
                return true;
            } else if (result.equalsIgnoreCase("D")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.println("Enter again: ");
        }
    }

    public boolean checkIdExist(ArrayList<Worker> list, String id) {
        try {
            for (Worker worker : list) {
                if (worker.getId().equalsIgnoreCase(id)) {
                    System.err.println("Id exist in list!");
                    return true;
                }
            }
        } catch (Exception e) {
            System.err.println("Not found!!");
        }
        return false;
    }
    
    public boolean checkWorkerExist(ArrayList<Worker> lw, String id,
            String name, int age, int salary, String workLocation) {
        //check from first to last list worker  worker exist or not
        for (Worker worker : lw) {
            if (id.equalsIgnoreCase(worker.getId())
                    && name.equalsIgnoreCase(worker.getName())
                    && age == worker.getAge()
                    && salary == worker.getSalary()) {
                return false;
            }
        }
        return true;
    }

}
