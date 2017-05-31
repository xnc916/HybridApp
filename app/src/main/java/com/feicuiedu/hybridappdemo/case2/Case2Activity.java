package com.feicuiedu.hybridappdemo.case2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

import com.feicuiedu.hybridappdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Case2Activity extends AppCompatActivity {

    @BindView(R.id.web_view) WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case2);
        ButterKnife.bind(this);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new JavaScriptInterface(), "JSInterface");
        webView.loadUrl("file:///android_asset/login2.html");
    }

    @OnClick(R.id.btn_clear)
    public void clear() {
        webView.loadUrl("javascript:clear()");
    }

    public class JavaScriptInterface {

        @JavascriptInterface
        public void showToast() {
            Toast.makeText(Case2Activity.this, "登录失败", Toast.LENGTH_SHORT).show();
        }
    }
}
