package com.wexos.guru.education.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.wexos.guru.education.model.Question;

import java.util.ArrayList;
import java.util.List;

public class DBAdapter_Data_WareHouse extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;

    // Database Name
    private static final String DATABASE_NAME = "onlineicttutorQuiz_Data_WareHouse";

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

    public DBAdapter_Data_WareHouse(Context context) {
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

        Question q1=new Question("A data warehouse is which of the following","Can be updated by end users", "Contains numerous naming conventions and formats", "Organized around important subject areas.", " Contains only current data","Contains only current data");
        this.addQuestion(q1);

        Question q2=new Question("A snowflake schema is which of the following types of tables","Fact", "Dimension", " Helper", "All of the above","All of the above");
        this.addQuestion(q2);

        Question q3=new Question("  The full form of OLAP is ","Online Analytical Processing", "Online Advanced Processing", "Online Advanced Preparation ", "Online Analytical Performance","Online Analytical Performance");
        this.addQuestion(q3);

        Question q4=new Question(" The data Warehouse is","read only", "write only", "read write only", "none","  read only");
        this.addQuestion(q4);

        Question q5=new Question("Expansion for DSS in DW is "," Decision Support system", "  Decision Single System", " Data Storable System", "Data Support System","Decision Support system");
        this.addQuestion(q5);

        Question q6=new Question("The important aspect of the data warehouse environment is that data found within the data warehouse is","subject-oriented", " time-variant", "integrated", "All of the above","All of the above");
        this.addQuestion(q6);

        Question q7=new Question("The time horizon in Data warehouse is usually"," 1-2 years", "3-4years", "5-6 years", "5-10 years","5-10 years");
        this.addQuestion(q7);

        Question q8=new Question("__________describes the data contained in the data warehouse"," Relational data", "Operational data", "Metadata", " Informational data","Metadata");
        this.addQuestion(q8);

        Question q9=new Question("____________predicts future trends & behaviors, allowing business managers to make proactive,knowledge-driven decisions","Data warehouse", "Data mining", "Datamarts", "Metadata","Data mining");
        this.addQuestion(q9);

        Question q10=new Question("  ________________ is the specialized data warehouse database","Oracle", " DBZ", "Informix", "Redbrick","Redbrick");
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


