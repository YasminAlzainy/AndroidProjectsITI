package yasmin.ayman.alzainy.startserviceintent;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ReceiveImage extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_image);

        try {
            Intent intent = getIntent();
            String imgFile = intent.getStringExtra("imgFile");
            FileInputStream fileInputStream = openFileInput(imgFile);
            Bitmap bitmap = BitmapFactory.decodeStream(fileInputStream);
            imageView = findViewById(R.id.imageView);
            imageView.setImageBitmap(bitmap);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
