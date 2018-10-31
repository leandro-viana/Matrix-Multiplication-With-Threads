import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Classe que contém as estatísticas
 */
public class Estatistica {
    private Collection<Double> dados = new ArrayList<>();
    private Double maximo = Double.MIN_VALUE;
    private Double minimo = Double.MAX_VALUE;
    public void adicionaDado(final Double dado) {
        maximo = Double.max(dado, maximo);
        minimo = Double.min(dado, minimo);
        this.dados.add(dado);
    }
    public Collection<Double> getDados() {
        return dados;
    }
    public Double getMaximo() {
        return maximo;
    }
    public Double getMinimo() {
        return minimo;
    }
    public Double calculaMedia() {
    	return dados.stream().mapToDouble(p -> p).average().getAsDouble();
    }
    public Double calculaDesvioPadrao() {
        Double desvio = 0.0;
        Double media = calculaMedia();

        for (Double elemento : dados) {
            desvio += Math.pow(elemento - media, 2);
        }

        desvio /= dados.size();

        return Math.sqrt(desvio);
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Dados Estatísticos: \n")
                .append(dataToString())
                .append('\n')
                .append("Tempo Máximo: ")
                .append(maximo)
                .append('\n')
                .append("Tempo Mínimo: ")
                .append(minimo)
                .append('\n')
                .append("Média: ")
                .append(calculaMedia())
                .append('\n')
                .append("Desvio Padrão: ")
                .append(calculaDesvioPadrao());

        return builder.toString();
    }
    protected String dataToString() {
        StringBuilder builder = new StringBuilder();

        Iterator<Double> iterator = dados.iterator();

        while (iterator.hasNext()) {
            builder.append(iterator.next());

            if (iterator.hasNext()) {
                builder.append("; ");
            }
        }
        return builder.toString();
    }

}