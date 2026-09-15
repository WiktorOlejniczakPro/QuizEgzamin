package com.example.quiz2026;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    ImageView image;
    TextView pytanie;
    RadioButton pyt1;
    RadioButton pyt2;
    RadioButton pyt3;
    Button skip;
    RadioGroup grupa;

    String[] Pytania = {"Które to schronisko?", "Zwierzę na zdjęciu to", "W oddali są widoczne"};
    String[] Odpowiedzi1 = {"Na Rysiance", "owczarek.", "Himalaje."};
    String[] Odpowiedzi2 = {"Na Wielkiej Raczy.", "wilk.", "Alpy."};
    String[] Odpowiedzi3 = {"Na Wielkiej Rycerzowej.", "kozica.", "Tatry."};
    String[] Poprawne = {"Na Wielkiej Raczy.", "owczarek.", "Tatry."};
    Integer Lpytanie = 1;
    Integer Lpkt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        image = findViewById(R.id.image);
        pytanie = findViewById(R.id.pytanie);
        pyt1 = findViewById(R.id.pyt1);
        pyt2 = findViewById(R.id.pyt2);
        pyt3 = findViewById(R.id.pyt3);
        skip = findViewById(R.id.skip);
        grupa = findViewById(R.id.grupa);


        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Lpytanie == 1 && pyt2.isChecked()){
                    grupa.clearCheck();
                    image.setImageResource(R.drawable.zad2);
                    pytanie.setText(Pytania[1]);
                    pyt1.setText(Odpowiedzi1[1]);
                    pyt2.setText(Odpowiedzi2[1]);
                    pyt3.setText(Odpowiedzi3[1]);
                    Lpytanie++;
                    Lpkt++;
                } else if (Lpytanie == 1 && (pyt1.isChecked() || pyt3.isChecked())) {
                    grupa.clearCheck();
                }

                if(Lpytanie == 2 && pyt1.isChecked()){
                    grupa.clearCheck();
                    image.setImageResource(R.drawable.zad3);
                    pytanie.setText(Pytania[2]);
                    pyt1.setText(Odpowiedzi1[2]);
                    pyt2.setText(Odpowiedzi2[2]);
                    pyt3.setText(Odpowiedzi3[2]);
                    Lpytanie++;
                    Lpkt++;
                } else if (Lpytanie == 2 && (pyt2.isChecked() || pyt3.isChecked())) {
                    grupa.clearCheck();
                }

                if(Lpytanie == 3 && pyt3.isChecked()){
                    grupa.clearCheck();
                    image.setImageResource(R.drawable.zad1);
                    pytanie.setText(Pytania[0]);
                    pyt1.setText(Odpowiedzi1[0]);
                    pyt2.setText(Odpowiedzi2[0]);
                    pyt3.setText(Odpowiedzi3[0]);
                    Lpytanie=1;
                    Lpkt++;
                }
                else if (Lpytanie == 3 && (pyt1.isChecked() || pyt2.isChecked())) {
                    grupa.clearCheck();
                }

            }
        });
    }
}