package com.developer.arsltech.barchartgraph;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BarChart CylinderView;
    private List<Integer> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CylinderView = findViewById(R.id.cylinder_view);

        list.add(200);
        list.add(400);
        list.add(800);
        list.add(100);
        list.add(20);
        list.add(250);
        list.add(30);
        list.add(200);
        list.add(400);
        list.add(800);
        list.add(100);
        list.add(20);
        list.add(250);
        list.add(30);
        list.add(200);
        list.add(400);
        list.add(800);
        list.add(100);
        list.add(20);
        list.add(250);
        list.add(30);

        CylinderView.setmHeightList(list);
        CylinderView.setWidth(788/list.size()/2);
        CylinderView.setRange(788/list.size()/2);
    }



}
