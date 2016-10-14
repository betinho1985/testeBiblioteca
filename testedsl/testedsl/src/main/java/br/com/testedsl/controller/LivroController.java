package br.com.testedsl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.testedsl.model.Livro;
import br.com.testedsl.repository.EmprestimoRepository;
import br.com.testedsl.repository.LivroRepository;
import br.com.testedsl.util.Mensagem;
import br.com.testedsl.util.Mensagem.TipoMensagem;

/**
 * @author Carlos
 *
 */
@Controller
@RequestMapping("/livro")
public class LivroController {

	@Autowired
	private LivroRepository livroRepository;

	@Autowired
	private EmprestimoRepository emprestimoRepository;

	@RequestMapping(value = "/cadastrar.do", method = RequestMethod.POST)
	public String cadastrar(Livro livro, Model model) {

		livroRepository.salvar(livro);
		model.addAttribute("livro", new Livro());
		model.addAttribute("mensagem", new Mensagem(
				"Sucesso ao cadastrar livro.", TipoMensagem.SUCESSO));
		return "cadastrarLivro";
	}

	@RequestMapping(value = "/excluir.do", method = RequestMethod.GET)
	public String excluir(Integer idLivro, Model model) {

		boolean hasLivroEmprestado = emprestimoRepository
				.getLivroPorId(idLivro);

		if (hasLivroEmprestado) {
			model.addAttribute("mensagem", new Mensagem(
					"Erro ao excluir pessoa.", TipoMensagem.ERRO));
		} else {

			livroRepository.excluir(idLivro);
			model.addAttribute("mensagem", new Mensagem(
					"Sucesso ao excluir livro.", TipoMensagem.SUCESSO));
		}

		return "forward:/livro/listar.do";
	}

	@RequestMapping(value = "/listar.do", method = RequestMethod.GET)
	public String listar(Model model) {

		List<Livro> livros = livroRepository.listar();
		model.addAttribute("livros", livros);
		return "listarLivros";

	}
}
