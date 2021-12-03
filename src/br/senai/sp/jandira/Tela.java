package br.senai.sp.jandira;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;

public class Tela extends JFrame {

    private JPanel contentPane;
    private Arquivo arquivo;
    private String caminho;

    // Bloco inicializador da classe:
    {
        this.arquivo = new Arquivo();
        this.caminho = "C:\\Users\\21276436\\Documents\\Test\\aula.txt";
    }

    /**
     * Create the frame.
     */
    public Tela() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 420);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(112, 128, 144));
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Arquivo");
        lblNewLabel.setForeground(new Color(255, 255, 240));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(0, 11, 126, 38);
        panel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Digite abaixo:");
        lblNewLabel_1.setForeground(new Color(255, 255, 240));
        lblNewLabel_1.setBackground(new Color(255, 255, 240));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1.setBounds(10, 53, 132, 38);
        panel.add(lblNewLabel_1);

        JTextPane txtpnInsert = new JTextPane();
        txtpnInsert.setBounds(20, 102, 542, 198);
        panel.add(txtpnInsert);

        JButton btnGravar = new JButton("GRAVAR");
        btnGravar.setBounds(77, 327, 162, 43);
        btnGravar.setForeground(Color.black);
        btnGravar.setBackground(Color.white);
        panel.add(btnGravar);

        JButton btnLimpar = new JButton("LIMPAR");
        btnLimpar.setBounds(358, 327, 162, 43);
        btnLimpar.setForeground(Color.black);
        btnLimpar.setBackground(Color.white);
        panel.add(btnLimpar);

        btnGravar.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                boolean result = false;
                String conteudoArquivo = "";

                conteudoArquivo = arquivo.ler(caminho);
                conteudoArquivo += txtpnInsert.getText();
                result = arquivo.escrever(caminho, conteudoArquivo);

                if (result) {
                    JOptionPane.showMessageDialog(null, "Dado gravado com " +
                            "sucesso", "Dado gravado com sucesso",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Erro ao gravar dados", "Dado gravado com sucesso",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                txtpnInsert.setText(null);
            }
        });

        btnLimpar.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                txtpnInsert.setText(null);
            }
        });
    }
}
