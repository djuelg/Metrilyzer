package de.djuelg.domain.metric;

import de.djuelg.domain.aggregator.ClassAggregator;
import de.djuelg.domain.datastructure.ClassDTO;
import de.djuelg.domain.datastructure.ModuleDTO;
import de.djuelg.domain.datastructure.PackageDTO;
import de.djuelg.domain.metric.result.BoxPlotMetricResult;

import java.util.Collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class AverageLinesPerClassMetric implements Metric {

    private final Collection<ClassDTO> classes;

    public AverageLinesPerClassMetric(PackageDTO packageDTO) {
        this.classes = new ClassAggregator().aggregate(packageDTO);
    }

    public AverageLinesPerClassMetric(ModuleDTO moduleDTO) {
        this.classes = new ClassAggregator().aggregate(moduleDTO);
    }

    @Override
    public BoxPlotMetricResult calculate() {
        Long median = calculateMedian(); // TODO replace with calculations for Boxplot
        throw new NotImplementedException();
    }

    private Long calculateMedian() {
        int size = classes.size();
        double median = classes.stream()
                .mapToLong(ClassDTO::getLineCount)
                .sorted()
                .skip((size-1)/2).limit(2-size%2)
                .average().orElse(Double.NaN);
        return Math.round(median);
    }
}
