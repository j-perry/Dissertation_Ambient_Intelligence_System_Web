/*
 * MSc Advanced Computer Science, University of Sussex
 * Jonathan Perry
 * Candidate No. 102235
 */
package ami.web.core.db;

// libraries
import static ami.web.core.db.IDatabase.dbUrl;
import static ami.web.core.db.IDatabase.driver;
import static ami.web.core.db.IDatabase.password;
import static ami.web.core.db.IDatabase.username;
import ami.web.core.models.client.DataBase;

// Java APIs
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * 
 * @author Jonathan Perry
 */
public class MonitoringTable implements IDatabase {
        
    private String query;
    
    private Statement qryStatement;
    private PreparedStatement prepQuery;
    private ResultSet resultSet;
    private Connection conn;
    
    private final String tableName = "Monitoring";
    
    public MonitoringTable() {
        // register the driver
        try {
            Class.forName(driver);
        }
        catch(ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Open a new JDBC connection
     */
    @Override
    public void open() {
        try {
            // https://mysql.student.sussex.ac.uk/phpmyadmin/
            conn = DriverManager.getConnection(dbUrl, username, password);
            System.out.println("MySQL CONNECTON FOUND");
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Close the JDBC connection
     */
    @Override
    public void close() {
        try {
            conn.close();
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
        
    /**
     * Retrieves raw data from the table
     * @return 
     */
    public ArrayList<DataBase> retrieveOverview() {
       ArrayList<DataBase> entries = new ArrayList<DataBase>();       
       DataBase dataBase = new DataBase();
       query = "SELECT * FROM " + tableName;
       
       try {
           conn = DriverManager.getConnection(dbUrl, username, password);            
           qryStatement = conn.createStatement();
           ResultSet rs = qryStatement.executeQuery(query);
           
           while(rs.next() ) {
               // session id
               dataBase.setSessionId(rs.getInt("SessionId"));
               
               // time
               dataBase.setHour(rs.getInt("Hour"));
               dataBase.setMinute(rs.getInt("Month"));
               
               // date
               dataBase.setDay(String.valueOf(rs.getInt("Day") ));
               dataBase.setMonth(String.valueOf(rs.getInt("Month") ));
               dataBase.setYear(rs.getInt("Year"));
               
               // general data
               dataBase.setValue(rs.getInt("Value"));
               dataBase.setType(rs.getString("Type"));
               dataBase.setLinguisticType(rs.getString("LinguisticType"));
               
               entries.add(dataBase);
           }
           
           rs.close();
       } catch(SQLException ex) {
           ex.printStackTrace();
       }
              
       return entries;
    }
    
    /**
     * Retrieves raw data from the table by field
     * @return 
     */
    public ArrayList<DataBase> retrieveOverviewByContext(String field) {
       ArrayList<DataBase> entries = new ArrayList<DataBase>();       
       DataBase dataBase = new DataBase();
       query = "SELECT * FROM " + tableName + " WHERE Context= '" + field + "'";
       
       try {
           conn = DriverManager.getConnection(dbUrl, username, password);            
           qryStatement = conn.createStatement();
           ResultSet rs = qryStatement.executeQuery(query);
           
           while(rs.next() ) {
               dataBase.setSessionId(rs.getInt("SessionId"));
               dataBase.setHostname(rs.getString("Hostname"));
               dataBase.setHour(rs.getInt("Hour"));
               dataBase.setMinute(rs.getInt("Minute"));
               dataBase.setDay(rs.getString("Day"));
               dataBase.setMonth(rs.getString("Month"));
               dataBase.setYear(rs.getInt("Year"));
               dataBase.setValue(rs.getInt("Value"));
               dataBase.setType(rs.getString("Context"));
               dataBase.setLinguisticType(rs.getString("LinguisticType"));
               
               entries.add(dataBase);
           }
           
           rs.close();
       } catch(SQLException ex) {
           ex.printStackTrace();
       }
              
       return entries;
    }
                
}