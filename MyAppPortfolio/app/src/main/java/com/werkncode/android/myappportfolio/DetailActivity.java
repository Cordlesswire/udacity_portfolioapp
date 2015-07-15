package com.werkncode.android.myappportfolio;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class DetailActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String[] data;

        //get the data we sent from MainActivity
        Bundle extras = getIntent().getExtras();
        data = extras.getStringArray(this.getApplication().toString());

        //update TextViews
        TextView appDescr = (TextView) findViewById(R.id.app_detail_descr);
        appDescr.setText(data[1]);
        TextView appName = (TextView) findViewById(R.id.app_detail_name);
        appName.setText(data[0]);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }
}
