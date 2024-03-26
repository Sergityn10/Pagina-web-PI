package es.unex.pi.dao;

import java.sql.Connection;
import java.util.List;

import es.unex.pi.model.propertyUser;

public interface PropertyUserDAO {
	/**
	 * set the database connection in this DAO.
	 * 
	 * @param conn
	 *            database connection.
	 */
	public void setConnection(Connection conn);

	/**
	 * Gets all the property and the categories related to them from the database.
	 * 
	 * @return List of all the property and the categories related to them from the database.
	 */
	
	public List<propertyUser> getAll();

	/**
	 *Gets all the PropertyCategory that are related to a category.
	 * 
	 * @param idu
	 *            Category identifier
	 * 
	 * @return List of all the PropertyCategory related to a category.
	 */
	public List<propertyUser> getAllByUser(long idu);
	
	/**
	 * Gets all the PropertyCategory that contains an specific property.
	 * 
	 * @param idp
	 *            Property Identifier
	 * 
	 * @return List of all the PropertyCategory that contains an specific property
	 */
	public List<propertyUser> getAllByProperty(long idp);

	/**
	 * Gets a PropertyCategory from the DB using idr and idu.
	 * 
	 * @param idp 
	 *            property identifier.
	 *            
	 * @param idu
	 *            User Identifier
	 * 
	 * @return PropertyCategory with that idr and idu.
	 */
	
	public propertyUser get(long idp,long idu);

	/**
	 * Adds an PropertyCategory to the database.
	 * 
	 * @param PropertyCategory
	 *            PropertyCategory object with the details of the relation between the property and the category.
	 * 
	 * @return property identifier or -1 in case the operation failed.
	 */
	
	public boolean add(propertyUser PropertyCategory);

	/**
	 * Updates an existing PropertyCategory in the database.
	 * 
	 * @param dbObject
	 *            PropertyCategory object that is going to be updated in the database 
	 * @param newObject
	 *            PropertyCategory object with the new details of the existing relation between the property and the category. 
	 * 
	 * @return True if the operation was made and False if the operation failed.
	 */
	
	public boolean update(propertyUser dbObject, propertyUser newObject);

	/**
	 * Deletes an PropertyUser from the database.
	 * 
	 * @param idp
	 *            Property identifier.
	 *            
	 * @param idu
	 *            User Identifier
	 * 
	 * @return True if the operation was made and False if the operation failed.
	 */
	
	public boolean delete(long idp, long idu);
}
