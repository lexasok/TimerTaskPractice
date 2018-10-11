package net.ozero.timertaskpractice;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import net.ozero.timertaskpractice.services.TimerService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(getClass().getName(), "onCreate");
    }

    public void buttonAddClicked(View view) {

        Intent intent = new Intent(this, TimerService.class);
        startService(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent intent = new Intent(this, TimerService.class);
        startService(intent);
    }
}
