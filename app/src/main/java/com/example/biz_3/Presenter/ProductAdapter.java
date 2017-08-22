package com.example.biz_3.Presenter;

/**
 * Created by ПОДАРУНКОВИЙ on 19.05.2017.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.biz_3.Model.CustomItemClickListener;
import com.example.biz_3.Model.Product;
import com.example.biz_3.R;

import java.util.List;


public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    public static class ProductViewHolder extends RecyclerView.ViewHolder {


        TextView name;
        TextView price;
        ImageView image;


        ProductViewHolder(View itemView) {
            super(itemView);

            name = (TextView)itemView.findViewById(R.id.product_name);
            price = (TextView)itemView.findViewById(R.id.product_price);
            image = (ImageView)itemView.findViewById(R.id.product_image);



        }
    }

    List<Product> products;


    CustomItemClickListener listener = new CustomItemClickListener() {
        @Override
        public void onItemClick(View v, int position) {
            Toast.makeText(v.getContext(), "item "+String.valueOf(position), Toast.LENGTH_SHORT).show();

        }
    };

    public ProductAdapter(List<Product> products, CustomItemClickListener listener){
        this.products = products;
        this.listener = listener;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }





    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product_card, viewGroup, false);
        final ProductViewHolder pp = new ProductViewHolder(v);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v, pp.getAdapterPosition());
            }
        });

        return pp;
    }

    @Override
    public void onBindViewHolder(ProductViewHolder persnViewHolder, int i) {
        persnViewHolder.name.setText(products.get(i).getName());


    }

    @Override
    public int getItemCount() {
        return products.size();
    }


}