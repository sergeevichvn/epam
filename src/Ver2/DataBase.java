package Ver2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * Class DataBase provides for works with a database;
 */
public class DataBase {
	
	private static String url = "jdbc:sqlite:./database/bill_db.s3db";
	
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	
	private static void connectionToDB() throws ClassNotFoundException, SQLException{
		Class.forName("org.sqlite.JDBC"); //create a class of the driver on a name
		con = DriverManager.getConnection(url); //get connection to database
		stmt = con.createStatement(); //create statement
  }
	
	private static void closeConnection() throws ClassNotFoundException, SQLException{
		rs.close();
		stmt.close();
		con.close();
	}
	
	//get employees from the database
	public static List<Employee> exportEmployee() throws ClassNotFoundException, SQLException{
		connectionToDB();
		String sqlQuery = "SELECT * FROM employee;";
		List<Employee> employees = new ArrayList<Employee>();
		
		rs = stmt.executeQuery(sqlQuery);
		
		while(rs.next()){
			employees.add(new Employee(rs.getString("lastname")));
		}
		closeConnection();
		
		return employees;
	}
	
	
	//get dishes from the database
	public static Menu exportDish() throws ClassNotFoundException, SQLException{
		connectionToDB();
		String sqlQuery = "SELECT * FROM dish;";
		Menu menu = new Menu();
		
		rs = stmt.executeQuery(sqlQuery);
		
		while(rs.next()){
			menu.addDishInMenu(new Dish(rs.getString("name"), rs.getDouble("weight"), rs.getDouble("price")));
		}
		closeConnection();
		
		return menu;
	}
	
	public static void setUrlToDB(String u){
		url = u;
	}
	
	
    @Override
    public String toString() { return "DataBase[url="+url+"]"; }
    
	
}
