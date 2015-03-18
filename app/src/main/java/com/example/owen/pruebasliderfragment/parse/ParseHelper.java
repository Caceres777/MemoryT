package com.example.owen.pruebasliderfragment.parse;

import android.content.Context;
import android.util.Log;

import com.example.owen.pruebasliderfragment.JavaBean.BeanCursos;
import com.example.owen.pruebasliderfragment.JavaBean.BeanPreguntas;
import com.example.owen.pruebasliderfragment.JavaBean.BeanRespuestas;
import com.example.owen.pruebasliderfragment.JavaBean.BeanTemas;
import com.example.owen.pruebasliderfragment.data.*;
import com.example.owen.pruebasliderfragment.parse.DataEntry.*;
import com.parse.Parse;
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


    public List<ParseObject> getAllChapter(ParseObject pointerUser) {
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


    public String getProgreso_TemasID(ParseObject pointerUser, ParseObject pointerChapter){
        Progreso_ChaptersEntry tabla = new Progreso_ChaptersEntry();
        String id = null;
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(tabla.getTableName());
            query.whereEqualTo(tabla.getUserID(), pointerUser);
            query.whereEqualTo(tabla.getChapterID(), pointerChapter);
        try {
            List<ParseObject> ob = query.find();
            id = ob.get(0).getObjectId();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return id;
    }


    public String getProgreso_PreguntasID(ParseObject pointerUser, ParseObject pointerQuestion){
        Progreso_QuestionEntry tabla = new Progreso_QuestionEntry();
        String id = null;
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(tabla.getTableName());
            query.whereEqualTo(tabla.getUserID(), pointerUser);
            query.whereEqualTo(tabla.getQuestionID(), pointerQuestion);
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
                cursos.add(new BeanCursos(0, mycurso.getObjectId(), curso.getString(tabla2.getDefinition()), curso.getString(tabla2.getName()), mycurso.getInt(tabla.getAccuracy()), curso.getParseFile(tabla2.getImage()).getData(), mycurso.getInt(tabla.getProgress())));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return cursos;
    }

    public BeanCursos getCoursesByIDFromProgresoCourses(ParseObject pointerUser) {
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
                cursobean = new BeanCursos(0, mycurso.getObjectId(), curso.getString(tabla2.getDefinition()), curso.getString(tabla2.getName()), mycurso.getInt(tabla.getAccuracy()), curso.getParseFile(tabla2.getImage()).getData(), mycurso.getInt(tabla.getProgress()));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return cursobean;
    }


    // obtiene los datos de los temas de parse para introducirlos dentro de SQLite
    public List<BeanTemas> getTemasByUserFromParse(ParseObject pointerUser, ParseObject pointerCourse, Context context) {
        Progreso_ChaptersEntry tabla = new Progreso_ChaptersEntry();
        ChaptersEntry tabla2 = new ChaptersEntry();
        DataSource dataSource = new DataSource(context);
        List<ParseObject> ob = null;
        ArrayList<BeanTemas> chapters = new ArrayList<BeanTemas>();
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(tabla.getTableName());
            query.whereEqualTo(tabla.getUserID(), pointerUser);
        try {
            ob = query.find();
            for (ParseObject mychapter : ob) {
                ParseObject chapter = (ParseObject) mychapter.fetchIfNeeded().get(tabla.getChapterID());
                ParseObject chaptercourse = (ParseObject)chapter.fetchIfNeeded().get(tabla2.getCurso());
                if(chaptercourse.getObjectId().equals(pointerCourse.getObjectId())) {
                    String aux = getProgreso_CursoID(ParseUser.getCurrentUser(), pointerCourse);
                    int fk_course = dataSource.getCursoByPARSE_ID(aux).getID_COURSE();
                    // falta coger el ID designado al curso dentro de la base de datos local
                    chapters.add(new BeanTemas(0,
                            mychapter.getObjectId(),
                            fk_course,
                            chapter.getString(tabla2.getName()),
                            mychapter.getInt(tabla.getAccuracy()),
                            chapter.getInt(tabla2.getPosition()),
                            mychapter.getInt(tabla.getProgress())
                    ));
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return chapters;
    }


    public List<BeanPreguntas> getPreguntasByUserFromParse(ParseObject pointerUser, ParseObject pointerCourse, Context context){
        Progreso_QuestionEntry tabla = new Progreso_QuestionEntry();
        QuestionEntry tablaQuestion = new QuestionEntry();
        ChaptersEntry tablaChapter = new ChaptersEntry();
        DataSource dataSource = new DataSource(context);
        List<ParseObject> ob = null;
        ArrayList<BeanPreguntas> questions = new ArrayList<BeanPreguntas>();
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(tabla.getTableName());
            query.whereEqualTo(tabla.getUserID(), pointerUser);
        try {
            ob = query.find();
            for(ParseObject myQuestion : ob){
                ParseObject question =  myQuestion.fetchIfNeeded().getParseObject(tabla.getQuestionID());
                ParseObject course = question.fetchIfNeeded().getParseObject(tablaQuestion.getChapterID()).fetchIfNeeded().getParseObject(tablaChapter.getCurso());
                if(course.getObjectId().equals(pointerCourse.getObjectId())){
                    int fk_tema = dataSource.getTemasByPARSE_ID(getProgreso_TemasID(pointerUser, myQuestion.fetchIfNeeded().getParseObject(tabla.getQuestionID()).getParseObject(tablaQuestion.getChapterID()))).getID_THEME();
                    questions.add(new BeanPreguntas(0,
                            myQuestion.getObjectId(),
                            fk_tema,
                            question.getString(tablaQuestion.getText()),
                            false,
                            0, 0
                    ));
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return questions;
    }


    public List<BeanRespuestas> getRespuestasByUserFromParse(ParseObject pointerUser, ParseObject pointerCourse, Context context){
        AnswerEntry tablaAnswer = new AnswerEntry();
        ChaptersEntry tablaChapters = new ChaptersEntry();
        DataSource dataSource = new DataSource(context);
        ArrayList<BeanRespuestas> answers = new ArrayList<BeanRespuestas>();
        List<ParseObject> obTemas = null;
        ParseQuery<ParseObject> query1 = new ParseQuery<ParseObject>(tablaChapters.getTableName());
            query1.whereEqualTo(tablaChapters.getCurso(), pointerCourse);
        try {
            obTemas = query1.find();
            for(ParseObject tema : obTemas){
                List<ParseObject> obAnswers = null;
                ParseQuery<ParseObject> query2 = new ParseQuery<ParseObject>(tablaAnswer.getTableName());
                    query2.whereEqualTo(tablaAnswer.getChaptersID(), tema);
                obAnswers = query2.find();
                for(ParseObject answer : obAnswers){
                    int fk_tema = dataSource.getTemasByPARSE_ID(getProgreso_TemasID(pointerUser, tema)).getID_THEME();
                    String aux = getProgreso_PreguntasID(pointerUser,answer.fetchIfNeeded().getParseObject(tablaAnswer.getQuestionID()));
                    int fk_question = dataSource.getPreguntasByParse_ID(aux).getID_QUESTION();
                    answers.add(new BeanRespuestas(
                            0,
                            fk_question,
                            fk_tema,
                            answer.getString(tablaAnswer.getText())
                    ));
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return answers;
    }

}
