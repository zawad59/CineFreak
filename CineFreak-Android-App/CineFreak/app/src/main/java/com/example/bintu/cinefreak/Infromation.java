package com.example.bintu.cinefreak;

/**
 * Created by bintu on 1/26/2017.
 */

public class Infromation {
    /**
     * Created by bintu on 1/26/2017.
     */
        public static int id;
        public static String name,password,userid;
        public Infromation()
        {

        }
        public Infromation(String userid,String password,String name)
        {
            this.name=name;
            this.password=password;
            this.userid=userid;

        }
    public Infromation(int id,String userid,String password,String name)
    {
        this.name=name;
        this.password=password;
        this.userid=userid;
        this.id=id;

    }


        public int getId()
        {
            return this.id;
        }
        public void setId(int Id)
        {
            this.id=Id;
        }

        public String getName()
        {
            return this.name;
        }
        public void setName(String Name)

        {
            this.name=Name;
        }
        public void setUserid(String userid)
        {
            this.userid=userid;
        }
        public String getUserid()
        {
            return this.userid;
        }
        public void setPassword(String password)

        {
            this.password=password;
        }
        public String getPassword()
        {
            return this.password;
        }


    }

