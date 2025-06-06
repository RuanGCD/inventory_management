import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Exemplo de Troca de Painel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        JPanel mainPanel = new JPanel(new CardLayout());

        // Painel inicial
        JPanel homeScreen = new JPanel(new BorderLayout());

        JLabel titulo = new JLabel("BALCÃO", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 72));
        titulo.setBackground(Color.WHITE);
        titulo.setBorder(BorderFactory.createEmptyBorder(30, 0, 30, 0));

        JPanel botoesPanel = new JPanel(new GridLayout(3, 3, 10, 10));
        botoesPanel.setBorder(BorderFactory.createEmptyBorder(20, 80, 20, 80));
        botoesPanel.setBackground(new Color(0, 64, 64));

        Font buttonFont = new Font("Arial", Font.BOLD, 18);
        JButton botaoCadastro = criarBotao("CADASTROS", new Color(255, 178, 127), buttonFont);
        JButton botaoVendas = criarBotao("LANÇAMENTOS", new Color(153, 204, 255), buttonFont);
        JButton botaoRelatorios = criarBotao("RELATÓRIOS", new Color(0, 204, 102), buttonFont);
        JButton botaoSair = criarBotao("SAIR", new Color(153, 0, 0), buttonFont);
        botaoSair.setForeground(Color.WHITE);

        botoesPanel.add(botaoCadastro);
        botoesPanel.add(botaoRelatorios);
        botoesPanel.add(botaoVendas);
        botoesPanel.add(botaoSair);
        homeScreen.add(titulo, BorderLayout.NORTH);
        homeScreen.add(botoesPanel, BorderLayout.CENTER);

        // Painel de cadastro

        JPanel cadastroScreen = new JPanel();
        cadastroScreen.setLayout(new BoxLayout(cadastroScreen, BoxLayout.Y_AXIS));

        JLabel cadastrotittle = new JLabel("CADASTROS");
        cadastroScreen.add(cadastrotittle);

        // Barra de menus
        JMenuBar menuBarCad = new JMenuBar();

        // Menus
        JMenu menuPraia = new JMenu("Moda Praia");
        JMenu menuAcad = new JMenu("Moda Academia");
        JMenu menuCliente = new JMenu("Clientes");
        JMenu menuFornecedor = new JMenu("Fornecedor");

        // Criando itens de menu

        JMenuItem itemCadastrar = new JMenuItem("Cadastrar");
        JMenuItem itemDeletar = new JMenuItem("Deletar");
        JMenuItem itemExcluir = new JMenuItem("Excluir");

        // Adiciona itens aos menus
        menuPraia.add(itemCadastrar);
        menuPraia.add(itemDeletar);
        menuPraia.add(itemExcluir);

        menuAcad.add(new JMenuItem("Cadastrar"));
        menuAcad.add(new JMenuItem("Deletar"));
        menuAcad.add(new JMenuItem("Excluir"));

        menuCliente.add(new JMenuItem("Cadastrar"));
        menuCliente.add(new JMenuItem("Deletar"));
        menuCliente.add(new JMenuItem("Excluir"));

        menuFornecedor.add(new JMenuItem("Cadastrar"));
        menuFornecedor.add(new JMenuItem("Deletar"));
        menuFornecedor.add(new JMenuItem("Excluir"));

        // Adiciona menus à barra
        menuBarCad.add(menuPraia);
        menuBarCad.add(menuAcad);
        menuBarCad.add(menuCliente);
        menuBarCad.add(menuFornecedor);

        // Botão de voltar
        JButton backbutton = new JButton("Voltar");

        // Adiciona ao painel
        cadastroScreen.add(menuBarCad);
        cadastroScreen.add(backbutton);

        //Painel de vendas
        JPanel screenVendas = new JPanel();
        JLabel vendastittle = new JLabel("Vender");


        // Adiciona os painéis ao CardLayout
        mainPanel.add(homeScreen, "HOME");
        mainPanel.add(cadastroScreen, "CADASTRO");
        mainPanel.add(screenVendas, "VENDA");

        // Evento de clique no botão
        botaoCadastro.addActionListener(e -> {
            CardLayout cl = (CardLayout) mainPanel.getLayout();
            cl.show(mainPanel, "CADASTRO");
        });

        backbutton.addActionListener(e -> {
            CardLayout cl = (CardLayout) mainPanel.getLayout();
            cl.show(mainPanel, "HOME");
        });
        botaoVendas.addActionListener(e -> {
            CardLayout cl = (CardLayout) mainPanel.getLayout();
            cl.show(mainPanel, "VENDA");
        });
        botaoSair.addActionListener(e -> {
            System.exit(0);
        });


        // Adiciona o mainPanel no frame
        frame.add(mainPanel);

        frame.setVisible(true);
    }
    private static JButton criarBotao(String texto, Color corFundo, Font fonte) {
        JButton botao = new JButton(texto);
        botao.setBackground(corFundo);
        botao.setFont(fonte);
        botao.setFocusPainted(false);
        botao.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        return botao;
    }
}
