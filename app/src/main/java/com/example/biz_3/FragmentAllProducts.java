package com.example.biz_3;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ПОДАРУНКОВИЙ on 20.05.2017.
 */

public class FragmentAllProducts extends DialogFragment implements View.OnClickListener {
    public FragmentAllProducts() {
    }

    public static interface ListInterface {
        public void onChooseList(int tag);
    }

    private ListInterface mListener;

    @Override
    public void onAttach(Activity activity) {
        mListener = (ListInterface) activity;
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        mListener = null;
        super.onDetach();
    }

private RecyclerView all_rv;
    List<Product> productList;
    private ProductAdapter all_adapter;
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_products,
        container, false);
    getDialog().setTitle("Все продукты");
    all_rv = (RecyclerView) view.findViewById(R.id.recycle_all_products);
    all_rv.setLayoutManager(new GridLayoutManager(getActivity().getApplication().getApplicationContext(),2));
    //setadapter
    initData();
    initAdapter();
    //get your recycler view and populate it.


        return view;
        }

    private void initAdapter(){
        ProductAdapter adapter = new ProductAdapter(productList, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

                Toast.makeText(getActivity().getApplication().getApplicationContext(), "item "+String.valueOf(position), Toast.LENGTH_SHORT).show();
                mListener.onChooseList(position);
                getDialog().dismiss();
            }
        });
       all_rv.setAdapter(adapter);
    }
    private void initData() {
        productList = new ArrayList<>();
        for(int i=0;i<20;i++){

            productList.add(new Product("url "+String.valueOf(i), "ProductName "+String.valueOf(i), i));

        }
    }
    @Override
public void onClick(View v) {

        Toast.makeText(getActivity().getApplicationContext(),"BUY",Toast.LENGTH_SHORT).show();

        }

        // ...
        }