package yasmin.ayman.alzainy.startserviceintent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String imgUrl = intent.getStringExtra("imgFile");

        Intent receiveImageIntent = new Intent(context.getApplicationContext(), ReceiveImage.class);
        receiveImageIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("imgFile", imgUrl);
        context.startActivity(receiveImageIntent);
    }
}
