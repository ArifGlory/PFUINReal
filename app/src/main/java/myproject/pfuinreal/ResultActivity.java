package myproject.pfuinreal;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ResultActivity extends AppCompatActivity {

    TextView txtSkor;
    Button btnKeHome,btnPembahasan,btnKeHistory;
    Intent i;
    private int skor;
    DialogInterface.OnClickListener listener;
    DBAdapter mDB;
    private String tanggal;
    String keyMateri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        mDB = DBAdapter.getInstance(getApplicationContext());

        i = getIntent();
        skor = i.getIntExtra("kirimSkor",skor);
        keyMateri = i.getStringExtra("key");
        if (skor>90){
            skor = 100;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        tanggal = dateFormat.format(new Date()); // Find todays date

        //insert riwayat latihan
        SQLiteDatabase db = mDB.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("nilai",skor);
        values.put("id_user",SharedVariable.userID);
        values.put("nama_materi",keyMateri);
        values.put("tanggal",tanggal);
        db.insert("tb_history", null, values);

        /*String sql = "INSERT INTO tb_history ( nilai, id_user, nama_materi, tanggal) VALUES ("+skor+","+SharedVariable.userID+",'"+keyMateri+"','"+waktu"'");
        db.execSQL(sql);*/

        txtSkor = (TextView) findViewById(R.id.txtSkor);
        btnKeHome = (Button) findViewById(R.id.btnKeHome);
        btnPembahasan = (Button) findViewById(R.id.btnPembahasan);
        txtSkor.setText(String.valueOf(skor));
        btnKeHistory = findViewById(R.id.btnKeHistory);

        btnKeHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(i);
            }
        });
        btnKeHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(getApplicationContext(),HistoryActivity.class);
                startActivity(i);
            }
        });
        btnPembahasan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(getApplicationContext(),PembahasanActivity.class);
                i.putExtra("key",keyMateri);
                startActivity(i);
            }
        });

    }

    @Override
    public void onBackPressed() {
        i = new Intent(getApplicationContext(),HomeActivity.class);
        startActivity(i);
        /*AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Apakan anda ingin keluar sesi permainan ?");
        builder.setCancelable(false);

        listener = new DialogInterface.OnClickListener()
        {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which == DialogInterface.BUTTON_POSITIVE){
                    i = new Intent(getApplicationContext(),HomeActivity.class);
                    startActivity(i);
                }

                if(which == DialogInterface.BUTTON_NEGATIVE){
                    dialog.cancel();
                }
            }
        };
        builder.setPositiveButton("Ya",listener);
        builder.setNegativeButton("Tidak", listener);
        builder.show();*/
    }
}
