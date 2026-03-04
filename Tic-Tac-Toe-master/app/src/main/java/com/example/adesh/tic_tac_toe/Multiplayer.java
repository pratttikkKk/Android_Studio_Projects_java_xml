package com.example.adesh.tic_tac_toe;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Multiplayer extends Activity {
    ImageButton up;
    ImageButton down;
    ImageButton left;
    ImageButton right;
    ImageButton center;
    ImageButton downRight;
    ImageButton downLeft;
    ImageButton upRight;
    public int playerTurn = 1;
    public int[] data = new int[9];
    public Boolean game = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multiplayer);
        for (int i = 0; i < 9; i++)
        {
            data[i] = 0;
        }
    }
    public void upClick(View view)
    {
        if (game == true && data[1] == 0)
        {
            up = (ImageButton)findViewById(R.id.ImageButton1);
            if (playerTurn == 1)
            {
                up.setImageResource(R.drawable.lxl);
                data[1] = 1;
                if ((checkForWin(1)) == 2)
                {
                    TextView textView = (TextView)findViewById(R.id.textView1);
                    textView.setText("Player 1 Wins!");
                }
                else if ((checkForWin(1)) == 1)
                {
                    TextView textView = (TextView)findViewById(R.id.textView1);
                    textView.setText("Tie");
                }
                playerTurn = 2;
            }
            else
            {
                up.setImageResource(R.drawable.lol);
                data[1] = 2;
                if ((checkForWin(2)) == 2)
                {
                    TextView textView = (TextView)findViewById(R.id.textView1);
                    textView.setText("Player 2 Wins!");
                }
                playerTurn = 1;
            }
        }
    }
    public void downClick(View view)
    {
        if (game == true && data[7] == 0)
        {
            down = (ImageButton)findViewById(R.id.ImageButton7);
            if (playerTurn == 1)
            {
                down.setImageResource(R.drawable.lxl);
                data[7] = 1;
                if ((checkForWin(1)) == 2)
                {
                    TextView textView = (TextView)findViewById(R.id.textView1);
                    textView.setText("Player 1 Wins!");
                }
                else if ((checkForWin(1)) == 1)
                {
                    TextView textView = (TextView)findViewById(R.id.textView1);
                    textView.setText("Tie");
                }
                playerTurn = 2;
            }
            else
            {
                down.setImageResource(R.drawable.lol);
                data[7] = 2;
                if ((checkForWin(2)) == 2)
                {
                    TextView textView = (TextView)findViewById(R.id.textView1);
                    textView.setText("Player 2 Wins!");
                }
                playerTurn = 1;
            }
        }
    }
    public void upLeftClick(View view)
    {
        if (game == true && data[0] == 0)
        {
            ImageButton upLeft = (ImageButton)findViewById(R.id.ImageButton0);
            if (playerTurn == 1)
            {
                upLeft.setImageResource(R.drawable.x);
                data[0] = 1;
                if ((checkForWin(1)) == 2)
                {
                    TextView textView = (TextView)findViewById(R.id.textView1);
                    textView.setText("Player 1 Wins!");
                }
                else if ((checkForWin(1)) == 1)
                {
                    TextView textView = (TextView)findViewById(R.id.textView1);
                    textView.setText("Tie");
                }
                playerTurn = 2;
            }
            else
            {
                upLeft.setImageResource(R.drawable.o);
                data[0] = 2;
                if ((checkForWin(2)) == 2)
                {
                    TextView textView = (TextView)findViewById(R.id.textView1);
                    textView.setText("Player 2 Wins!");
                }
                playerTurn = 1;
            }
        }
    }
    public void upRightClick(View view)
    {
        if (game == true && data[2] == 0)
        {
            ImageButton upRight = (ImageButton)findViewById(R.id.ImageButton2);
            if (playerTurn == 1)
            {
                upRight.setImageResource(R.drawable.x);
                data[2] = 1;
                if ((checkForWin(1)) == 2)
                {
                    TextView textView = (TextView)findViewById(R.id.textView1);
                    textView.setText("Player 1 Wins!");
                }
                else if ((checkForWin(1)) == 1)
                {
                    TextView textView = (TextView)findViewById(R.id.textView1);
                    textView.setText("Tie");
                }
                playerTurn = 2;
            }
            else
            {
                upRight.setImageResource(R.drawable.o);
                data[2] = 2;
                if ((checkForWin(1)) == 2)
                {
                    TextView textView = (TextView)findViewById(R.id.textView1);
                    textView.setText("Player 2 Wins!");
                }
                playerTurn = 1;
            }
        }
    }
    public void centerClick(View view)
    {
        if (game == true && data[4] == 0)
        {
            center = (ImageButton)findViewById(R.id.ImageButton4);
            if (playerTurn == 1)
            {
                center.setImageResource(R.drawable._lxl_);
                data[4] = 1;
                if ((checkForWin(1)) == 2)
                {
                    TextView textView = (TextView)findViewById(R.id.textView1);
                    textView.setText("Player 1 Wins!");
                }
                else if ((checkForWin(1)) == 1)
                {
                    TextView textView = (TextView)findViewById(R.id.textView1);
                    textView.setText("Tie");
                }
                playerTurn = 2;
            }
            else
            {
                center.setImageResource(R.drawable._lol_);
                data[4] = 2;
                if ((checkForWin(2)) == 2)
                {
                    TextView textView = (TextView)findViewById(R.id.textView1);
                    textView.setText("Player 2 Wins!");
                }
                playerTurn = 1;
            }
        }
    }
    public void downLeftClick(View view)
    {
        if (game == true && data[6] == 0)
        {
            ImageButton downLeft = (ImageButton)findViewById(R.id.ImageButton6);
            if (playerTurn == 1)
            {
                downLeft.setImageResource(R.drawable.x);
                data[6] = 1;
                if ((checkForWin(1)) == 2)
                {
                    TextView textView = (TextView)findViewById(R.id.textView1);
                    textView.setText("Player 1 Wins!");
                }
                else if ((checkForWin(1)) == 1)
                {
                    TextView textView = (TextView)findViewById(R.id.textView1);
                    textView.setText("Tie");
                }
                playerTurn = 2;
            }
            else
            {
                downLeft.setImageResource(R.drawable.o);
                data[6] = 2;
                if ((checkForWin(2)) == 2)
                {
                    TextView textView = (TextView)findViewById(R.id.textView1);
                    textView.setText("Player 2 Wins!");
                }
                playerTurn = 1;
            }
        }
    }
    public void downRightClick(View view)
    {
        if (game == true && data[8] == 0)
        {
            ImageButton downRight = (ImageButton)findViewById(R.id.ImageButton8);
            if (playerTurn == 1)
            {
                downRight.setImageResource(R.drawable.x);
                data[8] = 1;
                if ((checkForWin(1)) == 2)
                {
                    TextView textView = (TextView)findViewById(R.id.textView1);
                    textView.setText("Player 1 Wins!");
                }
                else if ((checkForWin(1)) == 1)
                {
                    TextView textView = (TextView)findViewById(R.id.textView1);
                    textView.setText("Tie");
                }
                playerTurn = 2;
            }
            else
            {
                downRight.setImageResource(R.drawable.o);
                data[8] = 2;
                if ((checkForWin(2)) == 2)
                {
                    TextView textView = (TextView)findViewById(R.id.textView1);
                    textView.setText("Player 2 Wins!");
                }
                playerTurn = 1;
            }
        }
    }
    public void leftClick(View view)
    {
        if (game == true && data[3] == 0)
        {
            ImageButton left = (ImageButton)findViewById(R.id.ImageButton3);
            if (playerTurn == 1)
            {
                left.setImageResource(R.drawable._x_);
                data[3] = 1;
                if ((checkForWin(1)) == 2)
                {
                    TextView textView = (TextView)findViewById(R.id.textView1);
                    textView.setText("Player 1 Wins!");
                }
                else if ((checkForWin(1)) == 1)
                {
                    TextView textView = (TextView)findViewById(R.id.textView1);
                    textView.setText("Tie");
                }
                playerTurn = 2;
            }
            else
            {
                left.setImageResource(R.drawable._o_);
                data[3] = 2;
                if ((checkForWin(2)) == 2)
                {
                    TextView textView = (TextView)findViewById(R.id.textView1);
                    textView.setText("Player 2 Wins!");
                }
                playerTurn = 1;
            }
        }
    }
    public void rightClick(View view)
    {
        if (game == true && data[5] == 0)
        {
            if (playerTurn == 1)
            {
                ImageButton right = (ImageButton)findViewById(R.id.ImageButton5);
                right.setImageResource(R.drawable._x_);
                data[5] = 1;
                if ((checkForWin(1)) == 2)
                {
                    TextView textView = (TextView)findViewById(R.id.textView1);
                    textView.setText("Player 1 Wins!");
                }
                else if ((checkForWin(1)) == 1)
                {
                    TextView textView = (TextView)findViewById(R.id.textView1);
                    textView.setText("Tie");
                }
                playerTurn = 2;
            }
            else
            {
                ImageButton right = (ImageButton)findViewById(R.id.ImageButton5);
                right.setImageResource(R.drawable._o_);
                data[5] = 2;
                if ((checkForWin(2)) == 2)
                {
                    TextView textView = (TextView)findViewById(R.id.textView1);
                    textView.setText("Player 2 Wins!");
                }
                playerTurn = 1;
            }
        }
    }
    public int checkForWin(int player)
    {
        if ((data[0] == player && data[1] == player && data[2] == player)
                || (data[3] == player && data[4] == player && data[5] == player)
                || (data[6] == player && data[7] == player && data[8] == player)
                || (data[0] == player && data[4] == player && data[8] == player)
                || (data[2] == player && data[4] == player && data[6] == player)
                || (data[0] == player && data[3] == player && data[6] == player)
                || (data[1] == player && data[4] == player && data[7] == player)
                || (data[2] == player && data[5] == player && data[8] == player))
        {
            game = false;
            return 2;
        }
        else if (data[0] != 0 && data[1] != 0
                && data[2] != 0 && data[3] != 0
                && data[4] != 0 && data[5] != 0
                && data[6] != 0 && data[7] != 0
                && data[8] != 0)
        {
            game = false;
            return 1;
        }
        else
        {
            return 0;
        }
    }
}