package br.com.testedsl.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.testedsl.model.Pessoa;

/**
 * 
 * @author Carlos
 *
 */
@Repository
public class PessoaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void salvar(Pessoa pessoa) {
		entityManager.persist(pessoa);

	}

	@Transactional
	public void excluir(Integer id) {
		Pessoa pessoa = entityManager.find(Pessoa.class, id);
		entityManager.remove(pessoa);
	}

	@SuppressWarnings("unchecked")
	public List<Pessoa> listar() {
		Query query = entityManager
				.createQuery("SELECT p FROM Pessoa p ORDER BY p.idPessoa ");

		return query.getResultList();
	}
}
