package io.java.sqlconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class sqlConnection {

	 // JDBC URL, username, and password of MySQL server
    private static final String JDBC_URL = "jdbc:sqlserver://localhost:1433;databaseName=Students;integratedSecurity=true;encrypt=true;trustServerCertificate=true";
    
    // JDBC Driver name and database URL
    private static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    
	public static void main(String[] args) {
		 
		 Object connection = null;
		try {
	            // Load and register the SQL Server JDBC driver
	            Class.forName(JDBC_DRIVER);

	            // Open a connection
	            System.out.println("Connecting to the database...");
	            connection = DriverManager.getConnection(JDBC_URL);

	            // If the connection is successful
	            System.out.println("Connection successful!");

	            // Perform a simple query to test the connection
	            String query = "SELECT TOP 1 * FROM Student";
	            var statement = ((Connection) connection).createStatement();
	            var resultSet = ((Statement) statement).executeQuery(query);

	            // Display the result (if any)
	            if (((ResultSet) resultSet).next()) {
	                System.out.println("Connected to the Students database and found a record in the Student table:");
	                System.out.println("Student ID: " + resultSet.getInt(1));
	            } else {
	                System.out.println("Connected to the Students database, but the Student table is empty.");
	            }

	        } catch (SQLException sqlException) {
	            // Handle any SQL errors
	            System.err.println("SQL Exception: " + sqlException.getMessage());
	            sqlException.printStackTrace();
	        } catch (ClassNotFoundException classNotFoundException) {
	            // Handle errors for the JDBC driver not found
	            System.err.println("JDBC Driver not found: " + classNotFoundException.getMessage());
	            classNotFoundException.printStackTrace();
	        } finally {
	            // Close the connection
	            try {
	                if (connection != null) {
	                    ((Connection) connection).close();
	                }
	            } catch (SQLException sqlException) {
	                sqlException.printStackTrace();
	            }
	        }
	}

}
