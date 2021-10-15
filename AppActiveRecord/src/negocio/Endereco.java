package negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import persistencia.ConexaoPostgreSQL;

public class Endereco {
	private int id;
	private String nome;
	private int numero;
	private String bairro;
	private String logradouro;
	private String complemento;
	private Pessoa pessoa;
	
	public Endereco(int id, String nome, int numero, String bairro, String logradouro, String complemento) {
		this.id = id;
		this.nome = nome;
		this.numero = numero;
		this.bairro = bairro;
		this.logradouro = logradouro;
		this.complemento = complemento;
	}
	public Endereco() {}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
		pessoa.getVetEndereco().add(this);
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
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	
	public ArrayList<Endereco> listar() throws SQLException, ClassNotFoundException{
	    ArrayList<Endereco> endereco = new ArrayList<Endereco>();
		String sql = "SELECT * FROM endereco";
		Connection connection = new ConexaoPostgreSQL().getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet rs = preparedStatement.executeQuery();
		Endereco e = null;
		while(rs.next()) {
			e = new Endereco();
			e.setId(rs.getInt("id"));
			e.setNumero(rs.getInt("numero"));
			e.setBairro(rs.getString("bairro"));
			e.setLogradouro(rs.getString("logradouro"));
			e.setComplemento(rs.getString("complemento"));
			endereco.add(e);
		}
		preparedStatement.close();
		connection.close();
		return endereco;
	}
	
	public void inserir(Endereco e) throws SQLException, ClassNotFoundException{
		String sql = "INSERT INTO endereco(id, numero, bairro, logradouro, complemento)VALUES(?,?,?,?,?);";
		Connection connection = new ConexaoPostgreSQL().getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, e.getId());
		preparedStatement.setInt(2, e.getNumero());
		preparedStatement.setString(3, e.getBairro());
		preparedStatement.setString(4, e.getLogradouro());
		preparedStatement.setString(5, e.getComplemento());
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
	
	}
	
	public void excluir(int id) throws SQLException, ClassNotFoundException{
		String sql = "DELETE FROM  endereco WHERE id = ?;";
		Connection connection = new ConexaoPostgreSQL().getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
		preparedStatement.close();
		connection.close();
	
	}
	
	public void atualizar(Endereco e) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE endereco SET numero = ?  WHERE id = ?;";
		Connection connection = new ConexaoPostgreSQL().getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, e.getNumero());
		preparedStatement.setInt(2, e.getId());
		//preparedStatement.setString(3, e.getBairro());
		//preparedStatement.setString(4, e.getLogradouro());
		//preparedStatement.setString(5, e.getComplemento());
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
	}
	
	
}
