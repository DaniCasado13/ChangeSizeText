package com.danicc.changesizetext.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.danicc.changesizetext.ChangeSizeApplication;
import com.danicc.changesizetext.model.Message;
import android.content.Intent;
import com.danicc.changesizetext.databinding.ActivityChangeSizeTextBinding;


public class ChangeSizeTextActivity extends AppCompatActivity {

private ActivityChangeSizeTextBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityChangeSizeTextBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btSend.setOnClickListener(view -> {
            btSendOnClick();
        });
    }

    private void btSendOnClick() {
        //1.Crear objeto Bundle.
        //2. Añadir el objeto message al Bundle.
        //3. Enviar Intent con el Bundle.

        Bundle bundle= new Bundle();

        //Para obtener el usuario de la clase Applicaction: obtenemos la clase Application (getApplication()),
        //hacemos casting a ChangeSizeApplication
        // utilizamos getUser(). para coger el usuario
        Message message= new Message(((ChangeSizeApplication)getApplication()).getUser(),
                binding.edTexto.getText().toString(),binding.skSize.getProgress());

        bundle.putSerializable("message",message);
        Intent intent= new Intent(this,ViewMessageActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}