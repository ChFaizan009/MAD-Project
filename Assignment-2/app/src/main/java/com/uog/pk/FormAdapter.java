package com.uog.pk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FormAdapter extends RecyclerView.Adapter<FormAdapter.MyViewHolder> {
    public static List<Model_Class> nocModels = new ArrayList<>();
    FormDBMS db ;
    FormActivity act = new FormActivity();
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_layout,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);


        return myViewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(nocModels.get(position).getName());
        holder.RegistrationNo.setText(nocModels.get(position).getF_Name());
        holder.RollNo.setText(nocModels.get(position).getGender());
        holder.ModeOfReceive.setText(nocModels.get(position).getCGPA());
        db = new FormDBMS(holder.itemView.getContext());
        holder.itemView.findViewById(R.id.btnDel).setOnClickListener(v ->{
            String Rolltodel = nocModels.get(position).getF_Name();




            nocModels.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position,nocModels.size());

            boolean check = db.deleteUserData(Rolltodel);

        });




    }



    @Override
    public int getItemCount() {
        return nocModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
   {
    TextView name;
    TextView RegistrationNo;
    TextView RollNo;
    TextView ModeOfReceive;

       public MyViewHolder(@NonNull View itemView) {
           super(itemView);
           name = itemView.findViewById(R.id.txtviewNameloc);
           RegistrationNo  = itemView.findViewById(R.id.txtviewregnoloc);
           RollNo = itemView.findViewById(R.id.txtviewRollnuloc);
           ModeOfReceive = itemView.findViewById(R.id.txtviewModeloc);


       }

   }

    public List<Model_Class> getNocModels() {
        return nocModels;
    }

    public void setNocModels(List<Model_Class> nocModels) {
        this.nocModels = nocModels;
    }
}

