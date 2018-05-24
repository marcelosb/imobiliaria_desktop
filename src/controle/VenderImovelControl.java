
package controle;

import acesso_banco_de_dados.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.VenderImovelBean;
import util.TabelaAbstrataVenderImoveis;
import visual.tela_vender_imovel.PainelPesquisarVenderImovel;

/**
 *
 * @author Marcelo
 */
public class VenderImovelControl {
    
    private static PreparedStatement pst;
    private static ResultSet rs;
    
    protected void cadastrar(VenderImovelBean vendaDeImovelBean) {
        try {
            pst = ConexaoBD.getPreparedStatement("INSERT INTO tabela_vender_imovel (data_da_venda, corretor, imovel, cliente, valor_negociado) VALUES(?, ?, ?, ?, ?)");
            
            pst.setString(1, vendaDeImovelBean.getDataDaVenda());
            pst.setString(2, vendaDeImovelBean.getCorretor());
            pst.setString(3, vendaDeImovelBean.getImovel());
            pst.setString(4, vendaDeImovelBean.getCliente());
            pst.setString(5, vendaDeImovelBean.getValorNegociado());
            
            pst.executeUpdate();
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO! " + erro);
        } finally {
            ConexaoBD.desconectar();
        }
        
    }
    
    
    protected void alterar(VenderImovelBean vendaDeImovelBean, int codigo) {
        try {   
            pst = ConexaoBD.getPreparedStatement("UPDATE tabela_vender_imovel SET codigo=?, data_da_venda=?, corretor=?, imovel=?, cliente=?, valor_negociado=?  WHERE rowid='"+codigo+"'");
            
            pst.setInt(1, vendaDeImovelBean.getCodigo());
            pst.setString(2, vendaDeImovelBean.getDataDaVenda());
            pst.setString(3, vendaDeImovelBean.getCorretor());
            pst.setString(4, vendaDeImovelBean.getImovel());
            pst.setString(5, vendaDeImovelBean.getCliente());
            pst.setString(6, vendaDeImovelBean.getValorNegociado());
            
            pst.executeUpdate();
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO! " + erro);
        } finally {
            ConexaoBD.desconectar();
        }
       
    }
    
    public static int codigo;
    public static String codigoString;
    public static String data_da_venda;
    public static String corretor;
    public static String imovel;
    public static String cliente;
    public static Double valor_negociado;
    
    protected void pesquisar(String nome) {
        try {
            pst = ConexaoBD.getPreparedStatement("SELECT * FROM tabela_vender_imovel WHERE corretor LIKE '%"+nome+"%' OR cliente LIKE '%"+nome+"%' ");
            rs = pst.executeQuery();   
            VenderImovelBean venderImovelBean;
            Dados.listaVenderImoveis.clear();
            while (rs.next()) {
                venderImovelBean = new VenderImovelBean();
                venderImovelBean.setCodigo(rs.getInt("codigo"));
                venderImovelBean.setDataDaVenda(rs.getString("data_da_venda"));
                venderImovelBean.setCorretor(rs.getString("corretor"));
                venderImovelBean.setImovel(rs.getString("imovel"));
                venderImovelBean.setCliente(rs.getString("cliente"));
                venderImovelBean.setValorNegociado(rs.getString("valor_negociado"));            
                
                Dados.listaVenderImoveis.add(venderImovelBean);
            }
            TabelaAbstrataVenderImoveis tabelaAbstrataVenderImoveis = new TabelaAbstrataVenderImoveis(Dados.listaVenderImoveis);
            PainelPesquisarVenderImovel.tabelaVenderImoveis.setModel(tabelaAbstrataVenderImoveis);
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO! " + erro);
        } finally {
            ConexaoBD.desconectar();
        }

    }
    
    protected List<VenderImovelBean> listar() {
        try {
            pst = ConexaoBD.getPreparedStatement("SELECT * FROM tabela_vender_imovel");
            rs = pst.executeQuery();
            VenderImovelBean venderImovelBean;
            
            Dados.listaVenderImoveis.clear();
            while (rs.next()) {
                venderImovelBean = new VenderImovelBean();
                venderImovelBean.setCodigo(rs.getInt("codigo"));
                venderImovelBean.setDataDaVenda(rs.getString("data_da_venda"));
                venderImovelBean.setCorretor(rs.getString("corretor"));
                venderImovelBean.setImovel(rs.getString("imovel"));
                venderImovelBean.setCliente(rs.getString("cliente"));
                venderImovelBean.setValorNegociado(rs.getString("valor_negociado"));
                
                Dados.listaVenderImoveis.add(venderImovelBean);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO GROTESCO! " + erro);
        } finally {
            ConexaoBD.desconectar();
        }
        return Dados.listaVenderImoveis;
    }
    
    protected void excluir(int codigo) {
        try {
            pst = ConexaoBD.getPreparedStatement("DELETE FROM tabela_vender_imovel WHERE codigo=?");
            pst.setInt(1, codigo);
            pst.executeUpdate();
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO! " + erro);
        } finally {
            ConexaoBD.desconectar();
        }
    }
    

}
