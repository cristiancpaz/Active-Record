package apresentacao;

import java.sql.SQLException;
import java.util.ArrayList;
import negocio.Pessoa;
import negocio.PessoaFisica;
import negocio.PessoaJuridica;
import persistencia.ConexaoPostgreSQL;

public class App {

	public static void main (String[] args) throws SQLException{
	
		  PessoaFisica p = new PessoaFisica();
		  p.load("000.000.000-00");
		  p.setNome(p.getNome()+" "+"da Silva");
		  p.atualizar();
		  System.out.println("Nome: "+p.getNome());
		  
	}   

}
