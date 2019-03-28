package yasmin.ayman.alzainy.myfirebase;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RealTimeDB extends AppCompatActivity {

    public static final String NOTE_USER = "Note_User";
    public static final String NOTE_BODY = "Note_Body";
    public static final String NOTE_TITLE = "Note_Title";

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    private ListView listViewNote;
    private Note note;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_time_db);

        Intent dbIntent = getIntent();
        String title = dbIntent.getStringExtra(ConfirmNoteActivity.TITLE_KEY);
        String body = dbIntent.getStringExtra(ConfirmNoteActivity.BODY_KEY);
        listViewNote = findViewById(R.id.listViewNote);
        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RealTimeDB.this, NoteActivity.class);
                startActivity(intent);
            }
        });

        final ArrayAdapter noteAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1);
        listViewNote.setAdapter(noteAdapter);

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference("Notes");
        Note note = new Note(title, body, "yasmin");
        mDatabaseReference.child(mDatabaseReference.push().getKey()).setValue(note);

        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Note note = dataSnapshot.getValue(Note.class);
                noteAdapter.clear();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    noteAdapter.add(snapshot.getValue(Note.class));
                }
                noteAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        listViewNote.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Note note = (Note) noteAdapter.getItem(position);
                String title = note.getTitle();
                String user = note.getUser();
                String body = note.getBody();

                Intent intent = new Intent(RealTimeDB.this, NoteBody.class);
                intent.putExtra(NOTE_USER, user);
                intent.putExtra(NOTE_TITLE, title);
                intent.putExtra(NOTE_BODY, body);
                startActivity(intent);

            }
        });


    }
}
