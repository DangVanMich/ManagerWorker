
package model;

import java.net.Socket;
import java.util.Date;

/**
 *
 * @author admin
 */
public class History {
    private Worker worker;
    private String status;
    private Date date;

    public History(Worker worker, String status, Date date) {
        this.worker = worker;
        this.status = status;
        this.date = date;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format("%-13s%-13s%-13s%-13s%-13s%-13s", worker.getId(), worker.getName(), worker.getAge(), worker.getSalary(), getStatus(), ( (date.getDate()+1)+"/"+(date.getMonth()+1)+"/"+(date.getYear()+1900) ) );
    }
   
}