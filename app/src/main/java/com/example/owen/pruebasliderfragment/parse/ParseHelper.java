package com.example.owen.pruebasliderfragment.parse;

import android.content.Context;

import com.example.owen.pruebasliderfragment.JavaBean.BeanCourse;
import com.example.owen.pruebasliderfragment.JavaBean.BeanQuestions;
import com.example.owen.pruebasliderfragment.JavaBean.BeanChapter;
import com.example.owen.pruebasliderfragment.data.*;
import com.example.owen.pruebasliderfragment.parse.ParseContract.*;
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
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(CourseEntry.TABLE_NAME);
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
        ParseObject progreso_curso = new ParseObject(Progress_courseEntry.TABLE_NAME);
        progreso_curso.put(Progress_courseEntry.USER_ID, pointerUser);
        progreso_curso.put(Progress_courseEntry.COURSE_ID, pointerCourse);
        progreso_curso.put(Progress_courseEntry.PROGRESS, 0);
        progreso_curso.saveInBackground();
    }

    private void setProgreso_Chapters(ParseObject pointerUser, ParseObject pointerCourse) {
        List<ParseObject> ob = null;
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(ChapterEntry.TABLE_NAME);
        query.whereEqualTo(ChapterEntry.COURSE_ID, pointerCourse);
        try {
            ob = query.find();
            for (ParseObject chapter : ob) {
                ParseObject myChapter = new ParseObject(Progress_chapterEntry.TABLE_NAME);
                myChapter.put(Progress_chapterEntry.USER_ID, pointerUser);
                myChapter.put(Progress_chapterEntry.CHAPTER_ID, chapter);
                myChapter.put(Progress_chapterEntry.ACCURACY, 0);
                myChapter.put(Progress_chapterEntry.PROGRESS, 0);
                myChapter.saveInBackground();
                setProgreso_Preguntas(pointerUser, chapter);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void setProgreso_Preguntas(ParseObject pointerUser, ParseObject pointerChapter) {
        List<ParseObject> ob = null;
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(QuestionEntry.TABLE_NAME);
        query.whereEqualTo(QuestionEntry.CHAPTER_ID, pointerChapter);
        try {
            ob = query.find();
            for (ParseObject question : ob) {
                ParseObject myQuestion = new ParseObject(Progress_questionEntry.TABLE_NAME);
                myQuestion.put(Progress_questionEntry.USER_ID, pointerUser);
                myQuestion.put(Progress_questionEntry.QUESTION_ID, question);
                myQuestion.put(Progress_questionEntry.TOTAL, 0);
                myQuestion.put(Progress_questionEntry.MISS, 0);
                myQuestion.put(Progress_questionEntry.EF, 2.5); // introducir EF dentro de la tabla progress_question de parse
                myQuestion.saveInBackground();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    public List<ParseObject> getAllMyCourses(ParseObject pointerUser) {
        List<ParseObject> ob = null;
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(Progress_courseEntry.TABLE_NAME);
        query.whereEqualTo(Progress_courseEntry.USER_ID, pointerUser);
        try {
            ob = query.find();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ob;
    }


    public List<ParseObject> getAllChapter(ParseObject pointerUser) {
        List<ParseObject> ob = null;
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(Progress_chapterEntry.TABLE_NAME);
            query.whereEqualTo(Progress_chapterEntry.USER_ID, pointerUser);
        try {
            ob = query.find();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ob;
    }


    public String getProgreso_CursoID(ParseObject pointerUser, ParseObject pointerCourse) {
        String id = null;
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(Progress_courseEntry.TABLE_NAME);
            query.whereEqualTo(Progress_courseEntry.USER_ID, pointerUser);
            query.whereEqualTo(Progress_courseEntry.COURSE_ID, pointerCourse);
        try {
            List<ParseObject> ob = query.find();
            id = ob.get(0).getObjectId();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return id;
    }


    public String getProgreso_TemasID(ParseObject pointerUser, ParseObject pointerChapter){
        String id = null;
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(Progress_chapterEntry.TABLE_NAME);
            query.whereEqualTo(Progress_chapterEntry.USER_ID, pointerUser);
            query.whereEqualTo(Progress_chapterEntry.CHAPTER_ID, pointerChapter);
        try {
            List<ParseObject> ob = query.find();
            id = ob.get(0).getObjectId();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return id;
    }


    public String getProgreso_PreguntasID(ParseObject pointerUser, ParseObject pointerQuestion){
        String id = null;
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(Progress_questionEntry.TABLE_NAME);
            query.whereEqualTo(Progress_questionEntry.USER_ID, pointerUser);
            query.whereEqualTo(Progress_questionEntry.QUESTION_ID, pointerQuestion);
        try {
            List<ParseObject> ob = query.find();
            id = ob.get(0).getObjectId();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return id;
    }



    /*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     * A partir de aqui estan los metodos encargados de devolver la informacion entre parse y la base de datos local
     +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/


    public List<BeanCourse> getCoursesByUser(ParseObject pointerUser) {
        List<ParseObject> ob = null;
        ArrayList<BeanCourse> cursos = new ArrayList<BeanCourse>();
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(Progress_courseEntry.TABLE_NAME);
        query.whereEqualTo(Progress_courseEntry.USER_ID, pointerUser);
        try {
            ob = query.find();
            for (ParseObject mycurso : ob) {
                ParseObject curso = (ParseObject) mycurso.get(Progress_courseEntry.COURSE_ID);
                cursos.add(new BeanCourse(0, mycurso.getObjectId(), curso.getString(CourseEntry.DEFINITION), curso.getString(CourseEntry.NAME), curso.getParseFile(CourseEntry.IMAGE).getData(), mycurso.getInt(Progress_courseEntry.PROGRESS)));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return cursos;
    }

    public BeanCourse getCoursesByIDFromProgresoCourses(ParseObject pointerUser) {
        List<ParseObject> ob = null;
        BeanCourse cursobean = null;
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(Progress_courseEntry.TABLE_NAME);
            query.whereEqualTo(Progress_courseEntry.USER_ID, pointerUser);
        try {
            ob = query.find();
            for (ParseObject mycurso : ob) {
                ParseObject curso = (ParseObject) mycurso.get(Progress_courseEntry.COURSE_ID);
                cursobean = new BeanCourse(0, mycurso.getObjectId(), curso.getString(CourseEntry.DEFINITION), curso.getString(CourseEntry.NAME), curso.getParseFile(CourseEntry.IMAGE).getData(), mycurso.getInt(Progress_courseEntry.PROGRESS));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return cursobean;
    }


    // obtiene los datos de los temas de parse para introducirlos dentro de SQLite
    public List<BeanChapter> getTemasByUserFromParse(ParseObject pointerUser, ParseObject pointerCourse, Context context) {
        DataSource dataSource = new DataSource(context);
        List<ParseObject> ob = null;
        ArrayList<BeanChapter> chapters = new ArrayList<BeanChapter>();
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(Progress_chapterEntry.TABLE_NAME);
            query.whereEqualTo(Progress_chapterEntry.USER_ID, pointerUser);
        try {
            ob = query.find();
            for (ParseObject mychapter : ob) {
                ParseObject chapter = (ParseObject) mychapter.fetchIfNeeded().get(Progress_chapterEntry.CHAPTER_ID);
                ParseObject chaptercourse = (ParseObject)chapter.fetchIfNeeded().get(ChapterEntry.COURSE_ID);
                if(chaptercourse.getObjectId().equals(pointerCourse.getObjectId())) {
                    String aux = getProgreso_CursoID(ParseUser.getCurrentUser(), pointerCourse);
                    int fk_course = dataSource.getCursoByPARSE_ID(aux).getID();
                    chapters.add(new BeanChapter(0,
                            mychapter.getObjectId(),
                            fk_course,
                            chapter.getString(ChapterEntry.NAME),
                            mychapter.getInt(Progress_chapterEntry.ACCURACY),
                            chapter.getInt(ChapterEntry.POSITION),
                            mychapter.getInt(Progress_chapterEntry.PROGRESS)
                    ));
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return chapters;
    }


    public List<BeanQuestions> getPreguntasByUserFromParse(ParseObject pointerUser, ParseObject pointerCourse, Context context){
        DataSource dataSource = new DataSource(context);
        List<ParseObject> ob = null;
        ArrayList<BeanQuestions> questions = new ArrayList<BeanQuestions>();
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(Progress_questionEntry.TABLE_NAME);
            query.whereEqualTo(Progress_questionEntry.USER_ID, pointerUser);
        try {
            ob = query.find();
            for(ParseObject myQuestion : ob){
                ParseObject question =  myQuestion.fetchIfNeeded().getParseObject(Progress_questionEntry.QUESTION_ID);
                ParseObject course = question.fetchIfNeeded().getParseObject(QuestionEntry.CHAPTER_ID).fetchIfNeeded().getParseObject(ChapterEntry.COURSE_ID);
                if(course.getObjectId().equals(pointerCourse.getObjectId())){
                    int fk_tema = dataSource.getTemasByPARSE_ID(getProgreso_TemasID(pointerUser, myQuestion.fetchIfNeeded().getParseObject(Progress_questionEntry.QUESTION_ID).getParseObject(QuestionEntry.CHAPTER_ID))).getID();
                    questions.add(new BeanQuestions(0,
                            myQuestion.getObjectId(),
                            fk_tema,
                            question.getString(QuestionEntry.TEXT1),
                            question.getString(QuestionEntry.TEXT2),
                            0, 0, 2.5,
                            question.getParseFile(QuestionEntry.IMAGE).getData()
                    ));
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return questions;
    }

}
