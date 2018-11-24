package de.djuelg.domain.metric.result;

public class BoxPlotMetricResult implements MetricResult {

    private final long minimum;
    private final long maximum;
    private final long firstQuartile;
    private final long thirdQuartile;
    private final long median;

    public BoxPlotMetricResult(long minimum, long maximum, long firstQuartile, long thirdQuartile, long median) {
        this.minimum = minimum;
        this.maximum = maximum;
        this.firstQuartile = firstQuartile;
        this.thirdQuartile = thirdQuartile;
        this.median = median;
    }

    public long getMinimum() {
        return minimum;
    }

    public long getMaximum() {
        return maximum;
    }

    public long getFirstQuartile() {
        return firstQuartile;
    }

    public long getThirdQuartile() {
        return thirdQuartile;
    }

    public long getMedian() {
        return median;
    }
}
