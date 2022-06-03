package my.ANN;

public class Main {

    public static void main(String[] args) {
        TrainingData trainingData = new TrainingData();
        ANN ann = new ANN();
        ann.setDataset(trainingData.getDataset());
        ann.trainingProcess();



        double[] prediccion = ann.predict(new double[]{0.08,0.07,0.05,0.03,0.17});
        for(int i = 0;i<2;i++) System.out.println(Math.round(prediccion[i]));
    }
}