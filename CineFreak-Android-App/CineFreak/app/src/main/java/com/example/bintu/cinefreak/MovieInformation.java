package com.example.bintu.cinefreak;

/**
 * Created by bintu on 2/6/2017.
 */

public class MovieInformation {

    public static String name,actor,actress,link,rating;
    public MovieInformation()
    {

    }
    public MovieInformation(String name,String actor,String actress,String link,String rating)
    {
       this.rating=rating;
        this.name=name;
        this.actor=actor;
        this.actress=actress;
        this.link=link;

    }

    public String getRating()
    {
        return this.rating;
    }
    public void setId(String rating )
    {
        this.rating=rating;
    }

    public String getActor()
    {
        return this.actor;
    }
    public void setActor(String actor)

    {
        this.actor=actor;
    }
    public String getActress()
    {
        return this.actress;
    }
    public void setActress(String actress)

    {
        this.actress=actress;
    }
    public String getLink()
    {
        return this.link;
    }
    public void setLink(String link)

    {
        this.link=link;
    }
    public String getName()
    {
        return this.name;
    }
    public void setName(String name)

    {
        this.name=name;
    }

}
