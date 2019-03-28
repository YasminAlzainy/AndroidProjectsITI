package yasmin.ayman.alzainy.thread;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Json extends AppCompatActivity {
    private Handler jsonHandler;
    private EditText editTextRank, editTextCountry, editTextPopulation;
    private ImageView imageViewJson;
    private Button btnNext, btnPrev;
    private String jsonUrl;
    public static int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
        editTextCountry = findViewById(R.id.editTextCountry);
        editTextPopulation = findViewById(R.id.editTextPopulation);
        editTextRank = findViewById(R.id.editTextRank);
        imageViewJson = findViewById(R.id.imageViewJson);
        btnNext = findViewById(R.id.btnNext);
        btnPrev = findViewById(R.id.btnPrev);
        jsonHandler = new Handler();
        jsonUrl = "https://www.androidbegin.com/tutorial/jsonparsetutorial.txt";

        new CountryAsync().execute(jsonUrl, String.valueOf(counter));


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter == 10) {
                    counter = 0;
                } else {
                    counter++;
                }
                new CountryAsync().execute(jsonUrl, String.valueOf(counter));


            }
        });

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter == 0) {
                    counter = 9;
                } else {
                    counter--;
                }
                new CountryAsync().execute(jsonUrl, String.valueOf(counter));
            }
        });
    }

    private class CountryAsync extends AsyncTask<String, Void, Country> {

        @Override
        protected Country doInBackground(String... strings) {
            return downloadJson(strings[0], Integer.parseInt(strings[1]));
        }

        @Override
        protected void onPostExecute(Country country) {
            super.onPostExecute(country);
            editTextCountry.setText(country.getCountry());
            editTextPopulation.setText(country.getPopulation());
            editTextRank.setText(country.getRank());
        }

        private Country downloadJson(String url, int counter) {
            Country countryObj = null;
            try {
                String rank = "not found", country = "not found", population = "not found", flag = "not found";
                HttpHandler httpHandler = new HttpHandler();
                String jsonString = httpHandler.makeServiceCall(url);
                JSONObject jsonObject = new JSONObject(jsonString);
                JSONArray jsonArray = (JSONArray) jsonObject.getJSONArray("worldpopulation");
                JSONObject objInArray = jsonArray.getJSONObject(counter);
                rank = objInArray.getString("rank");
                country = objInArray.getString("country");
                population = objInArray.getString("population");
                flag = objInArray.getString("flag");

                countryObj = new Country(country, population, rank);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return countryObj;
        }

    }


}
