package com.wexos.guru.education.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.wexos.guru.education.model.Question;

import java.util.ArrayList;
import java.util.List;

public class DBAdapter_Devops extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;

    // Database Name
    private static final String DATABASE_NAME = "onlineicttutorQuiz_JavaScript";

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

    public DBAdapter_Devops(Context context) {
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

        Question q1=new Question("Why so JavaScript and Java have similar name","JavaScript is a stripped-down version of Java", "JavaScript's syntax is loosely based on Java's", "They both originated on the island of Java", "  None of the above","JavaScript's syntax is loosely based on Java's");
        this.addQuestion(q1);

        Question q2=new Question(" ______ JavaScript is also called client-side JavaScript","Microsoft", " Navigator", "LiveWire", "Native","Navigator");
        this.addQuestion(q2);

        Question q3=new Question(" What are variables used for in JavaScript Programs ","Storing numbers, dates, or other values", "Storing numbers, dates, or other values", "Storing numbers, dates, or other values ", "None of the above","Storing numbers, dates, or other values");
        this.addQuestion(q3);

        Question q4=new Question("  Which of the following is not a valid JavaScript variable name","2names", "_first_and_last_names", "  FirstAndLast", "None of the above"," 2names");
        this.addQuestion(q4);

        Question q5=new Question("______ tag is an extension to HTML that can enclose any number of JavaScript  "," <SCRIPT>", " <BODY>", " <HEAD>", "<HEAD>","<SCRIPT>");
        this.addQuestion(q5);


        Question q6=new Question("Which of the following attribute can hold the JavaScript version","LANGUAGE", " SCRIPT", "VERSION", "None of the above"," LANGUAGE");
        this.addQuestion(q6);

        Question q7=new Question("What does the <noscript> tag do","  Enclose text to be displayed by non-JavaScript browsers", "Prevents scripts on the page from executing", "Describes certain low-budget movies", "None of the above"," Enclose text to be displayed by non-JavaScript browsers");
        this.addQuestion(q7);

        Question q8=new Question("JavaScript entities start with _______ and end with _________","Semicolon, colon", " Semicolon, Ampersand", "Ampersand, colon", "Ampersand, semicolon","Ampersand, semicolon");
        this.addQuestion(q8);

        Question q9=new Question("Which of the following best describes JavaScript"," a low-level programming language", "a scripting language precompiled in the browser", "a compiled scripting language", "an object-oriented scripting language","an object-oriented scripting language");
        this.addQuestion(q9);

        Question q10=new Question(" JavaScript is can be written ","directly into JS file and included into HTML", "None of these", "directly on the Server Script", "directly into HTML pages","directly into HTML pages");
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


