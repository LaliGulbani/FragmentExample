package laligulbani.by.fragmentexample;

import android.app.IntentService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.widget.Toast;


public class MyIntentService extends IntentService {

    final static String KEY_INT_FROM_SERVICE = "KEY_INT_FROM_SERVICE";
    final static String KEY_STRING_FROM_SERVICE = "KEY_STRING_FROM_SERVICE";
    final static String ACTION_UPDATE_CNT = "UPDATE_CNT";
    final static String ACTION_UPDATE_MSG = "UPDATE_MSG";

    final static String KEY_MSG_TO_SERVICE = "KEY_MSG_TO_SERVICE";
    final static String ACTION_MSG_TO_SERVICE = "MSG_TO_SERVICE";

    MyServiceReceiver myServiceReceiver;
    int cnt;

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    public void onCreate() {
        Toast.makeText(getApplicationContext(), "onCreate", Toast.LENGTH_LONG).show();
        myServiceReceiver = new MyServiceReceiver();
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(getApplicationContext(), "onStartCommand", Toast.LENGTH_LONG).show();

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_MSG_TO_SERVICE);
        registerReceiver(myServiceReceiver, intentFilter);

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(getApplicationContext(), "onDestroy", Toast.LENGTH_LONG).show();
        unregisterReceiver(myServiceReceiver);
        super.onDestroy();
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        cnt = 10;
        while (cnt >= 0) {
            try {
                Thread.sleep(1000);

                Intent i = new Intent();
                i.setAction(ACTION_UPDATE_CNT);
                i.putExtra(KEY_INT_FROM_SERVICE, cnt);
                sendBroadcast(i);

                cnt--;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public class MyServiceReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(ACTION_MSG_TO_SERVICE)) {
                String msg = intent.getStringExtra(KEY_MSG_TO_SERVICE);

                Intent i = new Intent();
                i.setAction(ACTION_UPDATE_MSG);
                i.putExtra(KEY_STRING_FROM_SERVICE, msg);
                sendBroadcast(i);
            }
        }
    }
}