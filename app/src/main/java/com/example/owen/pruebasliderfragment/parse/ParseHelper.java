package com.example.owen.pruebasliderfragment.parse;

import android.content.Context;
import android.util.Log;

import com.example.owen.pruebasliderfragment.JavaBean.BeanCursos;
import com.example.owen.pruebasliderfragment.JavaBean.BeanTemas;
import com.example.owen.pruebasliderfragment.data.*;
import com.example.owen.pruebasliderfragment.parse.DataEntry.*;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Owen on 05/03/2015.
 */
public class ParseHelper {


    public ParseHelper() {

    }


    public List<ParseObject> getAllCourses() {
        List<ParseObject> ob = null;
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(new CourseEntry().getTableName());
        try {
            ob = query.find();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ob;
    }


    public void setNewMyCourse(ParseObject pointerUser, ParseObject pointerCourse) {
        setProgreso_Course(pointerUser, pointerCourse);
        setProgreso_Chapters(pointerUser, pointerCourse);
    }

    private void setProgreso_Course(ParseObject pointerUser, ParseObject pointerCourse) {
        Progreso_cursosEntry tabla = new Progreso_cursosEntry();
        ParseObject progreso_curso = new ParseObject(tabla.getTableName());
        progreso_curso.put(tabla.getUserID(), pointerUser);
        progreso_curso.put(tabla.getCourseID(), pointerCourse);
        progreso_curso.put(tabla.getAccuracy(), 0);
        progreso_curso.put(tabla.getFinished(), false);
        progreso_curso.put(tabla.getProgress(), 0);
        progreso_curso.saveInBackground();
    }

    private void setProgreso_Chapters(ParseObject pointerUser, ParseObject pointerCourse) {
        ChaptersEntry tabla = new ChaptersEntry();
        Progreso_ChaptersEntry tabla2 = new Progreso_ChaptersEntry();
        List<ParseObject> ob = null;
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(tabla.getTableName());
        query.whereEqualTo(tabla.getCurso(), pointerCourse);
        try {
            ob = query.find();
            for (ParseObject chapter : ob) {
                ParseObject myChapter = new ParseObject(tabla2.getTableName());
                myChapter.put(tabla2.getUserID(), pointerUser);
                myChapter.put(tabla2.getChapterID(), chapter);
                myChapter.put(tabla2.getAccuracy(), 0);
                myChapter.put(tabla2.getFinished(), false);
                myChapter.put(tabla2.getProgress(), 0);
                myChapter.saveInBackground();
                setProgreso_Preguntas(pointerUser, chapter);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void setProgreso_Preguntas(ParseObject pointerUser, ParseObject pointerChapter) {
        QuestionEntry tabla = new QuestionEntry();
        Progreso_QuestionEntry tabla2 = new Progreso_QuestionEntry();
        List<ParseObject> ob = null;
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(tabla.getTableName());
        query.whereEqualTo(tabla.getChapterID(), pointerChapter);
        try {
            ob = query.find();
            for (ParseObject question : ob) {
                ParseObject myQuestion = new ParseObject(tabla2.getTableName());
                myQuestion.put(tabla2.getUserID(), pointerUser);
                myQuestion.put(tabla2.getQuestionID(), question);
                myQuestion.put(tabla2.getHits(), 0);
                myQuestion.put(tabla2.getMiss(), 0);
                myQuestion.put(tabla2.getMade(), false);
                myQuestion.saveInBackground();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    public List<ParseObject> getAllMyCourses(ParseObject pointerUser) {
        Progreso_cursosEntry tabla = new Progreso_cursosEntry();
        List<ParseObject> ob = null;
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(tabla.getTableName());
        query.whereEqualTo(tabla.getUserID(), pointerUser);
        try {
            ob = query.find();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ob;
    }


    public List<ParseObject> getAllChapter(ParseObject pointerUser, ParseObject pointerCourse) {
        Progreso_ChaptersEntry tabla = new Progreso_ChaptersEntry();
        List<ParseObject> ob = null;
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(tabla.getTableName());
        query.whereEqualTo(tabla.getUserID(), pointerUser);
        try {
            ob = query.find();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ob;
    }


    public String getProgreso_CursoID(ParseObject pointerUser, ParseObject pointerCourse) {
        Progreso_cursosEntry tabla = new Progreso_cursosEntry();
        String id = null;
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(tabla.getTableName());
        query.whereEqualTo(tabla.getUserID(), pointerUser);
        query.whereEqualTo(tabla.getCourseID(), pointerCourse);
        try {
            List<ParseObject> ob = query.find();
            id = ob.get(0).getObjectId();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return id;
    }



    /*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     * Apartir de aqui estan los metodos encargados de devolver la informacion entre parse y la base de datos local
     +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/


    public List<BeanCursos> getCoursesByUser(ParseObject pointerUser) {
        Progreso_cursosEntry tabla = new Progreso_cursosEntry();
        CourseEntry tabla2 = new CourseEntry();
        List<ParseObject> ob = null;
        ArrayList<BeanCursos> cursos = new ArrayList<BeanCursos>();
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(tabla.getTableName());
        query.whereEqualTo(tabla.getUserID(), pointerUser);
        try {
            ob = query.find();
            for (ParseObject mycurso : ob) {
                ParseObject curso = (ParseObject) mycurso.get(tabla.getCourseID());
                cursos.add(new BeanCursos(0, mycurso.getObjectId(), curso.getString(tabla2.getDefinition()), curso.getString(tabla2.getName()), mycurso.getInt(tabla.getAccuracy()), curso.getParseFile(tabla2.getImage()).getData()));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return cursos;
    }

    public BeanCursos getCoursesByIDFromProgresoCourses(ParseObject pointerUser, ParseObject pointerCourse) {
        Progreso_cursosEntry tabla = new Progreso_cursosEntry();
        CourseEntry tabla2 = new CourseEntry();
        List<ParseObject> ob = null;
        BeanCursos cursobean = null;
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(tabla.getTableName());
            query.whereEqualTo(tabla.getUserID(), pointerUser);
        try {
            ob = query.find();
            for (ParseObject mycurso : ob) {
                ParseObject curso = (ParseObject) mycurso.get(tabla.getCourseID());
                cursobean = new BeanCursos(0, mycurso.getObjectId(), curso.getString(tabla2.getDefinition()), curso.getString(tabla2.getName()), mycurso.getInt(tabla.getAccuracy()), curso.getParseFile(tabla2.getImage()).getData());
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return cursobean;
    }


    // obtiene los datos de los temas de parse para introducirlos dentro de SQLite
    public List<BeanTemas> getTemasByUserAndCourseFromProgreso_Chapters(ParseObject pointerUser, ParseObject pointerCourse, Context context) {
        Progreso_ChaptersEntry tabla = new Progreso_ChaptersEntry();
        ChaptersEntry tabla2 = new ChaptersEntry();
        DataSource dataSource = new DataSource(context);
        List<ParseObject> ob = null;
        ArrayList<BeanTemas> chapters = new ArrayList<BeanTemas>();
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(tabla.getTableName());
            query.whereEqualTo(tabla.getUserID(), pointerUser);
            query.include("pointer to Chapters table");
        try {
            ob = query.find();
            for (ParseObject mychapter : ob) {
                ParseObject chapter = (ParseObject) mychapter.fetchIfNeeded().get(tabla.getChapterID());
                ParseObject chaptercourse = (ParseObject)chapter.fetchIfNeeded().get(tabla2.getCurso());
                if(chaptercourse.getObjectId().equals(pointerCourse.getObjectId())) {
                    int fk_course = dataSource.getCursoByPARSE_ID(context, getProgreso_CursoID(ParseUser.getCurrentUser(), pointerCourse)).getID_COURSE();
                    // falta coger el ID designado al curso dentro de la base de datos local
                    chapters.add(new BeanTemas(0,
                            mychapter.getObjectId(),
                            fk_course,
                            chapter.getString(tabla2.getName()),
                            mychapter.getInt(tabla.getAccuracy()),
                            chapter.getInt(tabla2.getPosition())));
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return chapters;
    }

}
