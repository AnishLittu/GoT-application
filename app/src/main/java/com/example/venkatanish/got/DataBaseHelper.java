package com.example.venkatanish.got;

        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;
/**
 * Created by venkatanish on 06/11/17.
 */

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Game_of_thrones.db";
    public static final String KINGDOMS = "KINGDOMS";
    public static final String KNAME = "NAME";
    public static final String KRULER= "RULER";
    public static final String KHOUSE = "HOUSE";

    public static final String CHARACTERS = "CHARACTERS";
    public static final String FNAME= "FNAME";
    public static final String LNAME= "LNAME";
    public static final String CHOUSE= "HOUSE";
    public static final String CKINGDOM= "KINGDOM";
    public static final String STATUS= "STATUS";
    public static final String DOA= "DOA";

    public static final String RULERS = "RULERS";
    public static final String RNAME = "RNAME";
    public static final String RHOUSE = "HOUSE";
    public static final String RKINGDOM = "NAME";
    public static final String PREDECESSOR = "SURNAME";

    public static final String HOUSES= "HOUSES";
    public static final String HNAME= "HNAME";
    public static final String SIGIL= "SIGIL";
    public static final String HRULER= "HRULER";
    public static final String HKINGDOM= "HKINGDOM";




    public DataBaseHelper(Context context) {
        super(context,DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE HOUSES(HNAME varchar,SIGIL varchar,HRULER varchar,HKINGDOM varchar;");
        db.execSQL("CREATE TABLE KINGDOMS(KNAME varchar,KRULER varchar,KHOUSE varchar;");
        db.execSQL("CREATE TABLE RULERS(RNAME varchar,RHOUSE varchar,RKINGDOM varchar,PREDECESSOR varchar;");
        db.execSQL("CREATE TABLE "+CHARACTERS+"("+FNAME+" varchar,"+LNAME+" varchar,"+CHOUSE+ "varchar,"+CKINGDOM+" varchar,"+STATUS +"varchar,"+DOA +"varchar;");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+CHARACTERS);
        onCreate(db);

    }


    public void insertdata(String hname, String sigil, String hruler, String hkingdom) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("HNAME", hname);
        contentValues.put("SIGIL", sigil);
        contentValues.put("HRULER", hruler);
        contentValues.put("HKINGDOM", hkingdom);

         db.insert("HOUSES", null, contentValues);
        //return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+HOUSES,null);
        return res;
    }
}
