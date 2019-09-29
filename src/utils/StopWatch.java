package utils;

public class StopWatch {

    private double resultant_time;
    private double initial;

    public void start() {
        resultant_time = 0;
        initial = System.nanoTime();
    }

    public void stop() {
        resultant_time += System.nanoTime() - initial;
    }

    public void resume() {
        initial = System.nanoTime();
    }

    public double getResultant(boolean milli) {
        return (milli ? resultant_time/1e6 : resultant_time);
    }
}
