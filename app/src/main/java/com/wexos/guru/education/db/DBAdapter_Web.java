package com.wexos.guru.education.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.wexos.guru.education.model.Question;

import java.util.ArrayList;
import java.util.List;

public class DBAdapter_Web extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;

    // Database Name
    private static final String DATABASE_NAME = "onlineicttutorQuiz_Web_Technology";

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

    public DBAdapter_Web(Context context) {
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

        Question q1=new Question("Output of XML document can be viewed as"," Word processor", "Web browser", "Notepad", " None of the above","Web browser");
        this.addQuestion(q1);

        Question q2=new Question("XML","Can be used as a database", " Cannot be used as a database", " XML is not a database ,it is language", "None of these","Can be used as a database");
        this.addQuestion(q2);

        Question q3=new Question(" Let most segment of a name inn DNS represents  ","Individual Network", "Individual computer", "Domain name", "Network type","Individual computer");
        this.addQuestion(q3);

        Question q4=new Question(" How many root element can an XML document have ","One", "Two", " Three", "As many as the memory provides","One");
        this.addQuestion(q4);

        Question q5=new Question("The tags in XML are"," Case insensitive", " Case sensitive", " Browser dependent", "None of these"," Case sensitive");
        this.addQuestion(q5);

        Question q6=new Question("Which of the following attributes below are used for a font name","Fontname", "fn", "Font", "Face","Face");
        this.addQuestion(q6);

        Question q7=new Question("CIDR stands for "," Classified Internet Domain Routing", "Classless Inter Domain Routing", "Classless Internet Domain Routing", "Classified Inter Domain Routing","Classless Inter Domain Routing");
        this.addQuestion(q7);

        Question q8=new Question("Which of the following protocol is not used in the internet ","Telnet", "WIRL", "HTTP", "Gopher","WIRL");
        this.addQuestion(q8);

        Question q9=new Question("The XML DOM object is","Entity", "Entity reference", "Comment reference", "Comment data","Entity reference");
        this.addQuestion(q9);

        Question q10=new Question(" Attributes in XML are ","Elements inXML", "Child nodes", "A way of attaching characteristics or properties to elements of a document", "None of these","A way of attaching characteristics or properties to elements of a document");
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


