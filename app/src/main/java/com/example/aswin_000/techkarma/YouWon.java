package com.example.aswin_000.techkarma;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.ShareActionProvider;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class YouWon extends ActionBarActivity {

    private static final String LOG_TAG=YouWon.class.getSimpleName();
    private static final String ShareMsg1="I Have Just Scored ";
    private static  String ShareMsg2_score;
    private static final String ShareMsg3=" Points On Techkarma and Won The Game! Care For A Challenge ?";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_won);

        int a;

        Intent intent2 = getIntent();
        String pname= intent2.getStringExtra("PassedName");
        String pscore=intent2.getStringExtra("PassedScore");

        a=Integer.parseInt(pscore.replaceAll("[\\D]", ""));
        ShareMsg2_score=Integer.toString(a);




        TextView playername= (TextView) findViewById(R.id.xmlname);
        TextView playerscore= (TextView) findViewById(R.id.xmlscore);


        playername.setText(pname);
        playerscore.setText(pscore);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_you_won, menu);
        MenuItem menuItem=menu.findItem(R.id.action_share);

        ShareActionProvider mShareActionProvider= (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);

        if(mShareActionProvider!=null){
            mShareActionProvider.setShareIntent(createShareIntent());
        }
        else
        {
            Log.d(LOG_TAG,"Share Action Provider is null?");
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }

    private Intent createShareIntent(){

        Intent shareIntent= new Intent(Intent.ACTION_SEND);
        shareIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT,ShareMsg1+ShareMsg2_score+ShareMsg3);
        return shareIntent;
    }
}
