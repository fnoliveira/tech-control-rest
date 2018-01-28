package br.com.af.techcontrol.rest.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.af.techcontrol.rest.entity.base.PessoaFisica;
import br.com.af.techcontrol.rest.entity.base.Privilege;
import br.com.af.techcontrol.rest.entity.base.Role;
import br.com.af.techcontrol.rest.entity.base.User;
import br.com.af.techcontrol.rest.repository.PrivilegeRepository;
import br.com.af.techcontrol.rest.repository.RoleRepository;
import br.com.af.techcontrol.rest.repository.UserRepository;

@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	boolean alreadySetup = true;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PrivilegeRepository privilegeRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent event) {

		if (alreadySetup)
			return;

		// == create initial privileges
		Privilege readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
		Privilege writePrivilege = createPrivilegeIfNotFound("WRITE_PRIVILEGE");

		// == create initial roles
		List<Privilege> adminPrivileges = Arrays.asList(readPrivilege, writePrivilege);
		createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);

		List<Privilege> rolePrivileges = new ArrayList<>();
		createRoleIfNotFound("ROLE_USER", rolePrivileges);

		Role adminRole = roleRepository.findByName("ROLE_ADMIN");
		User user = new User();
		PessoaFisica pf = new PessoaFisica();
		pf.setNome("Francis");
		pf.setEnabled(true);
		pf.setCpf("99999999992");
		pf.setDataNascimento(new Date("01/01/2000"));
		pf.setSexo("M");
		user.setPessoa(pf);
		user.setUsername("admin");
		user.setEmail("admin@test.com");
		user.setPassword(passwordEncoder.encode("123456"));
		user.setRoles(Arrays.asList(adminRole));
		user.setEnabled(true);
		userRepository.save(user);

		Role basicRole = roleRepository.findByName("ROLE_USER");
		User basicUser = new User();
		basicUser.setUsername("user");
		basicUser.setEmail("user@test.com");
		basicUser.setPassword(passwordEncoder.encode("123456"));
		basicUser.setRoles(Arrays.asList(basicRole));
		basicUser.setEnabled(true);
		userRepository.save(basicUser);

		alreadySetup = true;
	}

	@Transactional
	private Privilege createPrivilegeIfNotFound(String name) {
		Privilege privilege = privilegeRepository.findByName(name);
		if (privilege == null) {
			privilege = new Privilege(name);
			privilegeRepository.save(privilege);
		}
		return privilege;
	}

	@Transactional
	private Role createRoleIfNotFound(String name, Collection<Privilege> privileges) {
		Role role = roleRepository.findByName(name);
		if (role == null) {
			role = new Role(name);
			role.setPrivileges(privileges);
			roleRepository.save(role);
		}
		return role;
	}
}
