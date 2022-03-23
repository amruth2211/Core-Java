package JDBC.src.main;

import JDBC.src.util.DatabaseConnection;
import java.util.List;

import JDBC.src.dao.WorkerDAO;
import JDBC.src.dao.WorkerDAOImplementation;
import JDBC.src.model.Worker;
import java.util.Date;

public class App {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        WorkerDAO workerDao = new WorkerDAOImplementation();
        Worker worker = new Worker(8, "Amruth", "chowdary@gmail.com");
        System.out.println(workerDao.add(worker) + " row is added!!!");
        Worker emp = new Worker(9, "Amruth", "Chowdary", 20000, new Date(), "new",
                "chowdary99@gmail.com");
        workerDao.update(emp);
        List<Worker> list = workerDao.getWorkers();
        for (Worker workers : list) {
            System.out.println(workers);
        }
        System.out.println(workerDao.getWorker(1));
        workerDao.delete(9);

        DatabaseConnection.closeConnection();
    }
}
