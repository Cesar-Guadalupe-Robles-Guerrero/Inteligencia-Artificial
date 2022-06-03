package my.logisticRegression;

public class Dataset {
    private double[][] dataSet = {{780,4,3,1},{750,3.9,4,1},{690,3.3,3,0},{710,3.7,5,1},{680,3.9,4,0},{730,3.7,6,1},{690,2.3,1,0},{720,3.3,4,1},{740,3.3,5,1}};
    //private double[][] dataSet = {{1,1,1,72},{1,2,72,1},{1,3,72,1},{1,4,72,0},{1,5,64,1},{1,6,64,0},{1,7,64,1},{2,1,72,1},{2,2,72,1},{2,3,72,0},{2,4,72,0},{2,5,64,0},{2,6,64,0},{2,7,64,1}};

    public double[][] getDataSet() {
        return dataSet;
    }

    public void setDataSet(double[][] dataSet) {this.dataSet = dataSet;}

    public Dataset() {} //constructor
}
