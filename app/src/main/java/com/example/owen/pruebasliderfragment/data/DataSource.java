package com.example.owen.pruebasliderfragment.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.owen.pruebasliderfragment.JavaBean.BeanCursos;
import com.example.owen.pruebasliderfragment.JavaBean.BeanTemas;
import com.example.owen.pruebasliderfragment.data.DataEntry.CursosEntry;
import com.example.owen.pruebasliderfragment.data.DataEntry.PreguntasEntry;
import com.example.owen.pruebasliderfragment.data.DataEntry.RespuestasEntry;
import com.example.owen.pruebasliderfragment.data.DataEntry.TemasEntry;

/**
 * Created by CHUFASCHIN on 29/01/2015.
 */
public class DataSource {
    private Context mContext;
    private Ayudante mSQLiteHelper ;
    boolean insertado = false;
    boolean borrado = false;
    boolean actualizado = false;
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
        DataSource dataSource = new DataSource(mContext);
        SQLiteDatabase database = dataSource.openWriteable();
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
        DataSource dataSource = null;
        SQLiteDatabase database = dataSource.openWriteable();
        database.beginTransaction();
        ContentValues args = new ContentValues();

        args.put(TemasEntry.ID_THEME, tema.getID_THEME());
        args.put(TemasEntry.ID_PARSE, tema.getID_PARSE());
        args.put(TemasEntry.NAME, tema.getNAME());
        args.put(TemasEntry.FK_ID_COURSE, tema.getFK_ID_COURSE());
        args.put(TemasEntry.ACCURACY, tema.getACCURACY());
        args.put(TemasEntry.ACCURACY, tema.getPOSITION());
        database.insert(new TemasEntry().getTableName(), null, args);
        database.setTransactionSuccessful();
        database.endTransaction();
        database.close();
        return insertado=true;
    }

    public boolean insertContactPreguntas(PreguntasEntry pregunta) {
        DataSource dataSource = null;
        SQLiteDatabase database = dataSource.openWriteable();
        database.beginTransaction();
        ContentValues args = new ContentValues();

        args.put(PreguntasEntry.ID_QUESTION, pregunta.getIdQuestion());
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
        DataSource dataSource = null;
        SQLiteDatabase database = dataSource.openWriteable();
        database.beginTransaction();
        ContentValues args = new ContentValues();

        long insercion;

        args.put(RespuestasEntry.ID_ANSWER, respuesta.getIdAnswer());
        args.put(RespuestasEntry.FK_ID_QUESTION, respuesta.getFkIdQuestion());
        args.put(RespuestasEntry.FK_ID_THEME, respuesta.getFkIdTheme());
        args.put(RespuestasEntry.TEXT, respuesta.getText());
        database.insert(respuesta.getTableName(), null, args);
        database.setTransactionSuccessful();
        database.endTransaction();
        database.close();
        return insertado=true;

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
