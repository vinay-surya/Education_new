package com.wexos.guru.education.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.wexos.guru.education.model.Question;

import java.util.ArrayList;
import java.util.List;

public class DBAdapter_Big_Data extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;

    // Database Name
    private static final String DATABASE_NAME = "onlineicttutorQuiz_Big_Data";

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

    public DBAdapter_Big_Data(Context context) {
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

        Question q1=new Question("What does commodity Hardware in Hadoop world mean"," Very cheap hardware", " Industry standard hardware", "Discarded hardware", "Low specifications Industry grade hardware","Low specifications Industry grade hardware");
        this.addQuestion(q1);

        Question q2=new Question("Which of the following are NOT big data problem(s)","Parsing 5 MB XML file every 5 minutes", " Processing IPL tweet sentiments", " Processing online bank transactions", " both (a) and (c)"," both (a) and (c)");
        this.addQuestion(q2);

        Question q3=new Question(" MapReduce was devised by ","Apple", "Google", "Microsoft ", "Samsung","Google");
        this.addQuestion(q3);

        Question q4=new Question(" HDFS is inspired by which of following Google project","BigTable", "GFS", " MapReduce", "None of the above","GFS");
        this.addQuestion(q4);

        Question q5=new Question("Which of the following is key to solving Big Data problem","MapReduce", "HBase", " HDFS", "All of the above","All of the above");
        this.addQuestion(q5);

        Question q6=new Question("Which of the following is used for machine learning on Hadoop?","Hive", "Pig", "Mahoot", "Mahoot","Mahoot");
        this.addQuestion(q6);

        Question q7=new Question(" Which of the following is used to analyse data stored in Hadoop cluster using SQL like query language","Mahoot", "Hive", "Pig", "All of the above","Hive");
        this.addQuestion(q7);

        Question q8=new Question("The type of data Hadoop can deal with is ","Structred", "Semi-structured", " Unstructured", "All of the above"," All of the above");
        this.addQuestion(q8);

        Question q9=new Question("The data from a remote hadoop cluster can"," not be read by another hadoop cluster", "be read using http", "be read using lan", "be read suing hftp","be read suing hftp");
        this.addQuestion(q9);

        Question q10=new Question("Which of the following technologies is a document store database","HBase", "Hive", "Cassandra", "CouchDB","CouchDB");
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


