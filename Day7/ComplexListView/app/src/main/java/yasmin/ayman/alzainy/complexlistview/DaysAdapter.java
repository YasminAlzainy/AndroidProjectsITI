package yasmin.ayman.alzainy.complexlistview;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class DaysAdapter extends ArrayAdapter<Day> {
    private Context context;
    private Day[] days;
    private static int counter = 0;
    private ViewHolder viewHolder;


    public DaysAdapter(Context context, int resource, int textViewResourceId, Day[] days) {
        super(context, resource, textViewResourceId, days);
        this.context = context;

        this.days = days;
    }

    @Override
    public View getView(int position, View currentRowView, ViewGroup listView) {
//        super.getView(position, cerruntRowView, listView);
//        View row = null;
//        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        row = layoutInflater.inflate(R.layout.row_layout ,listView,false);
//
//        ImageView imageView = row.findViewById(R.id.imageView);
//        TextView name = row.findViewById(R.id.textViewDay);
//       // TextView desc = row.findViewById(R.id.editTextDesc);
//        imageView.setImageResource(days[position].getImag());
//        name.setText(days[position].getName());
//
//        counter++;
//        Log.i("ListView" , Integer.toString(counter));


        super.getView(position, currentRowView, listView);
        View row = currentRowView;

        if (currentRowView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout, listView, false);
            viewHolder = new ViewHolder(row);
            row.setTag(viewHolder);
            counter++;
        } else {

            viewHolder = (ViewHolder) row.getTag();
            Log.i("ListView", "recycle");

        }

        viewHolder.getName().setText(days[position].getName());
        viewHolder.getImageView().setImageResource(days[position].getImag());

        Log.i("ListView", Integer.toString(counter));
        return row;
    }
}
