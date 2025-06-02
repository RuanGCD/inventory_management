import javax.swing.*;
import java.awt.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Color minhaCor = Color.decode("#2F4538");
        Color vermelho = Color.decode("#f57171");
        Color rosa = Color.decode("#ffccff");
        Color azul = Color.decode("#85b4d4");
        Color verde = Color.decode("#5ede5b");
        Color amarelo = Color.decode("#f7df07");
        // Frame Main Creation
        JFrame mainScreen = new JFrame("Main Screen");
        mainScreen.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       //Create divs
        JPanel header = new JPanel();
        JPanel body = new JPanel();
        body.setBorder(BorderFactory.createEmptyBorder(100, 20, 20, 20));
        // Criar componentes
        JLabel tittle = new JLabel("Balcão");
        JButton cadastros = new JButton("Cadastros");
        JButton Venda = new JButton("Vendas");
        JButton Relatorio = new JButton("Relatórios");
        JButton Financeiro = new JButton("Financeiro");
        JButton Fornecedores = new JButton("Fornecedores");
        // Adicionar componentes ao painel
        header.add(tittle);
        body.add(cadastros);
        body.add(Box.createRigidArea(new Dimension(80, 0)));
        body.add(Venda);
        body.add(Box.createRigidArea(new Dimension(80, 0)));
        body.add(Relatorio);
        body.add(Box.createRigidArea(new Dimension(80, 0)));
        body.add(Financeiro);
        body.add(Box.createRigidArea(new Dimension(80, 0)));
        body.add(Fornecedores);

        //Styles
        body.setBackground(minhaCor);
        header.setBackground(Color.white);
        tittle.setFont(new Font("Arial", Font.BOLD, 72));
        tittle.setForeground(vermelho);
        cadastros.setBackground(vermelho);
        cadastros.setFont(new Font("Arial", Font.BOLD, 64));
        Venda.setBackground(azul);
        Venda.setFont(new Font("Arial", Font.BOLD, 64));
        Financeiro.setBackground(verde);
        Financeiro.setFont(new Font("Arial", Font.BOLD, 64));
        Fornecedores.setBackground(rosa);
        Fornecedores.setFont(new Font("Arial", Font.BOLD, 64));
        Relatorio.setBackground(amarelo);
        Relatorio.setFont(new Font("Arial", Font.BOLD, 64));


        // Adicionar o painel ao frame
        mainScreen.add(header, BorderLayout.NORTH);
        mainScreen.add(body, BorderLayout.CENTER);


        // Tornar a janela visível
        mainScreen.setVisible(true);
    }
}