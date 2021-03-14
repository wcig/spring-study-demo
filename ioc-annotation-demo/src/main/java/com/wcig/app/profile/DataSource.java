package com.wcig.app.profile;

public class DataSource {
    private String name;

    public DataSource(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DataSource{" +
                "name='" + name + '\'' +
                '}';
    }
}
