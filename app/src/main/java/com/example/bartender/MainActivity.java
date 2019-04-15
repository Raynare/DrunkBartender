package com.example.bartender;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.content.pm.ActivityInfo;

import android.graphics.Point;
import android.graphics.Color;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private final int CELLS_COUNT = 10;
    int width;
    int height;
    int money = 0;
    AllIngredients ingredients = new AllIngredients();
    Coctails coctails = new Coctails();
    Coctail currentCoctail;
    CheckBox[] currentCheckboxes;
    LinearLayout ingredientsLayout;
    LinearLayout barLayout;
    ImageView coctailImg;
    TextView moneyTxt;
    int firstIngredient = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

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
        /*coctailImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingredientsLayout.setVisibility(ingredientsLayout.getVisibility() == View.VISIBLE ? View.INVISIBLE : View.VISIBLE);
            }
        });*/

        ImageView shopImg = findViewById(R.id.shopImg);
        shopImg.setY(50);
        shopImg.setX(width - 200);

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

    private void SetMoneyText()
    {
        moneyTxt.setText(String.format(Locale.ENGLISH,"Money: %d $", money));
    }

    private void PrepareBarLayout()
    {
        barLayout.removeAllViews();

        int availableHeight = (int) (height * 0.3);
        int availableWidth = width - 100;
        int cellWidth = (int) ((float) availableWidth / (float) CELLS_COUNT);

        Ingredient[] ingredientsAll = ingredients.getAllIngredients();
        for (int i = firstIngredient; i < firstIngredient + CELLS_COUNT; ++i)
        {
            if (i >= ingredientsAll.length) {
                return;
            }

            final Ingredient currentIngredient = ingredientsAll[i];
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
        }
    }

    private void UpdateCoctail()
    {
        money += currentCoctail.getPrice();
        SetMoneyText();
        currentCoctail = coctails.GetRandomCoctail();
        coctailImg.setImageResource(currentCoctail.getImageId());
        PrepareIngredientLayout();
    }

    private void PrepareIngredientLayout()
    {
        ingredientsLayout.setX((float) (width * 0.35));
        ingredientsLayout.setY((float) (height * 0.55));
        /*ingredientsLayout.setVisibility(View.INVISIBLE);*/
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
}
