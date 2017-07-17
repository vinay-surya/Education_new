package com.wexos.guru.education.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.wexos.guru.education.model.Question;

import java.util.ArrayList;
import java.util.List;

public class DBAdapter_Software extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;

    // Database Name
    private static final String DATABASE_NAME = "onlineicttutorQuiz_Software_Testing";

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

    public DBAdapter_Software(Context context) {
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

        Question q1=new Question(" Which of the following is NOT a white box technique"," Statement testing", "Path testing", "State transition testing", " Data flow testing","State transition testing");
        this.addQuestion(q1);

        Question q2=new Question("Which of these activities provides the biggest potential cost saving from the use of CAST","Test management", " Test execution", " Test execution", "Test planning","Test execution");
        this.addQuestion(q2);

        Question q3=new Question(" Which of the following would NOT normally form part of a test plan ","Features to be tested", "Risks", "Incident reports ", "Schedule","Schedule");
        this.addQuestion(q3);

        Question q4=new Question(" A program with high cyclometic complexity is almost likely to be:","Difficult to test", "Small", " Difficult to write", "Large"," Difficult to test");
        this.addQuestion(q4);

        Question q5=new Question("Which one of the following is not a check to be applied to import data during a validation run "," Image checks", " Parity checks", " Passwords", "Sequence checks","Image checks");
        this.addQuestion(q5);

        Question q6=new Question("White-box testing can be started :","after SRS creation", "after designing", "after programming", "after installation","after programming");
        this.addQuestion(q6);

        Question q7=new Question("Running the system under a live environment using Live data in order to find errors is known as"," Beta Testing", "Alpha Testing", "Acceptance Testing", "System Testing","Acceptance Testing");
        this.addQuestion(q7);

        Question q8=new Question("Testing of software with actual data and in actual environment is called : ","IAlpha testing", "IAlpha testing", "Regression testing", "None"," Beta testing");
        this.addQuestion(q8);

        Question q9=new Question("The testing of software against SRS is called :"," Acceptance testing", "Integration testing", "Regression testing", "System testing","System testing");
        this.addQuestion(q9);

        Question q10=new Question(" “Black” refers in the “Black-box” testing means","Characters of the movie “Black”", "I – O is hidden", "Design is hidden", "Users are hidden","Design is hidden");
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


