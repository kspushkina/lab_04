package com.example.lab_04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox[] chk = new CheckBox[4];
    EditText[] prices = new EditText[4];
    EditText[] num = new EditText[4];
    float[] price = new float[4];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num[0] = findViewById(R.id.applenum);
        num[1] = findViewById(R.id.strawberrynum);
        num[2] = findViewById(R.id.blueberrynum);
        num[3] = findViewById(R.id.potatoesnum);

        prices[0] = findViewById(R.id.appleprice);
        prices[1] = findViewById(R.id.strawberryprice);
        prices[2] = findViewById(R.id.blueberryprice);
        prices[3] = findViewById(R.id.potatoesprice);

        chk[0] = findViewById(R.id.apple);
        chk[1] = findViewById(R.id.strawberry);
        chk[2] = findViewById(R.id.blueberry);
        chk[3] = findViewById(R.id.potatoes);


    }

    public void calc(View view)
    {
        float sum = 0.0f;
        StringBuilder rep = new StringBuilder();
        int n = 4;
        for (int i = 0; i < n; i++) {
            if (chk[i].isChecked()) {
                int q;
                float p;
                try {
                    q = Integer.parseInt(num[i].getText().toString());
                    p = Float.parseFloat(prices[i].getText().toString());
                } catch (NumberFormatException e) {
                    Toast.makeText(this, "Ошибка: введите корректные данные для продукта " + (i + 1), Toast.LENGTH_SHORT).show();
                    return;
                }
                if (q <= 0 || p <= 0) {
                    Toast.makeText(this, "Ошибка: количество и цена продукта " + (i + 1) + " должны быть больше нуля", Toast.LENGTH_SHORT).show();
                    return;
                }
                float val = q * p;
                sum += val;
                rep.append(String.format("%s: %d x %.2f = %.2f\n", chk[i].getText().toString(), q, p, val));
            }
        }
        rep.append(String.format("Итоговая сумма: %.2f", sum));
        Toast.makeText(this, rep.toString(), Toast.LENGTH_LONG).show();
    }

}