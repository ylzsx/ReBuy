package com.example.rebuy.business.account.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rebuy.R;
import com.example.rebuy.business.main.MainActivity;
import com.example.rebuy.business.account.model.User;
import com.example.rebuy.commom.CacheKey;


import org.litepal.LitePal;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.edt_account)
    EditText mEdtAccount;
    @BindView(R.id.edt_password)
    EditText mEdtPassword;
    @BindView(R.id.edt_confirm_password)
    EditText mEdtConfirmPassword;
    @BindView(R.id.btn_cancel)
    Button mBtnCancel;
    @BindView(R.id.btn_register)
    Button mBtnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_cancel, R.id.btn_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_cancel:
                finish();
                break;
            case R.id.btn_register:
                String account = mEdtAccount.getText().toString().trim();
                String password = mEdtPassword.getText().toString().trim();
                String confirmPassword = mEdtConfirmPassword.getText().toString().trim();
                if ("".equals(account) || "".equals(password) || "".equals(confirmPassword)) {
                    Toast.makeText(this, "请完善你的注册信息", Toast.LENGTH_SHORT).show();
                } else {
                    if (password.equals(confirmPassword)) {
                        toRegister(account, password);
                    } else {
                        Toast.makeText(this, "两次密码不一致", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }
    }

    private void toRegister(String account, String password) {
        List<User> users = LitePal.where("account = ?", account).find(User.class);
        if (users.size() == 0) {
            User user = new User(account, password);
            if (user.save()) {
                Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
                // 保存登录状态
                SharedPreferences.Editor editor = getSharedPreferences(CacheKey.FILE_NAME, MODE_PRIVATE).edit();
                editor.putString(CacheKey.TOKEN, String.valueOf(users.get(0).getId()));
                editor.apply();

                finish();
            } else {
                Toast.makeText(this, "注册失败", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "注册失败：该用户已存在", Toast.LENGTH_SHORT).show();
        }
    }

}
