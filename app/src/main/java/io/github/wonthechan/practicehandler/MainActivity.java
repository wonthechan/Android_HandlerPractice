package io.github.wonthechan.practicehandler;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView textView;
    Button startButton;
    Button stopButton;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.countTextView);
        startButton = (Button) findViewById(R.id.startButton);
        stopButton = (Button) findViewById(R.id.stopButton);

        // switch 형식으로 리스너 달아주기
        startButton.setOnClickListener(this);
        stopButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.startButton:
            {
                cntHandler.sendEmptyMessage(0);
                break;
            }
            case R.id.stopButton:
            {
                cntHandler.removeMessages(0);
                break;
            }
        }
    }

    Handler cntHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            cntHandler.sendEmptyMessageDelayed(0, 1000);
            count++;
            textView.setText(""+count);
        }
    };


}
