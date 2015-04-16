package com.example.owen.pruebasliderfragment.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.owen.pruebasliderfragment.JavaBean.BeanChapter;
import com.example.owen.pruebasliderfragment.JavaBean.BeanCourse;
import com.example.owen.pruebasliderfragment.JavaBean.BeanQuestions;
import com.example.owen.pruebasliderfragment.data.SQLContract.*;

import java.util.ArrayList;
import java.util.List;

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
    private static String CONSULTA_CURSOS_BY_IDPARSE = "SELECT * FROM "+CourseEntry.TABLE_NAME+" WHERE "+CourseEntry.ID_PARSE+" = ";
    private static String CONSULTA_SELECTALL_CURSOS = "SELECT * FROM "+CourseEntry.TABLE_NAME;
    private static String CONSULTA_SELECT_CURSO = "SELECT * FROM "+CourseEntry.TABLE_NAME+" WHERE "+CourseEntry.ID+" = ";
    private static String CONSULTA_TEMAS_BY_IDPARSE = "SELECT * FROM "+ChapterEntry.TABLE_NAME+" WHERE "+ChapterEntry.ID_PARSE+" = ";
    private static String CONSULTA_SELECTALL_TEMAS = "SELECT * FROM "+ChapterEntry.TABLE_NAME+" WHERE "+ChapterEntry.FK_ID_COURSE+" = ";
    private static String CONSULTA_SELECT_TEMA = "SELECT * FROM "+ChapterEntry.TABLE_NAME+" WHERE "+ChapterEntry.ID+" = ";
    private static String CONSULTA_PREGUNTA_BY_IDPARSE = "SELECT * FROM "+QuestionEntry.TABLE_NAME+" WHERE "+QuestionEntry.ID_PARSE+" = ";
    private static String CONSULTA_SELECTALL_PREGUNTAS = "SELECT * FROM "+QuestionEntry.TABLE_NAME+" WHERE "+QuestionEntry.FK_ID_THEME+" = ";
    private static String CONSULTA_SELECT_RESPUESTAS_INCORRECTAS = "SELECT * FROM "+QuestionEntry.TABLE_NAME+" WHERE "+QuestionEntry.FK_ID_THEME+" = ";

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
    public boolean insertContactCursos(BeanCourse curso) {
        SQLiteDatabase database = this.openWriteable();
        database.beginTransaction();
        ContentValues args = new ContentValues();

        args.put(CourseEntry.ID_PARSE, curso.getID_PARSE());
        args.put(CourseEntry.DEFINITION, curso.getDEFINITION());
        args.put(CourseEntry.NAME, curso.getNAME());
        args.put(CourseEntry.PROGRESS, curso.getPROGRESS());
        args.put(CourseEntry.IMAGE, curso.getIMAGE());

        database.insert(CourseEntry.TABLE_NAME, null, args);
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
    public boolean insertContactTemas(BeanChapter tema) {
        SQLiteDatabase database = this.openWriteable();
        database.beginTransaction();
        ContentValues args = new ContentValues();

        args.put(ChapterEntry.ID_PARSE, tema.getID_PARSE());
        args.put(ChapterEntry.NAME, tema.getNAME());
        args.put(ChapterEntry.FK_ID_COURSE, tema.getFK_ID_COURSE());
        args.put(ChapterEntry.ACCURACY, tema.getACCURACY());
        args.put(ChapterEntry.PROGRESS, tema.getPROGRESS());
        args.put(ChapterEntry.POSITION, tema.getPOSITION());

        database.insert(ChapterEntry.TABLE_NAME, null, args);
        database.setTransactionSuccessful();
        database.endTransaction();
        this.close(database);
        return insertado=true;
    }

    public boolean insertContactPreguntas(BeanQuestions pregunta) {
        SQLiteDatabase database = this.openWriteable();
        database.beginTransaction();
        ContentValues args = new ContentValues();

        args.put(QuestionEntry.FK_ID_THEME, pregunta.getFK_ID_THEME());
        args.put(QuestionEntry.ID_PARSE, pregunta.getPARSE_ID());
        args.put(QuestionEntry.TEXT1, pregunta.getTEXT1());
        args.put(QuestionEntry.TEXT2, pregunta.getTEXT2());
        args.put(String.valueOf(QuestionEntry.TOTAL), String.valueOf(pregunta.getTOTAL()));
        args.put(String.valueOf(QuestionEntry.WRONG), String.valueOf(pregunta.getWRONG()));
        args.put(QuestionEntry.ASKED, pregunta.getASKED());

        database.insert(QuestionEntry.TABLE_NAME, null, args);
        database.setTransactionSuccessful();
        database.endTransaction();
        this.close(database);
        return insertado=true;
    }

    public ArrayList<BeanCourse> getCursos(){
        ArrayList<BeanCourse> cursos = new ArrayList<BeanCourse>();
        SQLiteDatabase db = this.openReadable();
        Cursor c = db.rawQuery(CONSULTA_SELECTALL_CURSOS, null);
        if(c.moveToFirst()) {
            for (int i = 0; i < c.getCount(); i++) {
                cursos.add(new BeanCourse(
                        c.getInt(c.getColumnIndex(CourseEntry.ID)),
                        c.getString(c.getColumnIndex(CourseEntry.ID_PARSE)),
                        c.getString(c.getColumnIndex(CourseEntry.DEFINITION)),
                        c.getString(c.getColumnIndex(CourseEntry.NAME)),
                        c.getBlob(c.getColumnIndex(CourseEntry.IMAGE)),
                        c.getInt(c.getColumnIndex(CourseEntry.PROGRESS))
                ));
                c.moveToNext();
            }
        }
        c.close();
        this.close(db);
        return cursos;
    }

    public BeanCourse getCurso(int courseID){
        BeanCourse course = null;
        SQLiteDatabase db = this.openReadable();
        Cursor c = db.rawQuery(CONSULTA_SELECT_CURSO+courseID, null);
        if(c.moveToFirst()) {
            for (int i = 0; i < c.getCount(); i++) {
                course = new BeanCourse(
                        c.getInt(c.getColumnIndex(CourseEntry.ID)),
                        c.getString(c.getColumnIndex(CourseEntry.ID_PARSE)),
                        c.getString(c.getColumnIndex(CourseEntry.DEFINITION)),
                        c.getString(c.getColumnIndex(CourseEntry.NAME)),
                        c.getBlob(c.getColumnIndex(CourseEntry.IMAGE)),
                        c.getInt(c.getColumnIndex(CourseEntry.PROGRESS))
                );
            }
        }
        c.close();
        this.close(db);
        return course;
    }

    public ArrayList<BeanChapter> getTemas(int IDCourse){
        ArrayList<BeanChapter> temas = new ArrayList<BeanChapter>();
        SQLiteDatabase db = this.openReadable();
        Cursor c = db.rawQuery(CONSULTA_SELECTALL_TEMAS+IDCourse, null);
        if(c.moveToFirst()) {
            for (int i = 0; i < c.getCount(); i++) {
                temas.add(new BeanChapter(
                        c.getInt(c.getColumnIndex(ChapterEntry.ID)),
                        c.getString(c.getColumnIndex(ChapterEntry.ID_PARSE)),
                        c.getInt(c.getColumnIndex(ChapterEntry.FK_ID_COURSE)),
                        c.getString(c.getColumnIndex(ChapterEntry.NAME)),
                        c.getInt(c.getColumnIndex(ChapterEntry.ACCURACY)),
                        c.getInt(c.getColumnIndex(ChapterEntry.POSITION)),
                        c.getInt(c.getColumnIndex(ChapterEntry.PROGRESS))
                ));
                c.moveToNext();
            }
        }
        c.close();
        this.close(db);
        return temas;
    }

    public BeanChapter getTema(int ID){
        BeanChapter chapter = null;
        SQLiteDatabase db = this.openReadable();
        Cursor c = db.rawQuery(CONSULTA_SELECT_TEMA+ID, null);
        if(c.moveToFirst()) {
            chapter = new BeanChapter(
                    c.getInt(c.getColumnIndex(ChapterEntry.ID)),
                    c.getString(c.getColumnIndex(ChapterEntry.ID_PARSE)),
                    c.getInt(c.getColumnIndex(ChapterEntry.FK_ID_COURSE)),
                    c.getString(c.getColumnIndex(ChapterEntry.NAME)),
                    c.getInt(c.getColumnIndex(ChapterEntry.ACCURACY)),
                    c.getInt(c.getColumnIndex(ChapterEntry.POSITION)),
                    c.getInt(c.getColumnIndex(ChapterEntry.PROGRESS))
            );
        }
        c.close();
        this.close(db);
        return chapter;
    }


    public ArrayList<BeanQuestions> getPreguntas(int IDChapter){
        ArrayList<BeanQuestions> preguntas = new ArrayList<BeanQuestions>();
        SQLiteDatabase db = this.openReadable();
        Cursor c = db.rawQuery(CONSULTA_SELECTALL_PREGUNTAS+IDChapter, null);
        if(c.moveToFirst()) {
            for (int i = 0; i < c.getCount(); i++) {
                preguntas.add(new BeanQuestions(
                        c.getInt(c.getColumnIndex(QuestionEntry.ID)),
                        c.getString(c.getColumnIndex(QuestionEntry.ID_PARSE)),
                        c.getInt(c.getColumnIndex(QuestionEntry.FK_ID_THEME)),
                        c.getString(c.getColumnIndex(QuestionEntry.TEXT1)),
                        c.getString(c.getColumnIndex(QuestionEntry.TEXT2)),
                        c.getInt(c.getColumnIndex(QuestionEntry.TOTAL)),
                        c.getInt(c.getColumnIndex(QuestionEntry.WRONG)),
                        c.getDouble(c.getColumnIndex(QuestionEntry.EF)),
                        c.getBlob(c.getColumnIndex(QuestionEntry.IMAGE)),
                        c.getInt(c.getColumnIndex(QuestionEntry.ASKED))
                ));
                c.moveToNext();
            }
        }
        c.close();
        this.close(db);
        return preguntas;
    }

    public ArrayList<String>  getRespuestasIncorrectas(int IDChapter,int IDQuestion){
        ArrayList<String> respuestas = new ArrayList<String>();
        SQLiteDatabase db = this.openReadable();
        Cursor c = db.rawQuery(CONSULTA_SELECT_RESPUESTAS_INCORRECTAS+IDChapter, null);
        if(c.moveToFirst()) {
            for (int i = 0; i < c.getCount(); i++) {
                if (IDQuestion != c.getInt(c.getColumnIndex(QuestionEntry.ID)))
                    respuestas.add(c.getString(c.getColumnIndex(QuestionEntry.TEXT2)));
                c.moveToNext();
            }
        }
        c.close();
        this.close(db);
        return respuestas;
    }


    public BeanCourse getCursoByPARSE_ID(String parse_id){
        SQLiteDatabase db = this.openReadable();
        BeanCourse curso = null;
        Cursor c = db.rawQuery(CONSULTA_CURSOS_BY_IDPARSE+"'"+parse_id+"'", null);
        if(c.moveToFirst()) {
            curso = new BeanCourse(
                    c.getInt(c.getColumnIndex(CourseEntry.ID)),
                    c.getString(c.getColumnIndex(CourseEntry.ID_PARSE)),
                    c.getString(c.getColumnIndex(CourseEntry.DEFINITION)),
                    c.getString(c.getColumnIndex(CourseEntry.NAME)),
                    c.getBlob(c.getColumnIndex(CourseEntry.IMAGE)),
                    c.getInt(c.getColumnIndex(CourseEntry.PROGRESS))
            );
        }
        c.close();
        this.close(db);
        return curso;
    }

    public BeanChapter getTemasByPARSE_ID(String parse_id){
        SQLiteDatabase db = this.openReadable();
        BeanChapter tema = null;
        Cursor c = db.rawQuery(CONSULTA_TEMAS_BY_IDPARSE+"'"+parse_id+"'", null);
        if(c.moveToFirst()) {
            tema = new BeanChapter(
                    c.getInt(c.getColumnIndex(ChapterEntry.ID)),
                    c.getString(c.getColumnIndex(ChapterEntry.ID_PARSE)),
                    c.getInt(c.getColumnIndex(ChapterEntry.FK_ID_COURSE)),
                    c.getString(c.getColumnIndex(ChapterEntry.NAME)),
                    c.getInt(c.getColumnIndex(ChapterEntry.ACCURACY)),
                    c.getInt(c.getColumnIndex(ChapterEntry.POSITION)),
                    c.getInt(c.getColumnIndex(ChapterEntry.PROGRESS)));
        }
        c.close();
        this.close(db);
        return tema;
    }

    public BeanQuestions getPreguntasByParse_ID(String parse_id){
        SQLiteDatabase db = this.openReadable();
        BeanQuestions pregunta = null;
        Cursor c = db.rawQuery(CONSULTA_PREGUNTA_BY_IDPARSE+"'"+parse_id+"'", null);
        if(c.moveToFirst()){
            pregunta = new BeanQuestions(
                    c.getInt(c.getColumnIndex(QuestionEntry.ID)),
                    c.getString(c.getColumnIndex(QuestionEntry.ID_PARSE)),
                    c.getInt(c.getColumnIndex(QuestionEntry.FK_ID_THEME)),
                    c.getString(c.getColumnIndex(QuestionEntry.TEXT1)),
                    c.getString(c.getColumnIndex(QuestionEntry.TEXT2)),
                    c.getInt(c.getColumnIndex(QuestionEntry.TOTAL)),
                    c.getInt(c.getColumnIndex(QuestionEntry.WRONG)),
                    c.getDouble(c.getColumnIndex(QuestionEntry.EF)),
                    c.getBlob(c.getColumnIndex(QuestionEntry.IMAGE)),
                    c.getInt(c.getColumnIndex(QuestionEntry.ASKED))
            );
        }
        c.close();
        this.close(db);
        return pregunta;
    }


    public void updatePreguntaTotal(BeanQuestions pregunta){
        SQLiteDatabase db = this.openReadable();
        ContentValues args = new ContentValues();

        args.put(String.valueOf(QuestionEntry.TOTAL), String.valueOf(pregunta.getTOTAL()+1));
        args.put(String.valueOf(QuestionEntry.WRONG), String.valueOf(pregunta.getWRONG()));
        args.put(String.valueOf(QuestionEntry.EF), String.valueOf(pregunta.getEF()));

        db.update(QuestionEntry.TABLE_NAME, args, QuestionEntry.ID+" = ?", new String[] { String.valueOf(pregunta.getID()) });
        this.close(db);
    }


    public void updatePreguntaAsked(BeanQuestions pregunta){
        SQLiteDatabase db = this.openReadable();
        ContentValues args = new ContentValues();

        args.put(QuestionEntry.ASKED, String.valueOf(pregunta.getASKED()));

        db.update(QuestionEntry.TABLE_NAME, args, QuestionEntry.ID+" = ?", new String[] { String.valueOf(pregunta.getID()) });
        this.close(db);
    }

    public void updateChapter(BeanChapter chapter){
        int wrong=0, total=0, asked=0;
        List<BeanQuestions> questions = getPreguntas(chapter.getID());
        for(BeanQuestions question : questions){
            total += question.getTOTAL();
            wrong += question.getWRONG();
            if(question.getASKED() > 0)
                asked++;
        }

        SQLiteDatabase db = this.openReadable();
        ContentValues args = new ContentValues();

        args.put(ChapterEntry.PROGRESS, String.valueOf(asked*100/questions.size()));
        args.put(ChapterEntry.ACCURACY, String.valueOf((total-wrong)*100/total));

        db.update(ChapterEntry.TABLE_NAME, args, ChapterEntry.ID+" = ?", new String[] { String.valueOf(chapter.getID()) });
        this.close(db);
    }

    public void updateCourse(BeanCourse course){
        int total=0;
        List<BeanChapter> chapters = getTemas(course.getID());
        for(BeanChapter chapter : chapters){
            total += chapter.getPROGRESS();
        }

        SQLiteDatabase db = this.openReadable();
        ContentValues args = new ContentValues();

        args.put(CourseEntry.PROGRESS, String.valueOf((total*100)/(chapters.size()*100)));

        db.update(CourseEntry.TABLE_NAME, args, CourseEntry.ID+" = ?", new String[] { String.valueOf(course.getID()) });
        this.close(db);
    }

}
