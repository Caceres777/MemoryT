package com.example.owen.pruebasliderfragment.parse;

import android.content.Context;
import android.util.Log;

import com.example.owen.pruebasliderfragment.Controller;
import com.example.owen.pruebasliderfragment.JavaBean.BeanCourse;
import com.example.owen.pruebasliderfragment.JavaBean.BeanQuestions;
import com.example.owen.pruebasliderfragment.JavaBean.BeanChapter;
import com.example.owen.pruebasliderfragment.data.*;
import com.example.owen.pruebasliderfragment.parse.ParseContract.*;
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

    private static final String OBJECT_ID = "objectId";

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
                myQuestion.put(Progress_questionEntry.ASKED, false);
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


    public List<ParseObject> getAllChaptersCourse(ParseObject pointerCourse) {
        List<ParseObject> chapters = null;
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(ChapterEntry.TABLE_NAME);
            query.whereEqualTo(ChapterEntry.COURSE_ID, pointerCourse);
        try {
            chapters = query.find();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return chapters;
    }

    public List<ParseObject> getAllQuestionsChapter(ParseObject pointerChapter) {
        List<ParseObject> questions = null;
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(QuestionEntry.TABLE_NAME);
        query.whereEqualTo(QuestionEntry.CHAPTER_ID, pointerChapter);
        try {
            questions = query.find();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return questions;
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

    public ParseObject getChapter(ParseObject pointerUser ,String progress_chapterID){
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(Progress_chapterEntry.TABLE_NAME);
            query.whereEqualTo(Progress_questionEntry.USER_ID, pointerUser);
            query.whereEqualTo(OBJECT_ID, progress_chapterID);
        ParseObject chapter = null;
        try {
            chapter = query.find().get(0).getParseObject(Progress_chapterEntry.CHAPTER_ID);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return chapter;
    }


    public void updateQuestionAsked(BeanQuestions question) {
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(Progress_questionEntry.TABLE_NAME);
            query.whereEqualTo(OBJECT_ID, question.getPARSE_ID());
        try {
            ParseObject pquest = query.find().get(0);
            pquest.put(Progress_questionEntry.ASKED, question.getASKED() > 0);
            pquest.saveInBackground();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void updateQuestionTotal(BeanQuestions question, int wrong) {
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(Progress_questionEntry.TABLE_NAME);
        query.whereEqualTo(OBJECT_ID, question.getPARSE_ID());
        try {
            ParseObject pquest = query.find().get(0);
            pquest.put(Progress_questionEntry.TOTAL, pquest.getInt(Progress_questionEntry.TOTAL)+1);
            pquest.put(Progress_questionEntry.MISS, question.getWRONG()+wrong);
            pquest.saveInBackground();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void updateChapter(BeanChapter chapter){
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(Progress_chapterEntry.TABLE_NAME);
        query.whereEqualTo(OBJECT_ID, chapter.getID_PARSE());
        try {
            ParseObject pchapt = query.find().get(0);
            pchapt.put(Progress_chapterEntry.PROGRESS, chapter.getPROGRESS());
            pchapt.put(Progress_chapterEntry.ACCURACY, chapter.getACCURACY());
            pchapt.saveInBackground();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void updateCourse(BeanCourse course){

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

    public BeanCourse getCourseByUserAndCourse(ParseObject pointerUser, ParseObject pointerCourse) {
        BeanCourse cursobean = null;
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(Progress_courseEntry.TABLE_NAME);
            query.whereEqualTo(Progress_courseEntry.USER_ID, pointerUser);
            query.whereEqualTo(Progress_courseEntry.COURSE_ID, pointerCourse);
        try {
            ParseObject myCourse = query.find().get(0);
            cursobean = new BeanCourse(0, myCourse.getObjectId(), pointerCourse.getString(CourseEntry.DEFINITION), pointerCourse.getString(CourseEntry.NAME), pointerCourse.getParseFile(CourseEntry.IMAGE).getData(), myCourse.getInt(Progress_courseEntry.PROGRESS));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return cursobean;
    }


    // obtiene los datos de los temas de parse para introducirlos dentro de SQLite
    public List<BeanChapter> getTemasByUserFromParse(ParseObject pointerUser, ParseObject pointerCourse, Context context) {
        ParseObject progress = null;
        List<ParseObject> pchapters = getAllChaptersCourse(pointerCourse);
        ArrayList<BeanChapter> chapters = new ArrayList<BeanChapter>();

        try {
            for(ParseObject chapter : pchapters){
                ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(Progress_chapterEntry.TABLE_NAME);
                    query.whereEqualTo(Progress_chapterEntry.USER_ID, pointerUser);
                    query.whereEqualTo(Progress_chapterEntry.CHAPTER_ID, chapter);
                progress = query.find().get(0);
                String aux = getProgreso_CursoID(ParseUser.getCurrentUser(), pointerCourse);
                int fk_course = new Controller(context).getIdCourseFromLocal(aux);
                chapters.add(new BeanChapter(0,
                        progress.getObjectId(),
                        fk_course,
                        chapter.getString(ChapterEntry.NAME),
                        progress.getInt(Progress_chapterEntry.ACCURACY),
                        chapter.getInt(ChapterEntry.POSITION),
                        progress.getInt(Progress_chapterEntry.PROGRESS)
                ));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return chapters;
    }

    // modificar metodo por problemas
    public List<BeanQuestions> getPreguntasByUserFromParse(ParseObject pointerUser, String progressChapter, Context context){
        ArrayList<BeanQuestions> questions = new ArrayList<BeanQuestions>();
        int fk_tema = new Controller(context).getIdCChapterFromLocal(progressChapter);
        ParseObject pointerChapter = getChapter(pointerUser, progressChapter);
        List<ParseObject> pquestions = getAllQuestionsChapter(pointerChapter);
        for(ParseObject question : pquestions) {
            ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(Progress_questionEntry.TABLE_NAME);
                query.whereEqualTo(Progress_questionEntry.USER_ID, pointerUser);
                query.whereEqualTo(Progress_questionEntry.QUESTION_ID, question);
            try {
                ParseObject myQuestion = query.find().get(0);
                if(question.getParseFile(QuestionEntry.IMAGE) == null) {
                    questions.add(new BeanQuestions(0,
                            myQuestion.getObjectId(),
                            fk_tema,
                            question.getString(QuestionEntry.TEXT1),
                            question.getString(QuestionEntry.TEXT2),
                            0, 0, 2.5,
                            null,
                            0
                    ));
                }else {
                    questions.add(new BeanQuestions(0,
                            myQuestion.getObjectId(),
                            fk_tema,
                            question.getString(QuestionEntry.TEXT1),
                            question.getString(QuestionEntry.TEXT2),
                            0, 0, 2.5,
                            question.getParseFile(QuestionEntry.IMAGE).getData(),
                            0
                    ));
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return questions;
    }




}
