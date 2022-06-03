package my.gradientDes;

public class Dataset {
    private double[][] dataSet;
    //private double[][] dataSet = {{1, 2}, {2, 4}, {3, 6}, {4, 8}, {5, 10}, {6, 12}, {7, 14}, {8, 16}, {9, 18}};

    public double[][] getDataSet() {
        return dataSet;
    }

    public void setDataSet(double[][] dataSet) {
        this.dataSet = dataSet;
    }

    public Dataset() {} //constructor
}
