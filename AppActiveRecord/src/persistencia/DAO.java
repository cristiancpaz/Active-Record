package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import negocio.Pessoa;


public interface DAO<Modelo> {    
    public void obter(Modelo p) throws SQLException;
    public ArrayList<Modelo> listar() throws SQLException;
    public void inserir(Modelo p) throws SQLException;
    public void excluir(String chave) throws SQLException;
    public void atualizar(Modelo p) throws SQLException;
    
}