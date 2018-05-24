
package controle;

import acesso_banco_de_dados.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.ImovelBean;
import util.TabelaAbstrataImoveis;
import visual.tela_imovel.PainelPesquisarImoveis;

/**
 *
 * @author Marcelo
 */
class ImovelControl {
    
    private static PreparedStatement pst;
    private static ResultSet rs;
    
    protected void cadastrar(ImovelBean imovelBean) {
        try {
            pst = ConexaoBD.getPreparedStatement("INSERT INTO tabela_imovel (proprietario, tipo, finalidade, valor_cobrado, status) VALUES(?, ?, ?, ?, ?)");
            pst.setString(1, imovelBean.getProprietario());
            pst.setString(2, imovelBean.getTipo());
            pst.setString(3, imovelBean.getFinalidade());
            pst.setString(4, imovelBean.getValorCobrado());
            pst.setString(5, imovelBean.getStatus());
            
            pst.executeUpdate();
     
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO! " + erro);
        } finally {
            ConexaoBD.desconectar();
        }
        
    }
    
    
    protected void alterar(ImovelBean imovelBean, int codigo) {
        try {
               
            pst = ConexaoBD.getPreparedStatement("UPDATE tabela_imovel SET proprietario=?, tipo=?, finalidade=?, valor_cobrado=?, status=? WHERE codigo='"+codigo+"'");
            
            pst.setString(1, imovelBean.getProprietario());
            pst.setString(2, imovelBean.getTipo());
            pst.setString(3, imovelBean.getFinalidade());
            pst.setString(4, imovelBean.getValorCobrado());
            pst.setString(5, imovelBean.getStatus());
            
            pst.executeUpdate();
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO! " + erro);
        } finally {
            ConexaoBD.desconectar();
        }
       
    }
    
    protected void alterarStatus(int codigo) {
        try {
            pst = ConexaoBD.getPreparedStatement("UPDATE tabela_imovel SET status=? WHERE codigo='"+codigo+"'");
            pst.setString(1, "Indisponível");
            pst.executeUpdate();
            
            PainelPesquisarImoveis.mostrarTabelaDeImoveis();
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO! " + erro);
        } finally {
            ConexaoBD.desconectar();
        }
       
    }
    
    protected List<ImovelBean> listar() {
        
        try {
            pst = ConexaoBD.getPreparedStatement("SELECT * FROM tabela_imovel");
            rs = pst.executeQuery();
            ImovelBean imovelBean;
            Dados.listaDeImoveis.clear();
            while (rs.next()) {
                imovelBean = new ImovelBean();
                imovelBean.setCodigo(rs.getInt("codigo"));
                imovelBean.setProprietario(rs.getString("proprietario"));
                imovelBean.setTipo(rs.getString("tipo"));
                imovelBean.setFinalidade(rs.getString("finalidade"));
                imovelBean.setValorCobrado(rs.getString("valor_cobrado"));
                imovelBean.setStatus(rs.getString("status"));
                
                Dados.listaDeImoveis.add(imovelBean);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO GROTESCO! " + erro);
        } finally {
            ConexaoBD.desconectar();
        }
        return Dados.listaDeImoveis;
    }
      

    protected void pesquisar(String nome) {
        try {
            pst = ConexaoBD.getPreparedStatement("SELECT * FROM tabela_imovel WHERE proprietario LIKE '%"+nome+"%' OR codigo LIKE '%"+nome+"%' ");
            rs = pst.executeQuery();   
            ImovelBean imovelBean;
            Dados.listaDeImoveis.clear();
            while (rs.next()) {
                imovelBean = new ImovelBean();
                imovelBean.setCodigo(rs.getInt("codigo"));
                imovelBean.setProprietario(rs.getString("proprietario"));
                imovelBean.setTipo(rs.getString("tipo"));
                imovelBean.setFinalidade(rs.getString("finalidade"));
                imovelBean.setValorCobrado(rs.getString("valor_cobrado"));  
                imovelBean.setStatus(rs.getString("status"));
                
                Dados.listaDeImoveis.add(imovelBean);
            }
            TabelaAbstrataImoveis tabelaAbstrataImoveis = new TabelaAbstrataImoveis(Dados.listaDeImoveis);
            PainelPesquisarImoveis.tabelaImoveis.setModel(tabelaAbstrataImoveis);
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO! " + erro);
        } finally {
            ConexaoBD.desconectar();
        }

    }
    
    protected void excluir(String nome) {
        try {
            pst = ConexaoBD.getPreparedStatement("DELETE FROM tabela_imovel WHERE proprietario=?");
            pst.setString(1, nome);
            pst.executeUpdate();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO! " + erro);
        } finally {
            ConexaoBD.desconectar();
        }
    }
    
    
    protected List<ImovelBean> listarCodDosImoveisVender(){
        try {
            pst = ConexaoBD.getPreparedStatement("SELECT codigo, tipo, valor_cobrado FROM tabela_imovel WHERE finalidade='Vender' AND status='Disponível' ORDER BY codigo ");
            rs = pst.executeQuery();
            ImovelBean imovelBean;
            Dados.listaDeImoveisVenderImovel.clear();
            while (rs.next()) {
                imovelBean = new ImovelBean();
                imovelBean.setCodigo(rs.getInt("codigo"));
                imovelBean.setTipo(rs.getString("tipo"));
                imovelBean.setValorCobrado(rs.getString("valor_cobrado"));

                Dados.listaDeImoveisVenderImovel.add(imovelBean);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO GROTESCO! " + erro);
        } finally {
            ConexaoBD.desconectar();
        }
        return Dados.listaDeImoveisVenderImovel;
    }
    
    protected List<ImovelBean> listarCodDosImoveisAlugar(){
        try {
            pst = ConexaoBD.getPreparedStatement("SELECT codigo, tipo, valor_cobrado FROM tabela_imovel WHERE finalidade='Alugar' AND status='Disponível' ORDER BY codigo ");
            rs = pst.executeQuery();
            ImovelBean imovelBean;
            Dados.listaDeImoveisAlugarImovel.clear();
            while (rs.next()) {
                imovelBean = new ImovelBean();
                imovelBean.setCodigo(rs.getInt("codigo"));
                imovelBean.setTipo(rs.getString("tipo"));
                imovelBean.setValorCobrado(rs.getString("valor_cobrado"));

                Dados.listaDeImoveisAlugarImovel.add(imovelBean);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO GROTESCO! " + erro);
        } finally {
            ConexaoBD.desconectar();
        }
        return Dados.listaDeImoveisAlugarImovel;
    }
    
}
