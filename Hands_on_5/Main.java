package my.normalEquation;

public class Main {

    public static void main(String[] args) {
        Dataset dataSet = new Dataset();//hardcoded dataset
        MLR mlr = new MLR();

        mlr.setData(dataSet.getDataSet());
        mlr.regress();
        mlr.displayRegressionEquation();
        //System.out.println(mlr.predict(new double[] {41.9,29.1}));
    }
}
