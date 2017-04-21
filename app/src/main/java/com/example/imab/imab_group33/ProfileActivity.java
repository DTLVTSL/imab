package com.example.imab.imab_group33;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

/**
 * Created by daniel on 4/21/2017.
 */

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    //firebase auth object
    private FirebaseAuth firebaseAuth;
    private StorageReference mStorageRef;
    //view objects

    private TextView editCodicFisc;
    private EditText editTextName;
    private EditText editTextSurname;
    private EditText DateBirth;
    private Button buttonSave;
    //defining a database reference
    private DatabaseReference databaseReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        //initializing firebase authentication object
        firebaseAuth = FirebaseAuth.getInstance();
        //if the user is not logged in
        //that means current user will return null
        if(firebaseAuth.getCurrentUser() == null){
            //closing this activity
            finish();
            //starting login activity
            startActivity(new Intent(this, LoginActivity.class));
        }
        //getting the database reference
        databaseReference = FirebaseDatabase.getInstance().getReference();
        //getting the views from xml resource
        editCodicFisc = (EditText) findViewById(R.id.editCodicFisc);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextSurname = (EditText) findViewById(R.id.editTextSurname);
        DateBirth = (EditText) findViewById(R.id.editDateBirth);
        buttonSave = (Button) findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(this);
        mStorageRef = FirebaseStorage.getInstance().getReference();

        //getting current user
        FirebaseUser user = firebaseAuth.getCurrentUser();
        //initializing views

    }

    private void saveUserInformation() {
        //Getting values from database
        String name = editTextName.getText().toString().trim();
        String sur = editTextSurname.getText().toString().trim();
        String cod = editCodicFisc.getText().toString().trim();
        String dby = DateBirth.getText().toString().trim();

        //creating a userinformation object
        UserInformation userInformation = new UserInformation(name, sur, cod, dby);

        //getting the current logged in user
        FirebaseUser user = firebaseAuth.getCurrentUser();


        //saving data to firebase database
        /*
        * first we are creating a new child in firebase with the
        * unique id of logged in user
        * and then for that user under the unique id we are saving data
        * for saving data we are using setvalue method this method takes a normal java object
        * */
        databaseReference.child(user.getUid()).setValue(userInformation);

        //displaying a success toast
        Toast.makeText(this, "Information Saved...", Toast.LENGTH_LONG).show();
    }


    //@Override
    public void onClick(View view) {

        if(view == buttonSave){
            saveUserInformation();
            finish();
            startActivity(new Intent(this, LoginActivity.class));

        }


    }
}