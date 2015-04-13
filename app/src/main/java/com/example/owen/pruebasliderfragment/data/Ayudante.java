package com.example.owen.pruebasliderfragment.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.owen.pruebasliderfragment.data.SQLContract.*;

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
            "CREATE TABLE "+ CourseEntry.TABLE_NAME +"( " +
                    CourseEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                    CourseEntry.ID_PARSE+ " TEXT NOT NULL,"+
                    CourseEntry.NAME + " TEXT NOT NULL,"+
                    CourseEntry.DEFINITION + " TEXT,"+
                    CourseEntry.PROGRESS+" INTEGER,"+
                    CourseEntry.IMAGE +" BLOB);";


    static final String CREATE_TABLE_CONTACT_TEMAS =
            "CREATE TABLE "+ ChapterEntry.TABLE_NAME +"( " +
                    ChapterEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                    ChapterEntry.ID_PARSE + " TEXT,"+
                    ChapterEntry.NAME +" TEXT," +
                    ChapterEntry.ACCURACY +" INTEGER,"+
                    ChapterEntry.FK_ID_COURSE + " INTEGER ,"+
                    ChapterEntry.POSITION + " INTEGER ,"+
                    CourseEntry.PROGRESS+" INTEGER,"+
                    "FOREIGN KEY("+ChapterEntry.FK_ID_COURSE+") REFERENCES "+ChapterEntry.TABLE_NAME+"("+CourseEntry.ID+"));";


    static final String CREATE_TABLE_CONTACT_BADGES =
            "CREATE TABLE "+ BadgesEntry.TABLE_NAME +"( " +
                    BadgesEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                    BadgesEntry.ID_PARSE + " TEXT,"+
                    BadgesEntry.FK_ID_COURSE + " INTEGER ," +
                    BadgesEntry.IMAGE +" BLOB,"+
                    BadgesEntry.TITLE +" TEXT,"+
                    BadgesEntry.TEXT +" TEXT,"+
                    "FOREIGN KEY("+BadgesEntry.FK_ID_COURSE+") REFERENCES "+CourseEntry.TABLE_NAME+"("+CourseEntry.ID+"));";


    static final String CREATE_TABLE_CONTACT_PREGUNTAS =
            "CREATE TABLE "+ QuestionEntry.TABLE_NAME +"( " +
                    QuestionEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                    QuestionEntry.ID_PARSE + " TEXT,"+
                    QuestionEntry.FK_ID_THEME + " INTEGER," +
                    QuestionEntry.TEXT1 +" TEXT1,"+
                    QuestionEntry.TEXT2 +" TEXT2,"+
                    QuestionEntry.TOTAL +" INTEGER,"+
                    QuestionEntry.IMAGE +" BLOB,"+
                    QuestionEntry.EF +" NUMERIC,"+
                    QuestionEntry.WRONG +" INTEGER,"+
                    "FOREIGN KEY("+QuestionEntry.FK_ID_THEME+") REFERENCES "+ChapterEntry.TABLE_NAME+"("+ChapterEntry.ID+"));";






    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_TABLE_CONTACT_CURSOS);
            db.execSQL(CREATE_TABLE_CONTACT_TEMAS);
            db.execSQL(CREATE_TABLE_CONTACT_BADGES);
            db.execSQL(CREATE_TABLE_CONTACT_PREGUNTAS);
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
            onCreate(db);
        }
    }


}

