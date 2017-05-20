package com.example.biz_3;

import android.app.DialogFragment;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by ПОДАРУНКОВИЙ on 20.05.2017.
 */

public class FragmentInfoProduct extends DialogFragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product,
                container, false);
        getDialog().setTitle("Имя Предприятия");
        Button nextButton = (Button) view.findViewById(R.id.buttonBuy);
        nextButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getActivity().getApplicationContext(),"BUY",Toast.LENGTH_SHORT).show();

    }

    // ...
}