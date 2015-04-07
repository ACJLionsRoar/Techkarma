package com.example.aswin_000.techkarma;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class GameMenu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_menu);

        Button B1 = (Button) findViewById(R.id.button1);
        Button B2 = (Button) findViewById(R.id.button2);
        Button B3 = (Button) findViewById(R.id.button3);
        Button B4 = (Button) findViewById(R.id.button4);

        View.OnClickListener button1=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), com.example.aswin_000.techkarma.PlayNow.class);
                startActivity(intent);
            }
        };
        B1.setOnClickListener(button1);

        View.OnClickListener button2=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HighScores.class);
                startActivity(intent);
            }
        };
        B2.setOnClickListener(button2);

        View.OnClickListener button3= new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent intent = new Intent(getApplicationContext(), com.example.aswin_000.techkarma.GameSettings.class);
                startActivity(intent);
            }
        };
        B3.setOnClickListener(button3);


        View.OnClickListener button4=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), About.class);
                startActivity(intent);
            }
        };
        B4.setOnClickListener(button4);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game_menu, menu);
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
