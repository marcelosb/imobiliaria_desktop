package acesso_banco_de_dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * @author Marcelo Henrique
 */
public class ConexaoBD {

    protected ConexaoBD() {
        
    }
    
    static Connection conexao;
    
    public static Connection conectar(){
        try {
            conexao = DriverManager.getConnection("jdbc:sqlite:sistema_imobiliario_bd.sqlite");   
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"Não foi possível conectar ao banco!"+erro, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        return conexao;
    }
    
    public static PreparedStatement getPreparedStatement(String SQL) throws SQLException{
        return conectar().prepareStatement(SQL);
    }
    
    public static void desconectar(){
        try {
            conexao.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"Não foi possível desconectar do banco!"+erro, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
}
