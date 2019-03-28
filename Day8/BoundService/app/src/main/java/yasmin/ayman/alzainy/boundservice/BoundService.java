package yasmin.ayman.alzainy.boundservice;

import android.app.Service;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Binder;
import android.os.IBinder;

import java.util.Date;
import java.util.Locale;

public class BoundService extends Service {

    private final IBinder myBinder = new MyBinder();

    public BoundService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return myBinder;
    }

    public String getCurrentTime ()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss MM/dd/yyyy",
                Locale.UK);
        return dateFormat.format(new Date());
    }


    public class MyBinder extends Binder
    {
        BoundService getService ()
        {
            return BoundService.this;
        }
    }

}
