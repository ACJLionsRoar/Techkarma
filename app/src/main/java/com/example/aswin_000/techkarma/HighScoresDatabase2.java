
package com.example.aswin_000.techkarma;
import android.provider.BaseColumns;

public class HighScoresDatabase2 {

    public  class TableData{

        public TableData()
        {

        }

        public abstract class TableInfo implements BaseColumns
        {
            public static  final String USER_NAME="username";
            public static  final String USER_SCORE="score";
            public static final String DATABASE_NAME="highscores.db";
            public static final String TABLE_NAME="highscores";


        }
    }
}
