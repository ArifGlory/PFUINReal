package myproject.pfuinreal;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LatihanActivity extends AppCompatActivity {

    ProgressBar progressBar;
    private ObjectAnimator mAnimation;
    Button btnA,btnB,btnC,btnD,btnE;
    int duration = 150000;
    private long tambahDurasi = 15000;
    private int skor = 0;
    private String getAnswer,tempSoal;
    int coinNow,jmlBenar,totalSkor;
    Intent i;
    ImageView imgPlay;
    public static String a;
    TextView txtSoal;
    private int currentSoal = 0;

    DBAdapter mDB;
    private Quiz mquiz;
    private List<Quiz> mlistQuiz;
    DialogInterface.OnClickListener listener;
    Intent intent;
    private String key;

    List<Quiz> listSoalShuffle = new ArrayList<Quiz>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latihan);

        intent = getIntent();
        key = intent.getStringExtra("key");

        btnA = (Button)findViewById(R.id.btnJwbA);
        btnB = (Button) findViewById(R.id.btnJwbB);
        btnC = (Button) findViewById(R.id.btnJwbC);
        btnD = (Button) findViewById(R.id.btnJwbD);
        btnE = (Button) findViewById(R.id.btnJwbE);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        imgPlay = (ImageView) findViewById(R.id.imgPlay);
        txtSoal = findViewById(R.id.txtSoal);

        mDB = DBAdapter.getInstance(getApplicationContext());
        if (key.equals("gel_cahaya")){
            mlistQuiz = mDB.getAllCahaya();

        }else if (key.equals("pembiasan")){
            mlistQuiz = mDB.getAllLensa();

        }else if (key.equals("induksi1")){
            mlistQuiz = mDB.getAllSoal();

        }else if (key.equals("induksi2")){
            mlistQuiz = mDB.getAllInduksi2();

        }else if (key.equals("medan_magnet")){
            mlistQuiz = mDB.getAllMagnet();

        }else if (key.equals("kapasitor")){
            mlistQuiz = mDB.getAllKapasitor();
        }

        Collections.shuffle(mlistQuiz);

        mAnimation = ObjectAnimator.ofInt(progressBar,"progress",0,100);
        mAnimation.setDuration(duration);
        mAnimation.setInterpolator(new DecelerateInterpolator());
        mAnimation.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                //  Toast.makeText(getApplicationContext(),"Animasi progres mulai",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                // Toast.makeText(getApplicationContext(),"Animasi progres berhenti",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationCancel(Animator animator) {
                // Toast.makeText(getApplicationContext(),"Animasi progres cancel",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationRepeat(Animator animator) {
                // Toast.makeText(getApplicationContext(),"Animasi progres diulang",Toast.LENGTH_SHORT).show();
            }
        });
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAnswer = "A";
                nextSoal();
            }
        });
        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAnswer = "B";
                nextSoal();
            }
        });
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAnswer = "C";
                nextSoal();
            }
        });
        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAnswer = "D";
                nextSoal();
            }
        });
        btnE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnswer = "E";
                nextSoal();
            }
        });

        mulaiQuiz();
        mAnimation.start();

    }

    private void mulaiQuiz(){

        setupSoal();
    }

    public  void setupSoal(){

        mquiz  = mlistQuiz.get(currentSoal);

        btnA.setText("A. "+mquiz.getJawaban_a());
        btnB.setText("B. "+mquiz.getJawaban_b());
        btnC.setText("C. "+mquiz.getJawaban_c());
        btnD.setText("D. "+mquiz.getJawaban_d());
        btnE.setText("E. "+mquiz.getJawaban_e());
        txtSoal.setText(mquiz.getSoal());

        currentSoal++;

    }

    public void nextSoal(){

        if (getAnswer.equals(mquiz.getJawaban_benar().toUpperCase())){

            if (key.equals("gel_cahaya") || key.equals("pembiasan")){
                skor = skor + 25;
            }else {
                skor = skor+33;
            }

        }else {

        }


        if (currentSoal<mlistQuiz.size()){
            setupSoal();
        }else {

            mAnimation.end();
            totalSkor = skor;
            Intent i = new Intent(this,ResultActivity.class);
            i.putExtra("kirimSkor",totalSkor);
            i.putExtra("key",key);
            startActivity(i);
        }
    }

    @Override
    protected void onDestroy() {
        if (mAnimation.isRunning()){
            mAnimation.end();
        }

        super.onDestroy();
    }

    @Override
    protected void onPause() {

        super.onPause();
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Apakan anda ingin keluar sesi latihan ?");
        builder.setCancelable(false);

        listener = new DialogInterface.OnClickListener()
        {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which == DialogInterface.BUTTON_POSITIVE){
                    //finishAffinity();
                    //System.exit(0);
                    mAnimation.end();
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
        builder.show();
    }
}
