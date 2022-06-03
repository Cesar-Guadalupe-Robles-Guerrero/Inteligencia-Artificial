package my.logisticRegression;

import java.lang.Math;

public class HelperArithmetic {
    public HelperArithmetic(){}

    public double sumatoria(double [] array){
        int n = array.length;
        double result = 0;
        for(int i=0;i<n;i++) result += array[i];
        return result;
    }

    double euler(double [] w, double [][] x, int i){
        int n = w.length;
        double result = 0;
        for(int j=1;j<n;j++) {

            result += w[j]*x[i][j];
        }
        return Math.exp(-(w[0]+ result));
    }

}
