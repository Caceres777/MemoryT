package com.example.owen.pruebasliderfragment;

import android.content.Context;

import com.example.owen.pruebasliderfragment.JavaBean.BeanChapter;
import com.example.owen.pruebasliderfragment.JavaBean.BeanCourse;
import com.example.owen.pruebasliderfragment.JavaBean.BeanQuestions;
import com.example.owen.pruebasliderfragment.data.DataSource;
import com.example.owen.pruebasliderfragment.parse.ParseHelper;
import com.parse.ParseObject;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Owen on 15/04/2015.
 */
public class Controller {

    private Context activity;
    private DataSource datasourse;
    ParseHelper parseHelper;

    public Controller(Context activity){
        this.activity = activity;
        datasourse = new DataSource(activity);
        parseHelper = new ParseHelper();
    }




    public void setCourse(ParseObject course){
        // guardamos en parse
        ParseObject user = ParseUser.getCurrentUser();
        parseHelper.setNewMyCourse(user, course);
        // guardamos en local
        // guardamos curso
        BeanCourse obcurso = parseHelper.getCourseByUserAndCourse(user, course);
        datasourse.insertContactCursos(obcurso);
        // guardamos tema
        List<BeanChapter> obTemas = parseHelper.getTemasByUserFromParse(user, course, activity);
        for(BeanChapter aux : obTemas){
            datasourse.insertContactTemas(aux);
            List<BeanQuestions> obQuestions = parseHelper.getPreguntasByUserFromParse(user, aux.getID_PARSE(), activity);
            for(BeanQuestions aux1 : obQuestions)
                datasourse.insertContactPreguntas(aux1);
        }

    }




    public int getIdCourseFromLocal(String parse_id){
        return datasourse.getCursoByPARSE_ID(parse_id).getID();
    }




    public int getIdCChapterFromLocal(String parse_id){
        return datasourse.getTemasByPARSE_ID(parse_id).getID();
    }




    public List<BeanCourse> getCourseFromLocal(){
        ArrayList<BeanCourse> courses = null;
        courses = datasourse.getCursos();
        return courses;
    }




    public List<BeanChapter> getChapterFromLocal(int IDcourse){
        ArrayList<BeanChapter> chapters = null;
        chapters = datasourse.getTemas(IDcourse);
        return chapters;
    }




    public List<BeanQuestions> getQuestionsFromLocal(int IDchapter){
        ArrayList<BeanQuestions> questions = null;
        questions = datasourse.getPreguntas(IDchapter);
        return questions;
    }




    public void updateQuestionTotal(BeanQuestions question, int wrong){
        datasourse.updatePreguntaTotal(question, wrong);
        parseHelper.updateQuestionTotal(question, wrong);
    }




    public void updateQuestionAsked(BeanQuestions question){
        datasourse.updatePreguntaAsked(question);
        parseHelper.updateQuestionAsked(question);
    }




    public void updateChapter(int chapterID){
        BeanChapter aux = datasourse.getTema(chapterID);
        datasourse.updateChapter(aux);
        aux = datasourse.getTema(chapterID);
        parseHelper.updateChapter(aux);
    }




    public void updateCourse(int courseID){
        BeanCourse aux = datasourse.getCurso(courseID);
        datasourse.updateCourse(aux);
        aux = datasourse.getCurso(courseID);
        parseHelper.updateCourse(aux);
    }
}
