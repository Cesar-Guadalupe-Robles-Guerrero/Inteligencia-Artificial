package my.logisticRegression;

import java.math.BigDecimal;

public class Logistic {
    private double [] w;
    private double[][] dataset;

    void setData(double[][] dataset){
        this.dataset = dataset;
        w = new double[dataset[0].length];
    }

    void regress(){
        HelperArithmetic ha = new HelperArithmetic();
        int f = dataset.length; //filas
        int c = dataset[0].length; //columnas
        double [][]x = new double[f][c];
        double []y = new double[f], model = new double[f];

        double alpha = 0.1; //precision
        for(int i=0;i<c;i++) w[i]=0; //Inicializar w's en 0

        for(int i=0;i<f;i++){
            for(int j=0;j<c;j++){
                if(j==0) x[i][j] = 1;
                else x[i][j] = dataset[i][j-1];
            }
            y[i] = dataset[i][c-1];
        }

        double []sigmoide = new double[f];
        for(int m=0;m<40000000;m++){
            for(int i=0;i<f;i++) sigmoide[i] = 1 / (1+ha.euler(w,x,i));
            for(int j=0;j<c;j++){
                for(int i=0;i<f;i++) model[i] = (sigmoide[i]-y[i])*x[i][j];
                w[j] =w[j] - alpha * ha.sumatoria(model);
            }
        }
    }

    double predict(double[][] values) {
        double sig = 0;
        HelperArithmetic ha = new HelperArithmetic();
        sig = 1 / (1+ha.euler(w,values,0));
        return sig;
    }

}
