package com.example.owen.pruebasliderfragment.parse;

import android.util.Log;

import com.example.owen.pruebasliderfragment.parse.DataEntry.ChaptersEntry;
import com.example.owen.pruebasliderfragment.parse.DataEntry.CourseEntry;
import com.example.owen.pruebasliderfragment.parse.DataEntry.Progreso_ChaptersEntry;
import com.example.owen.pruebasliderfragment.parse.DataEntry.Progreso_QuestionEntry;
import com.example.owen.pruebasliderfragment.parse.DataEntry.Progreso_cursosEntry;
import com.example.owen.pruebasliderfragment.parse.DataEntry.QuestionEntry;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

/**
 * Created by Owen on 05/03/2015.
 */
public class ParseHelper {


    public ParseHelper(){

    }


    public List<ParseObject> getAllCourses(){
        List<ParseObject> ob = null;
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(new CourseEntry().getTableName());
        try {
            ob = query.find();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ob;
    }


    public void setNewMyCourse(ParseObject pointerUser, ParseObject pointerCourse){
        setProgreso_Course(pointerUser, pointerCourse);
        setProgreso_Chapters(pointerUser, pointerCourse);
    }

    private void setProgreso_Course(ParseObject pointerUser, ParseObject pointerCourse){
        Progreso_cursosEntry tabla = new Progreso_cursosEntry();
        ParseObject progreso_curso = new ParseObject(tabla.getTableName());
        progreso_curso.put(tabla.getUserID(), pointerUser);
        progreso_curso.put(tabla.getCourseID(), pointerCourse);
        progreso_curso.put(tabla.getAccuracy(), 0);
        progreso_curso.put(tabla.getFinished(), false);
        progreso_curso.put(tabla.getProgress(), 0);
        progreso_curso.saveInBackground();
    }

    private void setProgreso_Chapters(ParseObject pointerUser, ParseObject pointerCourse){
        ChaptersEntry tabla = new ChaptersEntry();
        Progreso_ChaptersEntry tabla2 = new Progreso_ChaptersEntry();
        List<ParseObject> ob = null;
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(tabla.getTableName());
            query.whereEqualTo(tabla.getCurso(), pointerCourse);
        try {
            ob = query.find();
            for(ParseObject chapter : ob){
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

    private void setProgreso_Preguntas(ParseObject pointerUser, ParseObject pointerChapter){
        QuestionEntry tabla = new QuestionEntry();
        Progreso_QuestionEntry tabla2 = new Progreso_QuestionEntry();
        List<ParseObject> ob = null;
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(tabla.getTableName());
        query.whereEqualTo(tabla.getChapterID(), pointerChapter);
        try {
            ob = query.find();
            for(ParseObject question : ob){
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


    public List<ParseObject> getAllMyCourses(ParseObject pointerUser){
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


    public List<ParseObject> getAllChapter(ParseObject pointerUser, ParseObject pointerCourse){
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


}
