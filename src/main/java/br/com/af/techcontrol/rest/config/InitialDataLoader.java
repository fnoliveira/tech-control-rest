package br.com.af.techcontrol.rest.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.af.techcontrol.rest.entity.base.Endereco;
import br.com.af.techcontrol.rest.entity.base.Pessoa;
import br.com.af.techcontrol.rest.entity.base.Privilege;
import br.com.af.techcontrol.rest.entity.base.Telefone;
import br.com.af.techcontrol.rest.entity.base.User;
import br.com.af.techcontrol.rest.entity.condominio.Administrador;
import br.com.af.techcontrol.rest.enums.TipoPessoa;
import br.com.af.techcontrol.rest.service.AdministradorService;
import br.com.af.techcontrol.rest.service.BlocoService;
import br.com.af.techcontrol.rest.service.EnderecoService;
import br.com.af.techcontrol.rest.service.PessoaService;
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
	private PessoaService pessoaService;
	
	@Autowired
	AdministradorService administradorService;
	
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
			
		alreadySetup = true;
	}
	
	private void createUserMaster() {
		Pessoa pessoa = new Pessoa("Master",TipoPessoa.FISICA,"31406826898", null,null,null,"f@f.com",null);
		User user = new User(pessoa, "master", "123456", null, true);
		pessoa.setUser(user);
		userService.createUserIfNotFound(user, "ROLE_MASTER");
	}
	
	private void createAdministradorPJ() {

		Endereco enderecoA = new Endereco("06663190", "Rua um", "45", "", "Setor D", "Sao Paulo", "SP", "BR", true);
		Endereco enderecoB = new Endereco("06663045", "Rua dois", "90", "", "Setor E", "Sao Paulo", "SP", "BR", true);
				
		Pessoa pessoa = new Pessoa("Passos Adm",TipoPessoa.JURIDICA,"24540435000197", null,
				Arrays.asList(enderecoA, enderecoB),
				Arrays.asList(new Telefone("Celular", "11", "123451234", true),	new Telefone("Empresa", "11", "34343232", true)),
				"sac@passos.com.br",null);
		
		User user = new User(pessoa, "adm", "123456", null, true);
		pessoa.setUser(user);
		userService.createUserIfNotFound(user, "ROLE_ADMIN");
		
		Administrador administrador = new Administrador(pessoa, true);

		administradorService.save(administrador);
		
	}

	

	/*private void createCondominio() {

		Endereco endereco = new Endereco("06663000", "Rua tres", "100", "", "Setor A", "Sao Paulo", "SP", "BR", true);

		Contato contato = new Contato(Arrays.asList(new Telefone("Residencial", "11", "41411966", true)),
				Arrays.asList(new Email("Pessoal", "josevaldo@bol.com", true, true)));

		PessoaJuridica pessoaJuridica = pessoaJuridicaService.createPessoaPJ("Residencial Parque das Rosas",
				"Fatima Aparecida", "61057867000178", Arrays.asList(endereco), contato, new User());

		condominioService.save(new Condominio(pessoaJuridica, "Residencial", "V", true,
				Arrays.asList(new Bloco("A"), new Bloco("B"))));
	}
	
	private void createEspacoComum() {
		Condominio condominio = condominioService.findByCNPJ("61057867000178");
		condominio.setEspacos(Arrays.asList(new EspacoComum("Salao de Festas","Local para festas dos condominos",20,true,true,true)));
		condominioService.save(condominio);
		
	}

	private void createUnidade() {
		
		Condominio condominio = condominioService.findByCNPJ("61057867000178");
				
		List<Bloco> blocos = condominio.getBlocos();
		
		for (Bloco bloco : blocos) {
			List<Unidade> unidades = new ArrayList<Unidade>();
			unidades.add(new Unidade("110",true));
			unidades.add(new Unidade("120",true));
			unidades.add(new Unidade("130",true));
			unidades.add(new Unidade("140",true));
			
			bloco.setUnidades(unidades);
			blocoService.save(bloco);
		}
		
	}*/
	
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
