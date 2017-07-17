package com.wexos.guru.education.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.wexos.guru.education.model.Question;

import java.util.ArrayList;
import java.util.List;

public class DBAdapter extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;

    // Database Name
    private static final String DATABASE_NAME = "onlineicttutorQuiz_Java";

    // Table name
    private static final String TABLE_QUESTION = "question";

    // Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_QUESION = "question";
    private static final String KEY_ANSWER = "answer"; //correct option
    private static final String KEY_OPTA= "opta"; //option a
    private static final String KEY_OPTB= "optb"; //option b
    private static final String KEY_OPTC= "optc"; //option c
    private static final String KEY_OPTD= "optd"; //option d

    private SQLiteDatabase myDatabase;

    public DBAdapter(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        myDatabase=db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUESTION + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUESION
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC +" TEXT, "+KEY_OPTD+" TEXT)";

        db.execSQL(sql);

        addQuestions();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTION);

        // Create tables again
        onCreate(db);
    }

    public int rowCount()
    {
        int row=0;
        String selectQuery = "SELECT  * FROM " + TABLE_QUESTION;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }

    public List<Question> getAllQuestions() {

        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUESTION;
        myDatabase=this.getReadableDatabase();

        Cursor cursor = myDatabase.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setId(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOptionA(cursor.getString(3));
                quest.setOptionB(cursor.getString(4));
                quest.setOptionC(cursor.getString(5));
                quest.setOptionD(cursor.getString(6));

                quesList.add(quest);

            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }

    private void addQuestions()
    {
        //format is question-option1-option2-option3-option4-answer


        Question q1 = new Question("What is the return type of a method that does not returns any value", "int", "float", "void", "double", "void");
        this.addQuestion(q1);

        Question q2 = new Question("What is the process of defining more than one method in a class differentiated by method signature", "Function overriding", "Function overloading", "Function doubling", "None ", "Function overloading");
        this.addQuestion(q2);

        Question q3 = new Question("Which of the following is a method having same name as that of it’s class", "finalize", " delete", " class", "constructor", "constructor");
        this.addQuestion(q3);

        Question q4 = new Question("Which method can be defined only once in a program ", "main method", "finalize method", " static method", "private method", "main method");
        this.addQuestion(q4);

        Question q5 = new Question("Which class does not override the equals() and hashCode() methods, inheriting them directly from class Object ", "java.lang.String", "java.lang.Double", "java.lang.StringBuffer", "java.lang.Character", "java.lang.StringBuffer");
        this.addQuestion(q5);

        Question q6 = new Question("Which interface does java.util.Hashtable implement", "Java.util.Map", "Java.util.List", "Java.util.HashTable", "Java.util.Collection", "Java.util.Map");
        this.addQuestion(q6);

        Question q7 = new Question("Which of these packages contain all the collection classes ", "java.lang", " java.util", " java.net", "java.awt", " java.util");
        this.addQuestion(q7);

        Question q8 = new Question(" Which of these classes is not part of Java’s collection framework ", "Maps", " Array", " Stack", "Queue", "Queue");
        this.addQuestion(q8);

        Question q9 = new Question("Which of these methods deletes all the elements from invoking collection ", "clear()", " reset()", "delete()", "refresh()", "clear()");
        this.addQuestion(q9);

        Question q10 = new Question("What is Collection in Java ", "A group of objects", "A group of classes", "A group of classes", "None", "A group of objects");
        this.addQuestion(q10);


    }


    // Adding new question
    public void addQuestion(Question quest) {

        ContentValues values = new ContentValues();
        values.put(KEY_QUESION, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOptionA());
        values.put(KEY_OPTB, quest.getOptionB());
        values.put(KEY_OPTC, quest.getOptionC());
        values.put(KEY_OPTD, quest.getOptionD());

        // Inserting Row
        myDatabase.insert(TABLE_QUESTION, null, values);
    }


}