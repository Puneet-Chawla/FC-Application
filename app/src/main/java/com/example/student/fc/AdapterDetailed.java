package com.example.student.fc;

/**
 * Created by Student on 6/19/2017.
 */

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AdapterDetailed extends RecyclerView.Adapter<AdapterDetailed.ViewHolder> {

    private String companyName = "Chapter Banglore One";
    private String role = "a";
    private String Salary = "100";
    private String Qualification="B.tech";

    class ViewHolder extends RecyclerView.ViewHolder{

        public int currentItem;
        public TextView companyname;
        public TextView jobrole;
        public TextView qualification;
        public TextView location;
        public TextView salary;
        public TextView website;


        public ViewHolder(View itemView) {
            super(itemView);
            companyname = (TextView)itemView.findViewById(R.id.cn);
            jobrole = (TextView)itemView.findViewById(R.id.job);
            qualification = (TextView)itemView.findViewById(R.id.qualification);
            location = (TextView)itemView.findViewById(R.id.location);
             salary = (TextView)itemView.findViewById(R.id.salary);
            website = (TextView)itemView.findViewById(R.id.website);

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.detailed_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.companyname.setText(companyName);
        viewHolder.jobrole.setText(role);
        viewHolder.qualification.setText(Qualification);
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}

