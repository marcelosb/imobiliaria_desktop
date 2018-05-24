
package controle;

import acesso_banco_de_dados.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.ClientePessoaFisicaBean;
import modelo.ClientePessoaJuridicaBean;
import modelo.ClientePessoaResumoBean;
import util.TabelaAbstrataClientes;
import visual.tela_cliente.PainelPesquisarClientes;


/**
 *
 * @author Marcelo
 */
class ClienteControl {
    
    private static PreparedStatement pst;
    private static ResultSet rs;
    
    protected void cadastrarClientePF(ClientePessoaFisicaBean clientePessoaFisicaBean) {
        try {
            pst = ConexaoBD.getPreparedStatement("INSERT INTO tabela_cliente_pf (nome, endereco, cpf, tipo) VALUES(?, ?, ?, ?)");
            pst.setString(1, clientePessoaFisicaBean.getNome());
            pst.setString(2, clientePessoaFisicaBean.getEndereco());
            pst.setString(3, clientePessoaFisicaBean.getCPF());
            pst.setString(4, clientePessoaFisicaBean.getTipo());
            
            pst.executeUpdate();
               
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO! " + erro);
        } finally {
            ConexaoBD.desconectar();
        }
        
    }
    
    protected void alterarClientePF(ClientePessoaFisicaBean clientePessoaFisicaBean, int codigo) {
        try {
            pst = ConexaoBD.getPreparedStatement("UPDATE tabela_cliente_pf SET nome=?, endereco=?, cpf=? WHERE codigo='"+codigo+"'");
            
            pst.setString(1, clientePessoaFisicaBean.getNome());
            pst.setString(2, clientePessoaFisicaBean.getEndereco());
            pst.setString(3, clientePessoaFisicaBean.getCPF());
            
            pst.executeUpdate();
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO! " + erro);
        } finally {
            ConexaoBD.desconectar();
        }
       
    }
    
    protected void alterarClientePJ(ClientePessoaJuridicaBean clientePessoaJuridicaBean, int codigo) {
        try {
               
            pst = ConexaoBD.getPreparedStatement("UPDATE tabela_cliente_pj SET nome_fantasia=?, endereco=?, cnpj=? WHERE codigo='"+codigo+"'");
            
            pst.setString(1, clientePessoaJuridicaBean.getNomeFantasia());
            pst.setString(2, clientePessoaJuridicaBean.getEndereco());
            pst.setString(3, clientePessoaJuridicaBean.getCNPJ());
            
            pst.executeUpdate();
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO! " + erro);
        } finally {
            ConexaoBD.desconectar();
        }
       
    }
    
    protected void cadastrarCR(ClientePessoaResumoBean clientePessoaResumoBean) {
        try {
            pst = ConexaoBD.getPreparedStatement("INSERT INTO tabela_cliente_resumo (cliente, tipo) VALUES(?, ?)");
            pst.setString(1, clientePessoaResumoBean.getCliente());
            pst.setString(2, clientePessoaResumoBean.getTipo());
            pst.executeUpdate();
               
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO! " + erro);
        } finally {
            ConexaoBD.desconectar();
        }
        
    }
    
    protected void alterarCR(ClientePessoaResumoBean clientePessoaResumoBean, int codigo) {
        try {
               
            pst = ConexaoBD.getPreparedStatement("UPDATE tabela_cliente_resumo SET cliente=?, tipo=? WHERE codigo='"+codigo+"'");
            
            pst.setString(1, clientePessoaResumoBean.getCliente());
            pst.setString(2, clientePessoaResumoBean.getTipo());
            
            pst.executeUpdate();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO! " + erro);
        } finally {
            ConexaoBD.desconectar();
        }
       
    }
    
    protected void cadastrarClientePJ(ClientePessoaJuridicaBean clientePessoaJuridicaBean) {
        try {
            pst = ConexaoBD.getPreparedStatement("INSERT INTO tabela_cliente_pj (nome_fantasia, endereco, cnpj, tipo) VALUES(?, ?, ?, ?)");
            pst.setString(1, clientePessoaJuridicaBean.getNomeFantasia());
            pst.setString(2, clientePessoaJuridicaBean.getEndereco());
            pst.setString(3, clientePessoaJuridicaBean.getCNPJ());
            pst.setString(4, clientePessoaJuridicaBean.getTipo());
            
            pst.executeUpdate();
               
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO! " + erro);
        } finally {
            ConexaoBD.desconectar();
        }
        
    }
    
 
    protected void alterarCliente(ClientePessoaFisicaBean clienteBean, int codigo) {
        try {
            pst = ConexaoBD.getPreparedStatement("UPDATE tabela_cliente SET nome=?, endereco=?, cpf=? WHERE rowid='"+codigo+"'");
            
            pst.setString(1, clienteBean.getNome());
            pst.setString(2, clienteBean.getEndereco());
            pst.setString(3, clienteBean.getCPF());
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO! " + erro);
        } finally {
            ConexaoBD.desconectar();
        }
       
    }
    
    
    protected List<ClientePessoaResumoBean> listar() {
        try {
            pst = ConexaoBD.getPreparedStatement("SELECT * FROM tabela_cliente_resumo");
            rs = pst.executeQuery();
            ClientePessoaResumoBean clientePessoaResumoBean;
            Dados.listaDeClientesResumo.clear();
            while (rs.next()) {
                clientePessoaResumoBean = new ClientePessoaResumoBean();
                clientePessoaResumoBean.setCodigo(rs.getInt("codigo"));
                clientePessoaResumoBean.setCliente(rs.getString("cliente"));
                clientePessoaResumoBean.setTipo(rs.getString("tipo"));
                
                Dados.listaDeClientesResumo.add(clientePessoaResumoBean);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO GROTESCO! " + erro);
        } finally {
            ConexaoBD.desconectar();
        }
        return Dados.listaDeClientesResumo;
    }
      

    protected void pesquisar(String nome) {
        try {
            pst = ConexaoBD.getPreparedStatement("SELECT * FROM tabela_cliente_resumo WHERE cliente LIKE '%"+nome+"%' ");
            rs = pst.executeQuery();   
            ClientePessoaResumoBean clientePessoaResumoBean;
            Dados.listaDeClientesResumo.clear();
            while (rs.next()) {
                clientePessoaResumoBean = new ClientePessoaResumoBean();
                clientePessoaResumoBean.setCodigo(rs.getInt("codigo"));
                clientePessoaResumoBean.setCliente(rs.getString("cliente"));
                clientePessoaResumoBean.setTipo(rs.getString("tipo"));  
                
                Dados.listaDeClientesResumo.add(clientePessoaResumoBean);
            }
            TabelaAbstrataClientes tabelaAbstrataClientes = new TabelaAbstrataClientes(Dados.listaDeClientesResumo);
            PainelPesquisarClientes.tabelaClientes.setModel(tabelaAbstrataClientes);
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO! " + erro);
        } finally {
            ConexaoBD.desconectar();
        }

    }
    
    
    protected void excluir(String nome) {
        try {
            pst = ConexaoBD.getPreparedStatement("DELETE FROM tabela_cliente WHERE nome=?");
            pst.setString(1, nome);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente DELETADO com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO! " + erro);
        } finally {
            ConexaoBD.desconectar();
        }
    }
    
    protected void excluirClientePF(String nome) {
        try {
            pst = ConexaoBD.getPreparedStatement("DELETE FROM tabela_cliente_pf WHERE nome=?");
            pst.setString(1, nome);
            pst.executeUpdate();
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO! " + erro);
        } finally {
            ConexaoBD.desconectar();
        }
    }
    
    protected void excluirClientePJ(String nome) {
        try {
            pst = ConexaoBD.getPreparedStatement("DELETE FROM tabela_cliente_pj WHERE nome_fantasia=?");
            pst.setString(1, nome);
            pst.executeUpdate();
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO! " + erro);
        } finally {
            ConexaoBD.desconectar();
        }
    }
    
    protected void excluirClientePR(String nome) {
        try {
            pst = ConexaoBD.getPreparedStatement("DELETE FROM tabela_cliente_resumo WHERE cliente=?");
            pst.setString(1, nome);
            pst.executeUpdate();
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO! " + erro);
        } finally {
            ConexaoBD.desconectar();
        }
    }
    
    protected List<ClientePessoaResumoBean> ordenar(){
        try {
            pst = ConexaoBD.getPreparedStatement("SELECT codigo, cliente, tipo FROM tabela_cliente_resumo ORDER BY cliente");
            rs = pst.executeQuery();
            ClientePessoaResumoBean clientePessoaResumoBean;
            Dados.listaDeClientesResumo.clear();
            while (rs.next()) {
                clientePessoaResumoBean = new ClientePessoaResumoBean();
                clientePessoaResumoBean.setCodigo(rs.getInt("codigo"));
                clientePessoaResumoBean.setCliente(rs.getString("cliente"));
                clientePessoaResumoBean.setTipo(rs.getString("tipo"));

                Dados.listaDeClientesResumo.add(clientePessoaResumoBean);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO GROTESCO! " + erro);
        } finally {
            ConexaoBD.desconectar();
        }
        return Dados.listaDeClientesResumo;
    }
    
    protected List<ClientePessoaResumoBean> ordenarPeloNomeAlugar(){
        try {
            pst = ConexaoBD.getPreparedStatement("SELECT codigo, cliente, tipo FROM tabela_cliente_resumo ORDER BY cliente");
            rs = pst.executeQuery();
            ClientePessoaResumoBean clientePessoaResumoBean;
            Dados.listaDeClientesResumoAlugar.clear();
            while (rs.next()) {
                clientePessoaResumoBean = new ClientePessoaResumoBean();
                clientePessoaResumoBean.setCodigo(rs.getInt("codigo"));
                clientePessoaResumoBean.setCliente(rs.getString("cliente"));
                clientePessoaResumoBean.setTipo(rs.getString("tipo"));

                Dados.listaDeClientesResumoAlugar.add(clientePessoaResumoBean);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO GROTESCO! " + erro);
        } finally {
            ConexaoBD.desconectar();
        }
        return Dados.listaDeClientesResumoAlugar;
    }
    
    protected List<ClientePessoaFisicaBean> listarClientesPF(){
        try {
            pst = ConexaoBD.getPreparedStatement("SELECT codigo, nome, endereco, cpf FROM tabela_cliente_pf");
            rs = pst.executeQuery();
            ClientePessoaFisicaBean clientePessoaFisicaBean;
            Dados.listaDeClientesPessoaFisica.clear();
            while (rs.next()) {
                clientePessoaFisicaBean = new ClientePessoaFisicaBean();
                clientePessoaFisicaBean.setCodigo(rs.getInt("codigo"));
                clientePessoaFisicaBean.setNome(rs.getString("nome"));
                clientePessoaFisicaBean.setEndereco(rs.getString("endereco"));
                clientePessoaFisicaBean.setCPF(rs.getString("cpf"));

                Dados.listaDeClientesPessoaFisica.add(clientePessoaFisicaBean);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO GROTESCO! " + erro);
        } finally {
            ConexaoBD.desconectar();
        }
        return Dados.listaDeClientesPessoaFisica;
    }
    
    protected List<ClientePessoaJuridicaBean> listarClientesPJ(){
        try {
            pst = ConexaoBD.getPreparedStatement("SELECT codigo, nome_fantasia, endereco, cnpj FROM tabela_cliente_pj");
            rs = pst.executeQuery();
            ClientePessoaJuridicaBean clientePessoaJuridicaBean;
            Dados.listaDeClientesPessoaJuridica.clear();
            while (rs.next()) {
                clientePessoaJuridicaBean = new ClientePessoaJuridicaBean();
                clientePessoaJuridicaBean.setCodigo(rs.getInt("codigo"));
                clientePessoaJuridicaBean.setNomeFantasia(rs.getString("nome_fantasia"));
                clientePessoaJuridicaBean.setEndereco(rs.getString("endereco"));
                clientePessoaJuridicaBean.setCNPJ(rs.getString("cnpj"));

                Dados.listaDeClientesPessoaJuridica.add(clientePessoaJuridicaBean);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO GROTESCO! " + erro);
        } finally {
            ConexaoBD.desconectar();
        }
        return Dados.listaDeClientesPessoaJuridica;
    }
    
}
