package my.ANN;

public class AuxMath {
    AuxMath(){}
    double sigmoid(double val){ return 1/(1+Math.exp(-val)); }
    public double sumatoria(double [] array){
        int n = array.length;
        double result = 0;
        for(int i=0;i<n;i++) result += array[i];
        return result;
    }
}