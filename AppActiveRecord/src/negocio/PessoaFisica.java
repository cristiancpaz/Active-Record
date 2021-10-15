package negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;

import persistencia.ConexaoPostgreSQL;

public class PessoaFisica extends Pessoa {
	private String cpf;
	private String nome;
	
	
	  public PessoaFisica(int id,String nome, String cpf) {
		  super(id, nome);
	  
	  this.cpf = cpf;
	  }
	 
	
	public PessoaFisica() {
		super();
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	
	

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public void setNome(String nome) {
		this.nome = nome;
		
	}

	@Override
	  public void load(String cpf) throws SQLException  {
	  String sql = "SELECT * FROM pessoa WHERE cpf = ?;";
      Connection connection = new ConexaoPostgreSQL().getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, cpf);
      ResultSet rs = preparedStatement.executeQuery();
      if (rs.next()) {
          this.setId(rs.getInt("id"));
          this.setCpf(rs.getString("cpf"));
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
	        preparedStatement.setString(1, this.getCpf());
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
        preparedStatement.setString(1, this.cpf);
        preparedStatement.execute();
        preparedStatement.close();
		
	}


	@Override
	public void atualizar() throws SQLException {
		 String sql = "UPDATE pessoa SET nome = ? WHERE cpf = ?;";
	        Connection connection = new ConexaoPostgreSQL().getConnection();
	        PreparedStatement preparedStatement = connection.prepareStatement(sql);
	        preparedStatement.setString(1, this.getNome());
	        preparedStatement.setString(2, this.getCpf());
	        preparedStatement.execute();
	        preparedStatement.close();
	        connection.close();
		
	}
   

}


