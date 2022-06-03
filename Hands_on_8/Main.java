package my.logisticRegression;

public class Main {

    public static void main(String[] args) {
        Dataset dataset = new Dataset();
        Logistic logistic = new Logistic();

        logistic.setData(dataset.getDataSet());
        logistic.regress();

        if(logistic.predict(new double[][] {{1,780,4,4}} ) > 0.5) System.out.println("1");
        else System.out.println("0");
    }
}