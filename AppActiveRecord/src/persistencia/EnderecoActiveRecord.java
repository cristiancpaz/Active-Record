package persistencia;


	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import negocio.Endereco;

	public abstract class EnderecoActiveRecord {
		public  abstract ArrayList<Endereco> listar() throws SQLException, ClassNotFoundException;
		
		public abstract void inserir(Endereco e) throws SQLException, ClassNotFoundException;
		
		public abstract void excluir(int id) throws SQLException, ClassNotFoundException;

		public abstract void atualizar(Endereco e) throws ClassNotFoundException, SQLException;

	}


