package yasmin.ayman.alzainy.startserviceintent;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;


public class StarterIntentService extends IntentService {

    public static final String FILE_OUTPUT = "Image_Service";
    private static final String TAG = "service";
    private String imgUrl = "https://www.androidbegin.com/tutorial/flag/china.png";
    private MyBroadcastReceiver broadcastReceiver;

    public StarterIntentService() {
        super("StarterIntentService");
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i(TAG, "start");

        IntentFilter filter = new IntentFilter("sendBroadcastIntent");
        broadcastReceiver = new MyBroadcastReceiver();
        registerReceiver(broadcastReceiver, filter);

        //imgUrl = intent.getStringExtra(MainActivity.URL_IMG);
        try {
            URL imagUrl = new URL(imgUrl);
            HttpsURLConnection urlConnection = (HttpsURLConnection) imagUrl.openConnection();
            urlConnection.connect();
            InputStream inputStream = urlConnection.getInputStream();
            Bitmap result = BitmapFactory.decodeStream(inputStream);

            FileOutputStream outPutStream = openFileOutput(FILE_OUTPUT, MODE_PRIVATE);
            result.compress(Bitmap.CompressFormat.PNG, 100, outPutStream);

            broadcastSender(FILE_OUTPUT);
            Log.i(TAG, "end");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcastReceiver);
    }

    public void broadcastSender(String imgFile) {
        Intent intent = new Intent();
        intent.setAction("sendBroadcastIntent");
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        intent.putExtra("imgFile", imgFile);
        sendBroadcast(intent);
    }

}
