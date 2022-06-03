package my.slr;

public class SLR implements Regression{
    double b0=0, b1=0;
    double[][] dataSet;

    @Override
    public void setData(double[][] dataSet) {this.dataSet = dataSet;}

    @Override
    public void regress() {
        HelperArithmetic ha = new HelperArithmetic();
        Cramer cramer = new Cramer();

        double sumX = 0, sumY = 0, sumXY = 0, sumXX = 0;
        int n = dataSet.length;

        double[] x = new double[n], y = new double[n], xx = new double[n], xy = new double[n];

        //tabla de datos
        for(int i=0;i<n;i++){
            x[i] = dataSet[i][0];
            y[i] = dataSet[i][1];
            xx[i] = x[i] * x[i];
            xy[i] = x[i] * y[i];
        }

        sumX = ha.sumatoria(x);
        sumY = ha.sumatoria(y);
        sumXX = ha.sumatoria(xx);
        sumXY = ha.sumatoria(xy);

        double [] coefficients = cramer.solveCramer(sumX, sumY, sumXX, sumXY, n);
        this.b0 = coefficients[0];
        this.b1 = coefficients[1];
    }

    @Override
    public void displayRegressionEquation() {System.out.println("y = " + b0 + " + " + b1 + " * x\n");}

    @Override
    public double predict(double[] values) {return b0 + b1 * values[0];}
}
