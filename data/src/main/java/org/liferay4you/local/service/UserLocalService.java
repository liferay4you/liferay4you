package org.liferay4you.local.service;

import java.util.List;

import org.liferay4you.model.User;


public interface UserLocalService {

	/**
	 * Return the user given its id
	 * @param id
	 * @return
	 */
	public User findById(long id);
	
	/**
	 * Deletes the user given its id
	 * @param id
	 */
	public void delete(long id);
	
	/**
	 * Deletes the user given the object
	 * @param user
	 */
	public void delete(User user);
	
	/**
	 * Returns all users
	 * @return
	 */
	public List<User> findAll();
	
	/**
	 * Updates or creates the user given the object
	 * @param user
	 * @return
	 */
	public User update(User user);
	
	/**
	 * Updates or creates the user given the object and sets the password (BCrypt.hash)
	 * @param user
	 * @param pssw
	 * @return
	 */
	public User updatePassword(User user, String pssw);
	
	/**
	 * Checks the user mail with the password
	 * @param userMail
	 * @param pssw
	 * @return
	 */
	public boolean checkPssw(String userMail, String pssw);
	
	/**
	 * Checks if the user already exists (returns true if there is an error)
	 * @param userMail
	 * @return
	 */
	public boolean existsUserMail(String userMail);
	
	/**
	 * Returns the Object User given it's mail.
	 * @param userMail
	 * @return
	 */
	public User loginUser(String userMail);
}
