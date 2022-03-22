package JDBC.src.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import JDBC.src.model.Worker;
import JDBC.src.util.DatabaseConnection;

public class WorkerDAOImplementation implements WorkerDAO {
    Connection connection;

    public WorkerDAOImplementation() throws SQLException {
        this.connection = DatabaseConnection.getConnection();

    }

    public int add(Worker worker) throws SQLException {
        int workerId = worker.getWorkerId();
        String firstName = worker.getFirstName();
        String lastName = worker.getLastName();
        int salary = worker.getSalary();
        Date date = worker.getJoiningDate();
        String department = worker.getDepartment();
        String email = worker.getEmail();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String joiningDate = sdf.format(date);
        String query = String.format("INSERT INTO worker VALUES(%d,'%s','%s',%d,'%s','%s','%s');", workerId,
                firstName,
                lastName, salary, joiningDate, department, email);
        try (Statement statement = connection.createStatement()) {
            return statement.executeUpdate(query);
        }

    }

    public void delete(int workerId) throws SQLException {
        String query = "DELETE FROM Worker WHERE WORKER_ID = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, workerId);
            int res = ps.executeUpdate();
            System.out.println(res + " row is deleted!!!");
        }

    }

    public Worker getWorker(int workerId) throws SQLException {
        String query = "SELECT * FROM worker WHERE worker_id=?";
        Worker res = null;
        try (PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setInt(1, workerId);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                int workerId1 = result.getInt("worker_id");
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                int salary = result.getInt("salary");
                Date date = result.getDate("joining_date");
                String department = result.getString("department");
                String email = result.getString("email");

                res = new Worker(workerId1, firstName, lastName, salary, date, department, email);
            }
        }
        return res;
    }

    public List<Worker> getWorkers() throws SQLException {
        String query = "SELECT * FROM worker";
        List<Worker> list = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                int workerId = result.getInt("worker_id");
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                int salary = result.getInt("salary");
                Date date = result.getDate("joining_date");
                String department = result.getString("department");
                String email = result.getString("email");

                list.add(new Worker(workerId, firstName, lastName, salary, date, department, email));
            }
        }

        return list;
    }

    public void update(Worker emp) throws SQLException {
        int workerId = emp.getWorkerId();
        String firstName = emp.getFirstName();
        String lastName = emp.getLastName();
        int salary = emp.getSalary();
        Date date = emp.getJoiningDate();
        String department = emp.getDepartment();
        String email = emp.getEmail();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String joiningDate = sdf.format(date);
        String query = String.format("""
                UPDATE worker SET
                worker_id =%d,
                first_name = '%s',
                last_name ='%s',
                salary =%d,
                joining_date = '%s',
                department = '%s',
                email = '%s'
                WHERE worker_id = %d """, workerId,
                firstName,
                lastName, salary, joiningDate, department, email, workerId);
        try (Statement statement = connection.createStatement()) {
            int res = statement.executeUpdate(query);
            System.out.println(res + " row get Updated");
        }

    }
}
