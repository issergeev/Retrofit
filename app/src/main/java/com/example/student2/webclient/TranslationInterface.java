package com.example.student2.webclient;

import android.graphics.Canvas;
import android.telecom.Call;

import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by student2 on 20.04.18.
 */

public interface TranslationInterface {
    @GET("translate")
    public retrofit2.Call<Word>
        getTranslation(@Query("text") String text,
                       @Query("lang") String lang,
                       @Query("key") String APIKEY);
}