package JDBC.src.main;

import java.sql.*;

public class EmailAdd {
    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        final String url = "jdbc:mysql://localhost:3307/my_org";
        final String username = "root";
        final String password = "1234";

        /* Establishing a connection with the DB */
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            /* Fetching some DB metadata */
            System.out.println("Connected to database server "
                    + connection.getMetaData().getDatabaseProductName()
                    + " version: "
                    + connection.getMetaData().getDatabaseProductVersion());

            /* Statement Demo */
            try (Statement statement = connection.createStatement()) {
                // ADDING COLUMN EMAIL INTO WORKER
                String sql1 = "ALTER TABLE worker ADD email varchar(50) NOT NULL";
                statement.execute(sql1);

                String sql2 = """
                        UPDATE Worker
                            SET
                                email = CONCAT(LOWER(SUBSTRING(FIRST_NAME, 1, 1)), ".", LOWER(LAST_NAME), "@my_org.com")""";

                statement.execute(sql2);
                int rowsupdated = statement.executeUpdate(sql2);
                System.out.println((rowsupdated + " rows inserted."));

                String replaceSql = "update worker set email = replace(email,'com','in')";
                // statement.execute(replaceSql);
                int rowsreplaced = statement.executeUpdate(replaceSql);
                System.out.println(rowsreplaced + " rows replaced.");
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
