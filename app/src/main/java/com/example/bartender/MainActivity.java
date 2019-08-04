package com.example.bartender;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.pm.ActivityInfo;
import android.graphics.Point;
import android.graphics.Color;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.CheckBox;
import android.widget.ScrollView;
import android.widget.TextView;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;

import com.example.bartender.Models.ShopView;

import java.util.Locale;


public class MainActivity extends AppCompatActivity implements OnClickListener {
    private final int CELLS_COUNT = 16; // FOR NOW, BETTER NOT MORE THAN 10!!!
    int width;
    int height;
    AllIngredients ingredients;
    Coctails coctails;
    Coctail currentCoctail;
    CheckBox[] currentCheckboxes;
    LinearLayout ingredientsLayout;
    LinearLayout barLayout;
    ImageView coctailImg;
    int firstIngredient = 0;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        ingredients = new AllIngredients();
        coctails = new Coctails();

        ingredientsLayout = findViewById(R.id.ingredientsLayout);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        height = size.y;
        barLayout = findViewById(R.id.barLayout);
        barLayout.setY((float) (height * 0.75));
        currentCoctail = coctails.GetRandomCoctail();

        PrepareBarLayout();
        PrepareIngredientLayout();

        coctailImg = findViewById(R.id.coctailImg);
        coctailImg.setImageResource(currentCoctail.getImageId());
        coctailImg.setX((float) (width * 0.25));
        coctailImg.setY((float) (height * 0.55));

        moneyTxt = findViewById(R.id.moneyTxt);
        moneyTxt.setBackgroundColor(Color.GRAY);
        moneyTxt.setX(50);
        moneyTxt.setY(50);
        SetMoneyText();

        levelTxt = findViewById(R.id.levelTxt);
        levelTxt.setBackgroundColor(Color.GRAY);
        levelTxt.setX(50);
        levelTxt.setY(150);
        SetLevelText();

        ImageView shopImg = findViewById(R.id.shopImg);
        shopImg.setY(50);
        shopImg.setX(width - 200);
        shopImg.setOnClickListener(this);

        TextView barUpBtn = findViewById(R.id.barUpBtn);
        barUpBtn.setY(height - 240);
        barUpBtn.setX(width - 100);
        barUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (firstIngredient > 0)
                {
                    firstIngredient -= CELLS_COUNT;
                    PrepareBarLayout();
                }
            }
        });

        TextView barDownBtn = findViewById(R.id.barDownBtn);
        barDownBtn.setY(height - 200);
        barDownBtn.setX(width - 100);
        barDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstIngredient += CELLS_COUNT;
                PrepareBarLayout();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.shopImg:
                ScrollView shopLayout = new ShopView(this, this).Get();

                AlertDialog.Builder shopDialog = new AlertDialog.Builder(this)
                        .setView(shopLayout);
                shopDialog.show();
                break;
            default:
                break;
        }
    }

    public void SetMoneyText()
    {
        moneyTxt.setText(String.format(Locale.ENGLISH,"Money: %d $", Globals.money));
    }

    private void SetLevelText()
    {
        int maxExp = Globals.level * 100;

        levelTxt.setText(String.format(Locale.ENGLISH,"Level: %d (%d/%d)", Globals.level, exp, maxExp));
    }

    public void PrepareBarLayout()
    {
        barLayout.removeAllViews();
        dbHelper = new DBHelper(this);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor c = db.query("ingredients", null, null, null, null, null, null);
        if (c.moveToFirst()) {
            int ingedientIdColIndex = c.getColumnIndex("ingredientId");

            do {
                final int ingredientId = c.getInt(ingedientIdColIndex);
                final Ingredient currentIngredient = ingredients.getAllIngredients()[ingredientId];

                ImageView img = new ImageView(this);
                img.setScaleType(ImageView.ScaleType.FIT_XY);
                img.setImageResource(currentIngredient.getImageId());
                barLayout.addView(img);
                img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (CheckIngredients(currentIngredient.getImageId()))
                        {
                            UpdateCoctail();
                        }
                    }
                });
            } while (c.moveToNext());

            c.close();
        }
    }

    private void UpdateCoctail()
    {
        Globals.money += currentCoctail.getPrice();
        SetMoneyText();

        int maxExp = Globals.level * 100;
        exp += 10;
        if (exp >= maxExp)
        {
            Globals.level++;
            exp -= maxExp;
        }
        SetLevelText();

        currentCoctail = coctails.GetRandomCoctail();
        coctailImg.setImageResource(currentCoctail.getImageId());
        PrepareIngredientLayout();
    }

    private void PrepareIngredientLayout()
    {
        ingredientsLayout.setX((float) (width * 0.35));
        ingredientsLayout.setY((float) (height * 0.55));
        ingredientsLayout.removeAllViews();

        IngredientAdded[] ingredients = currentCoctail.getIngredients();
        int ingredientsCount = ingredients.length;
        if (ingredientsCount == 0)
        {
            return;
        }

        currentCheckboxes = new CheckBox[ingredientsCount];
        for (int i = 0; i < ingredientsCount; ++i)
        {
            currentCheckboxes[i] = new CheckBox(this);
            currentCheckboxes[i].setClickable(false);
            currentCheckboxes[i].setBackgroundColor(Color.BLACK);
            String ingredientName = getResources().getString(ingredients[i].getIngredient().getName());
            String ingredientText = String.format(Locale.ENGLISH, "%s (%d)", ingredientName, ingredients[i].getVolume());
            currentCheckboxes[i].setText(ingredientText);
            ingredientsLayout.addView(currentCheckboxes[i]);
        }
    }
    
    private boolean CheckIngredients(int id)
    {
        boolean done = true;

        IngredientAdded[] ingredients = currentCoctail.getIngredients();
        int ingredientsCount = ingredients.length;
        for (int i = 0; i < ingredientsCount; ++i)
        {
            if (ingredients[i].getIngredient().getImageId() == id)
            {
                currentCheckboxes[i].setChecked(true);
            }
            if (!currentCheckboxes[i].isChecked())
            {
                done = false;
            }
        }

        return done;
    }

    private TextView moneyTxt;
    private TextView levelTxt;
    private int exp = 0;
}
