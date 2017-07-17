package com.wexos.guru.education.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.wexos.guru.education.model.Question;
import com.wexos.guru.education.model.Question;

import java.util.ArrayList;
import java.util.List;

public class DBAdapter_Asp extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;

    // Database Name
    private static final String DATABASE_NAME = "onlineicttutorQuiz_Asp";

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

    public DBAdapter_Asp(Context context) {
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

        Question q1=new Question("Which of the following object is not an ASP component","LinkCounter", "Counter", " AdRotator", "  File Access","LinkCounter");
        this.addQuestion(q1);

        Question q2=new Question("The first event triggers in an aspx page is.","Page_Init()", "  Page_Load()", "Page_click()", " Page_List()","Page_Init()");
        this.addQuestion(q2);

        Question q3=new Question("Which of the following method must be overridden in a custom control","The Paint() method", " The Control_Build() method", "  The default constructor", " The Render() method"," The Render() method");
        this.addQuestion(q3);

        Question q4=new Question(" Which of the following tool is used to manage the GAC","GacMgr.exe", " RegSvr.exe", " GacUtil.exe", "GacSvr32.exe","  GacUtil.exe");
        this.addQuestion(q4);

        Question q5=new Question("Attribute must be set on a validator control for the validation to work","  ControlToValidate", "  ControlToBind", "  ValidateControl", "Validate","ControlToValidate");
        this.addQuestion(q5);

        Question q6=new Question("An alternative way of displaying text on web page using","asp:label", "asp:listitem", "asp:button", "asp:list","asp:label");
        this.addQuestion(q6);

        Question q7=new Question("Which DLL translate XML to SQL in IIS"," SQLISAPI.dll", " SQLXML.dll", " LISXML.dll", "SQLIIS.dll","SQLISAPI.dll");
        this.addQuestion(q7);

        Question q8=new Question("Default scripting language in ASP.","EcmaScript", "VBScript", " PERL", " JavaScript"," VBScript");
        this.addQuestion(q8);

        Question q9=new Question("Mode of storing ASP.NET session"," InProc", "StateServer", "SQL Server", "All of the above","All of the above");
        this.addQuestion(q9);

        Question q10=new Question(" Where do we include the user lists for windows authentication","< Credential>", "< authorization>", "< identity>", "< authentiation>","< authentiation>");
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


