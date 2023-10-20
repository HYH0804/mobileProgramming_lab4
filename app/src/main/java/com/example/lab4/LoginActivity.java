package com.example.lab4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class LoginActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_MENU = 101;

    EditText usernameInput;
    EditText passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        Button loginButton = findViewById(R.id.loginButton);
        
        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String username = usernameInput.getText().toString();
                String password = passwordInput.getText().toString();

                // 메뉴액티비티로 넘어갈 수 있도록 액티비티간 전환 겸 정보전달 객체인 intent 지정
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                // 해당 객체에 아이디와 비밀번호 String 넣어서 전달하며 메인메뉴 액티비티 생성
                intent.putExtra("username", username);
                intent.putExtra("password", password);

                // 메뉴액티비티 생성 : 인텐트 인자와 REQUEST_CODE_MENU 추가하여 받는 액티비티 측에서 확인 및 작업하도록 지정
                startActivityForResult(intent, REQUEST_CODE_MENU);
            }
        });

        usernameInput = findViewById(R.id.usernameInput);
        passwordInput = findViewById(R.id.passwordInput);

    }

    // 메인메뉴에서 로그인화면으로 이동하는 경우, 메인메뉴로부터 Intent 받아서 Toast 메시지 출력
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        // 다른 액티비티로부터 받은 값이 REQUEST_CODE_MENU인 경우 Toast 출력
        if (requestCode == REQUEST_CODE_MENU) {
            if (intent != null) {
                String menu = intent.getStringExtra("menu");
                String message = intent.getStringExtra("message");

                Toast toast = Toast.makeText(getBaseContext(), "result code : " + resultCode + ", menu : " + menu + ", message : " + message, Toast.LENGTH_LONG);
                toast.show();
            }
        }

    }

}
