package com.example.tarafficlight;

import static com.example.tarafficlight.R.drawable.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {
    private LinearLayout b_1, b_2, b_3;
    private Button button_1;
    private boolean start_stop = false;
    private int counter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b_1 = findViewById(R.id.svet1);
        b_2 = findViewById(R.id.svet2);
        b_3 = findViewById(R.id.svet3);
        button_1 = findViewById(R.id.button1);

    }

    public void onClickStart(View view) {
        if (!start_stop) {
            button_1.setText("STOP");

            start_stop = true;
            button_1.setBackgroundColor(getResources().getColor(R.color.purple_200));
            button_1.setTextColor(getResources().getColor(R.color.purple_700));

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (start_stop) {


                        counter++;
                        switch (counter) {
                            case 1:
                                b_1.setBackgroundColor(getResources().getColor(R.color.red));
                                b_2.setBackgroundColor(getResources().getColor(R.color.great));
                                b_3.setBackgroundColor(getResources().getColor(R.color.great));
                                break;
                            case 2:
                                b_1.setBackgroundColor(getResources().getColor(R.color.great));
                                b_2.setBackgroundColor(getResources().getColor(R.color.yellow));
                                b_3.setBackgroundColor(getResources().getColor(R.color.great));
                                break;
                            case 3:
                                b_1.setBackgroundColor(getResources().getColor(R.color.great));
                                b_2.setBackgroundColor(getResources().getColor(R.color.great));
                                b_3.setBackgroundColor(getResources().getColor(R.color.green));
                                counter = 0;
                                break;
                        }


                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }).start();
        } else {
            start_stop = false;
            button_1.setText("START");
            button_1.setBackgroundColor(getResources().getColor(R.color.teal_200));
            button_1.setTextColor(getResources().getColor(R.color.purple_700));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        start_stop = false;

    }
}