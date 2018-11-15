package com.example.alqahtag.myapplication;

import android.content.Intent;
import android.os.ParcelUuid;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ViewAnimator;

import java.util.concurrent.RunnableScheduledFuture;

public class MainActivity extends AppCompatActivity {


    public static final String KEY_NAME = "keyName";
    public static final String KEY_BIRTH = "keyBirth";
    public static final String KEY_GENDER = "keyGender";
    public static final String KEY_EMAIL = "keyEmail";
    public static final int REQUEST_EDIT = 1234;

    private EditText editTextName;
    private EditText editBirth;
    private EditText editGender;
    private EditText editEmail;

    private static final String TAG_LIFECYCLE = "TagLifecycle";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG_LIFECYCLE, "In onCreate() event");
        // initialize widget members
        editTextName = (EditText) findViewById(R.id.inputName);
        editBirth = (EditText) findViewById(R.id.inputBirth);
        editGender = (EditText) findViewById(R.id.inputGender);
        editEmail = (EditText) findViewById(R.id.inputEmail);
    }
//    when the user press for email notification preferences
    public void goEdit(View v){
        Intent note = new Intent(this, NoteEditingActivity.class);
        startActivityForResult(note, REQUEST_EDIT);
    }
//    when the user press Sign-up button
    public void goDisplay(View v){
        Intent Signup = new Intent();
        Signup.setAction("com.example.alqahtah.myapplication.ThirdActivity");
        Signup.putExtra(KEY_NAME, editTextName.getText().toString());
        Signup.putExtra(KEY_BIRTH, Integer.parseInt(editBirth.getText().toString()));
        Bundle bundle = new Bundle();
        bundle.putString(KEY_GENDER, editGender.getText().toString());
        bundle.putString(KEY_EMAIL, editEmail.getText().toString());
        Signup.putExtras(bundle);
        startActivity(Signup);
    }
//    to retrieve  data from Activities started by the startActivityForResult() method
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == REQUEST_EDIT && resultCode == RESULT_OK){
            editEmail.setText(data.getData().toString());
        }
        super.onActivityResult(requestCode,resultCode, data);
    }

     @Override
    public void onStart(){
        super.onStart();
        Log.d(TAG_LIFECYCLE, "In onStart() event");
     }
    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG_LIFECYCLE, "In the onResume() event");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG_LIFECYCLE, "In the onPause() event");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG_LIFECYCLE, "In the onStop() event");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG_LIFECYCLE, "In the onDestroy() event");
    }

}
