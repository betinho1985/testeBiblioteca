package br.com.testedsl.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.testedsl.model.Emprestimo;

/**
 * 
 * @author Carlos
 *
 */
@Repository
public class EmprestimoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public boolean PessoaHasEmprestimo(Integer idPessoa) {
		Query query = entityManager
				.createQuery("SELECT l FROM Livro l WHERE l.pessoa.id=:idPessoa AND l.datahoradevolucao=:dataAtual");
		query.setParameter("idPessoa", idPessoa);
		query.setParameter("dataAtual", new Date());

		if (query.getResultList().size() > 0)
			return true;

		else
			return false;
	}


	@Transactional
	public void salvar(Emprestimo emprestimo) {
		entityManager.persist(emprestimo);
	}

	@Transactional
	public void excluir(Integer id) {
		Emprestimo emprestimo = entityManager.find(Emprestimo.class, id);
		entityManager.remove(emprestimo);
	}

	@SuppressWarnings("unchecked")
	public List<Emprestimo> listar() {
		Query query = entityManager
				.createQuery("SELECT e FROM Emprestimo e ORDER BY e.idEmprestimo ");

		return query.getResultList();
	}

	@Transactional
	public boolean getLivroPorId(Integer idLivro) {
		Query query = entityManager
				.createQuery("SELECT e FROM Emprestimo e WHERE e.idLivro =:idLivro AND datahoradevolucao<=:dataAtual");
		query.setParameter("idLivro", idLivro);
		query.setParameter("dataAtual", new Date());

		if (query.getResultList().size() > 0) {
			return true;
		}

		return false;
	}
	
}
