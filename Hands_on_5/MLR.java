package my.normalEquation;

public class MLR {
    private double b0=0, b1=0, b2=0;
    private double[][] dataSet;

    public MLR(){};

    public void setData(double[][] dataSet) {
        this.dataSet = dataSet;
    }

    public void regress(){
        LinearAlgebra la = new LinearAlgebra();
        int n=dataSet.length, m=dataSet[0].length;
        double[][] x = new double[n][m], y = new double[n][1];

        //divide la dataSet original en dos arreglos distintos (X y Y)
        for(int i=0;i<n;i++){
            x[i][0]=1;
            for(int j=1;j<m;j++) x[i][j]=dataSet[i][j-1];
            y[i][0]=dataSet[i][m-1];
        }

        //operaciones matriciales
        double[][] coefficients = la.Multiplication(
                la.Inverse(la.Multiplication(la.Transposed(x),x)),
                la.Multiplication(la.Transposed(x),y));

        //instanciar betas
        this.b0 = coefficients[0][0];
        this.b1 = coefficients[1][0];
        this.b2 = coefficients[2][0];
    }

    public void displayRegressionEquation() {
        System.out.println("y = " + b0 + " + " + b1 + " x1 + " + b2 + " x2\n");
    }

    public double predict(double[] values) {return b0 + (b1 * values[0]) + (b2 * values[1]);}
}
