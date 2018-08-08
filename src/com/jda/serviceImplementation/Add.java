package com.jda.serviceImplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.jda.model.Person;

public class Add {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public void readDataBase() throws Exception {
   
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/addressBook?"
                            + "user=root&password=admin");

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement
                    .executeQuery("select * from addressBook.Person");

            writeResultSet(resultSet);
           

}
        
    public void addDatabase(Person person) throws ClassNotFoundException, SQLException {
    	Class.forName("com.mysql.cj.jdbc.Driver");
        // Setup the connection with the DB
        connect = DriverManager
                .getConnection("jdbc:mysql://localhost/addressBook?"
                        + "user=root&password=admin");

        // Statements allow to issue SQL queries to the database
        statement = connect.createStatement();
    
    // PreparedStatements can use variables and are more efficient
    preparedStatement = connect
            .prepareStatement("insert into  addressBook.Person values ( ?, ?, ?, ? , ?, ?,?)");
    // "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
    // Parameters start with 1
    preparedStatement.setString(1, person.getFirstName());
    preparedStatement.setString(2, person.getLastName());
    preparedStatement.setString(3, person.getPhone());
    preparedStatement.setString(4, person.getCity());
    preparedStatement.setString(5, person.getZip());
    preparedStatement.setString(6, person.getAddress());
    preparedStatement.setString(7, person.getState());
    preparedStatement.executeUpdate();
    }
    public void updateDatabase(String attribute,String value,String firstName) throws ClassNotFoundException, SQLException {
    	Class.forName("com.mysql.cj.jdbc.Driver");
        // Setup the connection with the DB
        connect = DriverManager
                .getConnection("jdbc:mysql://localhost/addressBook?"
                        + "user=root&password=admin");

        // Statements allow to issue SQL queries to the database
        statement = connect.createStatement();
    
            
            preparedStatement = connect
                    .prepareStatement("  UPDATE addressBook.Person set "+attribute+" = ? where firstName = ?;");
           // preparedStatement.setString(1, attribute);
            preparedStatement.setString(1, value);
            preparedStatement.setString(2, firstName);
            preparedStatement.executeUpdate();
        } 
    public void deleteDatabase(String firstName) throws SQLException, ClassNotFoundException {
    	Class.forName("com.mysql.cj.jdbc.Driver");
        // Setup the connection with the DB
        connect = DriverManager
                .getConnection("jdbc:mysql://localhost/addressBook?"
                        + "user=root&password=admin");

    	preparedStatement = connect
                .prepareStatement("delete from addressBook.Person where firstName= ? ; ");
                preparedStatement.setString(1, firstName);
                preparedStatement.executeUpdate();
    }
    private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            String user = resultSet.getString("firstName");
            String website = resultSet.getString("lastName");
            String summary = resultSet.getString("phone");
            String date = resultSet.getString("city");
            String comment = resultSet.getString("zip");
            System.out.println("firstName: " + user);
            System.out.println("lastName: " + website);
            System.out.println("phone: " + summary);
            System.out.println("city: " + date);
            System.out.println("zip: " + comment);
        }
      
    }
}
