package com.example.restoran;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
/*
Laudade jaoks klass, mille järgi saab isendeid luua.
 */

public class Laud {
    private int id;
    private int kohad;
    private List<String> tsoon;
    private int x;
    private int y;
    private int width;
    private int height;
    private String kujund;

    public Laud(int id, int kohad, List<String> tsoon, int x, int y, int width, int height, String kujund) {

        this.id = id;
        this.kohad = kohad;
        this.tsoon = tsoon;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.kujund = kujund;
    }

}