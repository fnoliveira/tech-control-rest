package br.com.af.techcontrol.rest.service;


import br.com.af.techcontrol.rest.entity.base.User;
import br.com.af.techcontrol.rest.service.base.CrudService;

public interface UserService extends CrudService<User, Long>{

	User findByUsername(String username);

	void createUserIfNotFound(User user, String roleName);

}