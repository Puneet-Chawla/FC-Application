package com.example.student.fc;


import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Timer;
import java.util.TimerTask;

public class Walkin extends AppCompatActivity {
    private RecyclerView mrecyclerView;
    FirebaseDatabase database;
    DatabaseReference myRef;
public static String website;
ProgressDialog progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offcampus);
        getSupportActionBar().setTitle("Walk In");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Recycler View
        mrecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mrecyclerView.setHasFixedSize(true);
        mrecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Send a Query to the database
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Data").child("0").child("company");

        progress = new ProgressDialog(this);
        progress.setMessage("Fetching Data...");
        progress.setTitle("Walk In");
//        progress.setIcon(R.mipmap.ic_launcher);
        progress.setCancelable(false);
        progress.show();
        Timer t = new Timer();
        t.schedule(new Walkin.waitingtimer(), 6000);
    }
    private class waitingtimer extends TimerTask {
        @Override
        public void run() {

            runOnUiThread(new Runnable() {

                @Override
                public void run() {

                    progress.dismiss();

                }
            });
        }

    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<AddCompany, BlogViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<AddCompany, BlogViewHolder>(
                        AddCompany.class,
                        R.layout.card_layout,
                        BlogViewHolder.class,
                        myRef) {


                    @Override
                    protected void populateViewHolder(BlogViewHolder viewHolder, AddCompany model, int position) {

                        viewHolder.setCompanyName(model.getCompany_name());
                        viewHolder.setCompanyLocation( model.getJob_location());
                        viewHolder.setSalary( model.getSalary());
                        viewHolder.setDuration(model.getLast_date());
                        viewHolder.sendurl(model.getApply_url());
                        viewHolder.sendqualification(model.getQualification());
                        viewHolder.sendexperience(model.getExperience());
                        viewHolder.sendwebsite(model.getCompany_website());
                    }
                };

        mrecyclerView.setAdapter(firebaseRecyclerAdapter);
    }



    public static class BlogViewHolder extends RecyclerView.ViewHolder {
        View mView;


        public BlogViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

// oncluck on cardd view i want intent

                }
            });
        }

        public void setCompanyName(String name) {
            TextView post_title = (TextView) mView.findViewById(R.id.item_title);
            post_title.setText(name);
        }
        public void setDuration(String duration)
        {
            TextView Duration=(TextView)mView.findViewById(R.id.item_duration);
            Duration.setText(duration);
        }

        public void setCompanyLocation( String location) {
            TextView post_image = (TextView) mView.findViewById(R.id.item_detail);
            post_image.setText(location);
        }
        public void setSalary(String salary)
        {
            TextView Salary=(TextView)mView.findViewById(R.id.item_salary);
            Salary.setText(salary);
        }
        public void sendurl(String url)
        {
            TextView post_image = (TextView) mView.findViewById(R.id.item_url);
            post_image.setVisibility(View.GONE);
        }
        public void sendqualification(String qua)
        {
            TextView post_image = (TextView) mView.findViewById(R.id.item_qualification);
            post_image.setText("N/A");

        }
        public void sendexperience(String exp)
        {
            TextView post_image = (TextView) mView.findViewById(R.id.item_experience);
            post_image.setText(exp);

        }
        public void sendwebsite(String web)
        { website=web;
            TextView post_image = (TextView) mView.findViewById(R.id.item_website);
            post_image.setText(web);

        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        if (id==android.R.id.home) {
            finish();
        }
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}

