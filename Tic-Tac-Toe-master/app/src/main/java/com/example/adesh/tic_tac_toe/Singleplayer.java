package com.example.adesh.tic_tac_toe;

import java.util.Random;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Singleplayer extends Activity {
    ImageButton up;
    ImageButton down;
    ImageButton left;
    ImageButton right;
    ImageButton center;
    ImageButton downRight;
    ImageButton downLeft;
    ImageButton upRight;
    public int[] data = new int[9];
    public Boolean game = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singleplayer);
        for (int i = 0; i < 9; i++)
        {
            data[i] = 0;
        }
    }
    @SuppressLint("SetTextI18n")
    public void upClick(View view)
    {
        if (data[1] == 0 && game)
        {
            ImageButton up = (ImageButton)findViewById(R.id.ImageButton1);
            up.setImageResource(R.drawable.lxl);
            data[1] = 1;
            if ((checkForWin(1)) == 2)
            {
                TextView textView = (TextView)findViewById(R.id.textView1);
                textView.setText("You Win!");
            }
            else if ((checkForWin(1)) == 1)
            {
                TextView textView = (TextView)findViewById(R.id.textView1);
                textView.setText("Tie");
            }
            else
                computerPlay();
        }
    }
    public void downClick(View view)
    {
        if (data[7] == 0 && game)
        {
            ImageButton down = (ImageButton)findViewById(R.id.ImageButton7);
            down.setImageResource(R.drawable.lxl);
            data[7] = 1;
            if ((checkForWin(1)) == 2)
            {
                TextView textView = (TextView)findViewById(R.id.textView1);
                textView.setText("You Win!");
            }
            else if ((checkForWin(1)) == 1)
            {
                TextView textView = (TextView)findViewById(R.id.textView1);
                textView.setText("Tie");
            }
            else
                computerPlay();
        }
    }
    public void upLeftClick(View view)
    {
        if (data[0] == 0 && game)
        {
            ImageButton upLeft = (ImageButton)findViewById(R.id.ImageButton0);
            upLeft.setImageResource(R.drawable.x);
            data[0] = 1;
            if ((checkForWin(1)) == 2)
            {
                TextView textView = (TextView)findViewById(R.id.textView1);
                textView.setText("You Win!");
            }
            else if ((checkForWin(1)) == 1)
            {
                TextView textView = (TextView)findViewById(R.id.textView1);
                textView.setText("Tie");
            }
            else
                computerPlay();
        }
    }
    public void upRightClick(View view)
    {
        if (data[2] == 0 && game == true)
        {
            ImageButton upRight = (ImageButton)findViewById(R.id.ImageButton2);
            upRight.setImageResource(R.drawable.x);
            data[2] = 1;
            if ((checkForWin(1)) == 2)
            {
                TextView textView = (TextView)findViewById(R.id.textView1);
                textView.setText("You Win!");
            }
            else if ((checkForWin(1)) == 1)
            {
                TextView textView = (TextView)findViewById(R.id.textView1);
                textView.setText("Tie");
            }
            else
                computerPlay();
        }
    }
    public void centerClick(View view)
    {
        if (data[4] == 0 && game == true)
        {
            ImageButton center = (ImageButton)findViewById(R.id.ImageButton4);
            center.setImageResource(R.drawable._lxl_);
            data[4] = 1;
            if ((checkForWin(1)) == 2)
            {
                TextView textView = (TextView)findViewById(R.id.textView1);
                textView.setText("You Win!");
            }
            else if ((checkForWin(1)) == 1)
            {
                TextView textView = (TextView)findViewById(R.id.textView1);
                textView.setText("Tie");
            }
            else
                computerPlay();
        }
    }
    public void downLeftClick(View view)
    {
        if (data[6] == 0 && game == true)
        {
            ImageButton downLeft = (ImageButton)findViewById(R.id.ImageButton6);
            downLeft.setImageResource(R.drawable.x);
            data[6] = 1;
            if ((checkForWin(1)) == 2)
            {
                TextView textView = (TextView)findViewById(R.id.textView1);
                textView.setText("You Win!");
            }
            else if ((checkForWin(1)) == 1)
            {
                TextView textView = (TextView)findViewById(R.id.textView1);
                textView.setText("Tie");
            }
            else
                computerPlay();
        }
    }
    public void downRightClick(View view)
    {
        if (data[8] == 0 && game == true)
        {
            ImageButton downRight = (ImageButton)findViewById(R.id.ImageButton8);
            downRight.setImageResource(R.drawable.x);
            data[8] = 1;
            if ((checkForWin(1)) == 2)
            {
                TextView textView = (TextView)findViewById(R.id.textView1);
                textView.setText("You Win!");
            }
            else if ((checkForWin(1)) == 1)
            {
                TextView textView = (TextView)findViewById(R.id.textView1);
                textView.setText("Tie");
            }
            else
                computerPlay();
        }
    }
    public void leftClick(View view)
    {
        if (data[3] == 0 && game == true)
        {
            ImageButton left = (ImageButton)findViewById(R.id.ImageButton3);

            left.setImageResource(R.drawable._x_);
            data[3] = 1;
            if ((checkForWin(1)) == 2)
            {
                TextView textView = (TextView)findViewById(R.id.textView1);
                textView.setText("You Win!");
            }
            else if ((checkForWin(1)) == 1)
            {
                TextView textView = (TextView)findViewById(R.id.textView1);
                textView.setText("Tie");
            }
            else
                computerPlay();
        }
    }
    public void rightClick(View view)
    {
        if (data[5] == 0)
        {
            ImageButton right = (ImageButton)findViewById(R.id.ImageButton5);
            right.setImageResource(R.drawable._x_);
            data[5] = 1;
            if ((checkForWin(1)) == 2)
            {
                TextView textView = (TextView)findViewById(R.id.textView1);
                textView.setText("You Win!");
            }
            else if ((checkForWin(1)) == 1)
            {
                TextView textView = (TextView)findViewById(R.id.textView1);
                textView.setText("Tie");
            }
            else
                computerPlay();
        }
    }
    public void computerPlay()
    {
        if (((data[0] == 2 && data[8] == 2)
                || (data[1] == 2 && data[7] == 2)
                || (data[2] == 2 && data[6] == 2)
                || (data[3] == 2 && data[5] == 2))
                && data[4] == 0)
        {
            ImageButton center = (ImageButton)findViewById(R.id.ImageButton4);
            data[4] = 2;
            center.setImageResource(R.drawable._lol_);
            if ((checkForWin(2)) == 2)
            {
                TextView textView = (TextView)findViewById(R.id.textView1);
                textView.setText("You Lose!");
            }

        }
        else if (((data[0] == 2 && data[1] == 2)
                || (data[5] == 2 && data[8] == 2)
                || (data[7] == 2 && data[4] == 2))
                && data[2] == 0)
        {
            ImageButton upRight = (ImageButton)findViewById(R.id.ImageButton2);
            data[2] = 2;
            upRight.setImageResource(R.drawable.o);
            if ((checkForWin(2)) == 2)
            {
                TextView textView = (TextView)findViewById(R.id.textView1);
                textView.setText("You Lose!");
            }
        }
        else if (((data[2] == 2 && data[1] == 2)
                || (data[4] == 2 && data[6] == 2)
                || (data[8] == 2 && data[4] == 2))
                && data[0] == 0)
        {
            ImageButton upLeft = (ImageButton)findViewById(R.id.ImageButton0);
            data[0] = 2;
            upLeft.setImageResource(R.drawable.o);
            if ((checkForWin(2)) == 2)
            {
                TextView textView = (TextView)findViewById(R.id.textView1);
                textView.setText("You Lose!");
            }
        }
        else if (((data[0] == 2 && data[3] == 2)
                || (data[7] == 2 && data[8] == 2)
                || (data[2] == 2 && data[4] == 2))
                && data[6] == 0)
        {
            ImageButton downLeft = (ImageButton)findViewById(R.id.ImageButton6);
            data[6] = 2;
            downLeft.setImageResource(R.drawable.o);
            if ((checkForWin(2)) == 2)
            {
                TextView textView = (TextView)findViewById(R.id.textView1);
                textView.setText("You Lose!");
            }
        }
        else if (((data[7] == 2 && data[6] == 2)
                || (data[5] == 2 && data[2] == 2)
                || (data[0] == 2 && data[4] == 2))
                && data[8] == 0)
        {
            ImageButton downRight = (ImageButton)findViewById(R.id.ImageButton8);
            data[8] = 2;
            downRight.setImageResource(R.drawable.o);
            if ((checkForWin(2)) == 2)
            {
                TextView textView = (TextView)findViewById(R.id.textView1);
                textView.setText("You Lose!");
            }
        }
        else if (((data[0] == 2 && data[2] == 2)
                || (data[4] == 2 && data[7] == 2))
                && data[1] == 0)
        {
            ImageButton up = (ImageButton)findViewById(R.id.ImageButton1);
            data[1] = 2;
            up.setImageResource(R.drawable.lol);
            if ((checkForWin(2)) == 2)
            {
                TextView textView = (TextView)findViewById(R.id.textView1);
                textView.setText("You Lose!");
            }
        }
        else if (((data[0] == 2 && data[6] == 2)
                || (data[4] == 2 && data[5] == 2))
                && data[3] == 0)
        {
            ImageButton left = (ImageButton)findViewById(R.id.ImageButton3);
            data[3] = 2;
            left.setImageResource(R.drawable._o_);
            if ((checkForWin(2)) == 2)
            {
                TextView textView = (TextView)findViewById(R.id.textView1);
                textView.setText("You Lose!");
            }
        }
        else if (((data[1] == 2 && data[4] == 2)
                || (data[6] == 2 && data[8] == 2))
                && data[7] == 0)
        {
            ImageButton down = (ImageButton)findViewById(R.id.ImageButton7);
            data[7] = 2;
            down.setImageResource(R.drawable.lol);
            if ((checkForWin(2)) == 2)
            {
                TextView textView = (TextView)findViewById(R.id.textView1);
                textView.setText("You Lose!");
            }
        }
        else if (((data[8] == 2 && data[2] == 2)
                || (data[4] == 2 && data[3] == 2))
                && data[5] == 0)
        {
            ImageButton right = (ImageButton)findViewById(R.id.ImageButton5);
            data[5] = 2;
            right.setImageResource(R.drawable._o_);
            if ((checkForWin(2)) == 2)
            {
                TextView textView = (TextView)findViewById(R.id.textView1);
                textView.setText("You Lose!");
            }
        }
        else
        {
            if (((data[0] == 1 && data[8] == 1)
                    || (data[1] == 1 && data[7] == 1)
                    || (data[2] == 1 && data[6] == 1)
                    || (data[3] == 1 && data[5] == 1))
                    && data[4] == 0)
            {
                ImageButton center = (ImageButton)findViewById(R.id.ImageButton4);
                data[4] = 2;
                center.setImageResource(R.drawable._lol_);
                if ((checkForWin(2)) == 2)
                {
                    TextView textView = (TextView)findViewById(R.id.textView1);
                    textView.setText("You Lose!");
                }
            }
            else if (((data[0] == 1 && data[1] == 1)
                    || (data[5] == 1 && data[8] == 1)
                    || (data[6] == 1 && data[4] == 1))
                    && data[2] == 0)
            {
                ImageButton upRight = (ImageButton)findViewById(R.id.ImageButton2);
                data[2] = 2;
                upRight.setImageResource(R.drawable.o);
                if ((checkForWin(2)) == 2)
                {
                    TextView textView = (TextView)findViewById(R.id.textView1);
                    textView.setText("You Lose!");
                }
            }
            else if (((data[2] == 1 && data[1] == 1)
                    || (data[3] == 1 && data[6] == 1)
                    || (data[8] == 1 && data[4] == 1))
                    && data[0] == 0)
            {
                ImageButton upLeft = (ImageButton)findViewById(R.id.ImageButton0);
                data[0] = 2;
                upLeft.setImageResource(R.drawable.o);
                if ((checkForWin(2)) == 2)
                {
                    TextView textView = (TextView)findViewById(R.id.textView1);
                    textView.setText("You Lose!");
                }
            }
            else if (((data[0] == 1 && data[3] == 1)
                    || (data[7] == 1 && data[8] == 1)
                    || (data[2] == 1 && data[4] == 1))
                    && data[6] == 0)
            {
                ImageButton downLeft = (ImageButton)findViewById(R.id.ImageButton6);
                data[6] = 2;
                downLeft.setImageResource(R.drawable.o);
                if ((checkForWin(2)) == 2)
                {
                    TextView textView = (TextView)findViewById(R.id.textView1);
                    textView.setText("You Lose!");
                }
            }
            else if (((data[7] == 1 && data[6] == 1)
                    || (data[5] == 1 && data[2] == 1)
                    || (data[0] == 1 && data[4] == 1))
                    && data[8] == 0)
            {
                ImageButton downRight = (ImageButton)findViewById(R.id.ImageButton8);
                data[8] = 2;
                downRight.setImageResource(R.drawable.o);
                if ((checkForWin(2)) == 2)
                {
                    TextView textView = (TextView)findViewById(R.id.textView1);
                    textView.setText("You Lose!");
                }
            }
            else if (((data[0] == 1 && data[2] == 1)
                    || data[4] == 1 && data[7] == 1)
                    && data[1] == 0)
            {
                ImageButton up = (ImageButton)findViewById(R.id.ImageButton1);
                data[1] = 2;
                up.setImageResource(R.drawable.lol);
                if ((checkForWin(2)) == 2)
                {
                    TextView textView = (TextView)findViewById(R.id.textView1);
                    textView.setText("You Lose!");
                }
            }
            else if (((data[0] == 1 && data[6] == 1)
                    || data[4] == 1 && data[5] == 1)
                    && data[3] == 0)
            {
                ImageButton left = (ImageButton)findViewById(R.id.ImageButton3);
                data[3] = 2;
                left.setImageResource(R.drawable._o_);
                if ((checkForWin(2)) == 2)
                {
                    TextView textView = (TextView)findViewById(R.id.textView1);
                    textView.setText("You Lose!");
                }
            }
            else if (((data[1] == 1 && data[4] == 1)
                    || data[6] == 1 && data[8] == 1)
                    && data[7] == 0)
            {
                ImageButton down = (ImageButton)findViewById(R.id.ImageButton7);
                data[7] = 2;
                down.setImageResource(R.drawable.lol);
                if ((checkForWin(2)) == 2)
                {
                    TextView textView = (TextView)findViewById(R.id.textView1);
                    textView.setText("You Lose!");
                }
            }
            else if (((data[8] == 1 && data[2] == 1)
                    || data[4] == 1 && data[3] == 1)
                    && data[5] == 0)
            {
                ImageButton right = (ImageButton)findViewById(R.id.ImageButton5);
                data[5] = 2;
                right.setImageResource(R.drawable._o_);
                if ((checkForWin(2)) == 2)
                {
                    TextView textView = (TextView)findViewById(R.id.textView1);
                    textView.setText("You Lose!");
                }
            }
            else
            {
                Random generator = new Random();
                int randomInt = generator.nextInt(9);
                Boolean bool = true;
                while (bool == true)
                {
                    if (data[randomInt] == 0)
                    {
                        switch (randomInt){
                            case 0:
                                ImageButton upLeft = (ImageButton)findViewById(R.id.ImageButton0);
                                upLeft.setImageResource(R.drawable.o);
                                break;
                            case 1:
                                ImageButton up = (ImageButton)findViewById(R.id.ImageButton1);
                                up.setImageResource(R.drawable.lol);
                                break;
                            case 2:
                                ImageButton upRight = (ImageButton)findViewById(R.id.ImageButton2);
                                upRight.setImageResource(R.drawable.o);
                                break;
                            case 3:
                                ImageButton left = (ImageButton)findViewById(R.id.ImageButton3);
                                left.setImageResource(R.drawable._o_);
                                break;
                            case 4:
                                ImageButton center = (ImageButton)findViewById(R.id.ImageButton4);
                                center.setImageResource(R.drawable._lol_);
                                break;
                            case 5:
                                ImageButton right = (ImageButton)findViewById(R.id.ImageButton5);
                                right.setImageResource(R.drawable._o_);
                                break;
                            case 6:
                                ImageButton downLeft = (ImageButton)findViewById(R.id.ImageButton6);
                                downLeft.setImageResource(R.drawable.o);
                                break;
                            case 7:
                                ImageButton down = (ImageButton)findViewById(R.id.ImageButton7);
                                down.setImageResource(R.drawable.lol);
                                break;
                            case 8:
                                ImageButton downRight = (ImageButton)findViewById(R.id.ImageButton8);
                                downRight.setImageResource(R.drawable.o);
                                break;
                        }
                        data[randomInt] = 2;
                        if ((checkForWin(2)) == 2)
                        {
                            TextView textView = (TextView)findViewById(R.id.textView1);
                            textView.setText("You Lose!");
                        }
                        bool = false;
                    }
                }
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