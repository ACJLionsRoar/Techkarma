package com.example.aswin_000.techkarma;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class PlayNow extends Activity {


    int index=0;
    String username;
    int score=0;


    String[] question={
            "1)Moving the contents within a window up or down is also called what?",
            "2)\"Memory\" is often used synonymously with what component?",
            "3)What was the name of Apple's desktop operating system through version 9?",
            "4)Which of the following file types contains tables and records?",
            "5)Which company developed the Kindle e-reader?",
            "6)What type of data structure might be described LIFO?",
            "7)Which of the following images sizes is not a standard OS X icon size?",
            "8)What is jQuery used to create?",
            "9)Which of the following is the most important New Year's resolution?",
            "10)LTE is a subset of what cellular data standard?",
            "11)Who Invented Google?",
            "12)James Clark Launched ?",
            "13)Ebay was founded by?",
            "14)Which is the latest stable version of OS X ?",
            "15)Which of these is not an Android code name ?",
            "16)Which of these is a cancelled version of Microsoft OS?",
            "17)Which Codename belongs to Ubuntu 10.10 ?",
            "18)What is another name for a system or device connected to a network?",
            "19)What is the technical name for a \"rule of thumb?\"",
            "20)What Internet service provides domain name registrant information?",
            "21)Who is known for  cryptanalysis of the Enigma ?",
            "22)What method is used to wire up behavior on a list item when it is clicked in android programming ?",
            "23)Which of these TV Shows feature Artificial Intelligence ?",
            "24)Which is the best preferred language if you want to start working in Unity ?",
            "25)What is the maximum value for an unsigned long int in C ?"

    };

    String[] optiona={
            "A) Tabbing",
            "A)RAM",
            "A)Windows",
            "A)Rich Text",
            "A)Apple",
            "A)Queue",
            "A)16x16 px",
            "A)3D graphics",
            "A)Eat Healthier Foods",
            "A)1G",
            "A)Larry Page and Sergey Brin",
            "A)Netscape",
            "A)Pierre Omidyar",
            "A)Mountain Lion",
            "A)Alpha",
            "A)Windows Phone 8.1",
            "A)Oneiric Ocelot",
            "A)Block",
            "A)Mnemonic",
            "A)WHOIS",
            "A)Charles Babbage",
            "A)setOnTouchListener(View.OnTouchListener l)",
            "A)Person Of Interest",
            "A)Javascript",
            "A)4294967293"

    };

    String[] optionb={
            "B) Scrolling",
            "B)Motherboard",
            "B)UNIX",
            "B)Compressed",
            "B)Amazon",
            "B)Linked Lists",
            "B)24x24 px",
            "B)Database structures",
            "B)Exercise More",
            "B)2G",
            "B)Larry Page and James Clark",
            "B)Skype",
            "B)Sachin Bansal and Binny Bansal",
            "B)Snow Leopard",
            "B)Beta",
            "B)Windows RT 8.1",
            "B)Maverick Meerkat",
            "B)Kernel",
            "B)Heuristic",
            "B)DNS",
            "B)Alan Turing",
            "B)setOnClickListener(View.OnTouchListener l)",
            "B)Breaking Bad",
            "B)C++",
            "B)4294967294"
    };

    String [] optionc={
            "C) Patching",
            "C)Hard Drive",
            "C)iOS",
            "C)Database",
            "C)Google",
            "C)Stack",
            "C)32x32 px",
            "C)Dynamic webpages",
            "C)Get Enough Sleep",
            "C)3G",
            "C)Jeff Bezos and Larry Page",
            "C)Ebay",
            "C)Kunal Bahl",
            "C)Yosemite",
            "C)Cookie",
            "C)Windows 7",
            "C)Quantal Quetzal",
            "C)Node",
            "C)Template",
            "C)Ping",
            "C)Edsger W. Dijkstra",
            "C)setOnItemSelectedListener(AdapterView.OnItemSelectedListener listener)",
            "C)Community",
            "C)C#",
            "C)4294967295"

    };

    String [] optiond={
            "D) Cycling",
            "D)BIOS",
            "D)Mac OS ",
            "D)Disk Image",
            "D)Microsoft",
            "D)Boolean",
            "D)128x128 px",
            "D)Windows applications",
            "D)Back up your data",
            "D)4G",
            "D)Bill Gates and Larry Page",
            "D)Netflix",
            "D)Jeff Bezos",
            "D)Mavericks",
            "D)Donut",
            "D)Windows Mobile 7",
            "D)Utopic Unicorn",
            "D)Waypoint",
            "D)Sample",
            "D)Traceroute",
            "D)Tim Berners-Lee",
            "D)setOnItemClickListener(AdapterView.OnItemClickListener listener)",
            "D)Lost",
            "D)Java",
            "D)4294967296"

    };

    String [] answer={
            "B","A","D","C","B","C","B","C","D","D","A","A","A","C","C","D","B","C","B","A","B","D","A","C","C"
    };

    int [] flag={
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
    };

    public int counter=0;


    public int getindex(int index)
    {
        if (index>=0 && index<25) {
            if (flag[index] == 0)
                flag[index] = 1;

            else {
                index++;
                flag[index] = 1;
            }
        }
        else
            index=99;

        return index;
    }
    public String getquestion(int slno)
    {
        return question[slno];
    }
    public String getoptiona(int slno)
    {
        return optiona[slno];
    }
    public String getoptionb(int slno)
    {
        return optionb[slno];
    }
    public String getoptionc(int slno)
    {
        return optionc[slno];
    }
    public String getoptiond(int slno)
    {
        return optiond[slno];
    }
    public String getanswer(int slno)
    {
        return answer[slno];
    }

    public void correctanswer()
    {

        if (counter<25)   // edit this ! to decrease questions 25 for all questions . 25 for all questions
        {
            score=score+10;

            TextView points= (TextView) findViewById(R.id.playnowscore);
            points.setText("Score:"+score);
            final Button b5 = (Button) findViewById(R.id.next);
            b5.setEnabled(true);
            b5.setText("Next->");

            Button b1 = (Button) findViewById(R.id.optiona);
            b1.setEnabled(false);

            Button b2 = (Button) findViewById(R.id.optionb);
            b2.setEnabled(false);

            Button b3 = (Button) findViewById(R.id.optionc);
            b3.setEnabled(false);

            Button b4 = (Button) findViewById(R.id.optiond);
            b4.setEnabled(false);

            TextView result= (TextView) findViewById(R.id.Result);
            result.setText("Woah! You Got It Right!!");


            View.OnClickListener B5 = new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    b5.setText("TechKarma");
                    Game();

                }
            };
            b5.setOnClickListener(B5);


        }

        else {
            score=score+10;
            TextView points= (TextView) findViewById(R.id.playnowscore);
            points.setText("Score:"+score);
            String pscore=points.getText().toString();
            String pname=username;

            Context topasscontext=getApplicationContext();
            HighScoresAsyncTask Async= new HighScoresAsyncTask(topasscontext);


            Async.execute(pname, pscore);

            Intent intent2 = new Intent(getApplicationContext(), com.example.aswin_000.techkarma.YouWon.class);
            intent2.setFlags(intent2.FLAG_ACTIVITY_CLEAR_TOP);







            intent2.putExtra("PassedName",username);
            intent2.putExtra("PassedScore",points.getText().toString());

            startActivity(intent2);
            finish();


            startActivity(intent2);

        }

    }

    public void wronganswer() {

        Button b5 = (Button) findViewById(R.id.next);
        b5.setEnabled(true);
        b5.setText("Start Again!");


        Button b1 = (Button) findViewById(R.id.optiona);
        b1.setEnabled(false);

        Button b2 = (Button) findViewById(R.id.optionb);
        b2.setEnabled(false);

        Button b3 = (Button) findViewById(R.id.optionc);
        b3.setEnabled(false);

        Button b4 = (Button) findViewById(R.id.optiond);
        b4.setEnabled(false);




        TextView result = (TextView) findViewById(R.id.Result);
        result.setText("That is Incorrect!");


        View.OnClickListener B5 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                counter=0;
                index=0;

                for(int i=0;i<3;i++)
                    flag[i]=0;
                TextView replacescore=(TextView) findViewById(R.id.playnowscore);
                String pscore=replacescore.getText().toString();
                score=0;
                replacescore.setText("Score:"+score);



                //////////////////////////////////////////////////////
                String pname=username;





                Context topasscontext=getApplicationContext();
                HighScoresAsyncTask Async= new HighScoresAsyncTask(topasscontext);


                Async.execute(pname, pscore);


                //////////////////////////////////////////////////////
                Game();



            }


        };
        b5.setOnClickListener(B5);
    }

    public void Game() {

        String que,a,b,c,d;
        int slno;
        final String ans;
        slno = getindex(index);
        index=slno;

        counter++;
        que = getquestion(slno);
        a = getoptiona(slno);
        b = getoptionb(slno);
        c = getoptionc(slno);
        d = getoptiond(slno);
        ans = getanswer(slno);



        TextView result = (TextView) findViewById(R.id.Result);
        result.setText(null);

        TextView textview_que = (TextView) findViewById(R.id.Question);
        textview_que.setText(que);

        Button b1 = (Button) findViewById(R.id.optiona);
        b1.setEnabled(true);
        b1.setText(a);

        Button b2 = (Button) findViewById(R.id.optionb);
        b2.setEnabled(true);
        b2.setText(b);

        Button b3 = (Button) findViewById(R.id.optionc);
        b3.setEnabled(true);
        b3.setText(c);

        Button b4 = (Button) findViewById(R.id.optiond);
        b4.setEnabled(true);
        b4.setText(d);

        Button b5 = (Button) findViewById(R.id.next);
        b5.setEnabled(false);


        View.OnClickListener B1 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (ans == "A") {
                    correctanswer();

                } else
                    wronganswer();

            }
        };
        b1.setOnClickListener(B1);

        View.OnClickListener B2 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (ans == "B")
                    correctanswer();

                else
                    wronganswer();
            }
        };
        b2.setOnClickListener(B2);

        View.OnClickListener B3 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (ans == "C")
                    correctanswer();

                else
                    wronganswer();
            }
        };
        b3.setOnClickListener(B3);

        View.OnClickListener B4 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (ans == "D")
                    correctanswer();

                else
                    wronganswer();
            }
        };
        b4.setOnClickListener(B4);



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_now);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setCancelable(false);



        alert.setTitle("Username");
        alert.setMessage("Pick a Cool Name Though!");

// Set an EditText view to get user input




        final EditText input = new EditText(this);
        alert.setView(input);

        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String value = input.getText().toString();
                username=value;
                TextView name=(TextView) findViewById(R.id.playnowname);
                name.setText(username);
                // Do something with value!


            }
        });


        alert.show();

        Game();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_play_now, menu);
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

}
