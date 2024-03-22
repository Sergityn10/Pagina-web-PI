package es.unex.pi.listener;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.logging.Logger;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyServletListener
 *
 */
@WebListener
public class MyServletListener implements ServletContextListener {

	Logger logger;
	
    /**
     * Default constructor. 
     */
    public MyServletListener() {
        // TODO Auto-generated constructor stub
    	logger = Logger.getLogger(MyServletListener.class.getName());
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	try {
	    	logger.info("DB shutdwon start");
	    	ServletContext sc = sce.getServletContext();
	    	Connection conn = (Connection) sc.getAttribute("dbConn");
	    	conn.close();
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	logger.info("DB destroyed");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	Connection conn = null;
    	try {
    		Class.forName("org.sqlite.JDBC");
    		String dbURL = "jdbc:sqlite:file:" + System.getProperty("user.home")+"/sqlite_dbs/Booking.db";
    		conn = DriverManager.getConnection(dbURL);
    		if (conn != null) {
    			logger.info ("Connected to database");
    			DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
    			logger.info ("Driver name:" + dm.getDriverName());
    			ServletContext sc = sce.getServletContext();
    			sc.setAttribute("dbConn",conn);
    	
//    			// Testing the connection
//    			Statement statement = conn.createStatement();  
//    	        ResultSet resultSet = statement.executeQuery("select * from pizzas");  
//    	         while (resultSet.next()) {  
//    	             System.out.println("Pizza: " + resultSet.getString("name"));  
//    	         } 
//    	        statement.close();
//    	        resultSet.close();
    		}
    	}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	logger.info("DB connection");
    }	
}
