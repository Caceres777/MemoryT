package com.example.owen.pruebasliderfragment.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.owen.pruebasliderfragment.JavaBean.BeanCursos;
import com.example.owen.pruebasliderfragment.JavaBean.BeanPreguntas;
import com.example.owen.pruebasliderfragment.JavaBean.BeanRespuestas;
import com.example.owen.pruebasliderfragment.JavaBean.BeanTemas;
import com.example.owen.pruebasliderfragment.data.DataEntry.CursosEntry;
import com.example.owen.pruebasliderfragment.data.DataEntry.PreguntasEntry;
import com.example.owen.pruebasliderfragment.data.DataEntry.RespuestasEntry;
import com.example.owen.pruebasliderfragment.data.DataEntry.TemasEntry;

import java.util.ArrayList;

/**
 * Created by CHUFASCHIN on 29/01/2015.
 */
public class DataSource {

    private Context mContext;
    private Ayudante mSQLiteHelper ;
    boolean insertado = false;
    boolean borrado = false;
    boolean actualizado = false;

    /**
     * Consultas a la base de datos
     */
    private static String CONSULTA_CURSOS_BY_IDPARSE = "SELECT * FROM "+CursosEntry.TABLE_NAME+" WHERE "+CursosEntry.ID_PARSE+" = ";
    private static String CONSULTA_SELECTALL_CURSOS = "SELECT * FROM "+CursosEntry.TABLE_NAME;
    private static String CONSULTA_TEMAS_BY_IDPARSE = "SELECT * FROM "+TemasEntry.TABLE_NAME+" WHERE "+TemasEntry.ID_PARSE+" = ";
    private static String CONSULTA_SELECTALL_TEMAS = "SELECT * FROM "+TemasEntry.TABLE_NAME+" WHERE "+TemasEntry.FK_ID_COURSE+" = ";
    private static String CONSULTA_PREGUNTA_BY_IDPARSE = "SELECT * FROM "+PreguntasEntry.TABLE_NAME+" WHERE "+PreguntasEntry.ID_PARSE+" = ";
    private static String CONSULTA_SELECTALL_PREGUNTAS = "SELECT * FROM "+PreguntasEntry.TABLE_NAME+" WHERE "+PreguntasEntry.FK_ID_THEME+" = ";
    private static String CONSULTA_SELECTALL_RESPUESTAS = "SELECT * FROM "+RespuestasEntry.TABLE_NAME+" WHERE "+RespuestasEntry.FK_ID_THEME+" = ";
    private static String CONSULTA_SELECT_RESPUESTAS_CORRECTA = "SELECT * FROM "+RespuestasEntry.TABLE_NAME+" WHERE "+RespuestasEntry.FK_ID_QUESTION+" = ";
    private static String CONSULTA_SELECT_RESPUESTAS_INCORRECTAS = "SELECT * FROM "+RespuestasEntry.TABLE_NAME+" WHERE "+RespuestasEntry.FK_ID_QUESTION+" != ";

    public DataSource(Context context) {
        mContext = context;
        mSQLiteHelper = new Ayudante(mContext);

    }
    public SQLiteDatabase openReadable() {
        return mSQLiteHelper.getReadableDatabase();
    }
    public SQLiteDatabase openWriteable() {
        return mSQLiteHelper.getWritableDatabase();
    }
    public void close(SQLiteDatabase database) {
        database.close();
    }

    /**
     * Metodo encargado de hacer insert en la tabla de cursos
     * @param curso
     * @return boolean
     */
    public boolean insertContactCursos(BeanCursos curso) {
        SQLiteDatabase database = this.openWriteable();
        database.beginTransaction();
        ContentValues args = new ContentValues();

        args.put(CursosEntry.ID_PARSE, curso.getID_PARSE());
        args.put(CursosEntry.DEFINITION, curso.getDEFINITION());
        args.put(CursosEntry.NAME, curso.getNAME());
        args.put(String.valueOf(CursosEntry.ACCURACY), curso.getACCURACY());
        args.put(CursosEntry.PROGRESS, curso.getPROGRESS());
        args.put(CursosEntry.IMAGE, curso.getIMAGE());

        database.insert(new CursosEntry().getTABLE_NAME(), null, args);
        database.setTransactionSuccessful();
        database.endTransaction();
        this.close(database);
        return insertado=true;
    }

    /**
     * Inserta en la tabla temas de la base de datos local
     * @param tema
     * @return
     */
    public boolean insertContactTemas(BeanTemas tema) {
        SQLiteDatabase database = this.openWriteable();
        database.beginTransaction();
        ContentValues args = new ContentValues();

        args.put(TemasEntry.ID_PARSE, tema.getID_PARSE());
        args.put(TemasEntry.NAME, tema.getNAME());
        args.put(TemasEntry.FK_ID_COURSE, tema.getFK_ID_COURSE());
        args.put(TemasEntry.ACCURACY, tema.getACCURACY());
        args.put(TemasEntry.PROGRESS, tema.getPROGRESS());
        args.put(TemasEntry.POSITION, tema.getPOSITION());

        database.insert(new TemasEntry().getTableName(), null, args);
        database.setTransactionSuccessful();
        database.endTransaction();
        this.close(database);
        return insertado=true;
    }

    public boolean insertContactPreguntas(BeanPreguntas pregunta) {
        SQLiteDatabase database = this.openWriteable();
        database.beginTransaction();
        ContentValues args = new ContentValues();

        args.put(PreguntasEntry.FK_ID_THEME, pregunta.getFK_ID_THEME());
        args.put(PreguntasEntry.ID_PARSE, pregunta.getPARSE_ID());
        args.put(PreguntasEntry.TEXT, pregunta.getTEXT());
        args.put(String.valueOf(PreguntasEntry.DONE), String.valueOf(pregunta.getDONE()));
        args.put(String.valueOf(PreguntasEntry.RIGHT), String.valueOf(pregunta.getRIGHT()));
        args.put(String.valueOf(PreguntasEntry.WRONG), String.valueOf(pregunta.getWRONG()));

        database.insert(PreguntasEntry.TABLE_NAME, null, args);
        database.setTransactionSuccessful();
        database.endTransaction();
        this.close(database);
        return insertado=true;
    }

    public boolean insertContactRespuestas(BeanRespuestas respuesta) {
        SQLiteDatabase database = this.openWriteable();
        database.beginTransaction();
        ContentValues args = new ContentValues();

        args.put(RespuestasEntry.FK_ID_QUESTION, respuesta.getFK_ID_QUESTION());
        args.put(RespuestasEntry.FK_ID_THEME, respuesta.getFK_ID_THEME());
        args.put(RespuestasEntry.TEXT, respuesta.getTEXT());

        database.insert(RespuestasEntry.TABLE_NAME, null, args);
        database.setTransactionSuccessful();
        database.endTransaction();
        this.close(database);
        return insertado=true;

    }

    public ArrayList<BeanCursos> getCursos(){
        ArrayList<BeanCursos> cursos = new ArrayList<BeanCursos>();
        SQLiteDatabase db = this.openReadable();
        Cursor c = db.rawQuery(CONSULTA_SELECTALL_CURSOS, null);
        if(c.moveToFirst()) {
            for (int i = 0; i < c.getCount(); i++) {
                cursos.add(new BeanCursos(c.getInt(0), c.getString(1), c.getString(3), c.getString(2), c.getInt(4), c.getBlob(6), c.getInt(5)));
            }
        }
        c.close();
        this.close(db);
        return cursos;
    }

    public ArrayList<BeanTemas> getTemas(int IDCourse){
        ArrayList<BeanTemas> temas = new ArrayList<BeanTemas>();
        SQLiteDatabase db = this.openReadable();
        Cursor c = db.rawQuery(CONSULTA_SELECTALL_TEMAS+IDCourse, null);
        if(c.moveToFirst()) {
            for (int i = 0; i < c.getCount(); i++) {
                temas.add(new BeanTemas(c.getInt(0), c.getString(1), c.getInt(5), c.getString(2), c.getInt(3), c.getInt(4), c.getInt(5)));
                c.moveToNext();
            }
        }
        c.close();
        this.close(db);
        return temas;
    }


    public ArrayList<BeanPreguntas> getPreguntas(int IDChapter){
        ArrayList<BeanPreguntas> preguntas = new ArrayList<BeanPreguntas>();
        SQLiteDatabase db = this.openReadable();
        Cursor c = db.rawQuery(CONSULTA_SELECTALL_PREGUNTAS+IDChapter, null);
        Log.d("PREGUNTAS", String.valueOf(c.getCount()));
        if(c.moveToFirst()) {
            for (int i = 0; i < c.getCount(); i++) {
                preguntas.add(new BeanPreguntas(c.getInt(0), c.getString(1), c.getInt(2), c.getString(3), c.getInt(4) > 0, c.getInt(5), c.getInt(6)));
                c.moveToNext();
            }
        }
        c.close();
        this.close(db);
        return preguntas;
    }


    public ArrayList<BeanRespuestas> getRespuestas(int IDChapter){
        ArrayList<BeanRespuestas> respuestas = new ArrayList<BeanRespuestas>();
        SQLiteDatabase db = this.openReadable();
        Cursor c = db.rawQuery(CONSULTA_SELECTALL_RESPUESTAS+IDChapter, null);
        if(c.moveToFirst()) {
            for (int i = 0; i < c.getCount(); i++) {
                respuestas.add(new BeanRespuestas(c.getInt(0), c.getInt(1), c.getInt(2), c.getString(3)));
                c.moveToNext();
            }
        }
        c.close();
        this.close(db);
        return respuestas;
    }


    public BeanRespuestas getRespuestaCorrecta(int IDQuestion){
        BeanRespuestas respuesta = null;
        SQLiteDatabase db = this.openReadable();
        Cursor c = db.rawQuery(CONSULTA_SELECT_RESPUESTAS_CORRECTA+IDQuestion, null);
        if(c.moveToFirst()) {
            respuesta = new BeanRespuestas(c.getInt(0), c.getInt(1), c.getInt(2), c.getString(3));
        }
        c.close();
        this.close(db);
        return respuesta;
    }


    public ArrayList<BeanRespuestas>  getRespuestasIncorrectas(int IDQuestion){
        ArrayList<BeanRespuestas> respuestas = new ArrayList<BeanRespuestas>();
        SQLiteDatabase db = this.openReadable();
        Cursor c = db.rawQuery(CONSULTA_SELECT_RESPUESTAS_INCORRECTAS+IDQuestion, null);
        if(c.moveToFirst()) {
            for (int i = 0; i < c.getCount(); i++) {
                Log.d("ANSWER", c.getString(3));
                respuestas.add(new BeanRespuestas(c.getInt(0), c.getInt(1), c.getInt(2), c.getString(3)));
                c.moveToNext();
            }
        }
        c.close();
        this.close(db);
        return respuestas;
    }


    public BeanCursos getCursoByPARSE_ID(String parse_id){
        SQLiteDatabase db = this.openReadable();
        BeanCursos curso = null;
        Cursor c = db.rawQuery(CONSULTA_CURSOS_BY_IDPARSE+"'"+parse_id+"'", null);
        if(c.moveToFirst()) {
            curso = new BeanCursos(c.getInt(0), c.getString(1), c.getString(3), c.getString(2), c.getInt(4), c.getBlob(6), c.getInt(5));
        }
        c.close();
        this.close(db);
        return curso;
    }

    public BeanTemas getTemasByPARSE_ID(String parse_id){
        SQLiteDatabase db = this.openReadable();
        BeanTemas tema = null;
        Cursor c = db.rawQuery(CONSULTA_TEMAS_BY_IDPARSE+"'"+parse_id+"'", null);
        if(c.moveToFirst()) {
            tema = new BeanTemas(c.getInt(0), c.getString(1), c.getInt(5), c.getString(2), c.getInt(3), c.getInt(4), c.getInt(5));
        }
        c.close();
        this.close(db);
        return tema;
    }

    public BeanPreguntas getPreguntasByParse_ID(String parse_id){
        SQLiteDatabase db = this.openReadable();
        BeanPreguntas pregunta = null;
        Cursor c = db.rawQuery(CONSULTA_PREGUNTA_BY_IDPARSE+"'"+parse_id+"'", null);
        if(c.moveToFirst()){
            pregunta = new BeanPreguntas(c.getInt(0), c.getString(1), c.getInt(2), c.getString(3), c.getInt(4)>0, c.getInt(5), c.getInt(6));
        }
        c.close();
        this.close(db);
        return pregunta;
    }


    public void updatePreguntaRight(BeanPreguntas pregunta, int right){
        SQLiteDatabase db = this.openReadable();
        ContentValues args = new ContentValues();

        args.put(PreguntasEntry.FK_ID_THEME, pregunta.getFK_ID_THEME());
        args.put(PreguntasEntry.ID_PARSE, pregunta.getPARSE_ID());
        args.put(PreguntasEntry.TEXT, pregunta.getTEXT());
        args.put(String.valueOf(PreguntasEntry.DONE), String.valueOf(pregunta.getDONE()));
        args.put(String.valueOf(PreguntasEntry.RIGHT), right);
        args.put(String.valueOf(PreguntasEntry.WRONG), String.valueOf(pregunta.getWRONG()));
        db.update(PreguntasEntry.TABLE_NAME, args, PreguntasEntry.ID_QUESTION+" = ?", new String[] { String.valueOf(pregunta.getID_QUESTION()) });
        this.close(db);
    }

    public void updatePreguntaWrong(BeanPreguntas pregunta, int wrong){
        SQLiteDatabase db = this.openReadable();
        ContentValues args = new ContentValues();

        args.put(PreguntasEntry.FK_ID_THEME, pregunta.getFK_ID_THEME());
        args.put(PreguntasEntry.ID_PARSE, pregunta.getPARSE_ID());
        args.put(PreguntasEntry.TEXT, pregunta.getTEXT());
        args.put(String.valueOf(PreguntasEntry.DONE), String.valueOf(pregunta.getDONE()));
        args.put(String.valueOf(PreguntasEntry.RIGHT), String.valueOf(pregunta.getRIGHT()));
        args.put(String.valueOf(PreguntasEntry.WRONG), wrong);
        db.update(PreguntasEntry.TABLE_NAME, args, PreguntasEntry.ID_QUESTION+" = ?", new String[] { String.valueOf(pregunta.getID_QUESTION()) });
        this.close(db);
    }

}
