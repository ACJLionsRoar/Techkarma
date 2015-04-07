package com.example.aswin_000.techkarma;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class GameSettings extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_settings);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game_settings, menu);
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

        private ArrayAdapter<String> GameSettingsAdapter;
        private Object adapterView;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_game_settings, container, false);

            String [] settingsoptions = {
                    "Language",
                    "Reset Highscores"
            };


            List<String> options = new ArrayList<String>(
                    Arrays.asList(settingsoptions));

            GameSettingsAdapter = new ArrayAdapter<String>(
                    getActivity(),
                    R.layout.settingslistview,
                    R.id.settings_textview,
                    options);

            ListView listView = (ListView) rootView.findViewById(
                    R.id.settings_listview);

            listView.setAdapter(GameSettingsAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    if (position==0)
                    {
                        Toast.makeText(getActivity(),"Coming Soon.App Still in Beta Test!",Toast.LENGTH_SHORT).show();


                    }
                    else if (position==1)
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                        builder.setMessage("Are you sure you want to delete all highscores from database?")
                                .setCancelable(false)
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Context ctx=getActivity().getApplicationContext();
                                        HighScoresDBHelper hsop=new HighScoresDBHelper(ctx);
                                        hsop.deleteinfo(hsop);
                                        Toast.makeText(getActivity(),"High Scores Database has been reset!",Toast.LENGTH_SHORT).show();

                                    }
                                })
                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                        AlertDialog alert = builder.create();
                        alert.show();

                    }

                }
            });

            return rootView;

        }
    }
}
