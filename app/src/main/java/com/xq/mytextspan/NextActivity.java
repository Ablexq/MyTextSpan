package com.xq.mytextspan;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        TextView mTv = ((TextView) this.findViewById(R.id.next_tv));
        Intent intent = getIntent();
        if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                String id = extras.getString("id");
                if (!TextUtils.isEmpty(id)) {
                    String string = "我是第" + id + "个链接";
                    mTv.setText(string);
                }
            }
        }
    }
}
