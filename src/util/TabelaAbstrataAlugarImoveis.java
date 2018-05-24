package util;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.AlugarImovelBean;

/**
 * @author Marcelo Henrique
 */
public class TabelaAbstrataAlugarImoveis extends AbstractTableModel {

    
    
    // constantes p/identificar colunas
    private final int CODIGO = 0;
    private final int DATA_DE_INICIO_DO_ALUGUEL = 1;
    private final int DATA_DO_FIM_DO_ALUGUEL = 2;
    private final int CORRETOR = 3;
    private final int IMOVEL = 4;
    private final int CLIENTE = 5;
    private final int VALOR_NEGOCIADO = 6;
   
    private final String colunas[] = {"Código", "Data de Início", "Data do Fim", "Corretor", "Imovel", "Cliente", "Valor Negociado"};
    
    // usamos como dados uma lista genérica de Empregado
    private final List<AlugarImovelBean> dados;
    
    public TabelaAbstrataAlugarImoveis(List<AlugarImovelBean> dados) {
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
            case DATA_DE_INICIO_DO_ALUGUEL:
                return String.class;
            case DATA_DO_FIM_DO_ALUGUEL:
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
        AlugarImovelBean alugarImovelBean = dados.get(rowIndex);

        //retorna o valor da coluna
        
        switch (columnIndex) {
            case CODIGO:
                return alugarImovelBean.getCodigo();
            case DATA_DE_INICIO_DO_ALUGUEL:
                return alugarImovelBean.getDataDeInicioDoContrato();
            case DATA_DO_FIM_DO_ALUGUEL:
                return alugarImovelBean.getDataDeFimDoContrato();     
            case CORRETOR:
                return alugarImovelBean.getCorretor();
            case IMOVEL:
                return alugarImovelBean.getImovel(); 
            case CLIENTE:
                return alugarImovelBean.getCliente(); 
            case VALOR_NEGOCIADO:
                return alugarImovelBean.getValorNegociado(); 
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
        AlugarImovelBean alugarImovelBean = dados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                //return clienteBean.getCodigo();
                alugarImovelBean.setCodigo(Integer.parseInt(aValue.toString()));
            case 1:
                alugarImovelBean.setDataDeInicioDoContrato(aValue.toString());
                //return clienteBean.getNome();
            case 2:
                alugarImovelBean.setDataDeFimDoContrato(aValue.toString());
                //return clienteBean.getNome();
            case 3:
                alugarImovelBean.setCorretor(aValue.toString());
                //return clienteBean.getEndereco();
            case 4:
                alugarImovelBean.setImovel(aValue.toString());
                //return clienteBean.getCPF();  
            case 5:
                alugarImovelBean.setCliente(aValue.toString());
                //return clienteBean.getCPF();  
            case 6:
                alugarImovelBean.setValorNegociado(aValue.toString());
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
    public AlugarImovelBean getValue(int rowIndex) {
        return dados.get(rowIndex);
    }

    /**
     * retorna o indice do objeto
     *
     * @param empregado
     * @return
     */
    public int indexOf(AlugarImovelBean empregado) {
        return dados.indexOf(empregado);
    }

    /**
     * add um empregado á lista
     *
     * @param empregado
     */
    public void onAdd(AlugarImovelBean empregado) {
        dados.add(empregado);
        fireTableRowsInserted(indexOf(empregado), indexOf(empregado));
    }

    /**
     * add uma lista de empregados
     *
     * @param dadosIn
     */
    public void onAddAll(List<AlugarImovelBean> dadosIn) {
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
    public void onRemove(AlugarImovelBean empregado) {
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
