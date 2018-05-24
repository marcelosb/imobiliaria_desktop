
package controle;

import acesso_banco_de_dados.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.AlugarImovelBean;
import modelo.VenderImovelBean;
import util.TabelaAbstrataAlugarImoveis;
import util.TabelaAbstrataVenderImoveis;
import visual.tela_alugar_imovel.PainelPesquisarAlugarImovel;
import visual.tela_vender_imovel.PainelPesquisarVenderImovel;

/**
 *
 * @author Marcelo
 */
class AlugarImovelControl {
    
    private static PreparedStatement pst;
    private static ResultSet rs;
    
    protected void cadastrar(AlugarImovelBean alugarImovelBean) {
        try {
            pst = ConexaoBD.getPreparedStatement("INSERT INTO tabela_alugar_imovel (data_de_inicio_do_contrato, data_de_fim_do_contrato, corretor, imovel, cliente, valor_negociado) VALUES(?, ?, ?, ?, ?, ?)");
            
            pst.setString(1, alugarImovelBean.getDataDeInicioDoContrato());
            pst.setString(2, alugarImovelBean.getDataDeFimDoContrato());
            pst.setString(3, alugarImovelBean.getCorretor());
            pst.setString(4, alugarImovelBean.getImovel());
            pst.setString(5, alugarImovelBean.getCliente());
            pst.setString(6, alugarImovelBean.getValorNegociado());
            
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
            JOptionPane.showMessageDialog(null, "Venda modificada com sucesso!");
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
            pst = ConexaoBD.getPreparedStatement("SELECT * FROM tabela_alugar_imovel WHERE corretor LIKE '%"+nome+"%' OR cliente LIKE '%"+nome+"%' ");
            rs = pst.executeQuery();   
            AlugarImovelBean alugarImovelBean;
            Dados.listaAlugarImoveis.clear();
            while (rs.next()) {
                alugarImovelBean = new AlugarImovelBean();
                alugarImovelBean.setCodigo(rs.getInt("codigo"));
                alugarImovelBean.setDataDeInicioDoContrato(rs.getString("data_de_inicio_do_contrato"));
                alugarImovelBean.setDataDeFimDoContrato(rs.getString("data_de_fim_do_contrato"));
                alugarImovelBean.setCorretor(rs.getString("corretor"));
                alugarImovelBean.setImovel(rs.getString("imovel"));
                alugarImovelBean.setCliente(rs.getString("cliente"));
                alugarImovelBean.setValorNegociado(rs.getString("valor_negociado"));            
                
                Dados.listaAlugarImoveis.add(alugarImovelBean);
            }
            TabelaAbstrataAlugarImoveis tabelaAbstrataAlugarImoveis = new TabelaAbstrataAlugarImoveis(Dados.listaAlugarImoveis);
            PainelPesquisarAlugarImovel.tabelaAlugarImoveis.setModel(tabelaAbstrataAlugarImoveis);
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO! " + erro);
        } finally {
            ConexaoBD.desconectar();
        }

    }
    
    protected List<AlugarImovelBean> listar() {
        
        try {
            pst = ConexaoBD.getPreparedStatement("SELECT * FROM tabela_alugar_imovel");
            rs = pst.executeQuery();
            AlugarImovelBean alugarImovelBean;
            
            Dados.listaAlugarImoveis.clear();
            while (rs.next()) {
                alugarImovelBean = new AlugarImovelBean();
                alugarImovelBean.setCodigo(rs.getInt("codigo"));
                alugarImovelBean.setDataDeInicioDoContrato(rs.getString("data_do_inicio_do_contrato"));
                alugarImovelBean.setDataDeFimDoContrato(rs.getString("data_do_fim_do_contrato"));
                alugarImovelBean.setCorretor(rs.getString("corretor"));
                alugarImovelBean.setImovel(rs.getString("imovel"));
                alugarImovelBean.setCliente(rs.getString("cliente"));
                alugarImovelBean.setValorNegociado(rs.getString("valor_negociado"));
                
                Dados.listaAlugarImoveis.add(alugarImovelBean);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO GROTESCO! " + erro);
        } finally {
            ConexaoBD.desconectar();
        }
        return Dados.listaAlugarImoveis;
    }
    
    protected void excluir(int codigo) {
        try {
            pst = ConexaoBD.getPreparedStatement("DELETE FROM tabela_alugar_imovel WHERE codigo=?");
            pst.setInt(1, codigo);
            pst.executeUpdate();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO! " + erro);
        } finally {
            ConexaoBD.desconectar();
        }
    }
    

}
