package com.example.bartender.Models;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.content.Context;

import com.example.bartender.MainActivity;

public class LotView {
    public LotView(Context context,
                   final MainActivity mainActivity,
                   String name,
                   int value,
                   int imageId) {
        m_layout = new LinearLayout(context);
        m_layout.setOrientation(LinearLayout.VERTICAL);

        ImageView image = new ImageView(context);
        image.setImageDrawable(context.getDrawable(imageId));
        m_layout.addView(image);

        TextView nameTxt = new TextView(context);
        nameTxt.setText(name);
        m_layout.addView(nameTxt);

        Button valueBtn = new Button(context);
        valueBtn.setText(value + "$");
        valueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.PrepareBarLayout();
            }
        });
        m_layout.addView(valueBtn);
    }

    public LinearLayout Get()
    {
        return m_layout;
    }

    private LinearLayout m_layout;
}
