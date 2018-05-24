package visual.tela_principal;

/*import controle.AlugarImovelControl;*/
import acesso_banco_de_dados.Singleton;
import visual.tela_vender_imovel.PainelVenderImoveis;
import visual.tela_imovel.PainelPesquisarImoveis;
import visual.tela_imovel.PainelEditarImoveis;
import visual.tela_imovel.PainelCadastrarImoveis;
import visual.tela_corretor.PainelPesquisarCorretores;
import visual.tela_corretor.PainelEditarCorretores;
import visual.tela_corretor.PainelCadastrarCorretores;
import visual.tela_cliente.PainelPesquisarClientes;
import visual.tela_cliente.PainelEditarClientes;
import visual.tela_cliente.PainelCadastrarClientes;
/*import controle.ClienteControl;*/
import controle.CorretorControl;
import controle.Dados;
import controle.Facade;
/*import controle.ImovelControl;*/
import controle.VenderImovelControl;
import java.awt.Color;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import modelo.AlugarImovelBean;
import modelo.CorretorBean;
import modelo.ImovelBean;
import modelo.VenderImovelBean;
import visual.tela_alugar_imovel.PainelAlugarImoveis;
import visual.tela_alugar_imovel.PainelDeDialogoAlugarImovel;
import visual.tela_alugar_imovel.PainelDeDialogoCadastrarAlugarImovel;
import visual.tela_alugar_imovel.PainelDeDialogoExcluirAlugarImovel;
import visual.tela_alugar_imovel.PainelEditarAlugarImoveis;
import visual.tela_alugar_imovel.PainelPesquisarAlugarImovel;
import visual.tela_cliente.PainelDeDialogoCadastrarCliente;
import visual.tela_cliente.PainelDeDialogoCliente;
import visual.tela_cliente.PainelDeDialogoExcluirCliente;
import visual.tela_corretor.PainelDeDialogoCadastrarCorretor;
import visual.tela_corretor.PainelDeDialogoCorretor;
import visual.tela_corretor.PainelDeDialogoExcluirCorretor;
import visual.tela_imovel.PainelDeDialogoCadastrarImovel;
import visual.tela_imovel.PainelDeDialogoExcluirImovel;
import visual.tela_imovel.PainelDeDialogoImovel;
import visual.tela_vender_imovel.PainelDeDialogoCadastrarVenderImovel;
import visual.tela_vender_imovel.PainelDeDialogoExcluirVenderImovel;
import visual.tela_vender_imovel.PainelDeDialogoVenderImovel;
import visual.tela_vender_imovel.PainelEditarVenderImoveis;
import visual.tela_vender_imovel.PainelPesquisarVenderImovel;

/**
 * @author Marcelo Henrique
 */
public class TelaPrincipalDoSistema extends javax.swing.JFrame {

    private static void desabilitarComponentesDevolucao() {
        //if (painelDevolucao != null) {
        //    areaDeTrabalhoDevolucoes.moveToBack(painelDevolucao);
        //    areaDeTrabalhoDevolucoes.remove(painelDevolucao);
        //}

    }

    public static Facade facade;
    
    public TelaPrincipalDoSistema() {
        
        UIManager.getDefaults().put("TabbedPane.contentBorderInsets", new Insets(0,0,0,0));
        UIManager.getDefaults().put("TabbedPane.tabAreaInsets", new Insets(0,0,0,0));
        UIManager.put("TabbedPane.selected",new Color(102, 102, 102));
        UIManager.put("TabbedPane.tabsOverlapBorder", true);
        
        
        initComponents();
        
        Singleton.obterUnicaInstanciaConexaoBD();
        facade = new Facade();

        menu.setVisible(false);
        switch (Dados.perfilUsuario) {
            case "Administrador":
                menu.setText(Dados.perfilUsuario.toUpperCase());
                exibirPainelInicio();
                exibirPainelPesquisarVenderImovel();
                exibirPainelPesquisarCliente();
                exibirPainelPesquisarCorretor();
                exibirPainelPesquisarImovel();
                exibirPainelVenderImovel();
                exibirPainelAlugarImovel();
                exibirPainelDevolucao();
                
                TelaPrincipalDoSistema.botaoEditarVenderImovel.setVisible(false);
                TelaPrincipalDoSistema.botaoExcluirVenderImovel.setVisible(false);
                
                TelaPrincipalDoSistema.botaoEditarAlugarImovel.setVisible(false);
                TelaPrincipalDoSistema.botaoExcluirAlugarImovel.setVisible(false);
                
                break;
       
            case "Vendedor":
                menu.setText(Dados.perfilUsuario.toUpperCase());
                
                botaoDeletarCliente.setVisible(false);
                botaoCadastrarImovel.setVisible(false);
                botaoEditarImovel.setVisible(false);
                botaoExcluirImovel.setVisible(false);
                
                //botaoVeiculosIndisponiveis.setVisible(false);
                
                exibirPainelInicio();
                exibirPainelPesquisarCliente();
                exibirPainelPesquisarCorretor();
                exibirPainelPesquisarImovel();
                exibirPainelDevolucao();
                break;
            
            default:
                break;
        }
         
    }


    public static void exibirPainelDevolucao() {
       
    }

    public static PainelPesquisarClientes painelPesquisarClientes = new PainelPesquisarClientes();
    public static void exibirPainelPesquisarCliente() {
        desabilitarComponentesClientes();
        areaDeTrabalhoCliente.add(painelPesquisarClientes);
        painelPesquisarClientes.setBounds(0, 0, 860, 519);
    }
    
    public static PainelPesquisarCorretores painelPesquisarCorretores = new PainelPesquisarCorretores();
    public static void exibirPainelPesquisarCorretor() {
        desabilitarComponentesCorretores();
        areaDeTrabalhoCorretor.add(painelPesquisarCorretores);
        painelPesquisarCorretores.setBounds(0, 0, 860, 520);
    }

    public static PainelPesquisarImoveis painelPesquisarImoveis = new PainelPesquisarImoveis();
    public static void exibirPainelPesquisarImovel() {
        desabilitarComponentesImoveis();
        areaDeTrabalhoImovel.add(painelPesquisarImoveis);
        painelPesquisarImoveis.setBounds(0, 0, 860, 520);
    }
    
    public static PainelPesquisarVenderImovel painelPesquisarVenderImovel = new PainelPesquisarVenderImovel();
    public static void exibirPainelPesquisarVenderImovel() {
        desabilitarComponentesVenderImoveis();
        areaDeTrabalhoVenderImovel.add(painelPesquisarVenderImovel);
        painelPesquisarVenderImovel.setBounds(0, 0, 860, 520);
    }
    
    public static PainelPesquisarAlugarImovel painelPesquisarAlugarImovel = new PainelPesquisarAlugarImovel();
    public static void exibirPainelPesquisarAlugarImovel() {
        desabilitarComponentesAlugarImoveis();
        areaDeTrabalhoAlugarImovel.add(painelPesquisarAlugarImovel);
        painelPesquisarAlugarImovel.setBounds(0, 0, 860, 520);
    }

    public static void exibirPainelVenderImovel() {
        desabilitarComponentesVenderImoveis();
        areaDeTrabalhoVenderImovel.add(painelVenderImoveis);
        painelVenderImoveis.setBounds(0, 0, 860, 520);
    }
    
    public static void exibirPainelAlugarImovel() {
        desabilitarComponentesAlugarImoveis();
        areaDeTrabalhoAlugarImovel.add(painelAlugarImoveis);
        painelAlugarImoveis.setBounds(0, 0, 860, 520);
    }

    public static PainelHome painelHome = new PainelHome();

    public static void exibirPainelInicio() {
        desabilitarComponentesHome();
        areaDeTrabalhoHome.add(painelHome);
        painelHome.setBounds(0, 0, 837, 564);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoDeBotoes = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        paineisComAbas = new javax.swing.JTabbedPane();
        painelInicio = new javax.swing.JPanel();
        areaDeTrabalhoHome = new javax.swing.JDesktopPane();
        painelCorretor = new javax.swing.JPanel();
        menuCliente1 = new javax.swing.JPanel();
        botaoDeletarCorretor = new javax.swing.JButton();
        botaoCadastrarCorretor = new javax.swing.JButton();
        botaoEditarCorretor = new javax.swing.JButton();
        areaDeTrabalhoCorretor = new javax.swing.JDesktopPane();
        painelCliente = new javax.swing.JPanel();
        menuCliente = new javax.swing.JPanel();
        botaoDeletarCliente = new javax.swing.JButton();
        botaoCadastrarCliente = new javax.swing.JButton();
        botaoEditarCliente = new javax.swing.JButton();
        areaDeTrabalhoCliente = new javax.swing.JDesktopPane();
        painelImovel = new javax.swing.JPanel();
        menuImovel = new javax.swing.JPanel();
        botaoExcluirImovel = new javax.swing.JButton();
        botaoCadastrarImovel = new javax.swing.JButton();
        botaoEditarImovel = new javax.swing.JButton();
        areaDeTrabalhoImovel = new javax.swing.JDesktopPane();
        painelVender = new javax.swing.JPanel();
        areaDeTrabalhoVenderImovel = new javax.swing.JDesktopPane();
        menuVenderImovel = new javax.swing.JPanel();
        botaoBuscarVendaDeImovel = new javax.swing.JButton();
        botaoEditarVenderImovel = new javax.swing.JButton();
        botaoExcluirVenderImovel = new javax.swing.JButton();
        painelAlugar = new javax.swing.JPanel();
        areaDeTrabalhoAlugarImovel = new javax.swing.JDesktopPane();
        menuVenderImovel1 = new javax.swing.JPanel();
        botaoBuscarAluguelDeImovel = new javax.swing.JButton();
        botaoEditarAlugarImovel = new javax.swing.JButton();
        botaoExcluirAlugarImovel = new javax.swing.JButton();
        barraMenu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menu = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Imobiliária UEPB");
        setBackground(new java.awt.Color(51, 51, 51));
        setIconImage(new ImageIcon(getClass().getResource("/imagens/tela_de_login/icone_imobiliaria.png")).getImage()
        );
        setMinimumSize(new java.awt.Dimension(1060, 650));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(998, 700));

        paineisComAbas.setBackground(new java.awt.Color(51, 51, 51));
        paineisComAbas.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        paineisComAbas.setFocusable(false);
        paineisComAbas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        paineisComAbas.setOpaque(true);

        painelInicio.setMinimumSize(new java.awt.Dimension(860, 520));
        painelInicio.setPreferredSize(new java.awt.Dimension(860, 520));

        areaDeTrabalhoHome.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout areaDeTrabalhoHomeLayout = new javax.swing.GroupLayout(areaDeTrabalhoHome);
        areaDeTrabalhoHome.setLayout(areaDeTrabalhoHomeLayout);
        areaDeTrabalhoHomeLayout.setHorizontalGroup(
            areaDeTrabalhoHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 875, Short.MAX_VALUE)
        );
        areaDeTrabalhoHomeLayout.setVerticalGroup(
            areaDeTrabalhoHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout painelInicioLayout = new javax.swing.GroupLayout(painelInicio);
        painelInicio.setLayout(painelInicioLayout);
        painelInicioLayout.setHorizontalGroup(
            painelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(areaDeTrabalhoHome)
        );
        painelInicioLayout.setVerticalGroup(
            painelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelInicioLayout.createSequentialGroup()
                .addComponent(areaDeTrabalhoHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        paineisComAbas.addTab("", new javax.swing.ImageIcon(getClass().getResource("/imagens/tela_principal_do_sistema/painel_home.png")), painelInicio, ""); // NOI18N

        menuCliente1.setBackground(new java.awt.Color(51, 153, 255));
        menuCliente1.setMaximumSize(new java.awt.Dimension(865, 50));
        menuCliente1.setMinimumSize(new java.awt.Dimension(865, 50));
        menuCliente1.setPreferredSize(new java.awt.Dimension(865, 50));

        botaoDeletarCorretor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tela_corretor/botao_excluir_corretor.png"))); // NOI18N
        botaoDeletarCorretor.setBorder(null);
        botaoDeletarCorretor.setBorderPainted(false);
        botaoDeletarCorretor.setContentAreaFilled(false);
        botaoDeletarCorretor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoDeletarCorretor.setFocusPainted(false);
        botaoDeletarCorretor.setFocusable(false);
        botaoDeletarCorretor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDeletarCorretorActionPerformed(evt);
            }
        });

        botaoCadastrarCorretor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tela_corretor/botao_cadastrar_corretor.png"))); // NOI18N
        botaoCadastrarCorretor.setBorder(null);
        botaoCadastrarCorretor.setBorderPainted(false);
        botaoCadastrarCorretor.setContentAreaFilled(false);
        botaoCadastrarCorretor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoCadastrarCorretor.setFocusPainted(false);
        botaoCadastrarCorretor.setFocusable(false);
        botaoCadastrarCorretor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarCorretorActionPerformed(evt);
            }
        });

        botaoEditarCorretor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tela_corretor/botao_editar_corretor.png"))); // NOI18N
        botaoEditarCorretor.setBorder(null);
        botaoEditarCorretor.setBorderPainted(false);
        botaoEditarCorretor.setContentAreaFilled(false);
        botaoEditarCorretor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoEditarCorretor.setFocusPainted(false);
        botaoEditarCorretor.setFocusable(false);
        botaoEditarCorretor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEditarCorretorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuCliente1Layout = new javax.swing.GroupLayout(menuCliente1);
        menuCliente1.setLayout(menuCliente1Layout);
        menuCliente1Layout.setHorizontalGroup(
            menuCliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuCliente1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoCadastrarCorretor, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoEditarCorretor, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoDeletarCorretor, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuCliente1Layout.setVerticalGroup(
            menuCliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botaoCadastrarCorretor, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(botaoEditarCorretor, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(botaoDeletarCorretor, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        areaDeTrabalhoCorretor.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout areaDeTrabalhoCorretorLayout = new javax.swing.GroupLayout(areaDeTrabalhoCorretor);
        areaDeTrabalhoCorretor.setLayout(areaDeTrabalhoCorretorLayout);
        areaDeTrabalhoCorretorLayout.setHorizontalGroup(
            areaDeTrabalhoCorretorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 875, Short.MAX_VALUE)
        );
        areaDeTrabalhoCorretorLayout.setVerticalGroup(
            areaDeTrabalhoCorretorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 549, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout painelCorretorLayout = new javax.swing.GroupLayout(painelCorretor);
        painelCorretor.setLayout(painelCorretorLayout);
        painelCorretorLayout.setHorizontalGroup(
            painelCorretorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(areaDeTrabalhoCorretor)
            .addComponent(menuCliente1, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE)
        );
        painelCorretorLayout.setVerticalGroup(
            painelCorretorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCorretorLayout.createSequentialGroup()
                .addComponent(menuCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(areaDeTrabalhoCorretor))
        );

        paineisComAbas.addTab("", new javax.swing.ImageIcon(getClass().getResource("/imagens/tela_principal_do_sistema/painel_corretor.png")), painelCorretor, ""); // NOI18N

        painelCliente.setBackground(new java.awt.Color(255, 255, 255));

        menuCliente.setBackground(new java.awt.Color(255, 153, 51));
        menuCliente.setMaximumSize(new java.awt.Dimension(865, 50));
        menuCliente.setMinimumSize(new java.awt.Dimension(865, 50));
        menuCliente.setPreferredSize(new java.awt.Dimension(865, 50));

        botaoDeletarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tela_cliente/botao_excluir_cliente.png"))); // NOI18N
        botaoDeletarCliente.setBorder(null);
        botaoDeletarCliente.setBorderPainted(false);
        botaoDeletarCliente.setContentAreaFilled(false);
        botaoDeletarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoDeletarCliente.setFocusPainted(false);
        botaoDeletarCliente.setFocusable(false);
        botaoDeletarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDeletarClienteActionPerformed(evt);
            }
        });

        botaoCadastrarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tela_cliente/botao_cadastrar_cliente.png"))); // NOI18N
        botaoCadastrarCliente.setBorder(null);
        botaoCadastrarCliente.setBorderPainted(false);
        botaoCadastrarCliente.setContentAreaFilled(false);
        botaoCadastrarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoCadastrarCliente.setFocusPainted(false);
        botaoCadastrarCliente.setFocusable(false);
        botaoCadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarClienteActionPerformed(evt);
            }
        });

        botaoEditarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tela_cliente/botao_editar_cliente.png"))); // NOI18N
        botaoEditarCliente.setBorder(null);
        botaoEditarCliente.setBorderPainted(false);
        botaoEditarCliente.setContentAreaFilled(false);
        botaoEditarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoEditarCliente.setFocusPainted(false);
        botaoEditarCliente.setFocusable(false);
        botaoEditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEditarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuClienteLayout = new javax.swing.GroupLayout(menuCliente);
        menuCliente.setLayout(menuClienteLayout);
        menuClienteLayout.setHorizontalGroup(
            menuClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoCadastrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoEditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoDeletarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(703, Short.MAX_VALUE))
        );
        menuClienteLayout.setVerticalGroup(
            menuClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botaoCadastrarCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(botaoEditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(botaoDeletarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        areaDeTrabalhoCliente.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout areaDeTrabalhoClienteLayout = new javax.swing.GroupLayout(areaDeTrabalhoCliente);
        areaDeTrabalhoCliente.setLayout(areaDeTrabalhoClienteLayout);
        areaDeTrabalhoClienteLayout.setHorizontalGroup(
            areaDeTrabalhoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        areaDeTrabalhoClienteLayout.setVerticalGroup(
            areaDeTrabalhoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 556, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout painelClienteLayout = new javax.swing.GroupLayout(painelCliente);
        painelCliente.setLayout(painelClienteLayout);
        painelClienteLayout.setHorizontalGroup(
            painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE)
            .addComponent(areaDeTrabalhoCliente)
        );
        painelClienteLayout.setVerticalGroup(
            painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelClienteLayout.createSequentialGroup()
                .addComponent(menuCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(areaDeTrabalhoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        paineisComAbas.addTab("", new javax.swing.ImageIcon(getClass().getResource("/imagens/tela_principal_do_sistema/painel_cliente.png")), painelCliente, ""); // NOI18N

        painelImovel.setBackground(new java.awt.Color(255, 255, 255));

        menuImovel.setBackground(new java.awt.Color(255, 204, 0));
        menuImovel.setMaximumSize(new java.awt.Dimension(32767, 50));
        menuImovel.setMinimumSize(new java.awt.Dimension(0, 50));
        menuImovel.setPreferredSize(new java.awt.Dimension(865, 50));

        botaoExcluirImovel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tela_imovel/botao_excluir_imovel.png"))); // NOI18N
        botaoExcluirImovel.setBorder(null);
        botaoExcluirImovel.setBorderPainted(false);
        botaoExcluirImovel.setContentAreaFilled(false);
        botaoExcluirImovel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoExcluirImovel.setFocusPainted(false);
        botaoExcluirImovel.setFocusable(false);
        botaoExcluirImovel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirImovelActionPerformed(evt);
            }
        });

        botaoCadastrarImovel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tela_imovel/botao_cadastrar_imovel.png"))); // NOI18N
        botaoCadastrarImovel.setBorder(null);
        botaoCadastrarImovel.setBorderPainted(false);
        botaoCadastrarImovel.setContentAreaFilled(false);
        botaoCadastrarImovel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoCadastrarImovel.setFocusPainted(false);
        botaoCadastrarImovel.setFocusable(false);
        botaoCadastrarImovel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarImovelActionPerformed(evt);
            }
        });

        botaoEditarImovel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tela_imovel/botao_editar_imovel.png"))); // NOI18N
        botaoEditarImovel.setBorder(null);
        botaoEditarImovel.setBorderPainted(false);
        botaoEditarImovel.setContentAreaFilled(false);
        botaoEditarImovel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoEditarImovel.setFocusPainted(false);
        botaoEditarImovel.setFocusable(false);
        botaoEditarImovel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEditarImovelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuImovelLayout = new javax.swing.GroupLayout(menuImovel);
        menuImovel.setLayout(menuImovelLayout);
        menuImovelLayout.setHorizontalGroup(
            menuImovelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuImovelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoCadastrarImovel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoEditarImovel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoExcluirImovel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(703, Short.MAX_VALUE))
        );
        menuImovelLayout.setVerticalGroup(
            menuImovelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botaoCadastrarImovel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(menuImovelLayout.createSequentialGroup()
                .addGroup(menuImovelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoExcluirImovel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoEditarImovel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        areaDeTrabalhoImovel.setBackground(new java.awt.Color(255, 255, 255));
        areaDeTrabalhoImovel.setPreferredSize(new java.awt.Dimension(860, 520));

        javax.swing.GroupLayout areaDeTrabalhoImovelLayout = new javax.swing.GroupLayout(areaDeTrabalhoImovel);
        areaDeTrabalhoImovel.setLayout(areaDeTrabalhoImovelLayout);
        areaDeTrabalhoImovelLayout.setHorizontalGroup(
            areaDeTrabalhoImovelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 860, Short.MAX_VALUE)
        );
        areaDeTrabalhoImovelLayout.setVerticalGroup(
            areaDeTrabalhoImovelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 549, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout painelImovelLayout = new javax.swing.GroupLayout(painelImovel);
        painelImovel.setLayout(painelImovelLayout);
        painelImovelLayout.setHorizontalGroup(
            painelImovelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuImovel, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE)
            .addComponent(areaDeTrabalhoImovel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        painelImovelLayout.setVerticalGroup(
            painelImovelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelImovelLayout.createSequentialGroup()
                .addComponent(menuImovel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(areaDeTrabalhoImovel, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE))
        );

        paineisComAbas.addTab("", new javax.swing.ImageIcon(getClass().getResource("/imagens/tela_principal_do_sistema/painel_imovel.png")), painelImovel, ""); // NOI18N

        areaDeTrabalhoVenderImovel.setBackground(new java.awt.Color(255, 255, 255));
        areaDeTrabalhoVenderImovel.setPreferredSize(new java.awt.Dimension(860, 520));

        javax.swing.GroupLayout areaDeTrabalhoVenderImovelLayout = new javax.swing.GroupLayout(areaDeTrabalhoVenderImovel);
        areaDeTrabalhoVenderImovel.setLayout(areaDeTrabalhoVenderImovelLayout);
        areaDeTrabalhoVenderImovelLayout.setHorizontalGroup(
            areaDeTrabalhoVenderImovelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 875, Short.MAX_VALUE)
        );
        areaDeTrabalhoVenderImovelLayout.setVerticalGroup(
            areaDeTrabalhoVenderImovelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 549, Short.MAX_VALUE)
        );

        menuVenderImovel.setBackground(new java.awt.Color(0, 204, 204));
        menuVenderImovel.setMaximumSize(new java.awt.Dimension(865, 50));
        menuVenderImovel.setMinimumSize(new java.awt.Dimension(865, 50));
        menuVenderImovel.setPreferredSize(new java.awt.Dimension(865, 50));

        botaoBuscarVendaDeImovel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tela_vender_imovel/botao_pesquisar_vender_imovel.png"))); // NOI18N
        botaoBuscarVendaDeImovel.setBorder(null);
        botaoBuscarVendaDeImovel.setBorderPainted(false);
        botaoBuscarVendaDeImovel.setContentAreaFilled(false);
        botaoBuscarVendaDeImovel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoBuscarVendaDeImovel.setMaximumSize(new java.awt.Dimension(40, 40));
        botaoBuscarVendaDeImovel.setMinimumSize(new java.awt.Dimension(40, 40));
        botaoBuscarVendaDeImovel.setPreferredSize(new java.awt.Dimension(40, 40));
        botaoBuscarVendaDeImovel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoBuscarVendaDeImovelActionPerformed(evt);
            }
        });

        botaoEditarVenderImovel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tela_vender_imovel/botao_editar_vender_imovel.png"))); // NOI18N
        botaoEditarVenderImovel.setBorder(null);
        botaoEditarVenderImovel.setBorderPainted(false);
        botaoEditarVenderImovel.setContentAreaFilled(false);
        botaoEditarVenderImovel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoEditarVenderImovel.setFocusPainted(false);
        botaoEditarVenderImovel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEditarVenderImovelActionPerformed(evt);
            }
        });

        botaoExcluirVenderImovel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tela_vender_imovel/botao_excluir_vender_imovel.png"))); // NOI18N
        botaoExcluirVenderImovel.setBorder(null);
        botaoExcluirVenderImovel.setBorderPainted(false);
        botaoExcluirVenderImovel.setContentAreaFilled(false);
        botaoExcluirVenderImovel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoExcluirVenderImovel.setMaximumSize(new java.awt.Dimension(40, 40));
        botaoExcluirVenderImovel.setMinimumSize(new java.awt.Dimension(40, 40));
        botaoExcluirVenderImovel.setPreferredSize(new java.awt.Dimension(40, 40));
        botaoExcluirVenderImovel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirVenderImovelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuVenderImovelLayout = new javax.swing.GroupLayout(menuVenderImovel);
        menuVenderImovel.setLayout(menuVenderImovelLayout);
        menuVenderImovelLayout.setHorizontalGroup(
            menuVenderImovelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuVenderImovelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoBuscarVendaDeImovel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoEditarVenderImovel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoExcluirVenderImovel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuVenderImovelLayout.setVerticalGroup(
            menuVenderImovelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botaoBuscarVendaDeImovel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(botaoEditarVenderImovel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuVenderImovelLayout.createSequentialGroup()
                .addComponent(botaoExcluirVenderImovel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout painelVenderLayout = new javax.swing.GroupLayout(painelVender);
        painelVender.setLayout(painelVenderLayout);
        painelVenderLayout.setHorizontalGroup(
            painelVenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(areaDeTrabalhoVenderImovel, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE)
            .addComponent(menuVenderImovel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE)
        );
        painelVenderLayout.setVerticalGroup(
            painelVenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelVenderLayout.createSequentialGroup()
                .addComponent(menuVenderImovel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(areaDeTrabalhoVenderImovel, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE))
        );

        paineisComAbas.addTab("", new javax.swing.ImageIcon(getClass().getResource("/imagens/tela_principal_do_sistema/painel_vender_imovel.png")), painelVender, ""); // NOI18N

        areaDeTrabalhoAlugarImovel.setBackground(new java.awt.Color(255, 255, 255));
        areaDeTrabalhoAlugarImovel.setMinimumSize(new java.awt.Dimension(860, 520));

        javax.swing.GroupLayout areaDeTrabalhoAlugarImovelLayout = new javax.swing.GroupLayout(areaDeTrabalhoAlugarImovel);
        areaDeTrabalhoAlugarImovel.setLayout(areaDeTrabalhoAlugarImovelLayout);
        areaDeTrabalhoAlugarImovelLayout.setHorizontalGroup(
            areaDeTrabalhoAlugarImovelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 860, Short.MAX_VALUE)
        );
        areaDeTrabalhoAlugarImovelLayout.setVerticalGroup(
            areaDeTrabalhoAlugarImovelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 551, Short.MAX_VALUE)
        );

        menuVenderImovel1.setBackground(new java.awt.Color(255, 153, 153));
        menuVenderImovel1.setMaximumSize(new java.awt.Dimension(865, 50));
        menuVenderImovel1.setMinimumSize(new java.awt.Dimension(865, 50));
        menuVenderImovel1.setPreferredSize(new java.awt.Dimension(865, 50));

        botaoBuscarAluguelDeImovel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tela_alugar_imovel/botao_pesquisar_alugar_imovel.png"))); // NOI18N
        botaoBuscarAluguelDeImovel.setBorder(null);
        botaoBuscarAluguelDeImovel.setBorderPainted(false);
        botaoBuscarAluguelDeImovel.setContentAreaFilled(false);
        botaoBuscarAluguelDeImovel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoBuscarAluguelDeImovel.setFocusable(false);
        botaoBuscarAluguelDeImovel.setMaximumSize(new java.awt.Dimension(40, 40));
        botaoBuscarAluguelDeImovel.setMinimumSize(new java.awt.Dimension(40, 40));
        botaoBuscarAluguelDeImovel.setPreferredSize(new java.awt.Dimension(40, 40));
        botaoBuscarAluguelDeImovel.setRequestFocusEnabled(false);
        botaoBuscarAluguelDeImovel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoBuscarAluguelDeImovelActionPerformed(evt);
            }
        });

        botaoEditarAlugarImovel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tela_alugar_imovel/botao_editar_alugar_imovel.png"))); // NOI18N
        botaoEditarAlugarImovel.setBorder(null);
        botaoEditarAlugarImovel.setBorderPainted(false);
        botaoEditarAlugarImovel.setContentAreaFilled(false);
        botaoEditarAlugarImovel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoEditarAlugarImovel.setMaximumSize(new java.awt.Dimension(40, 40));
        botaoEditarAlugarImovel.setMinimumSize(new java.awt.Dimension(40, 40));
        botaoEditarAlugarImovel.setPreferredSize(new java.awt.Dimension(40, 40));
        botaoEditarAlugarImovel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEditarAlugarImovelActionPerformed(evt);
            }
        });

        botaoExcluirAlugarImovel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tela_alugar_imovel/botao_excluir_alugar_imovel.png"))); // NOI18N
        botaoExcluirAlugarImovel.setBorder(null);
        botaoExcluirAlugarImovel.setBorderPainted(false);
        botaoExcluirAlugarImovel.setContentAreaFilled(false);
        botaoExcluirAlugarImovel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoExcluirAlugarImovel.setMaximumSize(new java.awt.Dimension(40, 40));
        botaoExcluirAlugarImovel.setMinimumSize(new java.awt.Dimension(40, 40));
        botaoExcluirAlugarImovel.setPreferredSize(new java.awt.Dimension(40, 40));
        botaoExcluirAlugarImovel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirAlugarImovelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuVenderImovel1Layout = new javax.swing.GroupLayout(menuVenderImovel1);
        menuVenderImovel1.setLayout(menuVenderImovel1Layout);
        menuVenderImovel1Layout.setHorizontalGroup(
            menuVenderImovel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuVenderImovel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoBuscarAluguelDeImovel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoEditarAlugarImovel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoExcluirAlugarImovel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(703, Short.MAX_VALUE))
        );
        menuVenderImovel1Layout.setVerticalGroup(
            menuVenderImovel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botaoBuscarAluguelDeImovel, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(botaoEditarAlugarImovel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(botaoExcluirAlugarImovel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout painelAlugarLayout = new javax.swing.GroupLayout(painelAlugar);
        painelAlugar.setLayout(painelAlugarLayout);
        painelAlugarLayout.setHorizontalGroup(
            painelAlugarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuVenderImovel1, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE)
            .addGroup(painelAlugarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelAlugarLayout.createSequentialGroup()
                    .addComponent(areaDeTrabalhoAlugarImovel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 15, Short.MAX_VALUE)))
        );
        painelAlugarLayout.setVerticalGroup(
            painelAlugarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAlugarLayout.createSequentialGroup()
                .addComponent(menuVenderImovel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 555, Short.MAX_VALUE))
            .addGroup(painelAlugarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelAlugarLayout.createSequentialGroup()
                    .addGap(0, 54, Short.MAX_VALUE)
                    .addComponent(areaDeTrabalhoAlugarImovel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        paineisComAbas.addTab("", new javax.swing.ImageIcon(getClass().getResource("/imagens/tela_principal_do_sistema/painel_alugar_imovel.png")), painelAlugar, ""); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paineisComAbas)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(paineisComAbas, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        barraMenu.setBackground(new java.awt.Color(0, 153, 153));
        barraMenu.setAlignmentX(4.0F);
        barraMenu.setAlignmentY(4.0F);
        barraMenu.setBorderPainted(false);
        barraMenu.setFocusable(false);
        barraMenu.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        barraMenu.setMargin(new java.awt.Insets(10, 10, 10, 10));
        barraMenu.setMaximumSize(new java.awt.Dimension(35, 25));
        barraMenu.setOpaque(false);
        barraMenu.setPreferredSize(new java.awt.Dimension(76, 48));

        jMenu1.setBackground(new java.awt.Color(51, 51, 51));
        jMenu1.setBorder(null);
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tela_principal_do_sistema/logo_uepb_imobi.png"))); // NOI18N
        jMenu1.setFocusable(false);
        jMenu1.setMaximumSize(new java.awt.Dimension(850, 100));
        jMenu1.setMinimumSize(new java.awt.Dimension(850, 100));
        jMenu1.setOpaque(true);
        jMenu1.setPreferredSize(new java.awt.Dimension(850, 100));
        barraMenu.add(jMenu1);

        menu.setBackground(new java.awt.Color(51, 51, 51));
        menu.setBorder(null);
        menu.setForeground(new java.awt.Color(255, 255, 255));
        menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tela_principal_do_sistema/usuario_logado.png"))); // NOI18N
        menu.setContentAreaFilled(false);
        menu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu.setFocusable(false);
        menu.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        menu.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        menu.setIconTextGap(10);
        menu.setMaximumSize(new java.awt.Dimension(210, 100));
        menu.setMinimumSize(new java.awt.Dimension(210, 100));
        menu.setOpaque(true);
        menu.setPreferredSize(new java.awt.Dimension(210, 100));

        jMenuItem2.setBackground(new java.awt.Color(51, 51, 51));
        jMenuItem2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenuItem2.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem2.setText("Novo Usuário");
        jMenuItem2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem2.setMaximumSize(new java.awt.Dimension(210, 22));
        jMenuItem2.setMinimumSize(new java.awt.Dimension(210, 22));
        jMenuItem2.setOpaque(true);
        jMenuItem2.setPreferredSize(new java.awt.Dimension(210, 22));
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menu.add(jMenuItem2);

        jMenuItem1.setBackground(new java.awt.Color(51, 51, 51));
        jMenuItem1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenuItem1.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem1.setText("Alterar Senha");
        jMenuItem1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem1.setMaximumSize(new java.awt.Dimension(210, 22));
        jMenuItem1.setMinimumSize(new java.awt.Dimension(210, 22));
        jMenuItem1.setOpaque(true);
        jMenuItem1.setPreferredSize(new java.awt.Dimension(210, 22));
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menu.add(jMenuItem1);

        jMenuItem3.setBackground(new java.awt.Color(51, 51, 51));
        jMenuItem3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenuItem3.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem3.setText("Sair");
        jMenuItem3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem3.setMaximumSize(new java.awt.Dimension(210, 22));
        jMenuItem3.setMinimumSize(new java.awt.Dimension(210, 22));
        jMenuItem3.setOpaque(true);
        jMenuItem3.setPreferredSize(new java.awt.Dimension(210, 22));
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menu.add(jMenuItem3);

        barraMenu.add(menu);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1060, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1076, 689));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    public static String nomeDialogoExcluirCliente = "";
    private void botaoDeletarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDeletarClienteActionPerformed

        if (PainelPesquisarClientes.tabelaClientes.getSelectedRow() != -1) {

            PainelDeDialogoExcluirCliente painelDeDialogoExcluirCliente = new PainelDeDialogoExcluirCliente(null, true);
            PainelDeDialogoExcluirCliente.textoExcluirDialogoCliente.setText("Tem certeza que deseja excluir " + PainelPesquisarClientes.tabelaClientes.getValueAt(PainelPesquisarClientes.tabelaClientes.getSelectedRow(), 1).toString() + " ?");
            painelDeDialogoExcluirCliente.setLocationRelativeTo(null);
            painelDeDialogoExcluirCliente.setVisible(true);
            
            //int opcao = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o(a) cliente " + PainelPesquisarClientes.tabelaClientes.getValueAt(PainelPesquisarClientes.tabelaClientes.getSelectedRow(), 1).toString() + "?", "Excluir cliente?", JOptionPane.YES_NO_OPTION);
            if (nomeDialogoExcluirCliente.equals("OK")) {
                
                String verificaNome = (String) PainelPesquisarClientes.tabelaClientes.getValueAt(PainelPesquisarClientes.tabelaClientes.getSelectedRow(), 1);
                String verificaTipoPessoa = (String) PainelPesquisarClientes.tabelaClientes.getValueAt(PainelPesquisarClientes.tabelaClientes.getSelectedRow(), 2);
                
                if(verificaTipoPessoa.equals("Pessoa Física")){
                    facade.excluirClientePessoaFisica(verificaNome);
                }
                else if(verificaTipoPessoa.equals("Pessoa Jurídica")){
                    facade.excluirClientePessoaJuridica(verificaNome);
                }
                
                facade.excluirClientePessoaResumo(verificaNome);
                
                PainelDeDialogoCadastrarCliente painelDeDialogoCadastrarCliente = new PainelDeDialogoCadastrarCliente(null, true);
                PainelDeDialogoCadastrarCliente.textoNomeDialogoCliente.setText("Cadastro excluído!");
                painelDeDialogoCadastrarCliente.setLocationRelativeTo(null);
                painelDeDialogoCadastrarCliente.setVisible(true);
                
                PainelVenderImoveis.campoSelecioneClienteDaCompra.removeItem(verificaNome);
                PainelAlugarImoveis.campoSelecioneClienteDoAluguel.removeItem(verificaNome);
                /////*************************************************************
                
                
                // remove um cliente da contagem total la do painel home
                //Dados.listaDeClientesResumo.remove(0);
                //PainelHome.atualizarResumoDoSistema();
                PainelPesquisarClientes.mostrarTabelaDeClientes();
            }
    
        }
        else{
            PainelDeDialogoCliente dialogoDeleteAlert = new PainelDeDialogoCliente(null, true);
            PainelDeDialogoCliente.textoNomeDialogoCliente.setText("Selecione um registro da tabela abaixo!");
            dialogoDeleteAlert.setLocationRelativeTo(null);
            dialogoDeleteAlert.setVisible(true);
            
        }

        

    }//GEN-LAST:event_botaoDeletarClienteActionPerformed

    public static PainelCadastrarClientes painelCadastrarClientesPF = new PainelCadastrarClientes();
    private void botaoCadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarClienteActionPerformed
        botaoCadastrarCliente.setEnabled(false);
        botaoEditarCliente.setEnabled(false);
        botaoDeletarCliente.setEnabled(false);
        
        desabilitarComponentesClientes();
        areaDeTrabalhoCliente.add(painelCadastrarClientesPF);
        painelCadastrarClientesPF.setBounds(0, 0, 860, 520);

    }//GEN-LAST:event_botaoCadastrarClienteActionPerformed

    public static PainelEditarClientes painelEditarClientes = new PainelEditarClientes();
    private void botaoEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarClienteActionPerformed

        if (PainelPesquisarClientes.tabelaClientes.getSelectedRow() != -1) {
            botaoCadastrarCliente.setEnabled(false);
            botaoEditarCliente.setEnabled(false);
            botaoDeletarCliente.setEnabled(false);
            
            desabilitarComponentesClientes();
            areaDeTrabalhoCliente.add(painelEditarClientes);
            painelEditarClientes.setBounds(0, 0, 860, 520);
        }else{
            PainelDeDialogoCliente dialogoEditarAlert = new PainelDeDialogoCliente(null, true);
            PainelDeDialogoCliente.textoNomeDialogoCliente.setText("Selecione um registro da tabela abaixo!");
            dialogoEditarAlert.setLocationRelativeTo(null);
            dialogoEditarAlert.setVisible(true);
            
        }
        
       
    }//GEN-LAST:event_botaoEditarClienteActionPerformed

    public static void desabilitarComponentesClientes() {
        if (painelPesquisarClientes != null) {
            areaDeTrabalhoCliente.moveToBack(painelPesquisarClientes);
            areaDeTrabalhoCliente.remove(painelPesquisarClientes);
        }
        if (painelCadastrarClientesPF != null) {
            areaDeTrabalhoCliente.moveToBack(painelCadastrarClientesPF);
            areaDeTrabalhoCliente.remove(painelCadastrarClientesPF);
        }
        if (painelEditarClientes != null) {
            areaDeTrabalhoCliente.moveToBack(painelEditarClientes);
            areaDeTrabalhoCliente.remove(painelEditarClientes);
        }

    }

    public static String nomeDialogoExcluirImovel = "";
    private void botaoExcluirImovelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirImovelActionPerformed

        if (PainelPesquisarImoveis.tabelaImoveis.getSelectedRow() != -1) {

            PainelDeDialogoExcluirImovel painelDeDialogoExcluirImovel = new PainelDeDialogoExcluirImovel(null, true);
            PainelDeDialogoExcluirImovel.textoExcluirDialogoImovel.setText("Tem certeza que deseja excluir " + PainelPesquisarImoveis.tabelaImoveis.getValueAt(PainelPesquisarImoveis.tabelaImoveis.getSelectedRow(), 1).toString() + " ?");
            painelDeDialogoExcluirImovel.setLocationRelativeTo(null);
            painelDeDialogoExcluirImovel.setVisible(true);
            
            //int opcao = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o imovel pertencente ao(a) proprietário(a) " + PainelPesquisarImoveis.tabelaImoveis.getValueAt(PainelPesquisarImoveis.tabelaImoveis.getSelectedRow(), 1).toString() + "?", "Excluir imovel?", JOptionPane.YES_NO_OPTION);
            if (nomeDialogoExcluirImovel.equals("OK")) {
                ImovelBean imovelBean = new ImovelBean();
                imovelBean.setProprietario((String) PainelPesquisarImoveis.tabelaImoveis.getValueAt(PainelPesquisarImoveis.tabelaImoveis.getSelectedRow(), 1));
                
                Dados.imovelBeanSelecioneImovelVenda.setCodigo(Integer.parseInt(PainelPesquisarImoveis.tabelaImoveis.getValueAt(PainelPesquisarImoveis.tabelaImoveis.getSelectedRow(), 0).toString()));
                Dados.imovelBeanSelecioneImovelVenda.setTipo((String) PainelPesquisarImoveis.tabelaImoveis.getValueAt(PainelPesquisarImoveis.tabelaImoveis.getSelectedRow(), 2));
                imovelBean.setFinalidade((String) PainelPesquisarImoveis.tabelaImoveis.getValueAt(PainelPesquisarImoveis.tabelaImoveis.getSelectedRow(), 3));
                 
                
                facade.excluirImovel(imovelBean.getProprietario());
                
                PainelDeDialogoCadastrarImovel dialogoExcluirCadastrarImovel = new PainelDeDialogoCadastrarImovel(null, true);
                PainelDeDialogoCadastrarImovel.textoCadastroDialogoImovel.setText("Cadastro excluído!");
                dialogoExcluirCadastrarImovel.setLocationRelativeTo(null);
                dialogoExcluirCadastrarImovel.setVisible(true);
                
                if(imovelBean.getFinalidade().equals("Vender")){
                    PainelVenderImoveis.campoSelecioneImovelDaVenda.removeItem(Dados.imovelBeanSelecioneImovelVenda.getCodigo().toString());
                }
                else if(imovelBean.getFinalidade().equals("Alugar")){
                    PainelAlugarImoveis.campoSelecioneImovelDoAluguel.removeItem(Dados.imovelBeanSelecioneImovelVenda.getCodigo().toString());
                }
                
                
                PainelPesquisarImoveis.mostrarTabelaDeImoveis();
            }
            
        }else{
            PainelDeDialogoImovel dialogoImovelAlert = new PainelDeDialogoImovel(null, true);
            PainelDeDialogoImovel.textoNomeDialogoImovel.setText("Selecione um registro da tabela abaixo!");
            dialogoImovelAlert.setLocationRelativeTo(null);
            dialogoImovelAlert.setVisible(true);
        }

        
    }//GEN-LAST:event_botaoExcluirImovelActionPerformed

    public static PainelCadastrarImoveis painelCadastrarImoveis = new PainelCadastrarImoveis();
    private void botaoCadastrarImovelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarImovelActionPerformed

        botaoCadastrarImovel.setEnabled(false);
        botaoEditarImovel.setEnabled(false);
        botaoExcluirImovel.setEnabled(false);
        
        desabilitarComponentesImoveis();
        areaDeTrabalhoImovel.add(painelCadastrarImoveis);
        painelCadastrarImoveis.setBounds(0, 0, 860, 520);
    }//GEN-LAST:event_botaoCadastrarImovelActionPerformed

    public static PainelEditarImoveis painelEditarImoveis = new PainelEditarImoveis();
    private void botaoEditarImovelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarImovelActionPerformed
        
        if (PainelPesquisarImoveis.tabelaImoveis.getSelectedRow() != -1) {
            botaoCadastrarImovel.setEnabled(false);
            botaoEditarImovel.setEnabled(false);
            botaoExcluirImovel.setEnabled(false);
            
            desabilitarComponentesImoveis();
            areaDeTrabalhoImovel.add(painelEditarImoveis);
            painelEditarImoveis.setBounds(0, 0, 860, 520);
        }else{
            PainelDeDialogoImovel dialogoImovelAlert = new PainelDeDialogoImovel(null, true);
            PainelDeDialogoImovel.textoNomeDialogoImovel.setText("Selecione um registro da tabela abaixo!");
            dialogoImovelAlert.setLocationRelativeTo(null);
            dialogoImovelAlert.setVisible(true);
            
        }
        
    }//GEN-LAST:event_botaoEditarImovelActionPerformed

    TelaCadastrarUsuario telaCadastrarUsuario = new TelaCadastrarUsuario(this, rootPaneCheckingEnabled);
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        telaCadastrarUsuario.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    TelaAlterarSenha telaAlterarSenha = new TelaAlterarSenha(this, rootPaneCheckingEnabled);
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        telaAlterarSenha.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        System.exit(0);
        //dispose();
        //new TelaDeLogin().setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    
    public static String nomeDialogoExcluir = "";
    private void botaoDeletarCorretorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDeletarCorretorActionPerformed
        if (PainelPesquisarCorretores.tabelaCorretores.getSelectedRow() != -1) {

            PainelDeDialogoExcluirCorretor painelDeDialogoExcluirCorretor = new PainelDeDialogoExcluirCorretor(null, true);
            PainelDeDialogoExcluirCorretor.textoExcluirDialogoCorretor.setText("Tem certeza que deseja excluir " + PainelPesquisarCorretores.tabelaCorretores.getValueAt(PainelPesquisarCorretores.tabelaCorretores.getSelectedRow(), 1).toString() + " ?");
            painelDeDialogoExcluirCorretor.setLocationRelativeTo(null);
            painelDeDialogoExcluirCorretor.setVisible(true);
            
            //int opcao = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o(a) corretor(a) " + PainelPesquisarCorretores.tabelaCorretores.getValueAt(PainelPesquisarCorretores.tabelaCorretores.getSelectedRow(), 1).toString() + "?", "Excluir corretor?", JOptionPane.YES_NO_OPTION);
            if (nomeDialogoExcluir.equals("OK")) {
                CorretorBean corretorBean = new CorretorBean();
                corretorBean.setNome((String) PainelPesquisarCorretores.tabelaCorretores.getValueAt(PainelPesquisarCorretores.tabelaCorretores.getSelectedRow(), 1));

                facade.excluirCorretor(corretorBean.getNome());
                
                PainelDeDialogoCadastrarCorretor painelDeDialogoCadastrarCorretor = new PainelDeDialogoCadastrarCorretor(null, true);
                PainelDeDialogoCadastrarCorretor.textoCadastroDialogoCorretor.setText("Cadastro excluído!");
                painelDeDialogoCadastrarCorretor.setLocationRelativeTo(null);
                painelDeDialogoCadastrarCorretor.setVisible(true);
                
                PainelVenderImoveis.campoSelecioneCorretorDaVenda.removeItem(corretorBean.getNome());
                PainelAlugarImoveis.campoSelecioneCorretorDoAluguel.removeItem(corretorBean.getNome());
                // remove um cliente da contagem total la do painel home
                //Dados.listaDeClientesResumo.remove(0);
                //PainelHome.atualizarResumoDoSistema();
                PainelPesquisarCorretores.mostrarTabelaDeCorretores();
            }
        }else{
            PainelDeDialogoCorretor alertaExclusao = new PainelDeDialogoCorretor(null, true);
            PainelDeDialogoCorretor.textoDialogo.setText("Selecione um registro da tabela abaixo!");
            alertaExclusao.setLocationRelativeTo(null);
            alertaExclusao.setVisible(true); 
        }

        
    }//GEN-LAST:event_botaoDeletarCorretorActionPerformed

    public static PainelEditarCorretores painelEditarCorretores = new PainelEditarCorretores();
    public static void desabilitarComponentesCorretores() {
        if (painelPesquisarCorretores != null) {
            areaDeTrabalhoCorretor.moveToBack(painelPesquisarCorretores);
            areaDeTrabalhoCorretor.remove(painelPesquisarCorretores);
        }
        if (painelCadastrarCorretores != null) {
            areaDeTrabalhoCorretor.moveToBack(painelCadastrarCorretores);
            areaDeTrabalhoCorretor.remove(painelCadastrarCorretores);
        }
        if (painelEditarCorretores != null) {
            areaDeTrabalhoCorretor.moveToBack(painelEditarCorretores);
            areaDeTrabalhoCorretor.remove(painelEditarCorretores);
        }

    }
    
    public static PainelVenderImoveis painelVenderImoveis = new PainelVenderImoveis();
    public static PainelEditarVenderImoveis painelEditarVenderImoveis = new PainelEditarVenderImoveis();
    public static void desabilitarComponentesVenderImoveis() {
        if (painelPesquisarVenderImovel != null) {
            areaDeTrabalhoVenderImovel.moveToBack(painelPesquisarVenderImovel);
            areaDeTrabalhoVenderImovel.remove(painelPesquisarVenderImovel);
        }
        if (painelVenderImoveis != null) {
            areaDeTrabalhoVenderImovel.moveToBack(painelVenderImoveis);
            areaDeTrabalhoVenderImovel.remove(painelVenderImoveis);
        }
        if (painelEditarVenderImoveis != null) {
            areaDeTrabalhoVenderImovel.moveToBack(painelEditarVenderImoveis);
            areaDeTrabalhoVenderImovel.remove(painelEditarVenderImoveis);
        }

    }
    
    public static PainelAlugarImoveis painelAlugarImoveis = new PainelAlugarImoveis();
    public static PainelEditarAlugarImoveis painelEditarAlugarImoveis = new PainelEditarAlugarImoveis();
    public static void desabilitarComponentesAlugarImoveis() {
        if (painelPesquisarAlugarImovel != null) {
            areaDeTrabalhoAlugarImovel.moveToBack(painelPesquisarAlugarImovel);
            areaDeTrabalhoAlugarImovel.remove(painelPesquisarAlugarImovel);
        }
        if (painelAlugarImoveis != null) {
            areaDeTrabalhoAlugarImovel.moveToBack(painelAlugarImoveis);
            areaDeTrabalhoAlugarImovel.remove(painelAlugarImoveis);
        }
        if (painelEditarAlugarImoveis != null) {
            areaDeTrabalhoAlugarImovel.moveToBack(painelEditarAlugarImoveis);
            areaDeTrabalhoAlugarImovel.remove(painelEditarAlugarImoveis);
        }

    }
    
    public static PainelCadastrarCorretores painelCadastrarCorretores = new PainelCadastrarCorretores();
    private void botaoCadastrarCorretorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarCorretorActionPerformed
        botaoCadastrarCorretor.setEnabled(false);
        botaoEditarCorretor.setEnabled(false);
        botaoDeletarCorretor.setEnabled(false);
        
        desabilitarComponentesCorretores();
        areaDeTrabalhoCorretor.add(painelCadastrarCorretores);
        painelCadastrarCorretores.setBounds(0, 0, 860, 520);
    }//GEN-LAST:event_botaoCadastrarCorretorActionPerformed

    private void botaoEditarCorretorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarCorretorActionPerformed
        if (PainelPesquisarCorretores.tabelaCorretores.getSelectedRow() != -1) {
            botaoCadastrarCorretor.setEnabled(false);
            botaoEditarCorretor.setEnabled(false);
            botaoDeletarCorretor.setEnabled(false);
            
            desabilitarComponentesCorretores();
            areaDeTrabalhoCorretor.add(painelEditarCorretores);
            painelEditarCorretores.setBounds(0, 0, 860, 520);
        }else{
            PainelDeDialogoCorretor dialogoAlert = new PainelDeDialogoCorretor(null, true);
            PainelDeDialogoCorretor.textoDialogo.setText("Selecione um registro da tabela abaixo!");
            dialogoAlert.setLocationRelativeTo(null);
            dialogoAlert.setVisible(true);
            
        }
    }//GEN-LAST:event_botaoEditarCorretorActionPerformed

    
    private void botaoBuscarVendaDeImovelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoBuscarVendaDeImovelActionPerformed
        botaoBuscarVendaDeImovel.setEnabled(false);
        
        desabilitarComponentesVenderImoveis();
        areaDeTrabalhoVenderImovel.add(painelPesquisarVenderImovel);
        painelPesquisarVenderImovel.setBounds(0, 0, 860, 520);
        
        TelaPrincipalDoSistema.botaoEditarVenderImovel.setVisible(true);
        TelaPrincipalDoSistema.botaoExcluirVenderImovel.setVisible(true);
    }//GEN-LAST:event_botaoBuscarVendaDeImovelActionPerformed

    
    private void botaoEditarVenderImovelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarVenderImovelActionPerformed
        if (PainelPesquisarVenderImovel.tabelaVenderImoveis.getSelectedRow() != -1) {
            botaoBuscarVendaDeImovel.setEnabled(false);
            botaoEditarVenderImovel.setEnabled(false);
            botaoExcluirVenderImovel.setEnabled(false);
             
            desabilitarComponentesVenderImoveis();
            areaDeTrabalhoVenderImovel.add(painelEditarVenderImoveis);
            painelEditarVenderImoveis.setBounds(0, 0, 860, 520);
        }else{
            PainelDeDialogoVenderImovel dialogoVenderImovelAlert = new PainelDeDialogoVenderImovel(null, true);
            PainelDeDialogoVenderImovel.textoNomeDialogoVenderImovel.setText("Selecione um registro da tabela abaixo!");
            dialogoVenderImovelAlert.setLocationRelativeTo(null);
            dialogoVenderImovelAlert.setVisible(true);
        }
    }//GEN-LAST:event_botaoEditarVenderImovelActionPerformed

    public static String nomeDialogoExcluirVenderImovel = "";
    private void botaoExcluirVenderImovelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirVenderImovelActionPerformed
        if (PainelPesquisarVenderImovel.tabelaVenderImoveis.getSelectedRow() != -1) {

            PainelDeDialogoExcluirVenderImovel painelDeDialogoExcluirVenderImovel = new PainelDeDialogoExcluirVenderImovel(null, true);
            PainelDeDialogoExcluirVenderImovel.textoExcluirDialogoVenderImovel.setText("Tem certeza que deseja excluir o registro " + PainelPesquisarVenderImovel.tabelaVenderImoveis.getValueAt(PainelPesquisarVenderImovel.tabelaVenderImoveis.getSelectedRow(), 0).toString() + " ?");
            painelDeDialogoExcluirVenderImovel.setLocationRelativeTo(null);
            painelDeDialogoExcluirVenderImovel.setVisible(true);
            
            if (nomeDialogoExcluirVenderImovel.equals("OK")) {
                VenderImovelBean venderImovelBean = new VenderImovelBean();
                venderImovelBean.setCodigo(Integer.parseInt(PainelPesquisarVenderImovel.tabelaVenderImoveis.getValueAt(PainelPesquisarVenderImovel.tabelaVenderImoveis.getSelectedRow(), 0).toString()));
                
                facade.excluirRegistroVenderImovel(venderImovelBean.getCodigo());
                
                PainelDeDialogoCadastrarVenderImovel painelDeDialogoCadastrarVenderImovel = new PainelDeDialogoCadastrarVenderImovel(null, true);
                PainelDeDialogoCadastrarVenderImovel.textoCadastroDialogoVenderImovel.setText("Cadastro excluído!");
                painelDeDialogoCadastrarVenderImovel.setLocationRelativeTo(null);
                painelDeDialogoCadastrarVenderImovel.setVisible(true);
                
                PainelPesquisarVenderImovel.mostrarTabelaVenderImovel();
            }
        }else{
            PainelDeDialogoVenderImovel dialogoVenderImovelAlerta = new PainelDeDialogoVenderImovel(null, true);
            PainelDeDialogoVenderImovel.textoNomeDialogoVenderImovel.setText("Selecione um registro da tabela abaixo!");
            dialogoVenderImovelAlerta.setLocationRelativeTo(null);
            dialogoVenderImovelAlerta.setVisible(true);
        }

        
    }//GEN-LAST:event_botaoExcluirVenderImovelActionPerformed

    private void botaoBuscarAluguelDeImovelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoBuscarAluguelDeImovelActionPerformed
        botaoBuscarAluguelDeImovel.setEnabled(false);
        
        desabilitarComponentesAlugarImoveis();
        areaDeTrabalhoAlugarImovel.add(painelPesquisarAlugarImovel);
        painelPesquisarAlugarImovel.setBounds(0, 0, 860, 520);
        
        TelaPrincipalDoSistema.botaoEditarAlugarImovel.setVisible(true);
        TelaPrincipalDoSistema.botaoExcluirAlugarImovel.setVisible(true);
    }//GEN-LAST:event_botaoBuscarAluguelDeImovelActionPerformed

    private void botaoEditarAlugarImovelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarAlugarImovelActionPerformed
        if (PainelPesquisarAlugarImovel.tabelaAlugarImoveis.getSelectedRow() != -1) {
            botaoBuscarAluguelDeImovel.setEnabled(false);
            botaoEditarAlugarImovel.setEnabled(false);
            botaoExcluirAlugarImovel.setEnabled(false);
             
            desabilitarComponentesAlugarImoveis();
            areaDeTrabalhoAlugarImovel.add(painelEditarAlugarImoveis);
            painelEditarAlugarImoveis.setBounds(0, 0, 860, 520);
        }else{
            PainelDeDialogoAlugarImovel dialogoAlugarImovelAlert = new PainelDeDialogoAlugarImovel(null, true);
            PainelDeDialogoAlugarImovel.textoNomeDialogoAlugarImovel.setText("Selecione um registro da tabela abaixo!");
            dialogoAlugarImovelAlert.setLocationRelativeTo(null);
            dialogoAlugarImovelAlert.setVisible(true);
        }
    }//GEN-LAST:event_botaoEditarAlugarImovelActionPerformed

    public static String nomeDialogoExcluirAlugarImovel = "";
    private void botaoExcluirAlugarImovelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirAlugarImovelActionPerformed
        if (PainelPesquisarAlugarImovel.tabelaAlugarImoveis.getSelectedRow() != -1) {

            PainelDeDialogoExcluirAlugarImovel painelDeDialogoExcluirAlugarImovel = new PainelDeDialogoExcluirAlugarImovel(null, true);
            PainelDeDialogoExcluirAlugarImovel.textoExcluirDialogoAlugarImovel.setText("Tem certeza que deseja excluir o registro " + PainelPesquisarAlugarImovel.tabelaAlugarImoveis.getValueAt(PainelPesquisarAlugarImovel.tabelaAlugarImoveis.getSelectedRow(), 0).toString() + " ?");
            painelDeDialogoExcluirAlugarImovel.setLocationRelativeTo(null);
            painelDeDialogoExcluirAlugarImovel.setVisible(true);
            
            if (nomeDialogoExcluirAlugarImovel.equals("OK")) {
                AlugarImovelBean alugarImovelBean = new AlugarImovelBean();
                alugarImovelBean.setCodigo(Integer.parseInt(PainelPesquisarAlugarImovel.tabelaAlugarImoveis.getValueAt(PainelPesquisarAlugarImovel.tabelaAlugarImoveis.getSelectedRow(), 0).toString()));
                
                facade.excluirRegistroAlugarImovel(alugarImovelBean.getCodigo());
                
                PainelDeDialogoCadastrarAlugarImovel painelDeDialogoCadastrarAlugarImovel = new PainelDeDialogoCadastrarAlugarImovel(null, true);
                PainelDeDialogoCadastrarAlugarImovel.textoCadastroDialogoAlugarImovel.setText("Cadastro excluído!");
                painelDeDialogoCadastrarAlugarImovel.setLocationRelativeTo(null);
                painelDeDialogoCadastrarAlugarImovel.setVisible(true);
                
                PainelPesquisarAlugarImovel.mostrarTabelaAlugarImovel();
            }
        }else{
            PainelDeDialogoAlugarImovel dialogoExcluirAlugarImovelAlert = new PainelDeDialogoAlugarImovel(null, true);
            PainelDeDialogoAlugarImovel.textoNomeDialogoAlugarImovel.setText("Selecione um registro da tabela abaixo!");
            dialogoExcluirAlugarImovelAlert.setLocationRelativeTo(null);
            dialogoExcluirAlugarImovelAlert.setVisible(true);
        }
    }//GEN-LAST:event_botaoExcluirAlugarImovelActionPerformed

    public static void desabilitarComponentesImoveis() {
        if (painelCadastrarImoveis != null) {
            areaDeTrabalhoImovel.moveToBack(painelCadastrarImoveis);
            areaDeTrabalhoImovel.remove(painelCadastrarImoveis);
        }
        if (painelEditarImoveis != null) {
            areaDeTrabalhoImovel.moveToBack(painelEditarImoveis);
            areaDeTrabalhoImovel.remove(painelEditarImoveis);
        }
        if (painelPesquisarImoveis != null) {
            areaDeTrabalhoImovel.moveToBack(painelPesquisarImoveis);
            areaDeTrabalhoImovel.remove(painelPesquisarImoveis);
        }
       

    }



    public static void desabilitarComponentesHome() {
//        if (cadastrarNovoClienteAlugar != null) {
//            areaDeTrabalhoAlugar.moveToBack(cadastrarNovoClienteAlugar);
//            areaDeTrabalhoAlugar.remove(cadastrarNovoClienteAlugar);
//        }
//
//        if (painelLocacao != null) {
//            areaDeTrabalhoAlugar.moveToBack(painelLocacao);
//            areaDeTrabalhoAlugar.remove(painelLocacao);
//        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        /**
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalDoSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalDoSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalDoSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalDoSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        */
        
        
   
        
        // Define o Look And Feel multi-plataforma (também chamado de "Metal")
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalDoSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalDoSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalDoSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalDoSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       }
       
  
        

//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Windows".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(TelaPrincipalDoSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(TelaPrincipalDoSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(TelaPrincipalDoSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(TelaPrincipalDoSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipalDoSistema().setVisible(true);
            }
        });
    }
    
    private static void desabilitarComponentesRelatorio() {
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane areaDeTrabalhoAlugarImovel;
    public static javax.swing.JDesktopPane areaDeTrabalhoCliente;
    public static javax.swing.JDesktopPane areaDeTrabalhoCorretor;
    public static javax.swing.JDesktopPane areaDeTrabalhoHome;
    public static javax.swing.JDesktopPane areaDeTrabalhoImovel;
    public static javax.swing.JDesktopPane areaDeTrabalhoVenderImovel;
    private javax.swing.JMenuBar barraMenu;
    public static javax.swing.JButton botaoBuscarAluguelDeImovel;
    public static javax.swing.JButton botaoBuscarVendaDeImovel;
    public static javax.swing.JButton botaoCadastrarCliente;
    public static javax.swing.JButton botaoCadastrarCorretor;
    public static javax.swing.JButton botaoCadastrarImovel;
    public static javax.swing.JButton botaoDeletarCliente;
    public static javax.swing.JButton botaoDeletarCorretor;
    public static javax.swing.JButton botaoEditarAlugarImovel;
    public static javax.swing.JButton botaoEditarCliente;
    public static javax.swing.JButton botaoEditarCorretor;
    public static javax.swing.JButton botaoEditarImovel;
    public static javax.swing.JButton botaoEditarVenderImovel;
    public static javax.swing.JButton botaoExcluirAlugarImovel;
    public static javax.swing.JButton botaoExcluirImovel;
    public static javax.swing.JButton botaoExcluirVenderImovel;
    private javax.swing.ButtonGroup grupoDeBotoes;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu menu;
    private javax.swing.JPanel menuCliente;
    private javax.swing.JPanel menuCliente1;
    private javax.swing.JPanel menuImovel;
    private javax.swing.JPanel menuVenderImovel;
    private javax.swing.JPanel menuVenderImovel1;
    public static javax.swing.JTabbedPane paineisComAbas;
    private javax.swing.JPanel painelAlugar;
    private javax.swing.JPanel painelCliente;
    private javax.swing.JPanel painelCorretor;
    private javax.swing.JPanel painelImovel;
    private javax.swing.JPanel painelInicio;
    private javax.swing.JPanel painelVender;
    // End of variables declaration//GEN-END:variables
}
