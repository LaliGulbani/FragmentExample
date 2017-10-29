package laligulbani.by.fragmentexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    Button btnStart, btnSend;
    EditText editTextMsgToSend;
    TextView textViewCntReceived, textViewMsgReceived;

    MyReceiver myReceiver;
    Intent myIntent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnStart = (Button) findViewById(R.id.start_service);
        btnSend = (Button) findViewById(R.id.send);
        editTextMsgToSend = (EditText) findViewById(R.id.msg_to_send);
        textViewCntReceived = (TextView) findViewById(R.id.cnt_receive);
        textViewMsgReceived = (TextView) findViewById(R.id.msg_receive);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myIntent = new Intent(Main2Activity.this, MyIntentService.class);
                startService(myIntent);

            }
        });
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msgToService = editTextMsgToSend.getText().toString();

                Intent intent = new Intent();
                intent.setAction(MyIntentService.ACTION_MSG_TO_SERVICE);
                intent.putExtra(MyIntentService.KEY_MSG_TO_SERVICE, msgToService);
                sendBroadcast(intent);
            }
        });
    }


    @Override
    protected void onStart(){
        myReceiver = new MyReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(MyIntentService.ACTION_UPDATE_CNT);
        intentFilter.addAction(MyIntentService.ACTION_UPDATE_MSG);
        registerReceiver(myReceiver, intentFilter);
        super.onStart();
    }

    @Override
    protected void onStop(){
        unregisterReceiver(myReceiver);
        super.onStop();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }

    private class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if(action.equals(MyIntentService.ACTION_UPDATE_CNT)){
                int int_from_service = intent.getIntExtra(MyIntentService.KEY_INT_FROM_SERVICE,0);
                textViewCntReceived.setText(String.valueOf(int_from_service));
            }else  if(action.equals(MyIntentService.ACTION_UPDATE_MSG)){
                String string_from_service = intent.getStringExtra(MyIntentService.KEY_STRING_FROM_SERVICE);
                textViewMsgReceived.setText(String.valueOf(string_from_service));
            }
        }
    }

}
