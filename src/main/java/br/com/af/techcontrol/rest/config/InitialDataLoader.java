package br.com.af.techcontrol.rest.config;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.af.techcontrol.rest.entity.base.Contato;
import br.com.af.techcontrol.rest.entity.base.Endereco;
import br.com.af.techcontrol.rest.entity.base.Pessoa;
import br.com.af.techcontrol.rest.entity.base.Privilege;
import br.com.af.techcontrol.rest.entity.base.Telefone;
import br.com.af.techcontrol.rest.entity.base.User;
import br.com.af.techcontrol.rest.entity.condominio.Bloco;
import br.com.af.techcontrol.rest.entity.condominio.Condominio;
import br.com.af.techcontrol.rest.entity.condominio.Unidade;
import br.com.af.techcontrol.rest.entity.funcionario.Administrador;
import br.com.af.techcontrol.rest.entity.funcionario.Funcionario;
import br.com.af.techcontrol.rest.enums.TipoPessoa;
import br.com.af.techcontrol.rest.service.AdministradorService;
import br.com.af.techcontrol.rest.service.BlocoService;
import br.com.af.techcontrol.rest.service.CondominioService;
import br.com.af.techcontrol.rest.service.EnderecoService;
import br.com.af.techcontrol.rest.service.PrivilegeService;
import br.com.af.techcontrol.rest.service.RoleService;
import br.com.af.techcontrol.rest.service.UnidadeService;
import br.com.af.techcontrol.rest.service.UserService;

@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	boolean alreadySetup = false;

	@Autowired
	private UserService userService;

	@Autowired
	AdministradorService administradorService;

	@Autowired
	CondominioService condominioService;

	@Autowired
	private BlocoService blocoService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private PrivilegeService privilegeService;

	@Autowired
	private EnderecoService enderecoService;

	@Autowired
	private UnidadeService unidadeService;

	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent event) {

		if (alreadySetup)
			return;

		initPrivilegesAndRoles();

		createUserMaster();

		createAdministradorPJ();

		createCondominio();

		createUnidade();

		alreadySetup = true;
	}

	private void createUserMaster() {
		
		Contato contato = new Contato("Comercial");
		contato.setEmail("fnolivei@outlook.com");
		
		Pessoa pessoa = new Pessoa("Master", TipoPessoa.FISICA, "31406826898", true);
		pessoa.setContatos(Arrays.asList(contato));
		
		User user = new User(pessoa, "master", "123456", true);
		pessoa.setUser(user);
		userService.createUserIfNotFound(user, "ROLE_MASTER");
	}

	private void createAdministradorPJ() {

		Endereco enderecoA = new Endereco("06663190", "Rua um", "45", "", "Setor D", "Sao Paulo", "SP", "BR", true);
		Endereco enderecoB = new Endereco("06663045", "Rua dois", "90", "", "Setor E", "Sao Paulo", "SP", "BR", true);

		Contato contato = new Contato("Comercial");
		contato.setEmail("sac@passos.com.br");
		contato.setTelefones(Arrays.asList(new Telefone("Celular", "11", "123451234", true), new Telefone("Empresa", "11", "34343232", true)));

		Pessoa pessoa = new Pessoa("Passos Adm", TipoPessoa.JURIDICA, "24540435000197", true);
		pessoa.setContatos(Arrays.asList(contato));
		pessoa.setEnderecos(Arrays.asList(enderecoA, enderecoB));

		User user = new User(pessoa, "adm", "123456", true);
		pessoa.setUser(user);
		userService.createUserIfNotFound(user, "ROLE_ADMIN");

		Administrador administrador = new Administrador(new Funcionario(pessoa, LocalDate.now(),true), true);

		administradorService.save(administrador);

	}

	private void createCondominio() {

		Endereco endereco = new Endereco("06663190", "Rua um", "45", "", "Setor D", "Sao Paulo", "SP", "BR", true);

		Contato contato = new Contato("Comercial");
		contato.setEmail("parquedasrosas@tech-control.com.br");
		contato.setTelefones(Arrays.asList(new Telefone("Empresa", "11", "41414141", true)));

		Pessoa pessoa = new Pessoa("Parque das Rosas", TipoPessoa.JURIDICA, "04846310000182", true);
		pessoa.setContatos(Arrays.asList(contato));
		pessoa.setEnderecos(Arrays.asList(endereco));

		Condominio condominio = new Condominio();
		condominio.setPessoa(pessoa);
		condominio.setFinalidade("Residencial");
		condominio.setTipoCondominio("vertical");
		condominio.setIsEnable(true);
		condominio.setBlocos(Arrays.asList(new Bloco("A", true), new Bloco("B", true)));
		condominioService.save(condominio);

	}

	private void createUnidade() {
		
		Condominio condominio = condominioService.findByCNPJ("04846310000182");
		
		List<Bloco> blocos = condominio.getBlocos();
		
		for (Bloco bloco : blocos) {
			
			List<Unidade> unidades = unidadeService.save(Arrays.asList(new Unidade("110", true), new Unidade("120", true), new Unidade("130", true),
					new Unidade("140", true)));
			
			bloco.setUnidades(unidades);
			
			blocoService.save(bloco);
		}
	}

	private void initPrivilegesAndRoles() {

		// == create initial privileges
		Privilege readPrivilege = privilegeService.createPrivilegeIfNotFound("READ_PRIVILEGE");
		Privilege writePrivilege = privilegeService.createPrivilegeIfNotFound("WRITE_PRIVILEGE");
		Privilege masterPrivilege = privilegeService.createPrivilegeIfNotFound("MASTER_PRIVILEGE");

		// == create initial roles
		List<Privilege> adminPrivileges = Arrays.asList(readPrivilege, writePrivilege);
		roleService.createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);

		List<Privilege> rolePrivileges = new ArrayList<>();
		roleService.createRoleIfNotFound("ROLE_USER", rolePrivileges);

		List<Privilege> masterPrivileges = Arrays.asList(masterPrivilege);
		roleService.createRoleIfNotFound("ROLE_MASTER", masterPrivileges);

	}

}
