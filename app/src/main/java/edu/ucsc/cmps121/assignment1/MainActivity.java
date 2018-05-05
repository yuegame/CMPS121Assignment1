package edu.ucsc.cmps121.assignment1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context = getApplicationContext();
        File text = new File(context.getFilesDir(), "data.txt");
        try {
            FileWriter writer = new FileWriter(text, true);
            writer.append("Here's the list of photos you saved:\n\n");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void editScreen(View view){
        Intent intent = new Intent(this, editScreen.class);
        startActivity(intent);
    }

    public void dataScreen(View view){
        Intent intent = new Intent(this, dataScreen.class);
        Context context = getApplicationContext();
        File text = new File(context.getFilesDir(), "data.txt");
        String dataLine;
        String dataList="";
        try {
            BufferedReader br = new BufferedReader(new FileReader(text));
            dataLine=br.readLine();
            while(dataLine!=null){
                dataList+=dataLine;
                dataList+="\n";
                dataLine=br.readLine();
            }
            br.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        intent.putExtra("data", dataList);
        startActivity(intent);
    }

    public void exitButton(View view){
        finish();
        System.exit(0);
    }
}
