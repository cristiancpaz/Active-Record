package negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import persistencia.ConexaoPostgreSQL;

public class PessoaJuridica extends Pessoa{
	private String cnpj;
	private String nome_fantasia;
	

	
	  public PessoaJuridica(int id, String nome, String cnpj, String nome_fantasia)
	  { super(id, nome); this.cnpj = cnpj; this.nome_fantasia = nome_fantasia;
	  
	  }
	 

	public PessoaJuridica() {
		super();
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome_fantasia() {
		return nome_fantasia;
	}

	public void setNome_fantasia(String nome_fantasia) {
		this.nome_fantasia = nome_fantasia;
	}
	
	@Override
	  public void load(String cnpj) throws SQLException  {
	  String sql = "SELECT * FROM pessoa WHERE cnpj = ?;";
      Connection connection = new ConexaoPostgreSQL().getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, this.cnpj);
      ResultSet rs = preparedStatement.executeQuery();
      if (rs.next()) {
        this.setId(rs.getInt("id"));
        this.setCnpj(rs.getString("cpf"));
        this.setNome(rs.getString("nome"));
       
    }
    preparedStatement.close();
    connection.close();
    
    }
	  
	 


	@Override
	public void inserir() throws SQLException {
		 String sql = "INSERT INTO pessoa (cpf, nome) VALUES (?, ?) RETURNING id;";
	        Connection connection = new ConexaoPostgreSQL().getConnection();
	        PreparedStatement preparedStatement = connection.prepareStatement(sql);
	       // preparedStatement.setInt(1, p.getId());
	        preparedStatement.setString(1, this.getCnpj());
	        preparedStatement.setString(2, this.getNome());
	        ResultSet rs = preparedStatement.executeQuery();
	        if (rs.next()) {
	            this.id = rs.getInt("id");
	        }
	        preparedStatement.close();
	        connection.close();
		
	}


	@Override
	public void excluir() throws SQLException {
		String sql = "DELETE FROM pessoa WHERE cpf = ?;";
      Connection connection = new ConexaoPostgreSQL().getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, this.cnpj);
      preparedStatement.execute();
      preparedStatement.close();
		
	}


	@Override
	public void atualizar() throws SQLException {
		 String sql = "UPDATE pessoa SET nome = ? WHERE cpf = ?;";
	        Connection connection = new ConexaoPostgreSQL().getConnection();
	        PreparedStatement preparedStatement = connection.prepareStatement(sql);
	        preparedStatement.setString(1, this.getNome());
	        preparedStatement.setString(2, this.getCnpj());
	        preparedStatement.execute();
	        preparedStatement.close();
	        connection.close();
		
	}

	
	
	

}
