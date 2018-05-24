package util;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.VenderImovelBean;

/**
 * @author Marcelo Henrique
 */
public class TabelaAbstrataVenderImoveis extends AbstractTableModel {

    // constantes p/identificar colunas
    private final int CODIGO = 0;
    private final int DATA_DA_VENDA = 1;
    private final int CORRETOR = 2;
    private final int IMOVEL = 3;
    private final int CLIENTE = 4;
    private final int VALOR_NEGOCIADO = 5;
   
    private final String colunas[] = {"Código", "Data da Venda", "Corretor", "Imovel", "Cliente", "Valor Negociado"};
    
    // usamos como dados uma lista genérica de Empregado
    private final List<VenderImovelBean> dados;
    
    public TabelaAbstrataVenderImoveis(List<VenderImovelBean> dados) {
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
            case DATA_DA_VENDA:
                return String.class;
            case CORRETOR:
                return String.class;
            case IMOVEL:
                return String.class;
            case CLIENTE:
                return String.class;
            case VALOR_NEGOCIADO:
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
        VenderImovelBean venderImovelBean = dados.get(rowIndex);

        //retorna o valor da coluna
        
        switch (columnIndex) {
            case CODIGO:
                return venderImovelBean.getCodigo();
            case DATA_DA_VENDA:
                return venderImovelBean.getDataDaVenda();
            case CORRETOR:
                return venderImovelBean.getCorretor();
            case IMOVEL:
                return venderImovelBean.getImovel(); 
            case CLIENTE:
                return venderImovelBean.getCliente(); 
            case VALOR_NEGOCIADO:
                return venderImovelBean.getValorNegociado(); 
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
        VenderImovelBean venderImovelBean = dados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                //return clienteBean.getCodigo();
                venderImovelBean.setCodigo(Integer.parseInt(aValue.toString()));
            case 1:
                venderImovelBean.setDataDaVenda(aValue.toString());
                //return clienteBean.getNome();
            case 2:
                venderImovelBean.setCorretor(aValue.toString());
                //return clienteBean.getEndereco();
            case 3:
                venderImovelBean.setImovel(aValue.toString());
                //return clienteBean.getCPF();  
            case 4:
                venderImovelBean.setCliente(aValue.toString());
                //return clienteBean.getCPF();  
            case 5:
                venderImovelBean.setValorNegociado(aValue.toString());
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
    public VenderImovelBean getValue(int rowIndex) {
        return dados.get(rowIndex);
    }

    /**
     * retorna o indice do objeto
     *
     * @param empregado
     * @return
     */
    public int indexOf(VenderImovelBean empregado) {
        return dados.indexOf(empregado);
    }

    /**
     * add um empregado á lista
     *
     * @param empregado
     */
    public void onAdd(VenderImovelBean empregado) {
        dados.add(empregado);
        fireTableRowsInserted(indexOf(empregado), indexOf(empregado));
    }

    /**
     * add uma lista de empregados
     *
     * @param dadosIn
     */
    public void onAddAll(List<VenderImovelBean> dadosIn) {
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
    public void onRemove(VenderImovelBean empregado) {
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
