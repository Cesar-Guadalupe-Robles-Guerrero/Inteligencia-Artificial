package my.ANN;

public class TrainingData {

    private double[][] dataset = { {0.1184, 0.2776, 0.3001, 0.1471, 0.2419, 0, 1}, {0.08474, 0.07864, 0.0869, 0.07017, 0.1812, 0, 1}, {0.09779, 0.08129, 0.06664, 0.04781, 0.1885, 1, 0}, {0.1096, 0.1599, 0.1974, 0.1279, 0.2069, 0, 1}};

    public double[][] getDataset() { return dataset; }

    public void setDataset(double[][] dataset) { this.dataset = dataset; }

    public TrainingData(){}

}
