package com.example.owen.pruebasliderfragment.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

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
                    CursosEntry.NAME + " VARCHAR NOT NULL,"+
                    CursosEntry.DEFINITION + " VARCHAR,"+
                    CursosEntry.ACCURACY +" INTEGER,"+
                    CursosEntry.IMAGE +" BLOB);";


    static final String CREATE_TABLE_CONTACT_TEMAS =
            "CREATE TABLE "+ TemasEntry.TABLE_NAME +"( " +
                    TemasEntry.ID_THEME + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                    TemasEntry.NAME +" VARCHAR," +
                    TemasEntry.ACCURACY +" INTEGER,"+
                    TemasEntry.FK_ID_COURSE + " INTEGER ,"+
                    "FOREIGN KEY("+TemasEntry.FK_ID_COURSE+") REFERENCES "+CursosEntry.TABLE_NAME+"("+CursosEntry.ID_COURSE+"));";

    static final String CREATE_TABLE_CONTACT_BADGES =
            "CREATE TABLE "+ BadgesEntry.TABLE_NAME +"( " +
                    BadgesEntry.ID_BADGE + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                    BadgesEntry.FK_ID_COURSE + " INTEGER ," +
                    BadgesEntry.IMAGE +" BLOB,"+
                    BadgesEntry.TITLE +" VARCHAR,"+
                    BadgesEntry.TEXT +" VARCHAR,"+
                    "FOREIGN KEY("+BadgesEntry.FK_ID_COURSE+") REFERENCES "+CursosEntry.TABLE_NAME+"("+CursosEntry.ID_COURSE+"));";

    static final String CREATE_TABLE_CONTACT_PREGUNTAS =
            "CREATE TABLE "+ PreguntasEntry.TABLE_NAME +"( " +
                    PreguntasEntry.ID_QUESTION + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                    PreguntasEntry.FK_ID_THEME + " INTEGER," +
                    PreguntasEntry.TEXT +" VARCHAR,"+
                    PreguntasEntry.DONE +" BOOLEAN,"+
                    PreguntasEntry.RIGHT +" BOOLEAN,"+
                    PreguntasEntry.WRONG +" BOOLEAN,"+
                    "FOREIGN KEY("+PreguntasEntry.FK_ID_THEME+") REFERENCES "+TemasEntry.TABLE_NAME+"("+TemasEntry.ID_THEME+"));";

    static final String CREATE_TABLE_CONTACT_RESPUESTAS =
            "CREATE TABLE "+ RespuestasEntry.TABLE_NAME +"( " +
                    RespuestasEntry.ID_ANSWER + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                    RespuestasEntry.FK_ID_QUESTION + " INTEGER," +
                    RespuestasEntry.FK_ID_THEME + " INTEGER," +
                    RespuestasEntry.TEXT +" VARCHAR,"+
                    "FOREIGN KEY("+RespuestasEntry.FK_ID_THEME+") REFERENCES "+TemasEntry.TABLE_NAME+"("+TemasEntry.ID_THEME+"),"+
                    "FOREIGN KEY("+RespuestasEntry.FK_ID_QUESTION+") REFERENCES "+PreguntasEntry.TABLE_NAME+"("+PreguntasEntry.ID_QUESTION+"));";


    /**
     * Consultas a la base de datos
     */
    static final String CONSULTA_SELECTALL_CURSOS = "SELECT * FROM "+CursosEntry.TABLE_NAME;



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

    public ArrayList<CursosEntry> getCursos(Context context){
        ArrayList<CursosEntry> cursos = null;
        DataSource ds = new DataSource(context);
        SQLiteDatabase db = ds.openReadable();
        Cursor c = db.rawQuery(CONSULTA_SELECTALL_CURSOS, null);
        for(int i = 0; i < c.getCount(); i++)
            Log.d("SQLDATA", c.getString(2));
        return cursos;
    }


    public void insertIntoCursos(){

    }
}


//    static final String CREATE_TABLE_CONTACT_USUARIOS =
//            "CREATE TABLE " + Contact.UsuariosEntry.TABLE_NAME + "( " +
//                    Contact.UsuariosEntry.COLUMN_ID_USER + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
//                    Contact.UsuariosEntry.COLUMN_NAME + " TEXT NOT NULL," +
//                    Contact.UsuariosEntry.COLUMN_EXP + " ," +
//                    Contact.UsuariosEntry.COLUMN_AVATAR + " ," +
//                    Contact.UsuariosEntry.COLUMN_MAIL + " NOT NULL," +
//                    Contact.UsuariosEntry.COLUMN_PASSWORD + " NOT NULL);";
