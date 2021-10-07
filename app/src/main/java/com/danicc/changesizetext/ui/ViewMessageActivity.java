package com.danicc.changesizetext.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.danicc.changesizetext.ChangeSizeApplication;
import com.danicc.changesizetext.databinding.ActivityViewMessageBinding;
import com.danicc.changesizetext.R;
import com.danicc.changesizetext.model.Message;

public class ViewMessageActivity extends AppCompatActivity {


    private static final String TAG = "ViewMessageActivity";
    ActivityViewMessageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityViewMessageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //1. Recoger Intent
        Intent intent= getIntent();
        //2.Recoger el mensaje
        Message message= (Message) intent.getSerializableExtra("message");
        binding.tvUser.setText(message.getUser().toString());
        binding.tvTexto.setText(message.getMessage());
        binding.tvTexto.setTextSize(message.getSize());


        /**
         * Todas las Activitys tienen acceso a la clase Application desde el método getApplication,
         * se debe aplicar un casting explícito.
         */
        Log.i(TAG,((ChangeSizeApplication)getApplication()).getUser().toString());
    }
}