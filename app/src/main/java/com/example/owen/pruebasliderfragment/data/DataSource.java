package com.example.owen.pruebasliderfragment.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.owen.pruebasliderfragment.JavaBean.BeanCursos;
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
        args.put(CursosEntry.IMAGE, curso.getIMAGE());

        database.insert(new CursosEntry().getTABLE_NAME(), null, args);
        database.setTransactionSuccessful();
        database.endTransaction();
        database.close();
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
        args.put(TemasEntry.POSITION, tema.getPOSITION());

        database.insert(new TemasEntry().getTableName(), null, args);
        database.setTransactionSuccessful();
        database.endTransaction();
        database.close();
        return insertado=true;
    }

    public boolean insertContactPreguntas(PreguntasEntry pregunta) {
        SQLiteDatabase database = this.openWriteable();
        database.beginTransaction();
        ContentValues args = new ContentValues();

        args.put(PreguntasEntry.FK_ID_THEME, pregunta.getIdTheme());
        args.put(PreguntasEntry.TEXT, pregunta.getText());
        args.put(String.valueOf(PreguntasEntry.DONE), String.valueOf(pregunta.getDone()));
        args.put(String.valueOf(PreguntasEntry.RIGHT), String.valueOf(pregunta.getRight()));
        args.put(String.valueOf(PreguntasEntry.WRONG), String.valueOf(pregunta.getWrong()));

        database.insert(pregunta.getTableName(), null, args);
        database.setTransactionSuccessful();
        database.endTransaction();
        database.close();
        return insertado=true;
    }

    public boolean insertContactRespuestas(RespuestasEntry respuesta) {
        SQLiteDatabase database = this.openWriteable();
        database.beginTransaction();
        ContentValues args = new ContentValues();

        long insercion;

        args.put(RespuestasEntry.FK_ID_QUESTION, respuesta.getFkIdQuestion());
        args.put(RespuestasEntry.FK_ID_THEME, respuesta.getFkIdTheme());
        args.put(RespuestasEntry.TEXT, respuesta.getText());

        database.insert(respuesta.getTableName(), null, args);
        database.setTransactionSuccessful();
        database.endTransaction();
        database.close();
        return insertado=true;

    }

    public ArrayList<BeanCursos> getCursos(){
        ArrayList<BeanCursos> cursos = null;
        SQLiteDatabase db = this.openReadable();
        Cursor c = db.rawQuery(CONSULTA_SELECTALL_CURSOS, null);
        for(int i = 0; i < c.getCount(); i++) {
            cursos.add(new BeanCursos(c.getInt(0), c.getString(1), c.getString(3), c.getString(2), c.getInt(4), c.getBlob(5)));
        }
        c.close();
        db.close();
        return cursos;
    }


    public BeanCursos getCursoByPARSE_ID(String parse_id){
        SQLiteDatabase db = this.openReadable();
        BeanCursos curso = null;
        Cursor c = db.rawQuery(CONSULTA_CURSOS_BY_IDPARSE+"'"+parse_id+"'", null);
        if(c.moveToFirst()) {
            curso = new BeanCursos(c.getInt(0), c.getString(1), c.getString(3), c.getString(2), c.getInt(4), c.getBlob(5));
        }
        c.close();
        db.close();
        return curso;
    }

    public BeanTemas getTemasByPARSE_ID(String parse_id){
        SQLiteDatabase db = this.openReadable();
        BeanTemas tema = null;
        Cursor c = db.rawQuery(CONSULTA_TEMAS_BY_IDPARSE+"'"+parse_id+"'", null);
        if(c.moveToFirst()) {
            //tema = new BeanCursos(c.getInt(0), c.getString(1), c.getString(3), c.getString(2), c.getInt(4), c.getBlob(5));
        }
        c.close();
        db.close();
        return tema;
    }

//    public boolean insertContactUsuarios(int idUser, String name, int exp, Blob avatar, String email, String pass) {
//        DataSource dataSource = null;
//        SQLiteDatabase database = dataSource.openWriteable();
//        database.beginTransaction();
//        ContentValues args = new ContentValues();
//
//        args.put(ContactBean.UsuariosEntry.getColumnIdUser(), idUser);
//        args.put(ContactBean.UsuariosEntry.getColumnName(), name);
//        args.put(ContactBean.UsuariosEntry.getColumnExp(), exp);
//        args.put(ContactBean.UsuariosEntry.getColumnAvatar(), String.valueOf(avatar));
//        args.put(ContactBean.UsuariosEntry.getColumnMail(), email);
//        args.put(ContactBean.UsuariosEntry.getColumnPassword(), pass);
//        database.insert(ContactBean.UsuariosEntry.getTableName(), null, args);
//        database.setTransactionSuccessful();
//        database.endTransaction();
//        database.close();
//        return insertado=true;
//    }

//    public boolean borrarContactoUsuario(long rowId) {
//        DataSource dataSource = null;
//        SQLiteDatabase database = dataSource.openWriteable();
//        database.beginTransaction();
//        database.delete(ContactBean.UsuariosEntry.getTableName(),
//                String.format("%s=%d", BaseColumns._ID, rowId),
//                null);
//        database.setTransactionSuccessful();
//        database.endTransaction();
//        database.close();
//        return actualizado=true;
//    }

}
