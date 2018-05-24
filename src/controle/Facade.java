
package controle;

import modelo.AlugarImovelBean;
import modelo.ClientePessoaFisicaBean;
import modelo.ClientePessoaJuridicaBean;
import modelo.ClientePessoaResumoBean;
import modelo.CorretorBean;
import modelo.ImovelBean;
import modelo.VenderImovelBean;

/**
 *
 * @author Marcelo
 */
public class Facade {
    
    private ImovelControl imovelControl;
    private AlugarImovelControl alugarImovelControl;
    private ClienteControl clienteControl;
    private CorretorControl corretorControl;
    private VenderImovelControl venderImovelControl;
    
    public Facade(){
        this.imovelControl = new ImovelControl();
        this.alugarImovelControl = new AlugarImovelControl();
        this.clienteControl = new ClienteControl();
        this.corretorControl = new CorretorControl();
        this.venderImovelControl = new VenderImovelControl();
    }
    
    // Métodos relacionados ao controle de imóveis
    public void cadastrarImovel(ImovelBean imovelBean){imovelControl.cadastrar(imovelBean);}
    public void alterarImovel(ImovelBean imovelBean, int codigo){imovelControl.alterar(imovelBean, codigo);}
    public void alterarStatusDoImovel(int codigo){imovelControl.alterarStatus(codigo);}
    public void listarImoveis(){imovelControl.listar();}
    public void pesquisarImovel(String nome){imovelControl.pesquisar(nome);}
    public void excluirImovel(String nome){imovelControl.excluir(nome);}
    public void listarCodigoDosImoveisVender(){imovelControl.listarCodDosImoveisVender();}
    public void listarCodigoDosImoveisAlugar(){imovelControl.listarCodDosImoveisAlugar();}
    
    // Métodos relacionados ao controle do aluguel de imóveis
    public void cadastrarAluguelDeImovel(AlugarImovelBean alugarImovelBean){alugarImovelControl.cadastrar(alugarImovelBean);}
    public void alterarVendaDeImovel(VenderImovelBean vendaDeImovelBean, int codigo){alugarImovelControl.alterar(vendaDeImovelBean, codigo);}
    public void pesquisarAlugarImovel(String nome){alugarImovelControl.pesquisar(nome);}
    public void listarAlugarImoveis(){alugarImovelControl.listar();}
    public void excluirRegistroAlugarImovel(int codigo){alugarImovelControl.excluir(codigo);}
    
    // Métodos relacionados ao controle dos clientes Pessoa Física e Pessoa Jurídica
    public void cadastrarClientePessoaFisica(ClientePessoaFisicaBean clientePessoaFisicaBean){clienteControl.cadastrarClientePF(clientePessoaFisicaBean);}
    public void alterarClientePessoaFisica(ClientePessoaFisicaBean clientePessoaFisicaBean, int codigo){clienteControl.alterarClientePF(clientePessoaFisicaBean, codigo);}
    public void alterarClientePessoaJuridica(ClientePessoaJuridicaBean clientePessoaJuridicaBean, int codigo){clienteControl.alterarClientePJ(clientePessoaJuridicaBean, codigo);}
    public void cadastrarClienteResumo(ClientePessoaResumoBean clientePessoaResumoBean){clienteControl.cadastrarCR(clientePessoaResumoBean);}
    public void alterarClienteResumo(ClientePessoaResumoBean clientePessoaResumoBean, int codigo){clienteControl.alterarCR(clientePessoaResumoBean, codigo);}
    public void cadastrarClientePessoaJuridica(ClientePessoaJuridicaBean clientePessoaJuridicaBean){clienteControl.cadastrarClientePJ(clientePessoaJuridicaBean);}
    public void editarCliente(ClientePessoaFisicaBean clienteBean, int codigo){clienteControl.alterarCliente(clienteBean, codigo);}
    public void listarClientes(){clienteControl.listar();}
    public void pesquisarCliente(String nome){clienteControl.pesquisar(nome);}
    public void excluirCliente(String nome){clienteControl.excluir(nome);}
    public void excluirClientePessoaFisica(String nome){clienteControl.excluirClientePF(nome);}
    public void excluirClientePessoaJuridica(String nome){clienteControl.excluirClientePJ(nome);}
    public void excluirClientePessoaResumo(String nome){clienteControl.excluirClientePR(nome);}
    public void ordenarClientesPeloNome(){clienteControl.ordenar();}
    public void ordenarClientesPeloNomeAlugar(){clienteControl.ordenarPeloNomeAlugar();}
    public void listarClientesPessoaFisica(){clienteControl.listarClientesPF();}
    public void listarClientesPessoaJuridica(){clienteControl.listarClientesPJ();}
    
    // Métodos relacionados ao controle de corretores
    public void cadastrarCorretor(CorretorBean corretorBean){corretorControl.cadastrar(corretorBean);}
    public void alterarCorretor(CorretorBean corretorBean, int codigo){corretorControl.alterar(corretorBean, codigo);}
    public void listarCorretores(){corretorControl.listar();}
    public void pesquisarCorretor(String nome){corretorControl.pesquisar(nome);}
    public void excluirCorretor(String nome){corretorControl.excluir(nome);}
    public void listarCorretoresPeloNome(){corretorControl.listarPeloNome();}
    public void listarCorretoresPeloNomeAlugar(){corretorControl.listarPorNomeAlugar();}
    
    // Métodos relacionados ao controle das vendas dos imóveis
    public void cadastrarVendaDoImovel(VenderImovelBean vendaDeImovelBean){venderImovelControl.cadastrar(vendaDeImovelBean);}
    public void alterarVendaDoImovel(VenderImovelBean vendaDeImovelBean, int codigo){venderImovelControl.alterar(vendaDeImovelBean, codigo);}
    public void pesquisarVenderImovel(String nome){venderImovelControl.pesquisar(nome);}
    public void listarVenderImoveis(){venderImovelControl.listar();}
    public void excluirRegistroVenderImovel(int codigo){venderImovelControl.excluir(codigo);}
    
}
