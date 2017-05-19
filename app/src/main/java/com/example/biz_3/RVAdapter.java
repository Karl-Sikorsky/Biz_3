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


public class RVAdapter extends RecyclerView.Adapter<RVAdapter.EnterpriseViewHolder> {

    public static class EnterpriseViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView name;
        TextView description;
        TextView telephon;
        TextView city;
        TextView category;

        EnterpriseViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            name = (TextView)itemView.findViewById(R.id.enterprise_name);
            description = (TextView)itemView.findViewById(R.id.description);
            telephon = (TextView)itemView.findViewById(R.id.telephon);
            category = (TextView)itemView.findViewById(R.id.category);
            city = (TextView)itemView.findViewById(R.id.city);

        }
    }

    List<Enterprise> enterprises;
    CustomItemClickListener listener = new CustomItemClickListener() {
        @Override
        public void onItemClick(View v, int position) {
            Toast.makeText(v.getContext(), "item "+String.valueOf(position), Toast.LENGTH_SHORT).show();
        }
    };

    RVAdapter(List<Enterprise> enterprises, CustomItemClickListener listener){
        this.enterprises = enterprises;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }





    @Override
    public EnterpriseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.enterprise_card, viewGroup, false);
        final EnterpriseViewHolder pvh = new EnterpriseViewHolder(v);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v, pvh.getAdapterPosition());
            }
        });

        return pvh;
    }

    @Override
    public void onBindViewHolder(EnterpriseViewHolder personViewHolder, int i) {
        personViewHolder.name.setText(enterprises.get(i).name);
        personViewHolder.description.setText(enterprises.get(i).description);
        personViewHolder.city.setText(enterprises.get(i).city);
        personViewHolder.category.setText(enterprises.get(i).category);
        personViewHolder.telephon.setText(enterprises.get(i).telephon);

    }

    @Override
    public int getItemCount() {
        return enterprises.size();
    }


    }