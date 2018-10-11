package net.ozero.timertaskpractice;

import android.app.IntentService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class RestartTimeServiceReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Log.i(getClass().getName(), "onReceive");

        Intent startServiceIntent = new Intent(context, IntentService.class);
        context.startService(startServiceIntent);
    }
}
