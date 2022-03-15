package com.example.myplaces;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    Button conection;
    Button conection2;
    Button conection3;
    Button conection4;
    Socket s;
    PrintWriter writer;
    TextView number;
    TextView number2;
    TextView number3;
    TextView number4;
    String mens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        conection = (Button) findViewById(R.id.conection);
        number = (TextView) findViewById(R.id.number);
        conection2 = (Button) findViewById(R.id.conection);
        number2 = (TextView) findViewById(R.id.number);
        conection3 = (Button) findViewById(R.id.conection);
        number3 = (TextView) findViewById(R.id.number);
        conection4 = (Button) findViewById(R.id.conection);
        number4 = (TextView) findViewById(R.id.number);

        onBtnClick();
    }

    public void onBtnClick() {

        conection.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                checkRight b4 = new checkRight();
                checkLeft b3 = new checkLeft();
                checkDown b2 = new checkDown();
                checkUp b1 = new checkUp();
                b1.execute();
                b2.execute();
                b3.execute();
                b4.execute();
            }
        });
    }

    class checkUp extends AsyncTask<String, Void, Void> {

        Handler h = new Handler();
        @Override
        protected Void doInBackground(String... voids) {
            try {
                //mens = String.valueOf(i);
                mens= "↑";
                if(s == null){
                    //change it to your IP
                    s = new Socket("192.168.0.17",6000);
                    writer = new PrintWriter(s.getOutputStream());
                    Log.i("i", "CONNECTED");
                }
                writer.write(mens);
                writer.flush();
                //writer.close();
                ///i = i+1;
                h.post(new Runnable() {
                    @Override
                    public void run() {
                        number.setText(mens);
                    }
                });
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

    }
    class checkDown extends AsyncTask<String, Void, Void> {

        Handler h = new Handler();
        @Override
        protected Void doInBackground(String... voids) {
            try {
                //mens = String.valueOf(i);
                mens= "↓";
                if(s == null){
                    //change it to your IP
                    s = new Socket("192.168.0.17",6000);
                    writer = new PrintWriter(s.getOutputStream());
                    Log.i("i", "CONNECTED");
                }
                writer.write(mens);
                writer.flush();
                //writer.close();
                ///i = i+1;
                h.post(new Runnable() {
                    @Override
                    public void run() {
                        number.setText(mens);
                    }
                });
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

    }
    class checkLeft extends AsyncTask<String, Void, Void> {

        Handler h = new Handler();
        @Override
        protected Void doInBackground(String... voids) {
            try {
                //mens = String.valueOf(i);
                mens= "←";
                if(s == null){
                    //change it to your IP
                    s = new Socket("192.168.0.17",6000);
                    writer = new PrintWriter(s.getOutputStream());
                    Log.i("i", "CONNECTED");
                }
                writer.write(mens);
                writer.flush();
                //writer.close();
                ///i = i+1;
                h.post(new Runnable() {
                    @Override
                    public void run() {
                        number.setText(mens);
                    }
                });
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

    }
    class checkRight extends AsyncTask<String, Void, Void> {

        Handler h = new Handler();
        @Override
        protected Void doInBackground(String... voids) {
            try {
                //mens = String.valueOf(i);
                mens= "→";
                if(s == null){
                    //change it to your IP
                    s = new Socket("192.168.0.17",6000);
                    writer = new PrintWriter(s.getOutputStream());
                    Log.i("i", "CONNECTED");
                }
                writer.write(mens);
                writer.flush();
                //writer.close();
                ///i = i+1;
                h.post(new Runnable() {
                    @Override
                    public void run() {
                        number.setText(mens);
                    }
                });
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

    }
}
