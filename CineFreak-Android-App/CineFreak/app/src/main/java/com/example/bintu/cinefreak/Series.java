package com.example.bintu.cinefreak;

/**
 * Created by bintu on 1/28/2017.
 */

public class Series {

    private int id;
    private String Seriesname;


    public Series() {

    }

    public Series(String Seriesname) {
        this.Seriesname = Seriesname;
    }

    public int get_id() {
        return id;
    }

    public void set_id(int _id) {
        this.id = _id;
    }

    public String get_series1name() {
        return Seriesname;
    }

    public void set_Seriesname(String _Seriesname)
    {
        this.Seriesname = Seriesname;
    }

}
