package com.werkncode.android.myappportfolio;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 _______   ______    __       __    ______
 |   ____| /  __  \  |  |     |  |  /  __  \
 |  |__   |  |  |  | |  |     |  | |  |  |  |
 |   __|  |  |  |  | |  |     |  | |  |  |  |
 |  |     |  `--'  | |  `----.|  | |  `--'  |
 |__|      \______/  |_______||__|  \______/

    app portfolio created for Udacity nanodegree by Ryan Radford

 github.com/werkn
 werkn.github.io

 */

public class MainActivity extends ActionBarActivity {

    //start our DetailActivity, display info about the app that was clicked.
    public void launchAppDescription(View view) {

        //method is called from Button, typecast to grab the app title
        Button b = (Button) view;
        String appName = b.getText().toString();

        //setup info to send to intent, future version will use appName to grab actual description
        //for now... placeholder text
        String[] appInfo = {
            appName,
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
            "Nunc fermentum at arcu nec mattis. Donec venenatis vestibulum " +
            "mi vel pellentesque. Integer aliquam ex eget maximus tempor. Integer " +
            "ex magna, pellentesque eu massa eu, dapibus elementum justo."
        };

        //executed in an Activity, so 'this' is Context
        Intent appDescrIntent = new Intent(this, DetailActivity.class);
        appDescrIntent.putExtra(this.getApplication().toString(), appInfo);
        startActivity(appDescrIntent);
    }

    //TODO: remove
    //display "Boogie Nights" in a toast when profile pic is clicked
    //this is gimmicky will remove later just wanted to see how to setup toasts
    public void burtQoute(View view) { showToast(view.getContext(), "Boogie Nights."); }
    private void showToast(Context context, String message) {

        //Note!  In order to one line this you need to call show.
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    /*
     Attempt to launch site via browser using explicit intent
     docs:  http://developer.android.com/guide/components/intents-filters.html
    */
    private void launchWebsite(String url) {

        try {
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse(url));

            startActivity(intent);

        //according to docs, *some* devices may not have installed apps to support explicit intents
        } catch (ActivityNotFoundException e) {
            Log.e(this.getClass().toString(), "No activity found to launch intent.");
        } catch (NullPointerException e) {
            Log.e(this.getClass().toString(), "null url given to method `launchWebsite`");
        }
    }

    //repo fork button events
    public void forkRepoBitbucket(View view) { launchWebsite("https://www.bitbucket.com/werkn"); }
    public void forkRepoGithub(View view) { launchWebsite("https://www.github.com/werkn"); }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //ActionBar link to website clicked
        if (id == R.id.action_website) {
            launchWebsite("http://werkn.github.io");
        }

        return super.onOptionsItemSelected(item);
    }

}
