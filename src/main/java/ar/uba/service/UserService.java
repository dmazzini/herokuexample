package ar.uba.service;

import ar.uba.domain.User;

public interface UserService {

	public void saveUser(User user);
	
	public void saveAdminUser(User user);
	
	public boolean isUserAlreadyPresent(User user);
}
