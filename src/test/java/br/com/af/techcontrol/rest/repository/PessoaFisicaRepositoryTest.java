package br.com.af.techcontrol.rest.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.af.techcontrol.rest.entity.base.PessoaFisica;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PessoaFisicaRepositoryTest {

	@Autowired
	private PessoaFisicaRepository pessoaFisicaRepository;

	@Test
	public void whenFindByNome_thenReturnPessoaFisica() {

		// given
		PessoaFisica maria = new PessoaFisica();
		maria.setNome("maria");
		maria.setCpf("31406826898");
		pessoaFisicaRepository.save(maria);

		// when
		PessoaFisica found = pessoaFisicaRepository.findByNome(maria.getNome());

		// then
		assertThat(found.getNome()).isEqualTo(maria.getNome());
	}

}
