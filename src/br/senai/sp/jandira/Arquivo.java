package br.senai.sp.jandira;

import java.io.*;
import java.util.ArrayList;

public class Arquivo {
    public boolean escrever(String caminho, String conteudo) {
        try {
            FileWriter arquivo = new FileWriter(caminho);
            PrintWriter gravarArquivo = new PrintWriter(arquivo);
            gravarArquivo.append(conteudo);
            gravarArquivo.close();
            return true;
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
            return false;
        }
    }

    /*
    * Lê dados no arquivo:
    * */
    public String ler(String caminho) {
        String conteudo = "";

        // Recupera os dados do arquivo e armazena em memória para manipulação
        try {
            // Abre o arquivo:
            FileReader arquivo = new FileReader(caminho);

            // Armazena o conteúdo do arquivo em memória:
            BufferedReader conteudoArquivo = new BufferedReader(arquivo);

            try {
            // Recupera os dados do arquivo:
            String linha = "";
            linha = conteudoArquivo.readLine();
            while (linha != null) {
                // Para não sobreescrever:
                conteudo += linha;
                linha = conteudoArquivo.readLine();
            }

            conteudoArquivo.close();
            return conteudo;

            } catch (IOException e) {
                System.out.println("ERROR: " + e.getMessage());
                return "";
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());
            return "";
        }
    }
}
