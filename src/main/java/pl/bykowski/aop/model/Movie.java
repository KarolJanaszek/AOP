package pl.bykowski.aop.model;

public class Movie {
    private String name;
    private String producer;
    private int release;

    public Movie(String name, String producer, int release) {
        this.name = name;
        this.producer = producer;
        this.release = release;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getRelease() {
        return release;
    }

    public void setRelease(int release) {
        this.release = release;
    }
}
