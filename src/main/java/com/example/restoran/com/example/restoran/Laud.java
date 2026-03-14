package com.example.restoran;

import java.util.List;

public class Laud {
    private int id;
    private int kohad;
    private List<String> tsoon;

    public Laud(int id, int kohad, List<String> tsoon) {
        this.id = id;
        this.kohad = kohad;
        this.tsoon = tsoon;
    }

    public int getId() {
        return id;
    }

    public int getKohad() {
        return kohad;
    }

    public List<String> getTsoon() {
        return tsoon;
    }

}
