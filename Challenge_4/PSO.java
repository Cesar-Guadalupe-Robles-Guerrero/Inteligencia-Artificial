package my.PSO;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class PSO {
    private double[][] dataset;

    void setDataset(double[][] dataset) { this.dataset = dataset; }

    void action(){
        /*
        STEP 1. Initialization
         */
        int m = dataset[0].length, n = dataset.length, c1 = 2, c2 = 2, r1 = (int) Math.round(Math.random()), r2 = (int) Math.round(Math.random());
        double w = (Math.random()*(0.9-0.4)) + 0.4;
        //double w = 0.5;
        double[][] position = new double[n][m], velocity = new double[n][m], xBest;
        double[] fitnessValue = new double[n];
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++) {
                velocity[i][j] = 0.1 * dataset[i][j];
                position[i][j] = velocity[i][j] + dataset[i][j];
            }
        xBest = position;

        for(int iterations=0;iterations<10000000;iterations++){
            /*
            STEP 2. Evaluate fitness
             */
            int gbeast = 0;
            double fx = 0, bestg = 0;

            for(int i=0;i<5;i++) {
                fx = 10 * Math.pow(position[i][0] - 1, 2) + 20 * Math.pow(position[i][1] - 2, 2) + 30 * Math.pow(position[i][2] - 3, 2);
                if(i==0) bestg = fx;
                if(fx < bestg) {
                    gbeast = i;
                    bestg = fx;
                }
            }

            /*
            STEP 3 calculate velocity and position
             */
            for(int i=0;i<n;i++)
                for(int j=0;j<m;j++){
                    velocity[i][j] = w*velocity[i][j] + c1*r1*(xBest[i][j]-position[i][j]) + c2*r2*(position[gbeast][j]-position[i][j]);
                    position[i][j] = position[i][j]+velocity[i][j];
                }

            /*
            STEP 4 objetive function used for minimization: Calculate fitness value
             */
            int gbeast2 = 0;
            double bestg2 = 0;
            for(int i=0;i<5;i++) {
                fx = 10 * Math.pow(position[i][0] - 1, 2) + 20 * Math.pow(position[i][1] - 2, 2) + 30 * Math.pow(position[i][2] - 3, 2);
                if(i==0) bestg2 = fx;
                if(fx < bestg2) {
                    gbeast2 = i;
                    bestg2 = fx;
                }
            }
            //System.out.println(bestg + " " + bestg2);
            if(bestg2 < bestg){
                gbeast = gbeast2;
                bestg = bestg2;
            }
            System.out.println(0-bestg);
            //System.out.println(position[gbeast][0] + " " + position[gbeast][1] + " " + position[gbeast][2] + " " + bestg);
        }
    }

}
