package com.example.aswin_000.techkarma;

import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.widget.Toast;

import java.util.ArrayList;


public class HighScoresAsyncTask extends AsyncTask<String,Void,Integer> {
    private Context asynccontext;

    public HighScoresAsyncTask(Context context)
    {
        asynccontext=context;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);

    }

    @Override
    protected Integer doInBackground(String... params) {
        //do your work here


        String USER_NAME,USER_SCORE;
        Context ctx=asynccontext;

        String pname= params[0];
        String pscore=params[1];
        int check = -1;


        if(Integer.parseInt(pscore.replaceAll("[\\D]", ""))!=0) {
            USER_NAME = pname;
            USER_SCORE = pscore;
            check=0;



      /*

        HighScoresDBHelper hsop=new HighScoresDBHelper(ctx);
        hsop.updateinfo(hsop,USER_NAME,USER_SCORE);
        Toast.makeText(getBaseContext(), "Your High Score Has Been Changed!", Toast.LENGTH_LONG).show();

         */

// READ FROM DATABASE ALL NAMES AND ALL SCORES
            HighScoresDBHelper hsop = new HighScoresDBHelper(ctx);
            Cursor CR = hsop.getinfo(hsop);

            ArrayList<String> allnames = new ArrayList<>();
            for (CR.moveToFirst(); !CR.isAfterLast(); CR.moveToNext()) {
                allnames.add(CR.getString(0));
            }


            ArrayList<String> allscores = new ArrayList<>();
            for (CR.moveToFirst(); !CR.isAfterLast(); CR.moveToNext()) {
                allscores.add(CR.getString(1));
            }


            //CHECK IF NAME ALREADY EXISTS AND ITS SCORE IS BELOW THE NEW SCORE

            int numberofpeoplestored = allnames.size();


            int gamescore = Integer.parseInt(pscore.replaceAll("[\\D]", ""));


            for (int i = 0; i < numberofpeoplestored; i++) {

                int databasescore = Integer.parseInt(allscores.get(i).replaceAll("[\\D]", ""));
                if (pname.equals(allnames.get(i)) && gamescore > databasescore) {
                    check = 1;
                } else if (pname.equals(allnames.get(i)) && gamescore <= databasescore) {
                    check = 2;
                }
            }


// IF DOESNT EXIST, THEN ADD
            if (check == 0) {
                if(pname.length()!=0)  // CHECK IF USER ENTERED A USERNAME OR NOT!
                {
                    HighScoresDBHelper DB = new HighScoresDBHelper(ctx);
                    DB.addinfo(DB, USER_NAME, USER_SCORE);
                }

                else // IF DIDNT ENTER, DONT STORE TO DATABASE
                    check=-1;



            }


// IF EXISTS, THEN UPDATE
            else if (check == 1) {

                hsop.updateinfo(hsop, USER_NAME, USER_SCORE);


            }
// IF EXISTS BUT NEWSCORE DOESNT NEED TO BE UPDATED: Do Nothing

        }
        return check;

    }

    @Override
    protected void onPostExecute(Integer result) {
        int check=result;
        super.onPostExecute(result);
        // do something with data here-display it or send to mainactivity

        if(check==0)        {Toast.makeText(asynccontext, "High Score Added To Database!!", Toast.LENGTH_SHORT).show();}
        else if (check==1)  Toast.makeText(asynccontext, "Awesome! New High Score!", Toast.LENGTH_SHORT).show();
        else if (check==2)  Toast.makeText(asynccontext, "Your Score Remains The Same in Database!", Toast.LENGTH_SHORT).show();



















    }
}