package com.example.biz_3;

/**
 * Created by ПОДАРУНКОВИЙ on 16.05.2017.
 */

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {


        TextView name;


        CategoryViewHolder(View itemView) {
            super(itemView);

            name = (TextView)itemView.findViewById(R.id.category_card);


        }
    }

    List<Category> categories;


    CustomItemClickListener listener = new CustomItemClickListener() {
        @Override
        public void onItemClick(View v, int position) {
            Toast.makeText(v.getContext(), "item "+String.valueOf(position), Toast.LENGTH_SHORT).show();
        }
    };

    CategoryAdapter(List<Category> categories, CustomItemClickListener listener){
        this.categories = categories;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }





    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.category_card, viewGroup, false);
        final CategoryViewHolder pp = new CategoryViewHolder(v);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v, pp.getAdapterPosition());
            }
        });

        return pp;
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder persnViewHolder, int i) {
        persnViewHolder.name.setText(categories.get(i).getName());


    }

    @Override
    public int getItemCount() {
        return categories.size();
    }


}