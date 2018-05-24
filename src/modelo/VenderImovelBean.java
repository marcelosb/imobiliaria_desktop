package modelo;

/**
 * @author Marcelo Henirque
 */
public class VenderImovelBean implements Composite{
    
    private Integer codigo;
    private String dataDaVenda;
    private String corretor;
    private String imovel;
    private String cliente;
    private String valorNegociado;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDataDaVenda() {
        return dataDaVenda;
    }

    public void setDataDaVenda(String dataDaVenda) {
        this.dataDaVenda = dataDaVenda;
    }

    public String getCorretor() {
        return corretor;
    }

    public void setCorretor(String corretor) {
        this.corretor = corretor;
    }

    public String getImovel() {
        return imovel;
    }

    public void setImovel(String imovel) {
        this.imovel = imovel;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    @Override
    public String getValorNegociado() {
        return valorNegociado;
    }

    @Override
    public void setValorNegociado(String valorNegociado) {
        this.valorNegociado = valorNegociado;
        /*
            Double valorDaVenda = valorNegociadoAuxiliar;
            Double valorFinalComDesconto = valor * 0.835; 
            valorAuxiliarFinal = valorFinalComDesconto;
            campoValorNegociadoDaVenda.setText(DecimalFormat.getCurrencyInstance().format(valorFinalComDesconto));
        */                
    }

    


}
