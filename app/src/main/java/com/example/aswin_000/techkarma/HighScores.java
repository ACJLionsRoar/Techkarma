package com.example.aswin_000.techkarma;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class HighScores extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_scores);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }



        Context ctx=this;
        HighScoresDBHelper hsop=new HighScoresDBHelper(ctx);
        Cursor CR=hsop.getinfo(hsop);

        ArrayList<String> allnames=new ArrayList<String>();
        for(CR.moveToFirst(); !CR.isAfterLast(); CR.moveToNext()) {
            allnames.add(CR.getString(0));
        }

        ArrayList<String> allscores=new ArrayList<String>();
        for(CR.moveToFirst(); !CR.isAfterLast(); CR.moveToNext()) {
            allscores.add(CR.getString(1));
        }

        ArrayList<String> displaylist=new ArrayList<String>();

        int numberofpeoplestored=allnames.size();

        for(int i=0;i<numberofpeoplestored;i++)
        {
            displaylist.add(allnames.get(i)+"        "+allscores.get(i));
        }



        //String fakedata[]={"Test1","Test2","Test3","Test4","Test5"};
        ArrayAdapter<String> HighScoresAdapter;

        //  List<String> allscoreslist = new ArrayList<String>(
        //          Arrays.asList(allnames));

        HighScoresAdapter = new ArrayAdapter<String>(
                getApplicationContext(),
                R.layout.highscoreslistview,
                R.id.highscores_textview,
                displaylist);

        ListView listView = (ListView) findViewById(R.id.highscores_listview);

        listView.setAdapter(HighScoresAdapter);

        Toast.makeText(this, "Database Loaded", Toast.LENGTH_SHORT).show();

       /*
       String allnamesarray[]={};
        String allscoresarray[]={};
        String displaylist[]={};
        int counter=0;
        int i=0;
        String Name;

        do {
            displaylist[i]=CR.getString(0);
            allnamesarray[i]=CR.getString(0);
            allscoresarray[i]=CR.getString(1);
            i++;
            counter++;

        }while(!CR.isAfterLast());

        for (CR.moveToFirst(); !CR.isAfterLast(); CR.moveToNext()) {
            displaylist[i]=CR.getString(0);
            allnamesarray[i]=CR.getString(0);
            allscoresarray[i]=CR.getString(1);
            i++;
            counter++;
        }
        */






    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_high_scores, menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_high_scores, container, false);




            // for(int j=0;j<counter;j++)
            //  {
            //      displaylist[j].concat(":"+allscoresarray[j]);
            //  }

            // Toast.makeText(getActivity(),"High Scores Loaded I Think",Toast.LENGTH_LONG).show();


            return rootView;
        }
    }
}
