package br.com.af.techcontrol.rest.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.af.techcontrol.rest.entity.base.Contato;
import br.com.af.techcontrol.rest.entity.base.Email;
import br.com.af.techcontrol.rest.entity.base.Endereco;
import br.com.af.techcontrol.rest.entity.base.PessoaFisica;
import br.com.af.techcontrol.rest.entity.base.PessoaJuridica;
import br.com.af.techcontrol.rest.entity.base.Privilege;
import br.com.af.techcontrol.rest.entity.base.Role;
import br.com.af.techcontrol.rest.entity.base.Telefone;
import br.com.af.techcontrol.rest.entity.base.User;
import br.com.af.techcontrol.rest.entity.condominio.Administrador;
import br.com.af.techcontrol.rest.entity.condominio.Bloco;
import br.com.af.techcontrol.rest.entity.condominio.Condominio;
import br.com.af.techcontrol.rest.entity.condomino.Unidade;
import br.com.af.techcontrol.rest.repository.AdministradorRepository;
import br.com.af.techcontrol.rest.repository.PrivilegeRepository;
import br.com.af.techcontrol.rest.repository.RoleRepository;
import br.com.af.techcontrol.rest.repository.UserRepository;

@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	boolean alreadySetup = true;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AdministradorRepository administradorRepository;

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

		criarUsuarios();

		//criarAdministradorPF();

		alreadySetup = true;
	}

	private void criarAdministradorPF() {

		PessoaFisica pf = new PessoaFisica();
		pf.setNome("Fatima");
		pf.setCpf("12345678901");
		pf.setSexo("F");
		pf.setIsEnable(true);

		List<Email> emailsAdmin = new ArrayList<Email>();
		emailsAdmin.add(new Email("Comercial", "fatima@tech.com.br", true, true));
		emailsAdmin.add(new Email("Pessoal", "fatima@bol.com.br", false, true));
		List<Telefone> telefonesAdmin = new ArrayList<Telefone>();
		telefonesAdmin.add(new Telefone("Celular", "11", "123451234", true));

		List<Condominio> condominios = new ArrayList<Condominio>();
		Condominio condominio = new Condominio();
		condominio.setFinalidade("Residencial");
		condominio.setTipoCondominio("V");
		condominio.setIsEnable(true);

		PessoaJuridica pj = new PessoaJuridica();
		pj.setNome("Condominio Parque das Rosas");
		pj.setCnpj("12345678901234");
		pj.setIsEnable(true);
		pj.setRazaoSocial("F Associacao Condominio Ltda");
		condominio.setPessoa(pj);

		condominio.setEndereco(new Endereco("06663190", "Rua um", "45", "", "Setor D", "Sao Paulo", "SP", "BR", true));

		List<Telefone> telefonesCond = new ArrayList<Telefone>();
		telefonesCond.add(new Telefone("Celular", "11", "123451234", true));
		List<Email> emailsCond = new ArrayList<Email>();
		emailsCond.add(new Email("Comercial", "pqrosas@tech.com.br", true, true));
		condominio.setContato(new Contato(telefonesCond, emailsCond));

		List<Unidade> unidades = new ArrayList<Unidade>();
		unidades.add(new Unidade("110"));
		unidades.add(new Unidade("120"));
		unidades.add(new Unidade("130"));

		List<Bloco> blocos = new ArrayList<Bloco>();
		blocos.add(new Bloco("Bloco A", unidades));

		condominio.setBlocos(blocos);

		condominios.add(condominio);

		Administrador adm = new Administrador(pf, new Contato(telefonesAdmin, emailsAdmin), condominios, true);

		administradorRepository.save(adm);

	}

	private void criarUsuarios() {
		PessoaFisica pf = new PessoaFisica();

		// == create initial privileges
		Privilege readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
		Privilege writePrivilege = createPrivilegeIfNotFound("WRITE_PRIVILEGE");
		Privilege masterPrivilege = createPrivilegeIfNotFound("MASTER_PRIVILEGE");

		// == create initial roles
		List<Privilege> adminPrivileges = Arrays.asList(readPrivilege, writePrivilege);
		createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);

		List<Privilege> rolePrivileges = new ArrayList<>();
		createRoleIfNotFound("ROLE_USER", rolePrivileges);

		List<Privilege> masterPrivileges = Arrays.asList(masterPrivilege);
		createRoleIfNotFound("ROLE_MASTER", masterPrivileges);

		// USUARIO ROOT
		Role masterRole = roleRepository.findByName("ROLE_MASTER");
		User masterUser = new User();
		pf.setNome("Master");
		pf.setIsEnable(true);
		pf.setCpf("99999999992");
		masterUser.setPessoa(pf);
		masterUser.setUsername("master");
		masterUser.setEmail("master@test.com");
		masterUser.setPassword(passwordEncoder.encode("123456"));
		masterUser.setRoles(Arrays.asList(masterRole));
		masterUser.setIsEnable(true);
		userRepository.save(masterUser);

		Role adminRole = roleRepository.findByName("ROLE_ADMIN");
		User user = new User();
		pf.setNome("Sindico");
		pf.setIsEnable(true);
		pf.setCpf("12312312334");
		user.setPessoa(pf);
		user.setUsername("admin");
		user.setEmail("admin@test.com");
		user.setPassword(passwordEncoder.encode("123456"));
		user.setRoles(Arrays.asList(adminRole));
		user.setIsEnable(true);
		userRepository.save(user);

		Role basicRole = roleRepository.findByName("ROLE_USER");
		User basicUser = new User();
		pf.setNome("Condomino");
		pf.setIsEnable(true);
		pf.setCpf("88888888890");
		basicUser.setPessoa(pf);
		basicUser.setUsername("user");
		basicUser.setEmail("user@test.com");
		basicUser.setPassword(passwordEncoder.encode("123456"));
		basicUser.setRoles(Arrays.asList(basicRole));
		basicUser.setIsEnable(true);
		userRepository.save(basicUser);
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
