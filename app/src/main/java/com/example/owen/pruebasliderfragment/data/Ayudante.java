package com.example.owen.pruebasliderfragment.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

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

//    static final String CREATE_TABLE_CONTACT_USUARIOS =
//            "CREATE TABLE " + Contact.UsuariosEntry.TABLE_NAME + "( " +
//                    Contact.UsuariosEntry.COLUMN_ID_USER + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
//                    Contact.UsuariosEntry.COLUMN_NAME + " TEXT NOT NULL," +
//                    Contact.UsuariosEntry.COLUMN_EXP + " ," +
//                    Contact.UsuariosEntry.COLUMN_AVATAR + " ," +
//                    Contact.UsuariosEntry.COLUMN_MAIL + " NOT NULL," +
//                    Contact.UsuariosEntry.COLUMN_PASSWORD + " NOT NULL);";

    static final String CREATE_TABLE_CONTACT_CURSOS =
            "CREATE TABLE " + Contact.CursosEntry.TABLE_NAME + "( " +
                    Contact.CursosEntry.COLUMN_ID_CURSO + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                    Contact.CursosEntry.ACCURACY +"INTEGER"+
                    Contact.CursosEntry.ACABADO +"BOOLEAN"+
                    Contact.CursosEntry.COLUMN_NOMBRE + " NOT NULL);";

    static final String CREATE_TABLE_CONTACT_TEMAS =
            "CREATE TABLE " + Contact.TemasEntry.TABLE_NAME + "( " +
                    Contact.TemasEntry.COLUMN_ID_TEMA + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                    Contact.TemasEntry.COLUMN_ID_CURSO + " INTEGER ," +
                    Contact.TemasEntry.ACCURACY +"INTEGER"+
                    Contact.TemasEntry.ACABADO +"BOOLEAN"+
                    "FOREIGN KEY("+Contact.TemasEntry.COLUMN_ID_CURSO+") REFERENCES "+Contact.CursosEntry.TABLE_NAME+"("+Contact.CursosEntry.COLUMN_ID_CURSO+")"+
                    Contact.TemasEntry.COLUMN_NOMBRE + " NOT NULL);";

    static final String CREATE_TABLE_CONTACT_PREGUNTAS =
            "CREATE TABLE " + Contact.PreguntasEntry.TABLE_NAME + "( " +
                    Contact.PreguntasEntry.COLUMN_ID_PREGUNTA + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                    Contact.PreguntasEntry.COLUMN_ID_TEMA + " INTEGER," +
                    "FOREIGN KEY("+Contact.PreguntasEntry.COLUMN_ID_TEMA+") REFERENCES "+Contact.TemasEntry.TABLE_NAME+"("+Contact.TemasEntry.COLUMN_ID_TEMA+")"+
                    Contact.PreguntasEntry.COLUMN_NOMBRE + " NOT NULL);";

    static final String CREATE_TABLE_CONTACT_RESPUESTAS =
            "CREATE TABLE " + Contact.RespuestasEntry.TABLE_NAME + "( " +
                    Contact.RespuestasEntry.COLUMN_ID_RESPUESTA + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                    Contact.RespuestasEntry.COLUMN_ID_PREGUNTA + " INTEGER," +
                    Contact.RespuestasEntry.COLUMN_ID_TEMA + " INTEGER," +
                    "FOREIGN KEY("+Contact.RespuestasEntry.COLUMN_ID_TEMA+") REFERENCES "+Contact.TemasEntry.TABLE_NAME+"("+Contact.TemasEntry.COLUMN_ID_TEMA+")"+
                    "FOREIGN KEY("+Contact.RespuestasEntry.COLUMN_ID_PREGUNTA+") REFERENCES "+Contact.PreguntasEntry.TABLE_NAME+"("+Contact.PreguntasEntry.COLUMN_ID_PREGUNTA+")"+
                    Contact.RespuestasEntry.COLUMN_NOMBRE + " NOT NULL);";

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
//            db.execSQL(CREATE_TABLE_CONTACT_USUARIOS);
            db.execSQL(CREATE_TABLE_CONTACT_CURSOS);
            db.execSQL(CREATE_TABLE_CONTACT_TEMAS);
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
            db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_CONTACT_PREGUNTAS);
            db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_CONTACT_RESPUESTAS);
            onCreate(db);
        }
    }
}