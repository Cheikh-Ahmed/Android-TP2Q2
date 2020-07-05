package com.example.tp2q2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private LinearLayout layoutscrol;
    RelativeLayout layout;
    private Button btn;
    private EditText edt;
    private ScrollView scrol;
    TextView textView;
    String chaine = "";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initviews();
        btn.setOnClickListener(this);
     if(savedInstanceState!=null){
       String txt =  savedInstanceState.getString("text");
       TextView tview =new TextView(this);
         tview.setTextColor(Color.WHITE);
         tview.setText(txt);
         layoutscrol.addView(tview);
     }

    }
    private void initviews(){
        layout=findViewById(R.id.dynamic);
        btn = findViewById(R.id.creer);
        edt = findViewById(R.id.edt);
        scrol=findViewById(R.id.scrol);
        layoutscrol=findViewById(R.id.layoutscrol);

    }


    public void onClick(View v) {
        if(v.getId()==R.id.creer){
            if (isEditTextEmpty(edt))
                return;
             textView = new TextView(this);
            String txt =  " Bienvennue " +edt.getText()+ "\n" ;
//            chaine = chaine + txt +"/n";
            textView.setTextColor(Color.WHITE);
            textView.setText(txt);
            edt.setText("");
            layoutscrol.addView(textView);

        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("text",textView.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        savedInstanceState.getString("text");
    }
    private boolean isEditTextEmpty(EditText editText) {
        if (editText.getText().toString().isEmpty()) {
            editText.requestFocus();
            editText.setError("Champ obligatoire!");
            return true;
        }
        return false;
    }
}