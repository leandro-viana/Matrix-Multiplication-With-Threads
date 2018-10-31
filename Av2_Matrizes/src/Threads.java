import java.*;

/**
 * Classe que representa a thread criada por linha 
 *
 */
public class Threads extends Thread{
	    private final int linha;
        private final Matriz matrizA;
	    private final Matriz matrizB;
	    private final Matriz resultante;
	    public Threads(String nome, Matriz matrizA, Matriz matrizB, Matriz resultante, int linha) {
	        super(nome);
	        this.matrizA = matrizA;
	        this.matrizB = matrizB;
	        this.resultante = resultante;
	        this.linha = linha;
	    }
	    @Override
	    public void run() {
	        Calcular.calculaLinhaMatriz(matrizA, matrizB, linha, resultante);
	    }

}