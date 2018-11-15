package com.example.alqahtag.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public class NoteEditingActivity extends AppCompatActivity {

    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_editing);
        radioGroup = (RadioGroup) findViewById(R.id.inputEdite);
    }

    public void onDoneClick(View v){
        Intent intent = new Intent();
        Uri uri = Uri.parse(radioGroup.getContext().toString());
        intent.setData(uri);
        setResult(RESULT_OK, intent);
        finish();
    }
}
