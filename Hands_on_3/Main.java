package my.slr;

public class Main {

    public static void main(String[] args) {
        //SLR

        Dataset dataSet = new Dataset();//hardcoded dataset
        SLR slr = new SLR();

        //private double[][] dataSet = {{23, 651}, {26, 762}, {30, 856}, {34, 1063}, {43, 1190}, {48, 1298}, {52, 1421}, {57, 1440}, {58, 1518}};

        slr.setData(dataSet.getDataSet());
        slr.regress();
        slr.displayRegressionEquation();
        System.out.println("y = " + slr.predict(new double[] {60}));

        //MLR
        /*

        Dataset dataSet = new Dataset();//hardcoded dataset
        MLR mlr = new MLR();

        //double [][] data ={{41.9,29.1,251.3},{43.4,29.3,251.3},{43.9,29.5,248.3},{44.5,29.7,267.5},{47.3,29.9,273},{47.5,30.3,276.5},{47.9,30.5,270.3},{50.2,30.7,274.9},{52.8,30.8,285},{53.2,30.9,290},{56.7,31.5,297},{57,31.7,302.5},{63.5,31.9,304.5},{65.3,32,309.3},{71.1,32.1,321.7},{77,32.5,330.7},{77.8,32.9,349}};

        mlr.setData(dataSet.getDataSet());
        mlr.regress();
        mlr.displayRegressionEquation();
        System.out.println(mlr.predict(new double[] {41.9,29.1}));
        */
    }
}
