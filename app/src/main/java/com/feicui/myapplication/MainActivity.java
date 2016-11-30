package com.feicui.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindColor;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity
{

    @BindView(R.id.tv_show)
    TextView textView;
    @BindView(R.id.button_show)
    Button button;

    @BindString(R.string.app_name)
    String name;

    @BindColor(R.color.colorAccent)
    int color;
    @BindView(R.id.listview)
    ListView listview;

    private Unbinder mBind;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBind = ButterKnife.bind(this);

        name = getResources().getString(R.string.app_name);
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 20; i++)
        {
            data.add("aaa" + i);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, data);
        listview.setAdapter(adapter);
    }

    @OnItemClick(R.id.listview)
    void onItemFun(int position)
    {
        Toast.makeText(this, "队长是煞笔" + position, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.button_show)
    public void showText()
    {
        textView.setText(name);
        textView.setTextColor(color);
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        mBind.unbind();
    }
}
