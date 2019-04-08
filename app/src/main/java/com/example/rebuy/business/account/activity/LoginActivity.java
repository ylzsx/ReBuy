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
import com.example.rebuy.business.main.activity.MainActivity;
import com.example.rebuy.business.account.model.UserModel;
import com.example.rebuy.commom.CacheKey;

import org.litepal.LitePal;
import org.litepal.tablemanager.Connector;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.edt_account)
    EditText mEdtAccount;
    @BindView(R.id.edt_password)
    EditText mEdtPassword;
    @BindView(R.id.btn_login)
    Button mBtnLogin;
    @BindView(R.id.btn_register)
    Button mBtnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        // 创建数据库和表
        Connector.getDatabase();

        // 判断是否有登录记录
        SharedPreferences preferences = getSharedPreferences(CacheKey.FILE_NAME, MODE_PRIVATE);
        String token = preferences.getString(CacheKey.TOKEN, "");
        if (!"".equals(token)) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @OnClick({R.id.btn_login, R.id.btn_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                String account = mEdtAccount.getText().toString().trim();
                String password = mEdtPassword.getText().toString().trim();
                if ("".equals(account) || "".equals(password)) {
                    Toast.makeText(this, "请完善你的登录信息", Toast.LENGTH_SHORT).show();
                } else {
                    toLogin(account, password);
                }
                break;
            case R.id.btn_register:
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }

    /**
     * 登录
     * @param account
     * @param password
     */
    private void toLogin(String account, String password) {
        List<UserModel> users = LitePal.where("account = ?", account).find(UserModel.class);
        if (users.size() == 0) {
            Toast.makeText(this, "登录失败：尚无该用户，请先注册", Toast.LENGTH_SHORT).show();
        } else {
            if (password.equals(users.get(0).getPassword())) {
                Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                // 保存登录状态
                SharedPreferences.Editor editor = getSharedPreferences(CacheKey.FILE_NAME, MODE_PRIVATE).edit();
                editor.putString(CacheKey.TOKEN, String.valueOf(users.get(0).getId()));
                editor.apply();

                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "登录失败：密码错误", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
