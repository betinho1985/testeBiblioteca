package br.com.testedsl.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @author Carlos
 *
 */

@Entity
public class Emprestimo implements Serializable {

	private static final long serialVersionUID = 7064809078222302493L;

	@Id
	@GeneratedValue(generator = "emprestimo_idemprestimo_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "emprestimo_idemprestimo_seq", sequenceName = "emprestimo_idemprestimo_seq", allocationSize = 1)
	private Integer idEmprestimo;

	@Column(name = "dataemprestimo")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataEmprestimo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idPessoa")
	private Pessoa pessoa;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idLivro")
	private Livro livro;

	@Column(name = "datahoradevolucao")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date dataHoraDevolucao;

	public Emprestimo() {
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return idEmprestimo;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.idEmprestimo = id;
	}

	/**
	 * @return the dataEmprestimo
	 */
	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}

	/**
	 * @param dataEmprestimo
	 *            the dataEmprestimo to set
	 */
	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	/**
	 * @return the pessoa
	 */
	public Pessoa getPessoa() {
		return pessoa;
	}

	/**
	 * @param pessoa the pessoa to set
	 */
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	/**
	 * @return the livro
	 */
	public Livro getLivro() {
		return livro;
	}

	/**
	 * @param livro the livro to set
	 */
	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	/**
	 * @return the dataHoraDevolucao
	 */
	public Date getDataHoraDevolucao() {
		return dataHoraDevolucao;
	}

	/**
	 * @param dataHoraDevolucao
	 *            the dataHoraDevolucao to set
	 */
	public void setDataHoraDevolucao(Date dataHoraDevolucao) {
		this.dataHoraDevolucao = dataHoraDevolucao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEmprestimo == null) ? 0 : idEmprestimo.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emprestimo other = (Emprestimo) obj;
		if (idEmprestimo == null) {
			if (other.idEmprestimo != null)
				return false;
		} else if (!idEmprestimo.equals(other.idEmprestimo))
			return false;
		return true;
	}

}
