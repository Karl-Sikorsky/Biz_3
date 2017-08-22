package com.example.biz_3.Presenter;
/**
 * Created by Karl on 16.05.2017.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.biz_3.Model.CustomItemClickListener;
import com.example.biz_3.Model.Enterprise;
import com.example.biz_3.R;

import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;


public class RVAdapter extends RecyclerView.Adapter<RVAdapter.EnterpriseViewHolder> {
    String CUSTOM_ACTION = "com.example.biz_3.YOUR_ACTION";
    Context context;
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
           // chooseActivity();
        }
    };

    private void chooseActivity() {
        Intent i = new Intent();
        i.setAction(CUSTOM_ACTION);

      startActivity(this.context,i,null);
    }

    public RVAdapter(Context applicationContext, List<Enterprise> enterprises, CustomItemClickListener listener){
        //for(int i=0;i<enterprises.size();i++)this.enterprises.add(enterprises.get(i));
        this.enterprises = enterprises;
        this.context = applicationContext;
        this.listener = listener;
        Log.d("onAdapter", "constructor called");
        for(int i=0;i<enterprises.size();i++){
        Log.d("onAdapter", "on constructor data: "+enterprises.get(i).getName()+enterprises.get(i).getDescription());}
    }
    /*@Override
    public int getItemCount(){
    return enterprises.size();
    }*/
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

        personViewHolder.name.setText(enterprises.get(i).getName());
        personViewHolder.description.setText(enterprises.get(i).getDescription());
        personViewHolder.city.setText(enterprises.get(i).getCity());
        personViewHolder.category.setText(enterprises.get(i).getCategory());
        personViewHolder.telephon.setText(enterprises.get(i).getTelephon());

    }

    @Override
    public int getItemCount() {
        return enterprises.size();
    }


    }