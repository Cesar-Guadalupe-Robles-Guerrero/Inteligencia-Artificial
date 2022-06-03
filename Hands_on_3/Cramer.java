package my.slr;

public class Cramer {

    public Cramer() {} //constructor

    public double[] solveCramer(double sigmaX, double sigmaY, double sigmaXX, double sigmaXY, int n) {
        double b0 = 0, b1 = 0;

        double detB1 = n * sigmaXY - sigmaX * sigmaY;
        double detS = n * sigmaXX - sigmaX * sigmaX;

        b1 = detB1 / detS;
        b0 = (sigmaY - b1 * sigmaX) / n;

        return new double[]{b0, b1};
    }

    public double[] solveCramer(double sigmaX1, double sigmaX2, double sigmaY, double sigmaX1_2, double sigmaX2_2, double sigmaX1X2, double sigmaX1Y, double sigmaX2Y, int n){

        double detS = (sigmaX1*sigmaX2*sigmaX1X2)+(sigmaX2*sigmaX1*sigmaX1X2)-(sigmaX2*sigmaX2*sigmaX1_2) + (n*sigmaX1_2*sigmaX2_2)-(n*sigmaX1X2*sigmaX1X2)-(sigmaX1*sigmaX1*sigmaX2_2);

        double detB0 = (sigmaY*sigmaX1_2*sigmaX2_2)-(sigmaY*sigmaX1X2*sigmaX1X2)-(sigmaX1*sigmaX1Y*sigmaX2_2)+(sigmaX1*sigmaX2Y*sigmaX1X2)+(sigmaX2*sigmaX1Y*sigmaX1X2)-(sigmaX2*sigmaX2Y*sigmaX1_2);

        double detB1 = (n*sigmaX1Y*sigmaX2_2)-(n*sigmaX2Y*sigmaX1X2)-(sigmaY*sigmaX1*sigmaX2_2)+(sigmaY*sigmaX2*sigmaX1X2)+(sigmaX2*sigmaX1*sigmaX2Y)-(sigmaX2*sigmaX2*sigmaX1Y);

        double detB2 = (n*sigmaX1_2*sigmaX2Y)-(n*sigmaX1X2*sigmaX1Y)-(sigmaX1*sigmaX1*sigmaX2Y)+(sigmaX1*sigmaX2*sigmaX1Y)+(sigmaY*sigmaX1*sigmaX1X2)-(sigmaY*sigmaX2*sigmaX1_2);

        return new double[]{detB0/detS, detB1/detS, detB2/detS};
    }
}