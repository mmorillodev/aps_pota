package helper;

public class StopWatch {

    private long resultant_time;
    private long initial;

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

    public long getResultantNano() {
        return resultant_time;
    }

    public double getResultantMilli() {
        return resultant_time/1e6;
    }
}
