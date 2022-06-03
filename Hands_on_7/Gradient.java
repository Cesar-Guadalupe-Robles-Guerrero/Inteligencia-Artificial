package my.gradientDes;

public interface Gradient {
    void setData(double[][] dataSet); //setea la dataset
    void regress(); //genera el calculo de la regresion a partir de los datos impartidos
    void displayRegressionEquation(); //muestra la ecuacion de regresion
    double  predict(double[] values); //obtiene el resultado devolviendo un double
}
