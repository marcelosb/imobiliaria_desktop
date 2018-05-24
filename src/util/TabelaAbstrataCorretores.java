package util;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.CorretorBean;

/**
 * @author Marcelo Henrique
 */
public class TabelaAbstrataCorretores extends AbstractTableModel {

    
    // Constantes para identificar colunas
    private final int REGISTRO = 0;
    private final int NOME = 1;
   
    
    private final String colunas[] = {"Registro", "Nome do Corretor"};
    
    // Usamos como dados uma lista genérica 
    private final List<CorretorBean> dados;

    public TabelaAbstrataCorretores(List<CorretorBean> dados) {
        //seto os dados no construtor
        this.dados = dados;
    }
    
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
            case REGISTRO:
                return int.class;
            case NOME:
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
        CorretorBean corretorBean = dados.get(rowIndex);

        //retorna o valor da coluna
        
        switch (columnIndex) {
            case REGISTRO:
                return corretorBean.getRegistro();
            case NOME:
                return corretorBean.getNome();
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
        CorretorBean corretorBean = dados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                //return clienteBean.getCodigo();
                corretorBean.setRegistro(Integer.parseInt(aValue.toString()));
            case 1:
                corretorBean.setNome(aValue.toString());
                //return clienteBean.getNome();
           
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
    public CorretorBean getValue(int rowIndex) {
        return dados.get(rowIndex);
    }

    /**
     * retorna o indice do objeto
     *
     * @param empregado
     * @return
     */
    public int indexOf(CorretorBean empregado) {
        return dados.indexOf(empregado);
    }

    /**
     * add um empregado á lista
     *
     * @param empregado
     */
    public void onAdd(CorretorBean empregado) {
        dados.add(empregado);
        fireTableRowsInserted(indexOf(empregado), indexOf(empregado));
    }
  
    /**
     * add uma lista de empregados
     *
     * @param dadosIn
     */
    public void onAddAll(List<CorretorBean> dadosIn) {
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
    public void onRemove(CorretorBean empregado) {
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
