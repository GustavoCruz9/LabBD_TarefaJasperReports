package cruz.gustavo.LabBD_TarefaJasperReports.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Produto {
	 private int codigo;
	 private String nome;
	 private double valorUnitario;
	 private int qtdEstoque;
}
