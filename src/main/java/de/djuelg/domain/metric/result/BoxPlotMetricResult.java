package de.djuelg.domain.metric.result;

import de.djuelg.domain.metric.Datapoint;

import java.util.List;
import java.util.stream.Collectors;

public class BoxPlotMetricResult implements MetricResult {

    private static final double FIRST_QUARTILE = 0.25;
    private static final double THIRD_QUARTILE = 0.75;
    private static final double MEDIAN = 0.5;

    private final List<Datapoint> datapoints;

    public BoxPlotMetricResult(List<Datapoint> datapoints) {
        this.datapoints = datapoints.stream().sorted().collect(Collectors.toList());
    }

    public long median() {
        return calculatePercentile(MEDIAN);
    }

    public long firstQuartile() {
        return calculatePercentile(FIRST_QUARTILE);
    }

    public long thirdQuartile() {
        return calculatePercentile(THIRD_QUARTILE);
    }

    private Long calculatePercentile(double percentile) {
        int size = datapoints.size();
        double q1 = datapoints.stream()
                .mapToLong(Datapoint::datapoint)
                .skip((long) ((size-1)*percentile)).limit(2-size%2)
                .average().orElse(Double.NaN);
        return Math.round(q1);
    }

    public long min() {
        return datapoints.stream().findFirst().orElseThrow(RuntimeException::new).datapoint();
    }

    public long max() {
        return datapoints.stream()
                .skip(datapoints.size()-1)
                .findFirst().orElseThrow(RuntimeException::new).datapoint();
    }

    public List<Datapoint> getDatapoints() {
        return datapoints;
    }
}
