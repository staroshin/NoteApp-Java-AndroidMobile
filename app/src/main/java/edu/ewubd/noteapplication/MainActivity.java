package edu.ewubd.noteapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    private ListView list_view;
    DatabaseClass db_class;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        list_view = (ListView) findViewById(R.id.listview);




        db_class = new DatabaseClass(this);

        show_data();

        Button create = findViewById(R.id.create);
        Button exit = findViewById(R.id.exit);


        create.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CreateNote.class);
                startActivity(i);
            }
        });




        exit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

    private void show_data()
    {
        Cursor d = db_class.get_data();



        ArrayList<String> list = new ArrayList<>();






        if(d.getCount()==0){
            Toast.makeText(MainActivity.this,"No Data",Toast.LENGTH_LONG).show();
        }
        else{
            while(d.moveToNext())
            {
                list.add(d.getString(0)+ "\n"+ d.getString(1)+"\n"+ d.getString(2));


            }


            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.one_item,R.id.item,list);

            list_view.setAdapter(adapter);



            list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
                {

                    Intent t = new Intent(MainActivity.this, UpdateNote.class);
                    startActivity(t);



                }
            });




        }


    }




}
