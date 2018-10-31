import java.*;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * Classe que ler as matrizes dos arquivos de entrada
 *
 */
public class Ler {

	private List<List<Integer>> linhas = new ArrayList<>();

    private int altura = 0;

    private int largura = 0;

    /**
     * Recebe uma string com os parâmetros de altura e largura
     * sendo A é altura e L largura.
     * @param dimensao string com parâmetros
     * @return 
     */
    public Ler alturaElargura(final String dimensao) {
        String[] dimensoes = dimensao.split(" ");
        if (dimensoes.length == 2) {
            novaAltura(dimensoes[0]);
            novaLargura(dimensoes[1]);
        }
        return this;
    }
    
    public int getaltura() {
        return altura;
    }

    public int getlargura() {
        return largura;
    }

    protected int novaAltura(final String novaAltura) {
        this.altura = Integer.parseInt(novaAltura);
        return this.altura;
    }

    protected int novaLargura(final String novaLargura) {
        this.largura = Integer.parseInt(novaLargura);
        return this.largura;
    }
     
    protected int lerElemento(final String elemento) {
        return Integer.parseInt(elemento);
    }
    
    public List<Integer> lerLinha(final String linhastring) {
        ArrayList<Integer> linha = new ArrayList<>();

        String[] elementos = linhastring.split(" ");
        for (String elemento : elementos) {
            int valor = lerElemento(elemento);
            linha.add(valor);
        }

        linhas.add(linha);
        return linha;
    }

    public Matriz construir() {
            return new Matriz(linhas);
    }
}
