package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    final static int maxN = 15;
    private Context context;
    private ImageView[][] ivCell = new ImageView[maxN][maxN];
    private Drawable[] drawCell = new Drawable[4];
    private int[][] valueCell = new int[maxN][maxN];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        loadResouce();
        designBoard();
    }
    private void loadResouce() {
        drawCell[0] = null; // empty cell
        drawCell[1] = context.getResources().getDrawable(R.drawable.x);
        drawCell[2] = context.getResources().getDrawable(R.drawable.o);
        drawCell[3] = context.getResources().getDrawable(R.drawable.block); //background
    }

    private void designBoard() {
        int sizeofCell = Math.round(screenWith()/maxN);
        LinearLayout.LayoutParams lpRow = new LinearLayout.LayoutParams(sizeofCell*maxN, sizeofCell);
        LinearLayout.LayoutParams lpCell = new LinearLayout.LayoutParams(sizeofCell,sizeofCell);

        LinearLayout linBoardGame = (LinearLayout) findViewById(R.id.gridbanco);

        //create cells
        for(int i=0; i<maxN; i++) {
            LinearLayout linRow = new LinearLayout(context);
            //make a rows
            for(int j=0; j<maxN; j++) {
                ivCell[i][j] = new ImageView(context);
                ivCell[i][j].setBackground(drawCell[3]);
                linRow.addView(ivCell[i][j],lpCell);
            }
            linBoardGame.addView(linRow, lpRow);
        }
    }
    private float screenWith() {
        Resources resources = context.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }

}