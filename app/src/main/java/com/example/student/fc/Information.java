package com.example.student.fc;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Information extends AppCompatActivity {
    public TextView companyname;
    public TextView jobrole;
    public TextView qualification;
    public TextView location;
    public TextView salary;
    public TextView website;
    String Website,Applyurl,Qualification,Jobrole;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        getSupportActionBar().setTitle("Job Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        companyname = (TextView)findViewById(R.id.cn);
        jobrole = (TextView)findViewById(R.id.job);
        qualification = (TextView)findViewById(R.id.qualification);
        location = (TextView)findViewById(R.id.location);
        salary = (TextView)findViewById(R.id.salary);
        website = (TextView)findViewById(R.id.website);

         Website = getIntent().getStringExtra("website");
         Qualification = getIntent().getStringExtra("qualification");
         Applyurl = getIntent().getStringExtra("url");

        qualification.setText(Qualification);
        website.setText(Website);

    }

    public void Apply(View v)
    {
        Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse(Applyurl));
        startActivity(i);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_card_demo, menu);
        return true;
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
