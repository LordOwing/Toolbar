package com.example.toolbar;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    private TextView infoText;
    private View lay;
    private Button add;
    private int counter = 0;
    private TextView count_text;
    private ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        lay = findViewById(R.id.layout);
        setSupportActionBar(toolbar);
        infoText = findViewById(R.id.infoText);
        add = findViewById(R.id.add);
        count_text = findViewById(R.id.counter);
        image = findViewById(R.id.image);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter +=1;
                count_text.setText(Integer.toString(counter));
            }
        });
    }

    // 1. Metoda tworząca menu na ekranie
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu); // Wskazujemy nasz plik XML
        return true; // Zwracamy true, żeby menu się wyświetliło
    }

    // 2. Metoda obsługująca kliknięcia w opcje
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Pobieramy ID klikniętego elementu
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Toast.makeText(this, "Wybrano Ustawienia", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (id == R.id.action_info) {
            if (infoText != null) {
                infoText.setText("Aplikacja stworzona przez: Jana Kowalskiego");
            } else {
                Toast.makeText(this, "Aplikacja stworzona przez: Jana Kowalskiego", Toast.LENGTH_SHORT).show();
            }
            return true;
        }
        else if (id == R.id.action_exit) {
            finish(); // Zamyka bieżącą aktywność (to nie zawsze = "ubij aplikację")
            return true;
        }
        else if (id == R.id.action_favorite) {
           Toast.makeText(this,"Dodano do ulubionych", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (id == R.id.action_red) {
            lay.setBackgroundColor(Color.parseColor("#FF0000"));
            return true;
        }
        else if (id == R.id.action_green) {
            lay.setBackgroundColor(Color.parseColor("#00FF00"));
            return true;
        }
        else if (id == R.id.action_blue) {
            lay.setBackgroundColor(Color.parseColor("#0000FF"));
            return true;
        }
        else if (id == R.id.action_reset_counter) {
            counter = 0;
            count_text.setText(Integer.toString(0));
            return true;
        }
        else if (id == R.id.action_small) {
            infoText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);

            return true;
        }
        else if (id == R.id.action_medium) {
            infoText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);

            return true;
        }
        else if (id == R.id.action_big) {
            infoText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);

            return true;
        }
        else if (id == R.id.action_image) {
            item.setChecked(!item.isChecked());
            if (item.isChecked()) {
                image.setVisibility(View.VISIBLE);
            } else {
                image.setVisibility(View.GONE);
            }

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}