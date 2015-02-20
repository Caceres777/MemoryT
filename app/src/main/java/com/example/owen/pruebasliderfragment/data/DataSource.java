package com.example.owen.pruebasliderfragment.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

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
    public boolean insertContactCursos(int idCurso, String name) {
        DataSource dataSource = null;
        SQLiteDatabase database = dataSource.openWriteable();
        database.beginTransaction();
        ContentValues args = new ContentValues();

        args.put(ContactBean.CursosEntry.getColumnIdCurso(), idCurso);
        args.put(ContactBean.CursosEntry.getColumnNombre(), name);
        database.insert(ContactBean.CursosEntry.getTableName(), null, args);
        database.setTransactionSuccessful();
        database.endTransaction();
        database.close();
        return insertado=true;
    }
    public boolean insertContactTemas(int idTema, String name, int fk_idCurso) {
        DataSource dataSource = null;
        SQLiteDatabase database = dataSource.openWriteable();
        database.beginTransaction();
        ContentValues args = new ContentValues();

        args.put(ContactBean.TemasEntry.getColumnIdTema(), idTema);
        args.put(ContactBean.TemasEntry.getColumnNombre(), name);
        args.put(ContactBean.TemasEntry.getColumnIdCurso(), fk_idCurso);
        database.insert(ContactBean.TemasEntry.getTableName(), null, args);
        database.setTransactionSuccessful();
        database.endTransaction();
        database.close();
        return insertado=true;
    }
    public boolean insertContactPreguntas(int idPregunta, String name, int fk_idTema) {
        DataSource dataSource = null;
        SQLiteDatabase database = dataSource.openWriteable();
        database.beginTransaction();
        ContentValues args = new ContentValues();

        args.put(ContactBean.PreguntasEntry.getColumnIdPregunta(), idPregunta);
        args.put(ContactBean.PreguntasEntry.getColumnNombre(), name);
        args.put(ContactBean.PreguntasEntry.getColumnIdTema(), fk_idTema);
        database.insert(ContactBean.PreguntasEntry.getTableName(), null, args);
        database.setTransactionSuccessful();
        database.endTransaction();
        database.close();
        return insertado=true;
    }
    public boolean insertContactRespuestas(int idRespuesta, String name, int fk_idPregunta, int fk_idTema) {
        DataSource dataSource = null;
        SQLiteDatabase database = dataSource.openWriteable();
        database.beginTransaction();
        ContentValues args = new ContentValues();

        long insercion;

        args.put(ContactBean.RespuestasEntry.getColumnIdRespuesta(), idRespuesta);
        args.put(ContactBean.RespuestasEntry.getColumnNombre(), name);
        args.put(ContactBean.RespuestasEntry.getColumnIdPregunta(), fk_idPregunta);
        args.put(ContactBean.RespuestasEntry.getColumnIdTema(), fk_idTema);
        database.insert(ContactBean.RespuestasEntry.getTableName(), null, args);
        database.setTransactionSuccessful();
        database.endTransaction();
        database.close();
        return insertado=true;

    }

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
