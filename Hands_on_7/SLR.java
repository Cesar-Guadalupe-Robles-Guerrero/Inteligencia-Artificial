package my.gradientDes;

public class SLR implements Gradient {
    private double b0 = 0, b1 = 0;
    private double[][] dataSet;

    public SLR(){};

    @Override
    public void setData(double[][] dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public void regress(){
        HelperArithmetic ha = new HelperArithmetic();
        int n=dataSet.length;
        double precision=0.0001, theError=0, alpha=0.0003;
        double[] model = new double[n], x = new double[n], y = new double[n];

        //divide la matriz en dos arreglos independientes
        for(int i=0;i<n;i++){
            x[i] = dataSet[i][0];
            y[i] = dataSet[i][1];
        }

        do{
            for(int i=0;i<n;i++) model[i] = y[i]-(b0 + b1*x[i]);

            theError = ha.exponenteCuadrado((1/(double)n) * ha.sumatoria(model));
            b0 = b0 - alpha * (-2/(double)n) * ha.sumatoria(model);
            b1 = b1 - alpha * (-2/(double)n) * ha.sumatoria(ha.producto(model,x));
        }while (precision<theError);
    }

    @Override
    public void displayRegressionEquation() {System.out.println("y = " + b0 + " + " + b1 + " * x\n");}

    @Override
    public double predict(double[] values) {return b0 + b1 * values[0];}
}
