package util;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.ClientePessoaResumoBean;

/**
 * @author Marcelo Henrique
 */
public class TabelaAbstrataClientes extends AbstractTableModel {

    /**
     * classe Table Model "modelo de tabela" p/entidade Empregado
     *
     * @author Roberto Silva
     */
    //constantes p/identificar colunas
    private final int CODIGO = 0;
    private final int CLIENTE = 1;
    private final int TIPO = 2;
    
    
    private final String colunas[] = {"Código", "Cliente", "Tipo"};
    
    private final List<ClientePessoaResumoBean> dados;//usamos como dados uma lista genérica de Empregado

    public TabelaAbstrataClientes(List<ClientePessoaResumoBean> dados) {
        //seto os dados no construtor
        this.dados = dados;
    }

//    public void removeTodasColunas(){
//        colunas = null;
//    }
    
    @Override
    public int getColumnCount() {
        //retorna o total de colunas
        return colunas.length;
    }

    @Override
    public int getRowCount() {
        //retorna o total de linhas na tabela
        return dados.size();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        //retorna o tipo de dado, para cada coluna
                
        switch (columnIndex) {
            case CODIGO:
                return int.class;
            case CLIENTE:
                return String.class;
            case TIPO:
                return String.class;     
            default:
                throw new IndexOutOfBoundsException("Coluna Inválida!!!");
        }
        
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //retorna o valor conforme a coluna e linha

        //pega o dados corrente da linha
        ClientePessoaResumoBean clientePessoaResumoBean = dados.get(rowIndex);

        //retorna o valor da coluna
        
        switch (columnIndex) {
            case CODIGO:
                return clientePessoaResumoBean.getCodigo();
            case CLIENTE:
                return clientePessoaResumoBean.getCliente();
            case TIPO:
                return clientePessoaResumoBean.getTipo();
            default:
                throw new IndexOutOfBoundsException("Coluna Inválida!!!");
        }
        
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }


    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        ClientePessoaResumoBean clientePessoaResumoBean = dados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                //return clienteBean.getCodigo();
                clientePessoaResumoBean.setCodigo(Integer.parseInt(aValue.toString()));
            case 1:
                clientePessoaResumoBean.setCliente(aValue.toString());
                //return clienteBean.getNome();
            case 2:
                clientePessoaResumoBean.setTipo(aValue.toString());
                //return clienteBean.getEndereco();
            default:
                System.err.println("Índice da coluna inválido");
        }
        
        fireTableCellUpdated(rowIndex, columnIndex);

    }

    
    //Métodos abaixo são para manipulação de dados
    /**
     * retorna o valor da linha indicada
     *
     * @param rowIndex
     * @return
     */
    public ClientePessoaResumoBean getValue(int rowIndex) {
        return dados.get(rowIndex);
    }

    /**
     * retorna o indice do objeto
     *
     * @param empregado
     * @return
     */
    public int indexOf(ClientePessoaResumoBean empregado) {
        return dados.indexOf(empregado);
    }

    /**
     * add um empregado á lista
     *
     * @param empregado
     */
    public void onAdd(ClientePessoaResumoBean empregado) {
        dados.add(empregado);
        fireTableRowsInserted(indexOf(empregado), indexOf(empregado));
    }

    
    /**
     * add uma lista de empregados
     *
     * @param dadosIn
     */
    public void onAddAll(List<ClientePessoaResumoBean> dadosIn) {
        dados.addAll(dadosIn);
        fireTableDataChanged();
    }

    /**
     * remove um registro da lista, através do indice
     *
     * @param rowIndex
     */
    public void onRemove(int rowIndex) {
        dados.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }

    /**
     * remove um registro da lista, através do objeto
     *
     * @param empregado
     */
    public void onRemove(ClientePessoaResumoBean empregado) {
        int indexBefore = indexOf(empregado);//pega o indice antes de apagar
        dados.remove(empregado);
        fireTableRowsDeleted(indexBefore, indexBefore);
    }

    /**
     * remove todos registros da lista
     */
    public void onRemoveAll() {
        dados.clear();
        fireTableDataChanged();
    }


}
