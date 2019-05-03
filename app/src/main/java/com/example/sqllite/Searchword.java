package com.example.sqllite;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import helper.MyHelper;
import model.Word;

public class Searchword extends AppCompatActivity {

    private EditText etsearchword;
    private Button btnsearchword;
    private ListView lstword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchword);

        etsearchword=findViewById(R.id.etsearchword);
        btnsearchword=findViewById(R.id.btnSearch);
        lstword=findViewById(R.id.lstWord);


        final MyHelper myHelper =new MyHelper(this);
        final SQLiteDatabase sqLiteDatabase=myHelper.getWritableDatabase();

        btnsearchword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SearchWord();

            }

            private void SearchWord()
            {

                List<Word> wordList =new ArrayList<>();
                wordList=myHelper.GetWordByname(etsearchword.getText().toString(),sqLiteDatabase);

                HashMap<String,String> hashMap=new HashMap<>();

                for (int i=0;i<wordList.size();i++){
                    hashMap.put(wordList.get(i).getWord(),wordList.get(i).getMeaning());
                }


                ArrayAdapter<String> stringArrayAdapter =new ArrayAdapter<>(
                        Searchword.this,
                        android.R.layout.simple_list_item_1,
                        new ArrayList<String>(hashMap.keySet())

                );

                lstword.setAdapter(stringArrayAdapter);

            }
        });





    }
}
