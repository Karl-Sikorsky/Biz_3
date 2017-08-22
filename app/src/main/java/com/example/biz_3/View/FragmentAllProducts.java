package com.example.biz_3.View;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.biz_3.Model.CustomItemClickListener;
import com.example.biz_3.Model.Product;
import com.example.biz_3.Presenter.ProductAdapter;
import com.example.biz_3.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Karl on 20.05.2017.
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




        return view;
        }

    private void initAdapter(){
        ProductAdapter adapter = new ProductAdapter(productList, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

                Toast.makeText(getActivity().getApplication().getApplicationContext(), "item "+String.valueOf(position), Toast.LENGTH_SHORT).show();
                mListener.onChooseList(position);
                productList = new ArrayList<>();


                getDialog().dismiss();
            }
        });
       all_rv.setAdapter(adapter);
    }
    private void initData() {
        productList = new ArrayList<Product>();
        Log.d("fragmentAll","try to get activity");
        InfoActivity activity = (InfoActivity) getActivity();
        Log.d("fragmentAll","sucsess to get activity");
        Log.d("fragmentAll","size: "+String.valueOf(activity.getProductList().size()));
        for(int i=0;i<activity.getProductList().size();i++){

            productList.add(new Product(activity.getProductList().get(i).getImage(),activity.getProductList().get(i).getName(),0));

        }
        initAdapter();
    }
    @Override
public void onClick(View v) {

        Toast.makeText(getActivity().getApplicationContext(),"BUY",Toast.LENGTH_SHORT).show();

        }

        // ...
        }