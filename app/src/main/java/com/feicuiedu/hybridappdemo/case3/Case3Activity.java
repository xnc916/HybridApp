package com.feicuiedu.hybridappdemo.case3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.feicuiedu.hybridappdemo.R;
import com.github.lzyzsd.jsbridge.BridgeHandler;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.github.lzyzsd.jsbridge.CallBackFunction;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Case3Activity extends AppCompatActivity {

    @BindView(R.id.web_view) BridgeWebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case3);
        ButterKnife.bind(this);

        webView.registerHandler("showToast", new BridgeHandler() {
            @Override public void handler(String data, CallBackFunction function) {
                Toast.makeText(Case3Activity.this, "登录失败", Toast.LENGTH_SHORT).show();
            }
        });

        webView.loadUrl("file:///android_asset/login3.html");
    }

    @OnClick(R.id.btn_clear)
    public void clear() {
        webView.callHandler("reset", "{\"username\":\"feicui\", \"password\":\"123\"}", new CallBackFunction() {
            @Override public void onCallBack(String data) {

            }
        });
    }
}
