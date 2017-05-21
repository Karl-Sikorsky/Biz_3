package com.example.biz_3;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.example.biz_3.R.id.recycle_products;
import static com.example.biz_3.R.id.rv;

public class InfoActivity extends AppCompatActivity implements FragmentInfoProduct.MyInterface, FragmentAllProducts.ListInterface {
    private List<Product> productList;
    private RecyclerView rv;
    private final int ALL_FRAGMENT = 456, FRAGMENT_PRODUCT = 228;
    Button buttonAll;
    FragmentInfoProduct fragmentProduct;
    OrderFragment fragmentOrder;
    FragmentAllProducts fragmentAll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_info);
      getSupportActionBar().hide();

        fragmentProduct = new FragmentInfoProduct();
        fragmentOrder = new OrderFragment();
        fragmentAll = new FragmentAllProducts();
        rv=(RecyclerView)findViewById(R.id.recycle_products);

        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();

        buttonAll = (Button)findViewById(R.id.buttonAll);
        buttonAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentAll.setTargetFragment(fragmentAll,ALL_FRAGMENT);
                fragmentAll.show(getFragmentManager(),"Все продукты");
            }
        });
    }



    private void initializeAdapter(){
        ProductAdapter adapter = new ProductAdapter(productList, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

                Toast.makeText(getApplicationContext(), "item "+String.valueOf(position), Toast.LENGTH_SHORT).show();
                fragmentProduct.setTargetFragment(fragmentProduct, FRAGMENT_PRODUCT);
                fragmentProduct.show(getFragmentManager(), "Имя продукта");

            }
        });
        rv.setAdapter(adapter);
    }
    private void initializeData() {
        productList = new ArrayList<>();
        for(int i=0;i<20;i++){

            productList.add(new Product("url "+String.valueOf(i), "ProductName "+String.valueOf(i), i));

        }
    }

    @Override
    public void onChoose(String tag) {
        Log.d("TAG_TAG","ok, onChoose()");
        Toast.makeText(getApplicationContext(),"GET ON CHOOSE", Toast.LENGTH_SHORT).show();
        fragmentOrder.setTargetFragment(fragmentOrder, 0);
        fragmentOrder.show(getFragmentManager(), "Заказ продукта");

    }

    @Override
    public void onChooseList(int tag) {
        Toast.makeText(getApplicationContext(),"GET ON CHOOSELIST", Toast.LENGTH_SHORT).show();
        fragmentProduct.setTargetFragment(fragmentProduct, FRAGMENT_PRODUCT);
        fragmentProduct.show(getFragmentManager(), "Продукт номер "+tag);

    }

}
