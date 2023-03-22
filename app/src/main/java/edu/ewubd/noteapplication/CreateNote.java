package edu.ewubd.noteapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateNote extends AppCompatActivity {


    DatabaseClass dbclass;
    private EditText title,des;
    private Button save,back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_note);

        title = findViewById(R.id.title);
        des = findViewById(R.id.des);


        save = findViewById(R.id.save);
        back = findViewById(R.id.back);

        dbclass = new DatabaseClass(this);
        save_data();


        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CreateNote.this, MainActivity.class);
                startActivity(i);
            }
        });


    }

    public void save_data()
    {
        save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                boolean isInserted = dbclass.add_data(title.getText().toString(), des.getText().toString());

                if(isInserted == true)
                {
                    Toast.makeText(CreateNote.this,"Note Created",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(CreateNote.this,"Failed",Toast.LENGTH_LONG).show();
                }
            }
        });



    }




}