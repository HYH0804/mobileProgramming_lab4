package com.example.lab4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab4.R;


public class ProductActivity extends AppCompatActivity {

	TextView titleText;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        titleText = findViewById(R.id.titleText);

        // process received intent
        Intent receivedIntent = getIntent();
        String titleMsg = receivedIntent.getStringExtra("titleMsg");

        Toast.makeText(this, "titleMsg : " + titleMsg, Toast.LENGTH_LONG).show();

        if (titleText != null) {
        	titleText.setText(titleMsg);
        }



        // backButton 지정

        /* backButton에 setOnClickListener 메소드 구현
        ** 다음 코드를 안에 복사하기 : toast 메시지 전달하여 메인메뉴에서 출력용
        **      Intent resultIntent = new Intent();
                resultIntent.putExtra("message", "result message is OK!");
                setResult(Activity.RESULT_OK, resultIntent);
        ** 메인메뉴로 복귀(현재 액티비티 종료)
        */
        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("message", "result message is OK!");

                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });

    }

}
