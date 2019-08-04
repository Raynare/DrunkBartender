package com.example.bartender.Models;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.content.Context;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;

import com.example.bartender.Globals;
import com.example.bartender.Ingredient;
import com.example.bartender.MainActivity;
import com.example.bartender.DBHelper;

public class LotView {
    public LotView(final Context context,
                   final MainActivity mainActivity,
                   final int id,
                   final Ingredient ingredient) {
        m_layout = new LinearLayout(context);
        m_layout.setOrientation(LinearLayout.VERTICAL);

        final String nameString = context.getResources().getString(ingredient.getName());
        final boolean isLevelEnough = ingredient.getLevel() <= Globals.level;
        final int color = isLevelEnough ? Color.GREEN : Color.RED;
        final int price = ingredient.getPrice();

        ImageView image = new ImageView(context);
        image.setImageDrawable(context.getDrawable(ingredient.getImageId()));
        m_layout.addView(image);

        TextView nameTxt = new TextView(context);
        nameTxt.setText(nameString);
        m_layout.addView(nameTxt);

        Button valueBtn = new Button(context);
        valueBtn.setText(price + "$");
        valueBtn.setBackgroundColor(color);
        valueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbHelper = new DBHelper(context);

                if (Globals.money < price || !isLevelEnough)
                {
                    return;
                }

                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues cv = new ContentValues();
                cv.put("ingredientId", id);
                cv.put("volume", ingredient.getVolume());
                db.insert("ingredients", null, cv);

                Globals.money -= price;
                mainActivity.SetMoneyText();
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
