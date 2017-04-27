package com.example.imab.imab_group33;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Invite_Activity extends AppCompatActivity {


    private EditText invite_text;
    private String message;
    private String to;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite);

        invite_text=(EditText) findViewById(R.id.invite_text);

        String GroupID;
        Bundle bundle = getIntent().getExtras();
        GroupID =bundle.getString("GroupID");
        message= GroupID;


        //sendEmail(invite_text.toString(),"invitation to the best group ever",message);

    }
    public void invite_button(View view){
        to= invite_text.getText().toString();
        invitar(to,"invitation to the best group ever",message);
    }

    public void invitar(String to,String sub,String mes){
        Log.i("Send email", "");

        String[] TO = {to};
        //String[] CC = {"xyz@gmail.com"};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");


        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        //emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, sub);
        emailIntent.putExtra(Intent.EXTRA_TEXT,mes);

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(Invite_Activity.this,
                    "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }

}
