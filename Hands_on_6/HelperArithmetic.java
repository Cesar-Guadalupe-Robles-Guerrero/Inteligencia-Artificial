package my.slr;

public class HelperArithmetic {

    public HelperArithmetic(){}

    public double sumatoria(double [] array){
        int n = array.length;
        double result = 0;
        for(int i=0;i<n;i++) result += array[i];
        return result;
    }


}
