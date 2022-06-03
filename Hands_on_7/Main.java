package my.gradientDes;

public class Main {

    public static void main(String[] args) {
        Dataset dataSet = new Dataset();//hardcoded dataset
        /*
        SLR slr = new SLR();

        double[][] data = {{23, 651}, {26, 762}, {30, 856}, {34, 1063}, {43, 1190}, {48, 1298}, {52, 1421}, {57, 1440}, {58, 1518}};
        dataSet.setDataSet(data);

        slr.setData(dataSet.getDataSet());
        slr.regress();
        slr.displayRegressionEquation();
        System.out.println(slr.predict(new double[] {60}));
        */

        MLR mlr = new MLR();

        //double [][] data ={{41.9,29.1,251.3},{43.4,29.3,251.3},{43.9,29.5,248.3},{44.5,29.7,267.5},{47.3,29.9,273},{47.5,30.3,276.5},{47.9,30.5,270.3},{50.2,30.7,274.9},{52.8,30.8,285},{53.2,30.9,290},{56.7,31.5,297},{57,31.7,302.5},{63.5,31.9,304.5},{65.3,32,309.3},{71.1,32.1,321.7},{77,32.5,330.7},{77.8,32.9,349}};
        //double [][] data ={{1,1,2},{2,2,4},{3,3,6},{4,4,8},{5,5,10},{6,6,12},{7,7,14},{8,8,16},{9,9,18}};
        double[][] data = {{1,2,31},{2,4,32},{3,6,33},{4,8,34},{5,10,35},{6,12,36},{7,14,37},{8,16,38},{9,18,39}};

        //double[][] data = {{60,22,140},{62,25,155},{67,24,159},{70,20,179},{71,15,192},{72,14,200},{75,14,212},{78,11,215}};
        //double[][] data = {{1.05,-1.07,-73.43},{-0.36,-0.63,-72.57},{-0.85,0.31,4.77},{1.33,0.3,65.41},{-0.46,-1.32,-142.68}};

        dataSet.setDataSet(data);

        mlr.setData(dataSet.getDataSet());
        mlr.regress();
        mlr.displayRegressionEquation();
        System.out.println(mlr.predict(new double[] {4,0.2}));
    }
}
