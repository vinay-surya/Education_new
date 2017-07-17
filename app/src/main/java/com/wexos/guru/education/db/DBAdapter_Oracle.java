package com.wexos.guru.education.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.wexos.guru.education.model.Question;

import java.util.ArrayList;
import java.util.List;

public class DBAdapter_Oracle extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;

    // Database Name
    private static final String DATABASE_NAME = "onlineicttutorQuiz_Oracle";

    // Table name
    private static final String TABLE_QUESTION = "question";

    // Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_QUESION = "question";
    private static final String KEY_ANSWER = "answer"; //correct option
    private static final String KEY_OPTA = "opta"; //option a
    private static final String KEY_OPTB = "optb"; //option b
    private static final String KEY_OPTC = "optc"; //option c
    private static final String KEY_OPTD = "optd"; //option d

    private SQLiteDatabase myDatabase;

    public DBAdapter_Oracle(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        myDatabase = db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUESTION + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUESION
                + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
                + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT, " + KEY_OPTD + " TEXT)";

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

    public int rowCount() {
        int row = 0;
        String selectQuery = "SELECT  * FROM " + TABLE_QUESTION;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row = cursor.getCount();
        return row;
    }

    public List<Question> getAllQuestions() {

        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUESTION;
        myDatabase = this.getReadableDatabase();

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

    private void addQuestions() {
        //format is question-option1-option2-option3-option4-answer

        Question q1=new Question(" Which processes is an instance made of Oracle","Oracle background processes", "Memory processes", "Data processes", "All of the Mentioned","Oracle background processes");
        this.addQuestion(q1);

        Question q2=new Question(" Which of the following segment is destroyed when the SQL statement is finished","Data Segment", " Object Segment", " Temporary Segment", "All of the Mentioned","Temporary Segment");
        this.addQuestion(q2);

        Question q3=new Question("What is the use of an index"," Retrieve data more quickly and efficiently", "Related data requires much less I/O overhead if accessed simultaneously", "Related data requires much less I/O overhead if accessed simultaneously", "All of the Mentioned","Retrieve data more quickly and efficiently");
        this.addQuestion(q3);

        Question q4=new Question("Which of the following components comprise an Oracle architecture","Database related background processes", "Database related background processes", "Database related background processes", " All of the Mentioned","  All of the Mentioned");
        this.addQuestion(q4);

        Question q5=new Question(" What is the use of extent in Oracle"," Stores user data within the database", " Stores user data within the database", " Stores user data within the database", " None of the Mentioned"," Minimize the amount of wasted (empty) storage");
        this.addQuestion(q5);

        Question q6=new Question("Which area of PGA stores binding variables and run-time buffers information"," SQL area", "Private SQL area", "Stack space", "Stack space","Private SQL area");
        this.addQuestion(q6);

        Question q7=new Question(" In Oracle, which of below are types of segments"," Permanent Segment", "Object Segment", "Data Segment", "All of the Mentioned","Data Segment");
        this.addQuestion(q7);

        Question q8=new Question("The redo log buffer and Shared pool are elements of ","PGA", "Buffer cache", "PGA and Buffer cache", "SGA","SGA");
        this.addQuestion(q8);

        Question q9=new Question(" The Oracle environment of database is called as ___________","  Database Schema", "Database Instances", " Data Structure", " All of the Mentioned"," All of the Mentioned");
        this.addQuestion(q9);

        Question q10=new Question(" Which is the smallest unit of storage in an Oracle database","Data Block", "Segment ", "Extent", "Data File","Data Block");
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


