package my.gradientDes;

public class MLR implements Gradient{
    private double b0 = 0, b1 = 0, b2=0;
    private double[][] dataSet;

    @Override
    public void setData(double[][] dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public void regress() {
        HelperArithmetic ha = new HelperArithmetic();
        int n=dataSet.length;
        double precision=0.0001, theError=0, alpha=0.0003;
        double[] model = new double[n], x1 = new double[n], x2 = new double[n], y = new double[n];

        //divide la matriz en dos arreglos independientes
        for(int i=0;i<n;i++){
            x1[i] = dataSet[i][0];
            x2[i] = dataSet[i][1];
            y[i] = dataSet[i][2];
        }

        do{
            for(int i=0;i<n;i++) model[i] = y[i]-(b0 + b1*x1[i] + b2*x2[i]);
            theError = ha.exponenteCuadrado((1/(double)n) * ha.sumatoria(model));
            b0 = b0 - alpha * (-2/(double)n) * ha.sumatoria(model);
            b1 = b1 - alpha * (-2/(double)n) * ha.sumatoria(ha.producto(model,x1));
            b2 = b2 - alpha * (-2/(double)n) * ha.sumatoria(ha.producto(model,x2));

        }while (precision<theError);
    }

    @Override
    public void displayRegressionEquation() {
        System.out.println("y = " + b0 + " + " + b1 + " x1 + " + b2 + " x2\n");
    }

    public double predict(double[] values) { return b0 + (b1 * values[0]) + (b2 * values[1]); }
}
