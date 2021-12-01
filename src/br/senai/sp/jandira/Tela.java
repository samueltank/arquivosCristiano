package br.senai.sp.jandira;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;

public class Tela extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */


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
        panel.add(btnGravar);

        JButton btnLimpar = new JButton("LIMPAR");
        btnLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnLimpar.setBounds(358, 327, 162, 43);
        panel.add(btnLimpar);

        btnGravar.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                String caminho = "C:\\Users\\21276436\\Documents\\Test" +
                        "\\aula.txt";
                Arquivo arquivo = new Arquivo();
                String conteudoArquivo = arquivo.ler(caminho);
                conteudoArquivo += "\n" + txtpnInsert.getText();
                arquivo.escrever(caminho, conteudoArquivo);
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
