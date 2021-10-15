package negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.ConexaoPostgreSQL;



public abstract class Pessoa {
    protected int id;
    protected String nome;
    protected ArrayList <Endereco>vetEndereco;
  
	
	public Pessoa(int id, String nome) {
		this.id = id; this.nome = nome;
	}
	 
    public Pessoa() {
    	this.vetEndereco = new ArrayList();
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
	public ArrayList<Endereco> getVetEndereco() {
		return vetEndereco;
	}
	public void setVetEndereco(ArrayList<Endereco> vetEndereco) {
		this.vetEndereco = vetEndereco;
	}

  	  
	public abstract void load(String cpf) throws SQLException; 

	   
	public abstract void inserir() throws SQLException;

	   
	public abstract void excluir() throws SQLException; 
	   
	public abstract void atualizar() throws SQLException;
    
   
}