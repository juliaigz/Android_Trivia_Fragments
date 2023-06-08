package com.example.trivia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.trivia.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mbinding;
    private Button button1;
    private EditText editText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        mbinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mbinding.getRoot());

        button1 = mbinding.button1;
        editText1 = mbinding.editText1;

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Crea una instancia del fragmento MessageFragment
                BlankFragment fragment = BlankFragment.newInstance(editText1.getText().toString());
                // Obtiene el administrador de fragmentos
                FragmentManager fragmentManager = getSupportFragmentManager();
                // Inicia una transacción de fragmento
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                // Reemplaza el contenido del contenedor con el fragmento MessageFragment
                transaction.replace(mbinding.container.getId(), fragment);
                // Opcional: añade la transacción a la pila de retroceso
                transaction.addToBackStack(null);
                // Realiza la transacción
                transaction.commit();


            }
        });




    }
}