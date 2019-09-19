public class StopWatch {

    private double resultant_time;
    private double initial;

    public void start() {
        resultant_time = 0;
        initial = System.nanoTime();
    }

    public double stop() {
        return resultant_time = System.nanoTime() - initial;
    }

    public double getResultant(boolean milli) {
        return (milli ? resultant_time/1e3 : resultant_time);
    }
}
