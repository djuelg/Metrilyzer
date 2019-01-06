package de.djuelg.domain.metric;

import de.djuelg.domain.model.Datapoint;

import java.util.Collection;
import java.util.Objects;
import java.util.StringJoiner;

public abstract class Metric<T extends Datapoint> {

    private final String name;
    private final Collection<T> datapoints;

    protected Metric(String name, Collection<T> datapoints) {
        this.name = name;
        this.datapoints = datapoints;
    }

    public void addDatapoint(T datapoint) {
        this.datapoints.add(datapoint);
    }

    public String getName() {
        return name;
    }

    public Collection<T> getDatapoints() {
        return datapoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Metric<?> that = (Metric<?>) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(datapoints, that.datapoints);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, datapoints);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Metric.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("datapoints=" + datapoints)
                .toString();
    }
}
