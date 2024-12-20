package jdbcm.study01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class app {
	Connection conn;
	public static void main(String[] args) {
		
		app myApp = new app();
		myApp.conn();
		myApp.getData();

		Connection con= myApp.getConn();
		List<user> usr = new ArrayList<user>();
		if(con != null) {
			usr = myApp.data(con);
		}
	}
	
 public void conn() {
	 String driver = "org.mariadb.jdbc.Driver";
	    try {
	        System.out.println("JDBC Start!");
	        Class.forName(driver);
	        
	        String url = "jdbc:mariadb://prj1119.tplinkdns.com:8282/edu";
	        String id = "user3";
	        String pwd = "user3";
	        
	        conn = DriverManager.getConnection(url, id, pwd);
	        System.out.println("JDBC connected!");
	    }
	    
	    catch(SQLException ex){
	    	System.out.println("jdbc driver exception!");
	    }
	    catch (ClassNotFoundException e) {

	    } catch (Exception e) {
	        e.printStackTrace();
	    } 
 }
 
 public void getData() {
	 try {
	     String sql = "SELECT * FROM users WHERE 삭제여부 = 0;";
	     PreparedStatement ps = conn.prepareStatement(sql);
	     ResultSet rs = ps.executeQuery();
		 List<user> list = new ArrayList<user>();
	     
	     while (rs.next()) {
	     	user usr = new user();
	     	usr.setNo(rs.getInt(1));
	     	usr.setEmail(rs.getString(2));
	     	usr.setPw(rs.getString(3));
	     	usr.setisDel(rs.getBoolean(4));
	     	list.add(usr);
			}
	     for(int i=0; i<list.size();i++) {
	    	 System.out.println(list.get(i));
	     }
	     System.out.println(list.size());
	     
	     rs.close();
	     ps.close();
	     System.out.println("JDBC Closeed");
	     
	 }catch(SQLException ex){
	    	System.out.println("jdbc driver exception!");
	    }catch (Exception e) {
	        e.printStackTrace();
	    } 
 }
 
 public List<user> data(Connection conn){
	 List<user> list = new ArrayList<user>();

	 try {
	     String sql = "SELECT * FROM users WHERE 삭제여부 = 0;";
	     PreparedStatement ps = conn.prepareStatement(sql);
	     ResultSet rs = ps.executeQuery();
		 
	     
	     while (rs.next()) {
	     	user usr = new user();
	     	usr.setNo(rs.getInt(1));
	     	usr.setEmail(rs.getString(2));
	     	usr.setPw(rs.getString(3));
	     	usr.setisDel(rs.getBoolean(4));
	     	list.add(usr);
			}
	     
	     rs.close();
	     ps.close();
	     
	 }catch(SQLException ex){
	    	System.out.println("jdbc driver exception!");
	    }catch (Exception e) {
	        e.printStackTrace();
	    } 
	return list;
	 
 }
 private Connection getConn() {
     try {
         String driver = "org.mariadb.jdbc.Driver";
         Class.forName(driver);
         System.out.println("JDBC Start!");

         String url = "jdbc:mariadb://prj1119.tplinkdns.com:8181/edu";
         String id = "user1";
         String pwd = "user1";
         return DriverManager.getConnection(url, id, pwd);
     } catch (ClassNotFoundException e) {
         System.out.println("JDBC Driver NO");
     } catch (Exception e) {
         e.printStackTrace();
     } 
     return null;
 }
 
 public void delData() {
	 try {
	     String sql = "delete from uses where 번호 = 9999;";
	     PreparedStatement ps = conn.prepareStatement(sql);
	     ResultSet rs = ps.executeQuery();
		 List<user> list = new ArrayList<user>();
	     
	     while (rs.next()) {
			}
	     
	     rs.close();
	     ps.close();
	     System.out.println("JDBC Closeed");
	     
	 }catch(SQLException ex){
	    	System.out.println("jdbc driver exception!");
	    }catch (Exception e) {
	        e.printStackTrace();
	    } 
 }
 
}