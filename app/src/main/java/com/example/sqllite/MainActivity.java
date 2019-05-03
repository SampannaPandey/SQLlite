package com.example.sqllite;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import helper.MyHelper;


public class MainActivity extends AppCompatActivity {
    EditText etWord, etMeaning;
    Button btnAddWord,btndisplayword,btnsearchword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etWord = findViewById(R.id.etWord);
        etMeaning = findViewById(R.id.etMeaning);
        btnAddWord = findViewById( R.id.btnAddWord);
        btndisplayword=findViewById(R.id.btndisplayword);
        btnsearchword=findViewById(R.id.btnsearchword);


        final MyHelper myHelper = new MyHelper (this);
        final SQLiteDatabase sqLiteDatabase = myHelper.getWritableDatabase();



        btndisplayword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,DisplayWord.class);
                startActivity(intent);
            }
        });

        btnsearchword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Searchword.class);
                startActivity(intent);
            }
        });

        btnAddWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long id=myHelper.InsertData(etWord.getText().toString(),etMeaning.getText().toString(),sqLiteDatabase);
                if (id>0){
                    Toast.makeText(MainActivity.this, "Successfull", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
