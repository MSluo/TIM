package com.example.wxy.tim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private OvalImageView img;
    private TextView fuwu;
    private CheckBox checkBox;
    private Button login_two;
    private EditText username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        img.setStrokeColot(0xFFFFFFFF);
        img.setStrokeWidth(5);
    }
    private TextView mBottomSheetDialog;
    public void init() {
        fuwu = findViewById(R.id.fuwu);
        img = findViewById(R.id.img);
        fuwu.setOnClickListener(this);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        checkBox=findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener(this);
        login_two=findViewById(R.id.login_two);
        login_two.setOnClickListener(this);
        mBottomSheetDialog  = findViewById(R.id.wufa);
        mBottomSheetDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomSheetDialog();
            }
        });
    }
   public void showToast(String str)
   {
       Toast.makeText(mContext,str,Toast.LENGTH_SHORT).show();
   }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.fuwu) {
          //  Uri uri = Uri.parse("http://play.mobile.qq.com/yy/eim/help/serverinfo.html");    //设置跳转的网站
            Intent intent = new Intent(this,WebActivity.class);
            startActivity(intent);
        }
        if (v.getId()==R.id.login_two)
        {
            if (username.getText().toString().isEmpty()||password.getText().toString().isEmpty())
            {
                showToast("账户或密码不能输入为空！");
                return;
            }else {
                if (username.getText().toString().equals("admin")&&password.getText().toString().equals("123456"))
                {
                    startActivity(new Intent(mContext,MainActivity.class));
                    finish();
                }
                else
                {
                    showToast("账户或密码错误");
                }
            }
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

    Context mContext= LoginActivity.this;
    private void showBottomSheetDialog() {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(mContext);
        View view = LayoutInflater.from(mContext).inflate(R.layout.popup_window_menu, null);
        final TextView menuItem1 = view.findViewById(R.id.tv_option1);
        menuItem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,menuItem1.getText().toString(),Toast.LENGTH_SHORT).show();
                if(bottomSheetDialog != null) {
                    bottomSheetDialog.dismiss();
                }
            }
        });
        final TextView menuItem2 = view.findViewById(R.id.tv_option2);
        menuItem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,menuItem2.getText().toString(),Toast.LENGTH_SHORT).show();
                if(bottomSheetDialog != null) {
                    bottomSheetDialog.dismiss();
                }
            }
        });
        final TextView menuItem3 = view.findViewById(R.id.tv_option3);
        menuItem3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,menuItem3.getText().toString(),Toast.LENGTH_SHORT).show();
                if(bottomSheetDialog != null) {
                    bottomSheetDialog.dismiss();
                }
            }
        });
        bottomSheetDialog.setContentView(view);
        bottomSheetDialog.setCancelable(true);
        bottomSheetDialog.setCanceledOnTouchOutside(true);
        bottomSheetDialog.show();
    }
}
