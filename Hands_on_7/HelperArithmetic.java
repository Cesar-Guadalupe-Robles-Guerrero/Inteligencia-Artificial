package my.gradientDes;

public class HelperArithmetic {

    public HelperArithmetic(){}

    public double sumatoria(double [] array){
        int n = array.length;
        double result = 0;
        for(int i=0;i<n;i++) result += array[i];
        return result;
    }

    public double exponenteCuadrado(double value){
        return value*value;
    }

    public double[] producto(double[] a, double[] b){
        int n=a.length;
        double[] result = new double[n];
        for(int i=0;i<n;i++) result[i] = a[i] * b[i];
        return result;
    }
}