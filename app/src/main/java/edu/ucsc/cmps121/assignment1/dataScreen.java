package edu.ucsc.cmps121.assignment1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.FileWriter;

public class dataScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_screen);
        Intent intent=getIntent();
        String dataString=intent.getStringExtra("data");
        TextView dataDisplay = (TextView) findViewById(R.id.photoData);
        dataDisplay.setText(dataString);
    }

    public void clearData(View view){
        Context context = getApplicationContext();
        File text = new File(context.getFilesDir(), "data.txt");
        try{
            FileWriter writer = new FileWriter(text, false);
            writer.write("Here's the list of photos you saved:\n\n");
            writer.close();
            TextView dataDisplay = (TextView) findViewById(R.id.photoData);
            dataDisplay.setText("Here's the list of photos you saved:\n\n");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
