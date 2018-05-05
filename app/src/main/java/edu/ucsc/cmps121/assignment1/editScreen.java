package edu.ucsc.cmps121.assignment1;

import java.io.File;
import java.io.FileWriter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;


public class editScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_screen);
    }

    public void returnMain(View view){
        Spinner year = (Spinner) findViewById(R.id.yearList);
        EditText description = (EditText) findViewById(R.id.descBox);
        EditText name = (EditText) findViewById(R.id.nameBox);
        Context context = getApplicationContext();
        File text = new File(context.getFilesDir(), "data.txt");
        String photoInfo="";
        if(year.getSelectedItem().toString()!=null && description.getText().equals("")!=true && name.getText().equals("")!=true) {
            photoInfo = "Year: "+year.getSelectedItem().toString()+ ", Name: "+name.getText()+", Description: " +
                    description.getText();
        }
        try {
            FileWriter writer = new FileWriter(text, true);
            if(photoInfo != ""&& photoInfo!="null") {
                writer.append(photoInfo + "\n");
                writer.close();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finish();
    }
}
