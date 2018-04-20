package com.xq.mytextspan;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SpannableString spannableString;
    private TextView mTv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTv1 = ((TextView) this.findViewById(R.id.tv1));

        setAgreeMent();
    }

    private void setAgreeMent() {
        String content = "我已阅读并同意《网络借贷风险提示书》 《网络借贷禁止性行为提示书》 《资金合法来源承认书》";
        spannableString = new SpannableString(content);

        setClick();
        setColor();
        setSize();

        mTv1.setText(spannableString);
        mTv1.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void setSize() {
        spannableString.setSpan(new AbsoluteSizeSpan(sp2px(this, 13)), 7, 18, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        spannableString.setSpan(new AbsoluteSizeSpan(sp2px(this, 16)), 19, 33, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        spannableString.setSpan(new AbsoluteSizeSpan(sp2px(this, 13)), 34, 45, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
    }

    private void setColor() {
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#5283f0")), 7, 18, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#5283f0")), 19, 33, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#5283f0")), 34, 45, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
    }

    private void setClick() {
        spannableString.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NextActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("id", "1");
                intent.putExtras(bundle);
                startActivity(intent);
            }

            @Override
            public void updateDrawState(TextPaint ds) {//去除下划线
                ds.setUnderlineText(false);
            }
        }, 7, 18, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        spannableString.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NextActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("id", "2");
                intent.putExtras(bundle);
                startActivity(intent);
            }

            @Override
            public void updateDrawState(TextPaint ds) {//去除下划线
                ds.setUnderlineText(false);
            }
        }, 19, 33, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        spannableString.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NextActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("id", "3");
                intent.putExtras(bundle);
                startActivity(intent);
            }

            @Override
            public void updateDrawState(TextPaint ds) {//去除下划线
                ds.setUnderlineText(false);
            }
        }, 34, 45, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
    }

    private int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }
}
