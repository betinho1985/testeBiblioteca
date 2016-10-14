package br.com.testedsl.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.testedsl.model.Livro;

/**
 * 
 * @author Carlos
 *
 */
@Repository
public class LivroRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void salvar(Livro livro) {
		entityManager.persist(livro);
	}


	@Transactional
	public void excluir(Integer id) {
		Livro livro = entityManager.find(Livro.class, id);
		entityManager.remove(livro);
	}

	@SuppressWarnings("unchecked")
	public List<Livro> listar() {
		Query query = entityManager
				.createQuery("SELECT l FROM Livro l ORDER BY l.idLivro ");

		return query.getResultList();
	}

}
