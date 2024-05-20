package cruz.gustavo.LabBD_TarefaJasperReports.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cruz.gustavo.LabBD_TarefaJasperReports.model.Produto;
import cruz.gustavo.LabBD_TarefaJasperReports.persistence.ProdutoDao;

@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoDao pDao;

	@RequestMapping(name = "index", value = "/index", method = RequestMethod.GET)
	public ModelAndView produtoGet(@RequestParam Map<String, String> param, ModelMap model) {
		return new ModelAndView("index");
	}
	
	@RequestMapping(name = "index", value = "/index", method = RequestMethod.POST)
	public ModelAndView produtoPost(@RequestParam Map<String, String> param, ModelMap model) {
		String cmd = param.get("botao");
		String qtd = param.get("qtd");
		
//		Produto produto = new Produto();
		List<Produto> produtos = new ArrayList<>();
		
		String saida = "";
		String erro = "";
		
		if(qtd.isEmpty()) {
			erro = "Digite um codigo por favor";
		}
		
		if(!erro.isEmpty()) {
			model.addAttribute("erro", erro);
			return new ModelAndView("index");
		}
		
		try {
			if(cmd.contains("Pesquisar")) {				
				produtos = listar(Integer.parseInt(qtd));
				if(produtos.isEmpty()) {
					saida = "Nao ha nenhum produto com qtd. menor que " + qtd;
				}
			}
		} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
			erro = e.getMessage();
		} finally {
			model.addAttribute("saida", saida);
			model.addAttribute("erro", erro);
			model.addAttribute("produtos", produtos);
		}
		
		return new ModelAndView("index");
	}

	private List<Produto> listar(int qtd) throws ClassNotFoundException, SQLException {
		return pDao.listar(qtd);
	}
	
}
