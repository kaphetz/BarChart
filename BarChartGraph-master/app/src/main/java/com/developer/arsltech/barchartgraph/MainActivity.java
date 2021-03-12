package com.developer.arsltech.barchartgraph;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BarChart CylinderView;
    private List<Integer> list = new ArrayList<>();

    PresetRadioGroup mSetDurationPresetRadioGroup;
    TextView mSetDurationEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSetDurationPresetRadioGroup = (PresetRadioGroup) findViewById(R.id.preset_time_radio_group);
        mSetDurationEditText = findViewById(R.id.tvContent);
        mSetDurationPresetRadioGroup.setOnCheckedChangeListener(new PresetRadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(View radioGroup, View radioButton, boolean isChecked, int checkedId) {
                mSetDurationEditText.setText(((PresetValueButton) radioButton).getValue());
            }
        });

        /*

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
        CylinderView.setWidth(20);
        CylinderView.setRange((788-(20*list.size()))/22);*/
    }



}
