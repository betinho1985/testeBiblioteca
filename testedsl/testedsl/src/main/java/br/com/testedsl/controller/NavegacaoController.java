package br.com.testedsl.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.testedsl.model.Emprestimo;
import br.com.testedsl.model.Livro;
import br.com.testedsl.model.Pessoa;
import br.com.testedsl.repository.EmprestimoRepository;
import br.com.testedsl.repository.LivroRepository;
import br.com.testedsl.repository.PessoaRepository;

/**
 * @author Carlos
 *
 */
@Controller
public class NavegacaoController {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private EmprestimoRepository emprestimoRepository;

	@RequestMapping(value = "/preparaCadastroPessoa.do")
	public String redirecionaCadastroPessoa(Map<String, Object> map) {
		map.put("pessoa", new Pessoa());
		return "cadastrarPessoa";
	}

	@RequestMapping(value = "/preparaCadastroLivro.do")
	public String redirecionaCadastroLivro(Map<String, Object> map) {
		map.put("livro", new Livro());
		return "cadastrarLivro";
	}

	@RequestMapping(value = "/preparaCadastroEmprestimo.do")
	public String redirecionaCadastroEmprestimo(Map<String, Object> map) {
		map.put("livros", livroRepository.listar());
		map.put("pessoas", pessoaRepository.listar());
		map.put("emprestimo", new Emprestimo());
		return "cadastrarEmprestimo";
	}

	@RequestMapping(value = "/preparaListagemEmprestimos.do")
	public String redirecionaListagemEmprestimo(Map<String, Object> map) {
		map.put("emprestimos", emprestimoRepository.listar());
		return "listarEmprestimo";
	}
}
