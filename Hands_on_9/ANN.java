package my.ANN;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class ANN {
    private double[][] dataset;
    private double[] x, w;
    private double b2;

    public void setDataset(double[][] dataset) { this.dataset = dataset; }

    void trainingProcess() {
        x = new double[5];
        double [] t = new double[2];

        /*
        Inicializar parametros
         */
        b2 = 0.5;
        double alpha = 0.01, b1 = 0.5, o1 = 0, o2 = 0;
        w = new double[35]; // n = 10
        for(int i=0;i<35;i++) w[i]=(Math.random()*(0.9-0.1)) + 0.1;;

        /*
        Auxiliares
         */
        AuxMath math = new AuxMath();
        double E = 0, dEdb1 = 0, dEdb2 = 0, dEdo1 = 0, dEdo2 = 0;
        double[] dEdw = new double[50], dEdh = new double[5], h = new double[5];
        double[] model = new double[5];
        boolean flag = true;

        for(int iteration=0;iteration<dataset.length || !flag;iteration++){
            if(!flag) iteration = 0 ;
            for(int j=0;j<5;j++) x[j]=dataset[iteration][j];

            t[0] = dataset[iteration][5];
            t[1] = dataset[iteration][6];

            if(iteration == 0) flag = true;

            do{
                /*
                ForwardPass
                 */
                int aux;
                for(int i=0;i<5;i++){
                    aux = 0;
                    for(int j=0;j<5;j++){
                        model[j] = w[i+aux]+x[j];
                        aux += 5;
                    }
                    h[i]=math.sigmoid(math.sumatoria(model) + b2);
                }
                o1 = math.sigmoid(w[25]*h[0]+w[27]*h[1]+w[29]*h[2]+w[31]*h[3]+w[33]*h[4]+b2);
                o2 = math.sigmoid(w[26]*h[0]+w[28]*h[1]+w[30]*h[2]+w[32]*h[3]+w[34]*h[4]+b2);
                if(t[0] == Math.round(o1)&&t[1] == Math.round(o2)) break ;

                /*
                Define the error
                 */
                dEdo1 = o1-t[0];
                dEdo2 = o2-t[1];
                E = (Math.pow(dEdo1,2)+Math.pow(dEdo2,2))/2;
                if(E<=0.000001) break;
                else flag = false;

                /*
                BackwardPass
                 */
                for(int i=0;i<5;i++){
                    dEdw[25+(i*2)] = dEdo1*(o1*(1-o1))*h[i];
                    dEdw[26+(i*2)] = dEdo2*(o2*(1-o2))*h[i];
                }
                dEdb2 = dEdo1*(o1*(1-o1)) + dEdo2*(o2*(1-o2)); //dEdb2

                for(int i=0;i<5;i++){
                    dEdh[i] = dEdo1*(o1*(1-o1))*w[25+(i*2)]+dEdo2*(o2*(1-o2))*w[26+(i*2)];
                }

                for(int i=0;i<5;i++){
                    dEdw[i*5] =dEdh[0]*(h[0]*(1-h[0]))*x[i];
                    dEdw[(i*5)+1] =dEdh[1]*(h[1]*(1-h[1]))*x[i];
                    dEdw[(i*5)+2] =dEdh[2]*(h[2]*(1-h[2]))*x[i];
                    dEdw[(i*5)+3] =dEdh[3]*(h[3]*(1-h[3]))*x[i];
                    dEdw[(i*5)+4] =dEdh[4]*(h[4]*(1-h[4]))*x[i];
                }

                dEdb1 = dEdo1*(o1*(1-o1))*w[25]*(h[0]*(1-h[0]))+dEdo2*(o2*(1-o2))*w[34]*(h[4]*(1-h[4])); //dEdb1
                for(int i=0;i<35;i++) w[i] -= alpha * dEdw[i];

                b1 -= alpha * dEdb1;
                b2 -= alpha * dEdb2;
                System.out.println(b1 +" ... "+b2+" ... "+E);
            }while(true);
        }
    }

    double[] predict(double[] array){
        double[] model = new double[5], h = new double[5];
        AuxMath math = new AuxMath();
        double o1=0, o2=0;

        int aux;
        for(int i=0;i<5;i++){
            aux = 0;
            for(int j=0;j<5;j++){
                model[j] = w[i+aux]+array[j];
                aux += 5;
            }
            h[i]=math.sigmoid(math.sumatoria(model) + b2);
        }
        o1 = math.sigmoid(w[25]*h[0]+w[27]*h[1]+w[29]*h[2]+w[31]*h[3]+w[33]*h[4]+b2);
        o2 = math.sigmoid(w[26]*h[0]+w[28]*h[1]+w[30]*h[2]+w[32]*h[3]+w[34]*h[4]+b2);
        return new double[]{o1,o2};
    }

}
