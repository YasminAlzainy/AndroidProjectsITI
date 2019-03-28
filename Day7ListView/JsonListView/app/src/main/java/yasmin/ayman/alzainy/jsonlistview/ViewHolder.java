package yasmin.ayman.alzainy.jsonlistview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder {
    private ImageView imageView;
    private TextView name , desc;
    private View currentView;

    public ViewHolder(View currentView) {
        this.currentView = currentView;
    }

    public ImageView getImageView() {
        if(imageView ==  null)
            imageView = currentView.findViewById(R.id.imageView);
        return imageView;
    }

    public TextView getName() {
        if (name == null)
            name = currentView.findViewById(R.id.textViewDay);
        return name;
    }

    public TextView getDesc() {
//        if (name == null)
//            name = currentView.findViewById(R.id.textViewDesc);
        return desc;
    }

}
