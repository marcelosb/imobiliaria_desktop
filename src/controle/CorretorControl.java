
package controle;

import acesso_banco_de_dados.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.CorretorBean;
import util.TabelaAbstrataCorretores;
import visual.tela_corretor.PainelPesquisarCorretores;


/**
 *
 * @author Marcelo
 */
public class CorretorControl {
    
    private static PreparedStatement pst;
    private static ResultSet rs;
    
    protected void cadastrar(CorretorBean corretorBean) {
        try {
            pst = ConexaoBD.getPreparedStatement("INSERT INTO tabela_corretor (nome, imobiliaria_vinculada) VALUES(?, ?)");
            pst.setString(1, corretorBean.getNome());
            pst.setString(2, corretorBean.getImobiliariaVinculada());
            
            pst.executeUpdate();
   
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO! " + erro);
        } finally {
            ConexaoBD.desconectar();
        }
        
    }
    
    
    protected void alterar(CorretorBean corretorBean, int codigo) {
        try {
            pst = ConexaoBD.getPreparedStatement("UPDATE tabela_corretor SET nome=?, imobiliaria_vinculada=? WHERE registro='"+codigo+"'");
            
            pst.setString(1, corretorBean.getNome());
            pst.setString(2, corretorBean.getImobiliariaVinculada());
            
            pst.executeUpdate();
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO! " + erro);
        } finally {
            ConexaoBD.desconectar();
        }
       
    }
    
    
    protected List<CorretorBean> listar() {
        try {
            pst = ConexaoBD.getPreparedStatement("SELECT * FROM tabela_corretor");
            rs = pst.executeQuery();
            CorretorBean corretorBean;
            
            Dados.listaDeCorretores.clear();
            while (rs.next()) {
                corretorBean = new CorretorBean();
                corretorBean.setRegistro(rs.getInt("registro"));
                corretorBean.setNome(rs.getString("nome"));
                
                Dados.listaDeCorretores.add(corretorBean);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO GROTESCO! " + erro);
        } finally {
            ConexaoBD.desconectar();
        }
        return Dados.listaDeCorretores;
    }
      

    protected void pesquisar(String nome) {
        try {
            pst = ConexaoBD.getPreparedStatement("SELECT registro, nome FROM tabela_corretor WHERE registro LIKE '%"+nome+"%' OR nome LIKE '%"+nome+"%' ");
            rs = pst.executeQuery();   
            CorretorBean corretorBean;
            Dados.listaDeCorretores.clear();
            while (rs.next()) {
                corretorBean = new CorretorBean();
                corretorBean.setRegistro(rs.getInt("registro"));
                corretorBean.setNome(rs.getString("nome"));          
                
                Dados.listaDeCorretores.add(corretorBean);
            }
            TabelaAbstrataCorretores tabelaAbstrataCorretores = new TabelaAbstrataCorretores(Dados.listaDeCorretores);
            PainelPesquisarCorretores.tabelaCorretores.setModel(tabelaAbstrataCorretores);
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO! " + erro);
        } finally {
            ConexaoBD.desconectar();
        }
    }
    
    
    protected void excluir(String nome) {
        try {
            pst = ConexaoBD.getPreparedStatement("DELETE FROM tabela_corretor WHERE nome=?");
            pst.setString(1, nome);
            pst.executeUpdate();
            

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO! " + erro);
        } finally {
            ConexaoBD.desconectar();
        }
    }

    protected List<CorretorBean> listarPeloNome(){
        try {
            pst = ConexaoBD.getPreparedStatement("SELECT registro, nome FROM tabela_corretor");
            rs = pst.executeQuery();
            CorretorBean corretorBean;
            Dados.listaDeCorretoresVenderImovel.clear();
            while (rs.next()) {
                corretorBean = new CorretorBean();
                corretorBean.setRegistro(rs.getInt("registro"));
                corretorBean.setNome(rs.getString("nome"));

                Dados.listaDeCorretoresVenderImovel.add(corretorBean);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO GROTESCO! " + erro);
        } finally {
            ConexaoBD.desconectar();
        }
        return Dados.listaDeCorretoresVenderImovel;
    }
    
    protected List<CorretorBean> listarPorNomeAlugar(){
        try {
            pst = ConexaoBD.getPreparedStatement("SELECT registro, nome FROM tabela_corretor");
            rs = pst.executeQuery();
            CorretorBean corretorBean;
            Dados.listaDeCorretoresAlugarImovel.clear();
            while (rs.next()) {
                corretorBean = new CorretorBean();
                corretorBean.setRegistro(rs.getInt("registro"));
                corretorBean.setNome(rs.getString("nome"));

                Dados.listaDeCorretoresAlugarImovel.add(corretorBean);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO GROTESCO! " + erro);
        } finally {
            ConexaoBD.desconectar();
        }
        return Dados.listaDeCorretoresAlugarImovel;
    }
    
    
}
