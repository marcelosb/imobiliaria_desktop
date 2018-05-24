package modelo;

/**
 * @author Marcelo Henirque
 */
public class AlugarImovelBean implements Composite{
    
    private int codigo;
    private String dataDeInicioDoContrato;
    private String dataDeFimDoContrato;
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

    public String getDataDeInicioDoContrato() {
        return dataDeInicioDoContrato;
    }

    public void setDataDeInicioDoContrato(String dataDeInicioDoContrato) {
        this.dataDeInicioDoContrato = dataDeInicioDoContrato;
    }

    public String getDataDeFimDoContrato() {
        return dataDeFimDoContrato;
    }

    public void setDataDeFimDoContrato(String dataDeFimDoContrato) {
        this.dataDeFimDoContrato = dataDeFimDoContrato;
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
        campoValorNegociadoDoAluguel.setText(imovelBean.getValorCobrado());
        */
    }
    

}
