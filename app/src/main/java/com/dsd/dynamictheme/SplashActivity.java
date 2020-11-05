package com.dsd.dynamictheme;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class SplashActivity extends AppCompatActivity {

    private ImageView ivProjectLogo;
    private TextView tvAppText;

    public static void initActivity(Context context) {
        Intent intent = new Intent(context, SplashActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkForTheme(this);
        setContentView(R.layout.activity_splash);
        viewById();
        setNavigationScheme();
    }

    public void setNavigationScheme() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                    moveToHome();
            }
        }, 1500);
    }

    public void viewById() {
        ivProjectLogo = findViewById(R.id.iv_project_logo);
        tvAppText = findViewById(R.id.tv_app_text);
    }
    public void moveToHome() {
        MainActivity.initActivity(SplashActivity.this);
    }

    public void checkForTheme(Context context) {
        try {
            String mySelectedTheme = PreferencesManager.getPreferenceByKey(context, getResources().getString(R.string.theme));
            if (mySelectedTheme.contains(getResources().getString(R.string.default_theme))) {
                setTheme(R.style.MyTheme_Default);
            } else if (mySelectedTheme.contains(getResources().getString(R.string.red))) {
                setTheme(R.style.MyTheme_Red);
            } else if (mySelectedTheme.contains(getResources().getString(R.string.white))) {
                setTheme(R.style.MyTheme_White);
            } else if (mySelectedTheme.contains(getResources().getString(R.string.black))) {
                setTheme(R.style.MyTheme_Black);
            } else if (mySelectedTheme.contains(getResources().getString(R.string.teal))) {
                setTheme(R.style.MyTheme_Teal);
            } else if (mySelectedTheme.contains(getResources().getString(R.string.brown))) {
                setTheme(R.style.MyTheme_Brown);
            } else if (mySelectedTheme.contains(getResources().getString(R.string.cyan))) {
                setTheme(R.style.MyTheme_Cyan);
            } else if (mySelectedTheme.contains(getResources().getString(R.string.pink))) {
                setTheme(R.style.MyTheme_Pink);
            } else if (mySelectedTheme.contains(getResources().getString(R.string.orange))) {
                setTheme(R.style.MyTheme_Orange);
            } else if (mySelectedTheme.contains(getResources().getString(R.string.green))) {
                setTheme(R.style.MyTheme_Green);
            } else if (mySelectedTheme.contains(getResources().getString(R.string.purple))) {
                setTheme(R.style.MyTheme_Purple);
            } else if (mySelectedTheme.contains(getResources().getString(R.string.blue))) {
                setTheme(R.style.MyTheme_Blue);
            } else if (mySelectedTheme.contains(getResources().getString(R.string.yellow))) {
                setTheme(R.style.MyTheme_Yellow);
            } else {
                setTheme(R.style.MyTheme_Default);
            }
        } catch (Exception e) {
            setTheme(R.style.MyTheme_Default);
        }
    }


}
