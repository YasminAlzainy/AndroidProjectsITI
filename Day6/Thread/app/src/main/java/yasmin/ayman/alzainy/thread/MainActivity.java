package yasmin.ayman.alzainy.thread;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    private EditText ETImag;
    private Button btnNext, btnDownload;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ETImag = findViewById(R.id.TFImgUrl);
        imageView = findViewById(R.id.imageView);
        btnDownload = findViewById(R.id.btnDownload);
        btnNext = findViewById(R.id.btnNext);

        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new ImageAsync().execute(ETImag.getText().toString());

            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jsonIntent = new Intent(MainActivity.this, Json.class);
                startActivity(jsonIntent);
            }
        });

    }

    private class ImageAsync extends AsyncTask<String, Void, Bitmap> {


        public ImageAsync(){}

        @Override
        protected Bitmap doInBackground(String... urls) {
            Bitmap result = null;
            try {
                URL imagUrl = new URL(urls[0]);
                HttpsURLConnection urlConnection = (HttpsURLConnection) imagUrl.openConnection();
                urlConnection.connect();
                InputStream inputStream = urlConnection.getInputStream();
                result = BitmapFactory.decodeStream(inputStream);


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            imageView.setImageBitmap(bitmap);
        }
    }


}
