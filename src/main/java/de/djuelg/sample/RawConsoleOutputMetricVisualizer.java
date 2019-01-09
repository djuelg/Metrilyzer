package de.djuelg.sample;

import de.djuelg.domain.MetricVisualizer;
import de.djuelg.domain.metric.Metric;
import de.djuelg.domain.model.Datapoint;

import java.nio.file.Path;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RawConsoleOutputMetricVisualizer implements MetricVisualizer {

    public RawConsoleOutputMetricVisualizer(Path path) {
    }

    @Override
    public void createDiagramsOf(List<Metric<? extends Datapoint>> results) {
        results.forEach(metric -> {
            System.out.println("## " + metric.getName() + "\n");
            System.out.println("### Top ten max\n");

            Collection<? extends Datapoint> datapoints = metric.getDatapoints();
            List<String> topTen = datapoints.stream().sorted().map(Datapoint::toString).collect(Collectors.toList());
            Collections.reverse(topTen);
            topTen.stream().limit(10).forEach(System.out::println);
            System.out.println();

            System.out.println("### Datapoints\n");
            String collect = datapoints.stream().map(Datapoint::getNumber).map(Object::toString).collect(Collectors.joining(","));
            System.out.println(collect);
            System.out.println();
        });
    }
}