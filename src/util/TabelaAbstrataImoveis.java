package util;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.ImovelBean;

/**
 * @author Marcelo Henrique
 */
public class TabelaAbstrataImoveis extends AbstractTableModel {

    
    // constantes p/identificar colunas
    private final int CODIGO = 0;
    private final int PROPRIETARIO = 1;
    private final int TIPO = 2;
    private final int FINALIDADE = 3;
    private final int VALOR_COBRADO = 4;
    private final int STATUS = 5;

    private final String colunas[] = {"Código", "Proprietário", "Tipo", "Finalidade", "Valor Cobrado", "Status"};
    
    // usamos como dados uma lista genérica
    private final List<ImovelBean> dados;

    public TabelaAbstrataImoveis(List<ImovelBean> dados) {
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
            case CODIGO:
                return int.class;
            case PROPRIETARIO:
                return String.class;
            case TIPO:
                return String.class;
            case FINALIDADE:
                return String.class;
            case VALOR_COBRADO:
                return String.class; 
            case STATUS:
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
        ImovelBean imovelBean = dados.get(rowIndex);

        //retorna o valor da coluna
        
        switch (columnIndex) {
            case CODIGO:
                return imovelBean.getCodigo();
            case PROPRIETARIO:
                return imovelBean.getProprietario();
            case TIPO:
                return imovelBean.getTipo();
            case FINALIDADE:
                return imovelBean.getFinalidade(); 
            case VALOR_COBRADO:
                return imovelBean.getValorCobrado(); 
            case STATUS:
                return imovelBean.getStatus(); 
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
        ImovelBean imovelBean = dados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                //return clienteBean.getCodigo();
                imovelBean.setCodigo(Integer.parseInt(aValue.toString()));
            case 1:
                imovelBean.setProprietario(aValue.toString());
                //return clienteBean.getNome();
            case 2:
                imovelBean.setTipo(aValue.toString());
                //return clienteBean.getEndereco();
            case 3:
                imovelBean.setFinalidade(aValue.toString());
                //return clienteBean.getCPF();  
            case 4:
                imovelBean.setValorCobrado(aValue.toString());
                //return clienteBean.getCPF();
            case 5:
                imovelBean.setStatus(aValue.toString());
                //return clienteBean.getCPF();        
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
    public ImovelBean getValue(int rowIndex) {
        return dados.get(rowIndex);
    }

    /**
     * retorna o indice do objeto
     *
     * @param empregado
     * @return
     */
    public int indexOf(ImovelBean empregado) {
        return dados.indexOf(empregado);
    }

    /**
     * add um empregado á lista
     *
     * @param empregado
     */
    public void onAdd(ImovelBean empregado) {
        dados.add(empregado);
        fireTableRowsInserted(indexOf(empregado), indexOf(empregado));
    }

    /**
     * add uma lista de empregados
     *
     * @param dadosIn
     */
    public void onAddAll(List<ImovelBean> dadosIn) {
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
    public void onRemove(ImovelBean empregado) {
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
