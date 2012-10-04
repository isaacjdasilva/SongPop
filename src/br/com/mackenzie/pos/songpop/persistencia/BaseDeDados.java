/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.pos.songpop.persistencia;

import br.com.mackenzie.pos.songpop.controle.util.Constantes;
import br.com.mackenzie.pos.songpop.controle.util.Util;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Isaac
 */
public class BaseDeDados {

    private File file;
    private FileReader fileReader;
    private BufferedReader bufferedReader;
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    private String nomeArquivo;
    private String urlCompletaArquivo;

    public BaseDeDados(String nomeArquivo) {
        this.setNomeArquivo(nomeArquivo);
        this.setUrlCompletaArquivo(Constantes.CAMINHO_BD + getNomeArquivo());
        criarOuAbrirArquivo();
        fecharArquivo();
    }

    public long sequenceAtual() {
        ArrayList<String> linhas = (ArrayList<String>) recuperarLinhasArquivo();

        if (!Util.isNullOrVazio(linhas)) {
            fecharArquivo();
            return Long.parseLong(linhas.get(linhas.size()));
        } else {
            fecharArquivo();
            return 0;
        }
    }

    public long proximaSequence() {
        ArrayList<String> linhas = (ArrayList<String>) recuperarLinhasArquivo();

        if (!Util.isNullOrVazio(linhas)) {
            
            String ultimaLinha = linhas.get(linhas.size() - 1);

            StringTokenizer st = new StringTokenizer(ultimaLinha, Constantes.REGEX);

            while (st.hasMoreTokens()) {
                fecharArquivo();
                return Long.parseLong(st.nextToken()) + 1;
            }
        }

        fecharArquivo();
        return 1;

    }

    public Collection<String> recuperarLinhasArquivo() {

        Collection<String> colecaoDeLinhas = new ArrayList<String>();

        try {

            criarOuAbrirArquivo();

            this.setBufferedReader(new BufferedReader(this.getFileReader()));

            String linha = getBufferedReader().readLine();

            while (linha != null) {
                colecaoDeLinhas.add(linha);
                linha = getBufferedReader().readLine();
            }

            fecharArquivo();

        } catch (IOException ex) {
            fecharArquivo();
            Logger.getLogger(BaseDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }

        colecaoDeLinhas = (ArrayList<String>) Util.removerNullColecao(colecaoDeLinhas);
        return colecaoDeLinhas;
    }

    public Collection<String> recuperarColecaoPorId(int coluna, Long id) {

        Collection<String> colecaoDeLinhas = new ArrayList<String>();

        try {

            criarOuAbrirArquivo();

            this.setBufferedReader(new BufferedReader(this.getFileReader()));

            String linha = getBufferedReader().readLine();

            while (linha != null) {

                StringTokenizer ids = new StringTokenizer(linha, Constantes.REGEX);

                if (ids != null && ids.countTokens() != 0) {

                    int i = 0;
                    while (ids.hasMoreTokens()) {

                        final String valor = ids.nextToken();

                        if (i == coluna) {
                            if (valor.trim().equalsIgnoreCase(String.valueOf(id))) {
                                // Registros encontrados
                                final String linhaInserir = linha;
                                colecaoDeLinhas.add(linhaInserir);
                            }

                            break;
                        }

                        i++;
                    }
                }

                linha = getBufferedReader().readLine();
            }

            fecharArquivo();

        } catch (IOException ex) {
            Logger.getLogger(BaseDeDados.class.getName()).log(Level.SEVERE, null, ex);
            fecharArquivo();
        }

        fecharArquivo();
        return colecaoDeLinhas;
    }

    public Collection<String> recuperarColecaoPorColuna(int coluna, Long id) {

        Collection<String> colecaoDeLinhas = new ArrayList<String>();

        try {

            criarOuAbrirArquivo();

            this.setBufferedReader(new BufferedReader(this.getFileReader()));

            String linha = getBufferedReader().readLine();

            while (linha != null) {

                StringTokenizer ids = new StringTokenizer(linha, Constantes.REGEX);

                if (ids != null && ids.countTokens() != 0) {

                    int i = 0;
                    while (ids.hasMoreTokens()) {
                        final String valorColuna = ids.nextToken();
                        if (i == coluna) {
                            if (valorColuna.trim().equalsIgnoreCase(String.valueOf(id))) {
                                final String linhaInserir = linha;
                                colecaoDeLinhas.add(linhaInserir);
                            }
                            break;
                        }

                        i++;
                    }
                }

                linha = getBufferedReader().readLine();
            }

            fecharArquivo();

        } catch (IOException ex) {
            fecharArquivo();
            Logger.getLogger(BaseDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }

        fecharArquivo();
        return colecaoDeLinhas;
    }

    public Collection<String> recuperarColecaoPorColuna(int coluna, String conteudo, String conteudoArray, boolean contemArray) {

        Collection<String> colecaoDeLinhas = new ArrayList<String>();

        try {

            criarOuAbrirArquivo();

            this.setBufferedReader(new BufferedReader(this.getFileReader()));

            String linha = getBufferedReader().readLine();

            while (linha != null) {

                StringTokenizer ids = new StringTokenizer(linha, Constantes.REGEX);

                if (contemArray) {

                    String conteudoColunaEncontrada = "";
                    
                    if (ids != null && ids.countTokens() != 0) {

                        int i = 0;
                        while (ids.hasMoreTokens()) {
                            final String valorColuna = ids.nextToken();
                            if (i == coluna) {
                                conteudoColunaEncontrada = valorColuna;
                                break;
                            }

                            i++;
                        }
                        
                        StringTokenizer idsConteudoColuna = new StringTokenizer(conteudoColunaEncontrada, Constantes.REGEX_ARRAY);
                    
                        if (idsConteudoColuna != null && idsConteudoColuna.countTokens() != 0) {
                            
                            while (idsConteudoColuna.hasMoreTokens()) {
                                final String valorColuna = idsConteudoColuna.nextToken();
                                
                                if (valorColuna.trim().equalsIgnoreCase(conteudoArray.trim())) {
                                    // Registros encontrados
                                    final String linhaInserir = linha;
                                    colecaoDeLinhas.add(linhaInserir);
                                    break;
                                }
                                
                            }

                        }
                    }

                } else {

                    if (ids != null && ids.countTokens() != 0) {

                        int i = 0;
                        while (ids.hasMoreTokens()) {
                            final String valorColuna = ids.nextToken();
                            if (i == coluna) {
                                if (valorColuna.trim().equalsIgnoreCase(String.valueOf(conteudo.trim()))) {
                                    final String linhaInserir = linha;
                                    colecaoDeLinhas.add(linhaInserir);
                                }
                                break;
                            }

                            i++;
                        }
                    }
                }

                linha = getBufferedReader().readLine();
            }

        } catch (IOException ex) {
            fecharArquivo();
            Logger.getLogger(BaseDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }

        fecharArquivo();
        return colecaoDeLinhas;
    }

    public String recuperarPorId(int coluna, Long id) {

        String linha = null;
        boolean encontrouConteudoLinha = false;

        try {

            criarOuAbrirArquivo();

            this.setBufferedReader(new BufferedReader(this.getFileReader()));

            linha = getBufferedReader().readLine();
            
            while (linha != null) {

                StringTokenizer ids = new StringTokenizer(linha, Constantes.REGEX);

                if (ids != null && ids.countTokens() != 0) {

                    int i = 0;
                    while (ids.hasMoreTokens()) {
                        final String valorColuna = ids.nextToken();
                        if (i == coluna) {
                            if (valorColuna.trim().equalsIgnoreCase(String.valueOf(id))) {
                                encontrouConteudoLinha = true;
                            } 
                            
                            break;
                        }

                        i++;
                    }
                }
                
                if (encontrouConteudoLinha) {
                    fecharArquivo();
                    return linha;
                }

                linha = getBufferedReader().readLine();
            }

        } catch (IOException ex) {
            fecharArquivo();
            Logger.getLogger(BaseDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }

        fecharArquivo();
        return linha;
    }

    public boolean escreverLinhasEmArquivo(String novaLinha) {

        try {
            // Todas as operações de IO podem gerar exceções

            // Instanciamos um FileWriter associado ao FileWriter
            // true pois vamos adicionar dados ao nosso arquivo
            this.setFileWriter(new FileWriter(getUrlCompletaArquivo(), true));

            this.setBufferedWriter(new BufferedWriter(getFileWriter()));

            if (this.getFile().length() != 0) {
                // Escrevendo a nova linha
                this.getBufferedWriter().newLine();
            }

            this.getBufferedWriter().write(novaLinha);

        } catch (Exception ex) {
            ex.getMessage();
            fecharArquivo();
            return false;
        }

        // Fechando o stream (importante)
        fecharArquivo();
        return true;
    }

    public void fecharArquivo() {

        try {
            if (this.getBufferedReader() != null) {
                this.getBufferedReader().close();
            }

            if (this.getFileReader() != null) {
                this.getFileReader().close();
            }

            if (this.getBufferedWriter() != null) {
                this.getBufferedWriter().close();
            }

            if (this.getFileWriter() != null) {
                this.getFileWriter().close();
            }

        } catch (IOException ex) {
            Logger.getLogger(BaseDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void criarOuAbrirArquivo() {

        this.setFile(new File(getUrlCompletaArquivo()));

        if (!this.getFile().exists()) {
            try {
                this.getFile().createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(BaseDeDados.class.getName()).log(Level.SEVERE, null, ex);
                fecharArquivo();
                System.exit(0);
            }
        }
        try {
            this.setFileReader(new FileReader(this.getFile()));
        } catch (FileNotFoundException ex) {
            try {
                this.getFile().createNewFile();
            } catch (IOException ex1) {
                fecharArquivo();
                Logger.getLogger(BaseDeDados.class.getName()).log(Level.SEVERE, null, ex1);
            }
            try {
                this.setFileReader(new FileReader(this.getFile()));
            } catch (FileNotFoundException ex1) {
                fecharArquivo();
                Logger.getLogger(BaseDeDados.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    public String getNomeArquivo() {
        return this.nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public FileReader getFileReader() {
        return fileReader;
    }

    public void setFileReader(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }

    public void setBufferedReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public FileWriter getFileWriter() {
        return fileWriter;
    }

    public void setFileWriter(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    public BufferedWriter getBufferedWriter() {
        return bufferedWriter;
    }

    public void setBufferedWriter(BufferedWriter bufferedWriter) {
        this.bufferedWriter = bufferedWriter;
    }

    public String getUrlCompletaArquivo() {
        return urlCompletaArquivo;
    }

    public void setUrlCompletaArquivo(String urlCompletaArquivo) {
        this.urlCompletaArquivo = urlCompletaArquivo;
    }
}