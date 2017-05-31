package com.feicuiedu.hybridappdemo.case1;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.feicuiedu.hybridappdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Case1Activity extends AppCompatActivity {

    private static final String HYBRID_BRIDGE_HOST = "feicuiedu.com.hybridapp";

    @BindView(R.id.web_view) WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case1);
        ButterKnife.bind(this);


        webView.setWebViewClient(new WebViewClient(){
            @Override public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Uri uri = Uri.parse(url);
                if (HYBRID_BRIDGE_HOST.equals(uri.getHost())) {
                    boolean success = "true".equals(uri.getQueryParameter("success"));

                    if (success) {
                        finish();
                    }

                    String msg = uri.getQueryParameter("msg");
                    Toast.makeText(Case1Activity.this, msg, Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });

        webView.loadUrl("http://106.14.32.204:8080/demo/login1.html");
    }
}
