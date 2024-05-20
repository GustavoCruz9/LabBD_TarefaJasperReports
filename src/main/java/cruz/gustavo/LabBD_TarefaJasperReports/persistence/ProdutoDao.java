package cruz.gustavo.LabBD_TarefaJasperReports.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cruz.gustavo.LabBD_TarefaJasperReports.model.Produto;

@Repository
public class ProdutoDao {
	
	@Autowired
	private GenericDao gDao;
	
	public List<Produto> listar(int qtd) throws SQLException, ClassNotFoundException {
		List<Produto> produtos = new ArrayList<>();
		
		Connection c = gDao.getConnection();
		String sql = """
				select * from Produto where qtd_estoque < ?
				""";

		PreparedStatement ps = c.prepareStatement(sql);
		
		ps.setInt(1, qtd);

		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Produto p = new Produto();
			
			p.setCodigo(rs.getInt("codigo"));
			p.setNome(rs.getString("nome"));
			p.setValorUnitario(rs.getDouble("valor_unitario"));
			p.setQtdEstoque(rs.getInt("qtd_estoque"));
			
			produtos.add(p);
		}
		
		return produtos;
	}

}
