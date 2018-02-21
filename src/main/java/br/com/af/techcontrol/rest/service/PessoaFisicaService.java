package br.com.af.techcontrol.rest.service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.af.techcontrol.rest.entity.base.Contato;
import br.com.af.techcontrol.rest.entity.base.Endereco;
import br.com.af.techcontrol.rest.entity.base.PessoaFisica;
import br.com.af.techcontrol.rest.repository.PessoaFisicaRepository;

@Service
@Transactional
public class PessoaFisicaService {

	@Autowired
	PessoaFisicaRepository repository;

	public PessoaFisica save(PessoaFisica pessoaFisica) {
		return repository.save(pessoaFisica);
	}

	public List<PessoaFisica> findAll() {
		return repository.findAll();
	}

	public PessoaFisica findOne(Long id) {
		return repository.findOne(id);
	}

	public PessoaFisica findByCpf(String cpf) {
		return repository.findByCpf(cpf);
	}

	public void delete(Long id) {
		repository.delete(id);
	}

	public PessoaFisica createPessoaPFIfNotFound(String nome, String cpf, String sexo, LocalDate datanascimento,
			Collection<Endereco> enderecos) {

		PessoaFisica pessoaFisica = findByCpf(cpf);
		if (pessoaFisica == null) {
			pessoaFisica = new PessoaFisica();
			pessoaFisica.setNome(nome);
			pessoaFisica.setCpf(cpf);
			pessoaFisica.setSexo(sexo);
			pessoaFisica.setDataNascimento(datanascimento);
			pessoaFisica.setEnderecos(enderecos);
			pessoaFisica.setIsEnable(true);
		}

		return pessoaFisica;
	}

	public PessoaFisica createPessoaPF(String nome, String cpf, String sexo, LocalDate datanascimento,
			Collection<Endereco> enderecos, Contato contato) {

		PessoaFisica pessoaFisica = new PessoaFisica();
		pessoaFisica.setNome(nome);
		pessoaFisica.setCpf(cpf);
		pessoaFisica.setSexo(sexo);
		pessoaFisica.setDataNascimento(datanascimento);
		pessoaFisica.setEnderecos(enderecos);
		pessoaFisica.setContato(contato);
		pessoaFisica.setIsEnable(true);

		return pessoaFisica;
	}
}
