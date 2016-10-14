package br.com.testedsl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.testedsl.model.Pessoa;
import br.com.testedsl.repository.EmprestimoRepository;
import br.com.testedsl.repository.PessoaRepository;
import br.com.testedsl.util.Mensagem;
import br.com.testedsl.util.Mensagem.TipoMensagem;

/**
 * @author Carlos
 *
 */
@Controller
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private EmprestimoRepository emprestimoRepository;

	@RequestMapping(value = "/cadastrar.do", method = RequestMethod.POST)
	public String cadastrar(Pessoa pessoa, Model model) {

		if (pessoa.getNome() == null || pessoa.getNome().equals("")) {
			model.addAttribute(
					"mensagem",
					new Mensagem(
							"Erro ao cadastrar pessoa, o campo nome não pode ser nulo.",
							TipoMensagem.ERRO));

		} else {

			pessoaRepository.salvar(pessoa);
			model.addAttribute("pessoa", new Pessoa());
			model.addAttribute("mensagem", new Mensagem(
					"Sucesso ao cadastrar pessoa.", TipoMensagem.SUCESSO));

		}
		return "cadastrarPessoa";
	}

	@RequestMapping(value = "/excluir.do", method = RequestMethod.GET)
	public String excluir(Integer idPessoa, Model model) {

		boolean hasLivroEmprestado = emprestimoRepository
				.PessoaHasEmprestimo(idPessoa);

		if (hasLivroEmprestado) {
			model.addAttribute("mensagem", new Mensagem(
					"Erro ao excluir pessoa.", TipoMensagem.ERRO));
		} else {

			pessoaRepository.excluir(idPessoa);
			model.addAttribute("mensagem", new Mensagem(
					"Sucesso ao excluir pessoa.", TipoMensagem.SUCESSO));
		}

		return "forward:/pessoa/listar.do";
	}

	@RequestMapping(value = "/listar.do", method = RequestMethod.GET)
	public String listar(Model model) {

		List<Pessoa> pessoas = pessoaRepository.listar();
		
		model.addAttribute("pessoa", pessoas);
		
		return "listarPessoas";

	}

}
