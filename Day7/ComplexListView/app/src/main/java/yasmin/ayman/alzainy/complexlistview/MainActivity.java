package yasmin.ayman.alzainy.complexlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listViewDays;
    private DaysAdapter daysAdapter;
    private Day[] days;

    public MainActivity() {
        days = new Day[]{new Day("Saterday", "Description ", R.drawable.first),
                new Day("Sunday", "Description ", R.drawable.second),
                new Day("Monday", "Description ", R.drawable.first),
                new Day("Tuesday", "Description ", R.drawable.second),
                new Day("Wednesday", "Description ", R.drawable.first),
                new Day("Thursday", "Description ", R.drawable.second),
                new Day("Friday", "Description ", R.drawable.first)

        };
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewDays = findViewById(R.id.listViewDays);

        daysAdapter = new DaysAdapter(MainActivity.this, R.layout.row_layout, R.id.textViewDay,days );

        listViewDays.setAdapter(daysAdapter);

        listViewDays.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listView, View cerruntRowView, int position, long id) {

                Toast.makeText(MainActivity.this, listView.getAdapter().getItem(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });



    }
}
