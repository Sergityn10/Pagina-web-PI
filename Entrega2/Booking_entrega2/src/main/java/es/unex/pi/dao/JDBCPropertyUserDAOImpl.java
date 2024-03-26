package es.unex.pi.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import es.unex.pi.model.propertyUser;
import es.unex.pi.model.propertyUser;

public class JDBCPropertyUserDAOImpl implements PropertyUserDAO {
	private Connection conn;
	private static final Logger logger = Logger.getLogger(JDBCPropertyUserDAOImpl.class.getName());
	
	@Override
	public void setConnection(Connection conn) {
		// TODO Auto-generated method stub
		this.conn=conn;
	}

	@Override
	public List<propertyUser> getAll() {
		// TODO Auto-generated method stub
		if (conn == null) return null;
		
		ArrayList<propertyUser> propertyUserList = new ArrayList<propertyUser>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM propertyUser");
						
			while ( rs.next() ) {
				propertyUser propertyUser = new propertyUser();
				fromRsToPropertyUserObject(rs,propertyUser);
				propertyUserList.add(propertyUser);
				logger.info("fetching all propertyUser: "+propertyUser.getIdp()+" "+propertyUser.getIdu());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return propertyUserList;
	}

	@Override
	public List<propertyUser> getAllByUser(long idu) {
		// TODO Auto-generated method stub
		if (conn == null) return null;
		
		ArrayList<propertyUser> propertyUserList = new ArrayList<propertyUser>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM propertyUser WHERE idu="+idu);

			while ( rs.next() ) {
				propertyUser propertyUser = new propertyUser();
				fromRsToPropertyUserObject(rs,propertyUser);
				propertyUserList.add(propertyUser);
				logger.info("fetching all propertyUser by idp: "+propertyUser.getIdp()+"->"+propertyUser.getIdu());
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return propertyUserList;
	}

	@Override
	public List<propertyUser> getAllByProperty(long idp) {
		// TODO Auto-generated method stub
		if (conn == null) return null;
		
		ArrayList<propertyUser> propertyUserList = new ArrayList<propertyUser>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM propertyUser WHERE idp="+idp);

			while ( rs.next() ) {
				propertyUser propertyUser = new propertyUser();
				fromRsToPropertyUserObject(rs,propertyUser);
				propertyUserList.add(propertyUser);
				logger.info("fetching all propertyUser by idu: "+propertyUser.getIdu()+"-> "+propertyUser.getIdp());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return propertyUserList;
	}

	@Override
	public propertyUser get(long idp, long idu) {
		// TODO Auto-generated method stub
if (conn == null) return null;
		
		propertyUser propertyUser = null;		
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM propertyUser WHERE idp="+idp+" AND idu="+idu);			 
			if (!rs.next()) return null;
			propertyUser= new propertyUser();
			fromRsToPropertyUserObject(rs,propertyUser);
			logger.info("fetching propertyUser by idp: "+propertyUser.getIdp()+"  and idu: "+propertyUser.getIdu());
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return propertyUser;
	}

	@Override
	public boolean add(propertyUser propertyUser) {
		// TODO Auto-generated method stub
		boolean done = false;
		if (conn != null){
			
			Statement stmt;
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate("INSERT INTO propertyUser (idp,idu) VALUES('"+
									propertyUser.getIdp()+"','"+
									propertyUser.getIdu()+"')");
						
				logger.info("creating propertyUser:("+propertyUser.getIdp()+" "+propertyUser.getIdu());
				done= true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return done;
	}

	@Override
	public boolean update(propertyUser dbObject, propertyUser newObject) {
		// TODO Auto-generated method stub
		boolean done = false;
		if (conn != null){

			Statement stmt;
			try {
				stmt = conn.createStatement();
				
				stmt.executeUpdate("UPDATE propertyUser SET idu="+newObject.getIdu()
				+" WHERE idp = "+dbObject.getIdp() + " AND idu = " + dbObject.getIdu());
				
				logger.info("updating propertyUser:("+dbObject.getIdp()+" "+dbObject.getIdu());
				
				done= true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return done;
	}

	@Override
	public boolean delete(long idp, long idu) {
		// TODO Auto-generated method stub
		boolean done = false;
		if (conn != null){

			Statement stmt;
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate("DELETE FROM propertyUser WHERE idp ="+idp+" AND idu="+idu);
				logger.info("deleting propertyUser: "+idp+" , idu="+idu);
				done= true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return done;
	}
	public void fromRsToPropertyUserObject(ResultSet rs, propertyUser propertyUser) throws SQLException {
		propertyUser.setIdp(rs.getInt("idp"));
		propertyUser.setIdu(rs.getInt("idu"));
				

	}

}
