package com.canerorak.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import org.mariuszgromada.math.mxparser.Expression;


public class MainActivity extends AppCompatActivity {

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.editText_Sonuc);
        editText.setShowSoftInputOnFocus(false);
    }

    public void Yazdir(View view)
    {
        double itemID=view.getId();
        if (itemID==(double) R.id.button_temizle)
        {
            editText.setText("");
        } else if (itemID==R.id.button_dot)
        {
            EkranaYazdir(".");
        } else if (itemID==R.id.button_0)
        {
            EkranaYazdir("0");
        } else if (itemID==R.id.button_1)
        {
            EkranaYazdir("1");
        } else if (itemID==R.id.button_2)
        {
            EkranaYazdir("2");
        } else if (itemID==R.id.button_3)
        {
            EkranaYazdir("3");
        } else if (itemID==R.id.button_4)
        {
            EkranaYazdir("4");
        } else if (itemID==R.id.button_5)
        {
            EkranaYazdir("5");
        } else if (itemID==R.id.button_6)
        {
            EkranaYazdir("6");
        } else if (itemID==R.id.button_7)
        {
            EkranaYazdir("7");
        } else if (itemID==R.id.button_8)
        {
            EkranaYazdir("8");
        } else if (itemID==R.id.button_9)
        {
            EkranaYazdir("9");
        } else if (itemID==R.id.button_divide)
        {
            EkranaYazdir("/");
        } else if (itemID==R.id.button_plus)
        {
            EkranaYazdir("+");
        } else if (itemID==R.id.button_minus)
        {
            EkranaYazdir("-");
        } else if (itemID==R.id.button_equal)
        {
            Sonuc();
        } else if (itemID==R.id.button_multiply)
        {
            EkranaYazdir("*");

        } else if (itemID==R.id.button_sil)
        {
            Sil();
        }
    }


        private void Sil() {
        int cursorPos=editText.getSelectionStart();
        if(cursorPos>0)
        {
            String eskiDeger = editText.getText().toString();
            String solTaraf = eskiDeger.substring(0, cursorPos-1);
            String sagTaraf = eskiDeger.substring(cursorPos);
            String yeniDeger = solTaraf+sagTaraf;
            editText.setText(yeniDeger);
            editText.setSelection(cursorPos-1);
        }
    }

    private void Sonuc()
    {
        String yazi = editText.getText().toString();
        Expression ifade = new Expression(yazi);

        try {
            double sonuc = ifade.calculate();
            editText.setText(String.valueOf(sonuc));

            editText.setSelection(editText.getText().length());
        } catch (Exception e) {
            editText.setText("Hatalı İfade");
        }
    }


    private void EkranaYazdir(String deger ) {

        int cursorPos=editText.getSelectionStart();
        String eskiDeger=editText.getText().toString();
        String solTaraf=eskiDeger.substring(0,cursorPos);
        String sagTaraf=eskiDeger.substring(cursorPos);
        String yeniDeger=solTaraf+deger+sagTaraf;
        editText.setText(yeniDeger);
        editText.setSelection(cursorPos+1);
    }
}