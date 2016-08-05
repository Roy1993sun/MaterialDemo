package com.roy.materialdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    ImageView mDetailImage;
    TextView  mDetailTextview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mDetailImage = (ImageView) findViewById(R.id.detail_image);
        mDetailTextview = (TextView) findViewById(R.id.detail_textview);

        if (getIntent().getSerializableExtra("bean") != null) {
            ItemBean bean = (ItemBean) getIntent().getSerializableExtra("bean");
            Toast.makeText(DetailActivity.this, bean.img, Toast.LENGTH_SHORT)
                 .show();

            Picasso.with(this)
                   .load(bean.img)
                   .placeholder(R.mipmap.ic_launcher)
                   .into(mDetailImage);

            mDetailTextview.setText(bean.text);
        }
    }
}
