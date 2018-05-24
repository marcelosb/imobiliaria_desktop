
package modelo;

/**
 *
 * @author Marcelo
 */
public class ImovelBean {
    
    private Integer codigo;
    private String proprietario;
    private String tipo;
    private String finalidade;
    private String valorCobrado;
    private String status;

    private static ImovelBean instanciaImovel = null;
    
    public static ImovelBean getInstancia(){
        if(instanciaImovel == null){
            instanciaImovel = new ImovelBean();
        }
        return instanciaImovel;
    }
    
    public ImovelBean(){
    }
    
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFinalidade() {
        return finalidade;
    }

    public void setFinalidade(String finalidade) {
        this.finalidade = finalidade;
    }

    public String getValorCobrado() {
        return valorCobrado;
    }

    public void setValorCobrado(String valorCobrado) {
        this.valorCobrado = valorCobrado;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
