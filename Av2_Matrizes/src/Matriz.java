import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa uma Matriz
 */

public class Matriz {
	
	private List<List<Integer>> matriz;

    public Matriz(List<List<Integer>> matriz) {
        this.matriz = matriz;
    }

	public Matriz(int tamanhoMatriz){
		matriz = new ArrayList<>();
		for (int i = 0; i < tamanhoMatriz; i++) {
            List<Integer> linhaMatriz = new ArrayList<>();
            for (int j = 0; j < tamanhoMatriz; j++) {
            	linhaMatriz.add(0);
            }
            matriz.add(linhaMatriz);
        }
		
	}
	
    public int getTamanho() {
        return matriz.size();
    }

    public int getElemento(int linha, int coluna) {
        return matriz.get(linha).get(coluna);
    }
    public void setElemento(int linha, int coluna, int valor) {
        matriz.get(linha).set(coluna, valor);
    }
    public List<Integer> getLinhaMatriz(int linha) {
        return matriz.get(linha);
    }
    public List<Integer> getColunaMatriz(int coluna) {
        ArrayList<Integer> colunaMatriz = new ArrayList<>();

        for (List<Integer> linha : matriz) {
        	colunaMatriz.add(linha.get(coluna));
        }
        return colunaMatriz;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (List<Integer> linhaMatriz : matriz) {
            for (Integer elemento : linhaMatriz) {
                builder.append(elemento);
                builder.append(" ");
            }
            builder.setCharAt(builder.length() - 1, '\n');
        }
        return builder.toString();
    }
}

