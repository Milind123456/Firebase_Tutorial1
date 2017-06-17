package com.example.test.firebase1;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuAdapter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {
    Button mFirebasebtn;
    EditText name,eid;
    TextView tv,tv2;
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFirebasebtn = (Button) findViewById(R.id.button2);
        final DatabaseReference mref = database.getReference();
        name = (EditText) findViewById(R.id.editText);
        eid = (EditText) findViewById(R.id.editText2);
        tv = (TextView) findViewById(R.id.textView);
        mFirebasebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //1 - Create a child in root object
                //2 - Assign value to the child
                String name1 = name.getText().toString();
                String email = eid.getText().toString();

            HashMap<String,String> dataMap = new HashMap<String, String>();
                dataMap.put("Name",name1);
                dataMap.put("E-mail",email);
                dataMap.put("Age","25");
                mref.push().setValue(dataMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this,"Successfull",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this,"Unsuccessfull",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
       
    }
}
