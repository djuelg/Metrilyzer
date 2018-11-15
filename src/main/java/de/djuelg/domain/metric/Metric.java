package de.djuelg.domain.metric;

import de.djuelg.domain.metric.result.MetricResult;

public interface Metric {
    MetricResult calculate();
}
