package com.example.trivia;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.trivia.databinding.FragmentBlankBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private FragmentBlankBinding mbinding2;
    private TextView textViewHola;
    private Button button2;

    private String hola;

    public BlankFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance(String param1) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment NUEVA FORMA PARA binding FRAGMENTOS
        mbinding2=FragmentBlankBinding.inflate(inflater, container, false);
        textViewHola = mbinding2.textViewHola;
        button2 = mbinding2.button2;


        textViewHola.setText("Hola "+mParam1);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = mbinding2.radioGroup.indexOfChild(mbinding2.radioGroup.findViewById(mbinding2.radioGroup.getCheckedRadioButtonId()));

                if (index == 2){
                    hola= "Ganaste";
                } else {
                    hola = "Perdiste";
                }

                llamarFragment2(hola);

            }
        });

        return mbinding2.getRoot();
    }

    public void llamarFragment2(String texto){

        // Crea una instancia del fragmento MessageFragment
        BlankFragment2 fragment = BlankFragment2.newInstance(mParam1, texto);
        // Obtiene el administrador de fragmentos
        FragmentManager fragmentManager = getFragmentManager(); //para llamar un fragment desde otro ya no se pone support
        // Inicia una transacción de fragmento
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // Reemplaza el contenido del contenedor con el fragmento MessageFragment
        transaction.replace(mbinding2.container2.getId(), fragment);
        // Opcional: añade la transacción a la pila de retroceso
        transaction.addToBackStack(null);
        // Realiza la transacción
        transaction.commit();
    }
}