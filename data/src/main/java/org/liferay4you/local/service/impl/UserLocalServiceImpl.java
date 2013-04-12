package org.liferay4you.local.service.impl;

import java.util.List;

import org.apache.commons.collections.IteratorUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.liferay4you.local.service.UserLocalService;
import org.liferay4you.model.User;
import org.liferay4you.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("unchecked")
public class UserLocalServiceImpl implements UserLocalService {
	
	Log log = LogFactory.getLog(getClass());
	
	/* *******************************
	 ******* Implementation **********
	 ****************************** */
	
	public User findById(long id) {
		return userRepository.findOne(id);
	}
	
	public void delete(long id) {
		userRepository.delete(id);
	}
	
	public void delete(User user) {
		userRepository.delete(user);
	}
	
	public List<User> findAll() {
		return IteratorUtils.toList(userRepository.findAll().iterator());
	}
	
	public User update(User user) {
		return userRepository.save(user);
	}
	
	public User updatePassword(User user, String pssw) {
		String pass = BCrypt.hashpw(pssw, BCrypt.gensalt());
		user.setPassword(pass);
		return userRepository.save(user);
	}
	
	public boolean checkPssw(String userMail, String pssw) {
		try {
			User user = userRepository.findByMail(userMail);
			return BCrypt.checkpw(pssw, user.getPassword());
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error on -checkPssw(String userMail, String pssw)- ", e);
			return false;
		}
	}
	
	public boolean existsUserMail(String userMail) {
		boolean exists = true;
		try {
			User user = userRepository.findByMail(userMail);
			if (user == null) {
				exists = false;
			}
		} catch (Exception e) {
			log.error("Error on -existsUserMail(String userMail)- ", e);
		}
		return exists;
	}
	
	public User loginUser(String userMail) {
		return userRepository.findByMail(userMail);
	}
	
	/* *******************************
	 ******** Repositories ***********
	 ****************************** */
	
	private UserRepository userRepository;
	
	/* *******************************
	 ********* Constructor ***********
	 ****************************** */
	
	@Autowired
	public UserLocalServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
}
