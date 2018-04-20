package com.example.student2.webclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    Button translate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        translate = (Button) findViewById(R.id.button);
        translate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView = (TextView) findViewById(R.id.Answer);
                editText = (EditText) findViewById(R.id.text);
                translate(editText.getText().toString(), "en-ru");
            }
        });
    }

    void translate (String text, String lang) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://translate.yandex.net/api/v1.5/tr.json/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        TranslationInterface api = retrofit.create(TranslationInterface.class);
        Call<Word> call = api.getTranslation(text, lang, "trnsl.1.1.20170817T125107Z.599626fc31ee267a.cbc3b921a77cb183e65409c51de10b392ff7df7d");
        call.enqueue(new Callback<Word>() {
            @Override
            public void onResponse(Call<Word> call, Response<Word> response) {
                Word word = response.body();
                if (word != null)
                    textView.setText(word.getText().get(0));
            }

            @Override
            public void onFailure(Call<Word> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}