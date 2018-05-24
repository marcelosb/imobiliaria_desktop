
package acesso_banco_de_dados;

/**
 * @author Marcelo
 */
public class Singleton {
   
    private static Singleton instancia = null;
    
    private Singleton(){
        
    }
    
    public static Singleton obterUnicaInstanciaConexaoBD(){
        if(instancia == null){
            instancia = new Singleton();
            ConexaoBD unicaInstancia = new ConexaoBD();
        }
        return instancia;
    }
    
}
