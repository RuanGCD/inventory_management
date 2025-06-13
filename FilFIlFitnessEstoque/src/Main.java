import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Exemplo de Troca de Painel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        JPanel mainPanel = new JPanel(new CardLayout());

        // HOME
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

        // CADASTRO
        JPanel cadastroScreen = new JPanel(new BorderLayout());
        JLabel cadastrotittle = new JLabel("CADASTROS", SwingConstants.CENTER);
        cadastrotittle.setFont(new Font("Arial", Font.BOLD, 32));
        cadastroScreen.add(cadastrotittle, BorderLayout.NORTH);

        JPanel botoesCadastroPanel = new JPanel(new GridLayout(2, 2, 20, 20));
        botoesCadastroPanel.setBorder(BorderFactory.createEmptyBorder(30, 100, 30, 100));

        String[] categorias = new String[]{"Moda Praia", "Moda Academia", "Clientes", "Fornecedor"};

        for (String categoria : categorias) {
            JButton botao = new JButton(categoria);
            botao.setFont(new Font("Arial", Font.BOLD, 16));
            botao.setPreferredSize(new Dimension(200, 100));

            JPopupMenu popup = new JPopupMenu();
            JMenuItem itemCadastrar = new JMenuItem("Cadastrar");
            JMenuItem itemDeletar = new JMenuItem("Deletar");
            JMenuItem itemExcluir = new JMenuItem("Excluir");

            popup.add(itemCadastrar);
            popup.add(itemDeletar);
            popup.add(itemExcluir);

            // Ação especial para Moda Praia
            if (categoria.equals("Moda Praia")) {
                itemCadastrar.addActionListener(ev -> {
                    JDialog dialog = new JDialog((JFrame) null, "Cadastro - Moda Praia", true);
                    dialog.setSize(400, 400);
                    dialog.setLayout(new BorderLayout());

                    JPanel inputsPanel = new JPanel(new GridLayout(8, 2, 10, 10));
                    inputsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

                   String[] labels = {"Nome", "Tamanho", "Cor", "Preço", "Quantidade", "Estampa", "Tipo", "Material"};

                    for (String label : labels) {
                        inputsPanel.add(new JLabel(label + ":"));
                        inputsPanel.add(new JTextField());
}

                    JButton btnEnviar = new JButton("Enviar");
                    btnEnviar.addActionListener(enviarEvent -> {
                        // Lógica para salvar os dados pode ser inserida aqui
                        dialog.dispose();
                    });

                    JPanel bottomPanel = new JPanel();
                    bottomPanel.add(btnEnviar);

                    dialog.add(inputsPanel, BorderLayout.CENTER);
                    dialog.add(bottomPanel, BorderLayout.SOUTH);
                    dialog.setLocationRelativeTo(null);
                    dialog.setVisible(true);
                });
            }

            botao.addActionListener(e -> popup.show(botao, botao.getWidth() / 2, botao.getHeight() / 2));
            botoesCadastroPanel.add(botao);
        }

        cadastroScreen.add(botoesCadastroPanel, BorderLayout.CENTER);
        JButton backbutton = new JButton("Voltar");
        backbutton.setFont(new Font("Arial", Font.PLAIN, 14));
        cadastroScreen.add(backbutton, BorderLayout.SOUTH);

        // VENDAS
        JPanel screenVendas = new JPanel();
        JLabel vendastittle = new JLabel("Vender");
        screenVendas.add(vendastittle);

        // Adiciona todas as telas ao painel principal
        mainPanel.add(homeScreen, "HOME");
        mainPanel.add(cadastroScreen, "CADASTRO");
        mainPanel.add(screenVendas, "VENDA");

        // Troca de telas
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

        botaoSair.addActionListener(e -> System.exit(0));

        // Exibe a janela
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
