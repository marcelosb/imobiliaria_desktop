package controle;

import java.util.ArrayList;
import modelo.AlugarImovelBean;
import modelo.ClientePessoaFisicaBean;
import modelo.ClientePessoaJuridicaBean;
import modelo.ClientePessoaResumoBean;
import modelo.CorretorBean;
import modelo.ImovelBean;
import modelo.VenderImovelBean;

/**
 * @author Marcelo Henrique
 */

public class Dados {

    public static Integer codigo;
    public static String nome = "Admin";
    public static String sobrenome = "Teste";
    public static String usuario;
    public static String senha;
    public static String email;
    public static String perfilUsuario = "Administrador";
    
    public static String corretorSelecaoVenderImoveis = "";
        
    public static ArrayList<ClientePessoaFisicaBean> listaDeClientes = new ArrayList();
    public static ArrayList<ClientePessoaResumoBean> listaDeClientesResumo = new ArrayList();
    public static ArrayList<ClientePessoaResumoBean> listaDeClientesResumoAlugar = new ArrayList();
    
    public static ArrayList<CorretorBean> listaDeCorretores = new ArrayList();
    public static ArrayList<VenderImovelBean> listaVenderImoveis = new ArrayList();
    public static ArrayList<AlugarImovelBean> listaAlugarImoveis = new ArrayList();
    
    public static ArrayList<ImovelBean> listaDeImoveis = new ArrayList();
    
    
    public static ArrayList<ImovelBean> listaDeImoveisVenderImovel = new ArrayList();
    public static ArrayList<ImovelBean> listaDeImoveisAlugarImovel = new ArrayList();
    
    public static Double listaDeImoveisValorCobrado = 0.0;
    
    public static ArrayList<ClientePessoaFisicaBean> listaDeClientesVenderImovel = new ArrayList();
    
    public static ArrayList<ClientePessoaFisicaBean> listaDeClientesPessoaFisica = new ArrayList();
    public static ArrayList<ClientePessoaJuridicaBean> listaDeClientesPessoaJuridica = new ArrayList();
    
    public static ArrayList<CorretorBean> listaDeCorretoresVenderImovel = new ArrayList();
    public static ArrayList<CorretorBean> listaDeCorretoresAlugarImovel = new ArrayList();
    
    public static ClientePessoaResumoBean clientePessoaResumoBean = new ClientePessoaResumoBean();
    public static ClientePessoaFisicaBean clienteFisicoEstaticoBean = new ClientePessoaFisicaBean();
    public static ClientePessoaJuridicaBean clienteJuridicoEstaticoBean = new ClientePessoaJuridicaBean();
    
    public static CorretorBean corretorEstaticoBean = new CorretorBean();
    public static VenderImovelBean venderImovelEstaticoBean = new VenderImovelBean();
    public static ImovelBean imovelEstaticoBean = new ImovelBean();
    
    public static ImovelBean imovelBeanSelecioneImovelVenda = new ImovelBean();
    public static ImovelBean imovelBeanSelecioneImovelVendaAlteracao = new ImovelBean();
    public static ImovelBean imovelBeanSelecioneImovelVendaAlteracaoAnterior = new ImovelBean();
    
    public static ArrayList<ClientePessoaFisicaBean> listaPesquisaCliente = new ArrayList();
    public static boolean cadastrouNovoCliente = false;
    public static ArrayList<String> listaMarcaDeVeiculos = new ArrayList();
    
    public static String CorretorEstatico = "";
    public static String ImovelEstatico = "";
    public static String ImovelEstaticoAlugar = "";
    public static String ClienteEstatico = "";
}
