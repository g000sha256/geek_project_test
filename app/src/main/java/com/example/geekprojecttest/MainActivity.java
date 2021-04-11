package com.example.geekprojecttest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button button = new Button(this);
        button.setText("Кнопка смерти");
        button.setOnClickListener(
            v -> {
                throw new IllegalStateException("Нельзя нажимать эту кнопку");
            }
        );
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.CENTER;
        setContentView(button, layoutParams);
        FirebaseMessaging
            .getInstance()
            .getToken()
            .addOnCompleteListener(
                task -> {
                    String token = task.getResult();
                    Log.e("GeekProject", "Token: " + token);
                }
            );
    }

}