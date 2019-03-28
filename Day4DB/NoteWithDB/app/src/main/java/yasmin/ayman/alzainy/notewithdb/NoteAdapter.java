package yasmin.ayman.alzainy.notewithdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class NoteAdapter {

    private static final String TITLE = "Title";
    private static final String BODY = "Body";
    private static final String NOTE_TABLE = "note_table";

    private NoteHelper noteHelper;
    private Context context;
    private SQLiteDatabase databaseWriter, databaseReader;


    public NoteAdapter(Context _context) {
        context = _context;
        noteHelper = new NoteHelper(context);
        databaseWriter = noteHelper.getWritableDatabase();
        databaseReader = noteHelper.getReadableDatabase();
    }

    public void insert(String title, String body) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(TITLE, title);
        contentValues.put(BODY, body);

        databaseWriter.insert(NOTE_TABLE ,null , contentValues);

    }

    public String retrieve (String title)
    {
        String body = null;
        // WHERE Title = " + title;
        String query= "SELECT 'Body' FROM " +NOTE_TABLE;
        String selection = "Title = ? ";
        String [] columns = {"Body"};
        String []SelectionArgs  = {title};
        Cursor cursor = databaseReader.query(NOTE_TABLE ,columns,selection,SelectionArgs ,null ,
                null , null);

        while (cursor.moveToNext())
        {
            body = cursor.getString(cursor.getColumnIndex("Body"));
        }
        return body;
    }

    public boolean update() {
        return false;
    }

    public boolean delete() {
        return false;
    }

    public String query() {
        return null;
    }


    ////////////////////////////
    public class NoteHelper extends SQLiteOpenHelper {
        private Context context;
        private static final int DATABASE_VERSION = 1;
        private static final String DATABASE_NAME = "mydb.db";
        private static final String TABLE_NAME = "Notes";
        private static final String TITLE = "title";
        private static final String BODEY = "body";


        public NoteHelper(Context _context) {
            super(_context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String query = "CREATE TABLE note_table( Title VARCHAR(255), Body VARCHAR(255))";
            db.execSQL(query);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
