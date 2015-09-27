package abassawo.c4q.nyc.ecquo.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import java.util.Random;

import abassawo.c4q.nyc.ecquo.R;

public class LauncherActivity extends Activity {

    private static final int SPLASHTIME = 3000;
    private static final int STOPSPLASH = 0;
    private Handler mSplashHandler;
    public TextView showQuote;
    Context context;

    // Handler start
    {
        mSplashHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case STOPSPLASH:
                        Intent intent = new Intent(LauncherActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                }
            }
        };
    }
// Handler end


        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        //Get array of quotes
        showQuote = (TextView) findViewById(R.id.quote_text);
        String[] quotes = getResources().getStringArray(R.array.quotes);
        int randomIndex = new Random().nextInt(quotes.length);
        String quote = quotes[randomIndex];
        showQuote.setText(quote);

//        {
//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                /* Create an Intent that will start the Menu-Activity. */
//                    Intent mainIntent = new Intent(LauncherActivity.this, MainActivity.class);
//                    LauncherActivity.this.startActivity(mainIntent);
//                    LauncherActivity.this.finish();
//                }
//            }, SPLASHTIME);



            // to start the handler
         mSplashHandler.sendEmptyMessageDelayed(STOPSPLASH, SPLASHTIME);
        }
    }
