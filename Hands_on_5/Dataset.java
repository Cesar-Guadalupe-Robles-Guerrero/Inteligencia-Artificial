package my.normalEquation;

public class Dataset {
    private double [][] dataSet ={{41.9,29.1,251.3},{43.4,29.3,251.3},{43.9,29.5,248.3},{44.5,29.7,267.5},{47.3,29.9,273},{47.5,30.3,276.5},{47.9,30.5,270.3},{50.2,30.7,274.9},{52.8,30.8,285},{53.2,30.9,290},{56.7,31.5,297},{57,31.7,302.5},{63.5,31.9,304.5},{65.3,32,309.3},{71.1,32.1,321.7},{77,32.5,330.7},{77.8,32.9,349}};
    //private double[][] dataSet = {{1,2,31},{2,4,32},{3,6,33},{4,8,34},{5,10,35},{6,12,36},{7,14,37},{8,16,38},{9,18,39}};
    public double[][] getDataSet() {
        return dataSet;
    }

    public void setDataSet(double[][] dataSet) {
        this.dataSet = dataSet;
    }

    public Dataset() {} //constructor
}
