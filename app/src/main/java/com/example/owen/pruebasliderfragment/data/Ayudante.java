package com.example.owen.pruebasliderfragment.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.owen.pruebasliderfragment.JavaBean.BeanCursos;
import com.example.owen.pruebasliderfragment.data.DataEntry.BadgesEntry;
import com.example.owen.pruebasliderfragment.data.DataEntry.CursosEntry;
import com.example.owen.pruebasliderfragment.data.DataEntry.PreguntasEntry;
import com.example.owen.pruebasliderfragment.data.DataEntry.RespuestasEntry;
import com.example.owen.pruebasliderfragment.data.DataEntry.TemasEntry;

import java.util.ArrayList;

/**
 * Created by CHUFASCHIN on 29/01/2015.
 */

public class Ayudante extends SQLiteOpenHelper {
    public Ayudante(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    static final String DATABASE_NAME = "MEMORYt";
    static final int DATABASE_VERSION = 1;
    private static final String TAG = "";

    static final String CREATE_TABLE_CONTACT_CURSOS =
            "CREATE TABLE "+ CursosEntry.TABLE_NAME +"( " +
                    CursosEntry.ID_COURSE + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                    CursosEntry.ID_PARSE+ " TEXT NOT NULL,"+
                    CursosEntry.NAME + " TEXT NOT NULL,"+
                    CursosEntry.DEFINITION + " TEXT,"+
                    CursosEntry.ACCURACY +" INTEGER,"+
                    CursosEntry.PROGRESS+" INTEGER,"+
                    CursosEntry.IMAGE +" BLOB);";


    static final String CREATE_TABLE_CONTACT_TEMAS =
            "CREATE TABLE "+ TemasEntry.TABLE_NAME +"( " +
                    TemasEntry.ID_THEME + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                    TemasEntry.ID_PARSE + " TEXT,"+
                    TemasEntry.NAME +" TEXT," +
                    TemasEntry.ACCURACY +" INTEGER,"+
                    TemasEntry.FK_ID_COURSE + " INTEGER ,"+
                    TemasEntry.POSITION + " INTEGER ,"+
                    CursosEntry.PROGRESS+" INTEGER,"+
                    "FOREIGN KEY("+TemasEntry.FK_ID_COURSE+") REFERENCES "+CursosEntry.TABLE_NAME+"("+CursosEntry.ID_COURSE+"));";

    static final String CREATE_TABLE_CONTACT_BADGES =
            "CREATE TABLE "+ BadgesEntry.TABLE_NAME +"( " +
                    BadgesEntry.ID_BADGE + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                    BadgesEntry.ID_PARSE + " TEXT,"+
                    BadgesEntry.FK_ID_COURSE + " INTEGER ," +
                    BadgesEntry.IMAGE +" BLOB,"+
                    BadgesEntry.TITLE +" TEXT,"+
                    BadgesEntry.TEXT +" TEXT,"+
                    "FOREIGN KEY("+BadgesEntry.FK_ID_COURSE+") REFERENCES "+CursosEntry.TABLE_NAME+"("+CursosEntry.ID_COURSE+"));";

    static final String CREATE_TABLE_CONTACT_PREGUNTAS =
            "CREATE TABLE "+ PreguntasEntry.TABLE_NAME +"( " +
                    PreguntasEntry.ID_QUESTION + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                    PreguntasEntry.ID_PARSE + " TEXT,"+
                    PreguntasEntry.FK_ID_THEME + " INTEGER," +
                    PreguntasEntry.TEXT +" TEXT,"+
                    PreguntasEntry.DONE +" BOOLEAN,"+
                    PreguntasEntry.RIGHT +" INTEGER,"+
                    PreguntasEntry.WRONG +" INTEGER,"+
                    "FOREIGN KEY("+PreguntasEntry.FK_ID_THEME+") REFERENCES "+TemasEntry.TABLE_NAME+"("+TemasEntry.ID_THEME+"));";

    static final String CREATE_TABLE_CONTACT_RESPUESTAS =
            "CREATE TABLE "+ RespuestasEntry.TABLE_NAME +"( " +
                    RespuestasEntry.ID_ANSWER + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                    RespuestasEntry.FK_ID_QUESTION + " INTEGER," +
                    RespuestasEntry.FK_ID_THEME + " INTEGER," +
                    RespuestasEntry.TEXT +" TEXT,"+
                    "FOREIGN KEY("+RespuestasEntry.FK_ID_THEME+") REFERENCES "+TemasEntry.TABLE_NAME+"("+TemasEntry.ID_THEME+"),"+
                    "FOREIGN KEY("+RespuestasEntry.FK_ID_QUESTION+") REFERENCES "+PreguntasEntry.TABLE_NAME+"("+PreguntasEntry.ID_QUESTION+"));";






    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_TABLE_CONTACT_CURSOS);
            db.execSQL(CREATE_TABLE_CONTACT_TEMAS);
            db.execSQL(CREATE_TABLE_CONTACT_BADGES);
            db.execSQL(CREATE_TABLE_CONTACT_PREGUNTAS);
            db.execSQL(CREATE_TABLE_CONTACT_RESPUESTAS);
        } catch (Exception e) {
            Log.e(TAG, "SQLException ", e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldOne, int newOne) {
        if (oldOne > 1 && newOne <= 0) {
            //-example
        } else {
//                db.createTable(db, CREATE_TABLE_CONTACT_USUARIOS);
//            db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_CONTACT_USUARIOS);
            db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_CONTACT_CURSOS);
            db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_CONTACT_TEMAS);
            db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_CONTACT_BADGES);
            db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_CONTACT_PREGUNTAS);
            db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_CONTACT_RESPUESTAS);
            onCreate(db);
        }
    }


}

