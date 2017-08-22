package com.example.biz_3.View;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.biz_3.R;

/**
 * Created by ПОДАРУНКОВИЙ on 20.05.2017.
 */

public class FragmentInfoProduct extends DialogFragment implements View.OnClickListener {
    public static interface MyInterface {
        public void onChoose(String tag);
    }

    private MyInterface mListener;

    @Override
    public void onAttach(Activity activity) {
        mListener = (MyInterface) activity;
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        mListener = null;
        super.onDetach();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product,
                container, false);
        InfoActivity activity = (InfoActivity) getActivity();
        TextView tv = (TextView)view.findViewById(R.id.nametv);
        tv.setText(activity.getProductList().get(activity.getCurrentProduct()).getName());

        Log.d("frgPrd",activity.getProductList().get(activity.getCurrentProduct()).getName());
        getDialog().setTitle(activity.getProductList().get(activity.getCurrentProduct()).getName());
        Button nextButton = (Button) view.findViewById(R.id.buttonBuy);
        nextButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getActivity().getApplicationContext(),"BUY",Toast.LENGTH_SHORT).show();
        mListener.onChoose("info");
        getDialog().dismiss();
    }

    // ...
}