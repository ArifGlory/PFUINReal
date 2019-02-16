package myproject.pfuinreal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ListMateriUtama extends AppCompatActivity {

    Button btnFisikaDasar2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_materi_utama);

        btnFisikaDasar2 = findViewById(R.id.btnFisikaDasar2);
        btnFisikaDasar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MateriFisikaDasar2Activity.class);
                startActivity(intent);
            }
        });
    }
}
