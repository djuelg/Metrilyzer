package de.djuelg.domain.model;

import java.util.Objects;

public abstract class Datapoint implements Comparable<Datapoint> {

    protected final String name;
    protected final long number;

    public Datapoint(String name, long number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public long getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Datapoint datapoint = (Datapoint) o;
        return number == datapoint.number &&
                Objects.equals(name, datapoint.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number);
    }

    @Override
    public String toString() {
        return name + ": \t" + number;
    }

    @Override
    public int compareTo(Datapoint o) {
        return (int) (number - o.number);
    }
}
