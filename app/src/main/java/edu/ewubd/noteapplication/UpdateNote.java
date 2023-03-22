package edu.ewubd.noteapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateNote extends AppCompatActivity {


    DatabaseClass db_class;
    private EditText title,des,id;
    private Button update,back;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_note);

        id = findViewById(R.id.id);
        title = findViewById(R.id.title);
        des = findViewById(R.id.des);


        update = findViewById(R.id.update);
        back = findViewById(R.id.back);

        db_class = new DatabaseClass(this);


        update_data();


        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(UpdateNote.this, MainActivity.class);
                startActivity(i);
            }
        });


    }



    public void update_data()
    {
        update.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                boolean isUpdated = db_class.update_data(id.getText().toString(),title.getText().toString(), des.getText().toString());

                if(isUpdated == true)
                {
                    Toast.makeText(UpdateNote.this,"Note Updated",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(UpdateNote.this,"Failed",Toast.LENGTH_LONG).show();
                }
            }
        });



    }




}