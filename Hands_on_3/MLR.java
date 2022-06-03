package my.slr;

public class MLR implements Regression{
    double b0=0, b1=0, b2=0;
    double[][] dataSet;

    @Override
    public void setData(double[][] dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public void regress() {
        HelperArithmetic ha = new HelperArithmetic();
        Cramer cramer = new Cramer();

        double sumX1 = 0, sumX2 = 0, sumY = 0, sumX2_1 = 0, sumX2_2 = 0, sumX1X2 = 0, sumX1Y = 0, sumX2Y = 0;
        int n = dataSet.length;

        double[] x1 = new double[n], x2 = new double[n],
                y = new double[n], x2_1 = new double[n],
                x2_2 = new double[n], x1x2 = new double[n],
                x1y = new double[n], x2y = new double[n];

        //tabla de datos
        for(int i=0;i<n;i++){
            x1[i] = dataSet[i][0];
            x2[i] = dataSet[i][1];
            y[i] = dataSet[i][2];
            x2_1[i] = x1[i]*x1[i];
            x2_2[i] = x2[i]*x2[i];
            x1x2[i] = x1[i]*x2[i];
            x1y[i] = x1[i]*y[i];
            x2y[i] = x2[i]*y[i];
        }

        sumX1 = ha.sumatoria(x1);
        sumX2 = ha.sumatoria(x2);
        sumY = ha.sumatoria(y);
        sumX2_1 = ha.sumatoria(x2_1);
        sumX2_2 = ha.sumatoria(x2_2);
        sumX1X2 = ha.sumatoria(x1x2);
        sumX1Y = ha.sumatoria(x1y);
        sumX2Y = ha.sumatoria(x2y);

        double[] coefficients = cramer.solveCramer(sumX1, sumX2, sumY, sumX2_1, sumX2_2, sumX1X2, sumX1Y, sumX2Y, n);

        this.b0 = coefficients[0];
        this.b1 = coefficients[1];
        this.b2 = coefficients[2];

    }

    @Override
    public void displayRegressionEquation() {
        System.out.println("y = " + b0 + " + " + b1 + " x1 + " + b2 + " x2\n");
    }

    public double predict(double[] values) {return b0 + (b1 * values[0]) + (b2 * values[1]);}
}
