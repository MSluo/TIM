package com.example.wxy.tim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private OvalImageView img;
    private TextView fuwu;
    private CheckBox checkBox;
    private Button login_two;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        img.setStrokeColot(0xFFFFFFFF);
        img.setStrokeWidth(5);
    }

    public void init() {
        fuwu = findViewById(R.id.fuwu);
        img = findViewById(R.id.img);
        fuwu.setOnClickListener(this);
        checkBox=findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener(this);
        login_two=findViewById(R.id.login_two);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.fuwu) {
          //  Uri uri = Uri.parse("http://play.mobile.qq.com/yy/eim/help/serverinfo.html");    //设置跳转的网站
            Intent intent = new Intent(this,WebActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (buttonView.isChecked())
        {
            login_two.setEnabled(true);
            login_two.setBackgroundColor(Color.parseColor("#D80D37E0"));
        }
        else
        {  login_two.setEnabled(false);
            login_two.setBackgroundColor(Color.parseColor("#D6D7D7"));
        }
    }
}
