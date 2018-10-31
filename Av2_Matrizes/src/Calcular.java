import java.util.ArrayList;
import java.util.List;

/**
 * Classe que realiza os cálculos das matrizes
 */
public class Calcular {

    private Calcular() {
    	
    }

    /**
     * Algoritmo sequencial para multiplicação de matrizes
     */
    public static Matriz multiplicacaoSequencial(Matriz matrizA, Matriz matrizB) {
        List<List<Integer>> todosElementos = new ArrayList<>();

        for (int i = 0; i < matrizA.getTamanho(); i++) {
        	todosElementos.add(new ArrayList<>());
            for (int j = 0; j < matrizA.getTamanho(); j++) {
            	todosElementos.get(i).add(0);
            }
        }

        Matriz matrizResultante = new Matriz(todosElementos);

        for (int i = 0; i < matrizResultante.getTamanho(); i++) {
            for (int j = 0; j < matrizResultante.getTamanho(); j++) {
                int resultado = 0;

                for (int k = 0; k < matrizResultante.getTamanho(); k++) {
                    resultado += matrizA.getElemento(i, k) * matrizB.getElemento(k, j);
                }

                matrizResultante.setElemento(i, j, resultado);
            }
        }

        return matrizResultante;
    }

    /**
     * Calcula o produto de duas matrizes A e B e retorna a matriz resultado
     */
    protected  static Matriz calculaProdutoMatrizes(Matriz matrizA, Matriz matrizB) {
        int tamanho = matrizA.getTamanho();
        Matriz matrizResultante = new Matriz(tamanho);
        
        for (int i = 0; i < tamanho; i++) {
        	calculaLinhaMatriz(matrizA, matrizB, i, matrizResultante);
        }

        return matrizResultante;
    }

    /**
     * Calcula e atribui os elementos na matriz resultado
     */
    protected  static void calculaLinhaMatriz(Matriz matrizA, Matriz matrizB, int linha, Matriz matrizResultante) {
        int tamanho = matrizResultante.getTamanho();
        
        for (int coluna = 0; coluna < tamanho; coluna++) {
            Integer element = calculaElementoMatriz(matrizA, matrizB, linha, coluna);
            matrizResultante.setElemento(linha, coluna, element);
        }
    }

    /**
     * Calcula o elemento na posição, no produto entre as matrizes A e B
     */
    protected static Integer calculaElementoMatriz(Matriz matrizA, Matriz matrizB, int linha, int coluna) {
        int resultado = 0;
        int tamanho = matrizA.getTamanho();
        
        for (int i = 0; i < tamanho; i++) {
            resultado += matrizA.getElemento(linha, i) * matrizB.getElemento(i, coluna);
        }

        return resultado;
    }
}

