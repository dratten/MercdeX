package com.dalzai.mercedx;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import java.util.Objects;

public class ChatActivity extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_chat);
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("MercedX is loading...");
        progressDialog.setCancelable(false);
        WebView web_view = findViewById(R.id.web_view);
        web_view.requestFocus();
        web_view.getSettings().setJavaScriptEnabled(true);
        web_view.getSettings().setGeolocationEnabled(true);
        web_view.setSoundEffectsEnabled(true);
        web_view.loadData("<html><body style='margin:0;padding:0;'>" +
                        "<iframe\n" +
                        "    allow=\"microphone;\"\n" +
                        "    width=\"99%\"\n" +
                        "    height=\"99%\"\n" +
                        "    src=\"https://console.dialogflow.com/api-client/demo/embedded/f8371bd1-bbb1-42e6-8937-d793bd171fd5\">\n" +
                        "</iframe>" +
                        "</body></html>",
                "text/html", "UTF-8");
        web_view.setWebChromeClient(new WebChromeClient()
        {
            public void onProgressChanged(WebView view, int progress)
            {
                if(progress < 100)
                {
                    progressDialog.show();
                }
                else
                {
                    progressDialog.dismiss();
                }
            }
        });
    }
}
