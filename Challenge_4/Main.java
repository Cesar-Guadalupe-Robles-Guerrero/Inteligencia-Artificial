package my.PSO;

public class Main {

    public static void main(String[] args) {
        Dataset dataset = new Dataset();
        PSO pso = new PSO();
        pso.setDataset(dataset.getDataSet());
        pso.action();
    }
}
