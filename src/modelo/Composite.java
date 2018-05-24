
package modelo;

/**
 * @author Marcelo
 */
public interface Composite {
    
    // O parâmetro passado é do tipo String pois
    // facilita na formatação da moeda BR
    public void setValorNegociado(String valor);
    
    // O retorno é do tipo String, pois facilita na formatação da Moeda BR
    public String getValorNegociado();
}
