package com.example.bintu.cinefreak;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by bintu on 1/26/2017.
 */

public class Databasehelper extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION=7;
    private static final String DATABASE_NAME="informationManager.db";

    private static final String TABLE_NAME="informations";
    private static final String TABLE_NAME2="movieinformations";
    private static final String COLUMN_MID="id";
    private static final String COLUMN_MNAME="mname";
    private static final String COLUMN_ACTOR="actor";
    private static final String COLUMN_ACTRESS="actress";
    private static final String COLUMN_LINK="link";
    private static final String COLUMN_RATING="rating";
    private static final String COLUMN_ID="id";
    private static final String COLUMN_USERNAME="userid";
    private static final String COLUMN_PASSWORD="pass";
    private static final String COLUMN_NAME="name";
    private static final String Column_Horror1="Horrorwa";
    private static final String Column_Romantic1="Romanticwa";
    private static final String Column_Scientific1="Scientificwa";
    private static final String Column_Thriller1="Thrillerwa";
    private static final String Column_Action1="Actionwa";
    private static final String Column_Comedy1="Comedywa";
    private static final String Column_Animation1="Animationwa";
    private static final String Column_Other="Otherwa";
    private static final String Column_Horror2="Horrorwi";
    private static final String Column_Romantic2="Romanticwi";
    private static final String Column_Scientific2="Scientificwi";
    private static final String Column_Thriller2="Thrillerwi";
    private static final String Column_Action2="Actionwi";
    private static final String Column_Comedy2="Comedywi";
    private static final String Column_Animation2="Animationwi";
    private static final String Column_Other2="Otherwi";
    SQLiteDatabase db;
    String TABLE_CREATE="CREATE TABLE "+ TABLE_NAME +"("+COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_USERNAME +" TEXT,"
            + COLUMN_PASSWORD +" TEXT,"+COLUMN_NAME+" TEXT,"+Column_Horror1+" TEXT,"+Column_Romantic1+" TEXT,"
            +Column_Scientific1+" TEXT,"+Column_Thriller1+" TEXT,"+Column_Action1+" TEXT,"+Column_Comedy1+" TEXT,"
            +Column_Animation1+" TEXT,"+Column_Other+" TEXT,"+Column_Horror2+" TEXT,"+Column_Romantic2+" TEXT,"
            +Column_Scientific2+" TEXT,"+Column_Thriller2+" TEXT,"+Column_Action2+" TEXT,"+Column_Comedy2+" TEXT,"
            +Column_Animation2+" TEXT,"+Column_Other2+" TEXT "
            +")";
    String movie_table="CREATE TABLE "+TABLE_NAME2+"("+COLUMN_MID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                       COLUMN_MNAME+" TEXT,"+COLUMN_ACTOR+" TEXT,"+COLUMN_ACTRESS+" TEXT,"+COLUMN_LINK+" TEXT,"
                       +COLUMN_RATING+" TEXT "+")";


    public Databasehelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){

               db.execSQL(TABLE_CREATE);
               db.execSQL(movie_table);
               this.db=db;

    }

    @Override

    public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME2);
        this.onCreate(db);

    }

    public boolean in(Infromation C)
    {
        db=this.getWritableDatabase();
        ContentValues value=new ContentValues();
        value.put(COLUMN_USERNAME,C.getUserid());
        value.put(COLUMN_PASSWORD,C.getPassword());
        value.put(COLUMN_NAME,C.getName());

        db.insert(TABLE_NAME,null,value);
        db.close();

        return true;

    }
    public void mo(MovieInformation M)
    {
        db=this.getWritableDatabase();
        ContentValues value=new ContentValues();
        value.put(COLUMN_MNAME,M.getName());
        value.put(COLUMN_ACTOR,M.getActor());
        value.put(COLUMN_ACTRESS,M.getActress());
        value.put(COLUMN_LINK,M.getLink());
        value.put(COLUMN_RATING,M.getRating());

        db.insert(TABLE_NAME2,null,value);
        db.close();


    }
    public void delete(String moviename) {
        db=this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME2 + " WHERE " + COLUMN_MNAME+ "=\"" + moviename + "\"";
        db.execSQL(query);
        db.close();
    }
    public void update(String moviename,String Category,String uid) {
        db=this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Category,moviename);
        db.update(TABLE_NAME, values, COLUMN_USERNAME+"="+uid,null);
        db.close();
    }



    public Infromation searchitem(String uname)
    {
        db=this.getReadableDatabase();
        String query="SELECT * FROM "+TABLE_NAME;
        Cursor cursor=db.rawQuery(query,null);
        String a,b;
        b="nothing found";
        Infromation in=new Infromation(" ","Not Found"," ");
        if(cursor!=null && cursor.moveToFirst())
        {

            do {
                a=cursor.getString(1);

                if(a.equals(uname))
                {

                     in= new Infromation(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2),cursor.getString(3));
                   // in.setId(Integer.parseInt(cursor.getString(0)));
                   // in.setPassword(cursor.getString(2));
                   // in.setName(cursor.getString(3));

                    break;
                }
            }while(cursor.moveToNext());
        }
        db.close();
        return in;

    }
    public MovieInformation searchMovieInfo(String moviename)
    {
        db=this.getReadableDatabase();
        String query="SELECT * FROM "+TABLE_NAME2;
        Cursor cursor=db.rawQuery(query,null);
        String a,b;
        b="nothing found";
        MovieInformation in=new MovieInformation(" "," "," "," "," ");
        if(cursor!=null && cursor.moveToFirst())
        {

            do {
                a=cursor.getString(1);

                if(a.equals(moviename))
                {

                    in= new MovieInformation(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5));
                    break;
                }
            }while(cursor.moveToNext());
        }
        db.close();
        return in;

    }
    //Add a new row to the database.
    public String addseries1(Series series1,String Uid,String Category) {
        db =this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME,Uid);
        String query="SELECT * FROM "+TABLE_NAME;
        Cursor cursor=db.rawQuery(query,null);
        String a,s=series1.get_series1name();
        int k=1;
        if(cursor!=null && cursor.moveToFirst())
        {

            do {
                a=cursor.getString(1);

                if(a.equals(Uid))
                {
                    if(cursor.getString(cursor.getColumnIndex(Category))!=null)
                    s=series1.get_series1name()+cursor.getString(cursor.getColumnIndex(Category));
                    //s="saw\n"+"aa\nbb";
                    values.put(Category,s);
                    db.update(TABLE_NAME, values, COLUMN_ID+"=?", new String[]{String.valueOf(cursor.getString(0))});
                    break;
                }
            }while(cursor.moveToNext());
            db.close();
        }
        db.close();
        return s;
        //Writing to database now.
    }
    public String displayMovie(String Uid,String Category)
    {
        db =this.getWritableDatabase();
        String query="SELECT * FROM "+TABLE_NAME;
        Cursor cursor=db.rawQuery(query,null);
        String a,s=" ";
        int k=0;
        if(cursor!=null && cursor.moveToFirst())
        {

            do {
                a=cursor.getString(1);

                if(a.equals(Uid))
                {
                    if(cursor.getString(cursor.getColumnIndex(Category))!=null)
                    s=cursor.getString(cursor.getColumnIndex(Category));
                    break;
                }
            }while(cursor.moveToNext());
            db.close();
        }
        return s;


    }

}
