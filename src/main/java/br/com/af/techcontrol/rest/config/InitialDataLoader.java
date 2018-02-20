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

import br.com.af.techcontrol.rest.entity.base.Email;
import br.com.af.techcontrol.rest.entity.base.Endereco;
import br.com.af.techcontrol.rest.entity.base.PessoaFisica;
import br.com.af.techcontrol.rest.entity.base.PessoaJuridica;
import br.com.af.techcontrol.rest.entity.base.Privilege;
import br.com.af.techcontrol.rest.entity.base.Telefone;
import br.com.af.techcontrol.rest.entity.condominio.Administrador;
import br.com.af.techcontrol.rest.entity.condominio.Bloco;
import br.com.af.techcontrol.rest.entity.condominio.Condominio;
import br.com.af.techcontrol.rest.entity.condomino.Unidade;
import br.com.af.techcontrol.rest.service.AdministradorService;
import br.com.af.techcontrol.rest.service.BlocoService;
import br.com.af.techcontrol.rest.service.CondominioService;
import br.com.af.techcontrol.rest.service.ContatoService;
import br.com.af.techcontrol.rest.service.EnderecoService;
import br.com.af.techcontrol.rest.service.PessoaFisicaService;
import br.com.af.techcontrol.rest.service.PessoaJuridicaService;
import br.com.af.techcontrol.rest.service.PrivilegeService;
import br.com.af.techcontrol.rest.service.RoleService;
import br.com.af.techcontrol.rest.service.UserService;

@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	boolean alreadySetup = false;

	@Autowired
	private UserService userService;

	@Autowired
	private AdministradorService administradorService;

	@Autowired
	private CondominioService condominioService;

	@Autowired
	private BlocoService blocoService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private PrivilegeService privilegeService;

	@Autowired
	private PessoaFisicaService pessoaFisicaService;

	@Autowired
	private EnderecoService enderecoService;

	@Autowired
	private PessoaJuridicaService pessoaJuridicaService;

	@Autowired
	private ContatoService contatoService;

	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent event) {

		if (alreadySetup)
			return;

		initPrivilegesAndRoles();

		createAdministradorPJ();

		createAdministradorPF();

		createCondominio();
		
		alreadySetup = true;
	}

	private void createAdministradorPJ() {
		Endereco enderecoMatriz = enderecoService.createEndereco("06663190", "Rua um", "45", "", "Setor D", "Sao Paulo",
				"SP");
		Endereco enderecoFilial = enderecoService.createEndereco("06663045", "Rua dois", "90", "", "Setor E",
				"Sao Paulo", "SP");
		PessoaJuridica pessoaJuridica = pessoaJuridicaService.createPessoaPJIfNotFound("Passos Adm", "Jose Passos ltda",
				"24540435000197", Arrays.asList(enderecoMatriz, enderecoFilial));

		contatoService.createContatoIfNotFound(pessoaJuridica,
				Arrays.asList(new Telefone("Celular", "11", "123451234", true),
						new Telefone("Empresa", "11", "34343232", true)),
				Arrays.asList(new Email("Comercial", "jose@passos.com.br", true, true),
						new Email("SAC", "sac@passos.com.br", false, true)));

		userService.createUserIfNotFound(pessoaJuridica, "adminpj", "123456", "ROLE_ADMIN");

		Administrador administrador = new Administrador(pessoaJuridica, true);

		administradorService.save(administrador);
	}

	private void createAdministradorPF() {

		Endereco endereco = enderecoService.createEndereco("06663190", "Rua um", "60", "", "Setor D", "Sao Paulo",
				"SP");

		PessoaFisica pessoaFisica = pessoaFisicaService.createPessoaPFIfNotFound("Jose da Silva", "31406826898", "M",
				LocalDate.of(1985, 04, 03), Arrays.asList(endereco));

		contatoService.createContatoIfNotFound(pessoaFisica,
				Arrays.asList(new Telefone("Residencial", "11", "41411966", true),
						new Telefone("Celular", "11", "947010120", true)),
				Arrays.asList(new Email("Pessoal", "jose@bol.com", true, true)));

		userService.createUserIfNotFound(pessoaFisica, "adminpf", "123456", "ROLE_ADMIN");

		Administrador administrador = new Administrador(pessoaFisica, true);

		administradorService.save(administrador);
	}

	private void createCondominio() {

		Endereco endereco = enderecoService.createEndereco("06663000", "Rua tres", "100", "", "Setor A", "Sao Paulo",
				"SP");
		PessoaJuridica pessoaJuridica = pessoaJuridicaService.createPessoaPJIfNotFound("Residencial Parque das Rosas",
				"Fatima Aparecida", "61057867000178", Arrays.asList(endereco));

		Administrador administrador = administradorService.findByPessoaId(new Long(1));

		Condominio condominio = condominioService
				.save(new Condominio(pessoaJuridica, "Residencial", "V", administrador, true));

		
		blocoService.save(Arrays.asList(new Bloco("A", condominio), new Bloco("B", condominio)));
		
	}
	
	
	private void createUnidade() {
		
		PessoaJuridica pj = pessoaJuridicaService.findByCnpj("61057867000178");
		
		Condominio condominio =  condominioService.findByPessoaId(pj.getId());
		
		List<Bloco> blocos = condominio.getBlocos();
		
		for (Bloco bloco : blocos) {
			Unidade unidade = 
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
