package myproject.pfuinreal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Glory on 28/09/2016.
 */
public class DBAdapter extends SQLiteAssetHelper {

    private static final String DB_NAME                 = "db_pfuinreal4";
    private static final int        DB_VER                  = 1;
    public static final String TABLE_SOAL_INDUKSI              = "tb_induksi1";
    public static final String TABLE_SOAL_INDUKSI2              = "tb_induksi2";
    public static final String TABLE_SOAL_LENSA              = "tb_lensa";
    public static final String TABLE_SOAL_MAGNET              = "tb_magnet";
    public static final String TABLE_SOAL_KAPASITOR              = "tb_kapasitor";
    public static final String TABLE_SOAL_CAHAYA              = "tb_cahaya";
    public static final String TABLE_USER              = "tb_user";
    public static final String TABLE_HISTORY              = "tb_history";

    public static final String COL_SOAL_ID             = "id";
    public static final String COL_SOAL_SOAL           = "soal";
    public static final String COL_SOAL_JAWABAN_A      = "jawaban_a";
    public static final String COL_SOAL_JAWABAN_B      = "jawaban_b";
    public static final String COL_SOAL_JAWABAN_C      = "jawaban_c";
    public static final String COL_SOAL_JAWABAN_D      = "jawaban_d";
    public static final String COL_SOAL_JAWABAN_E      = "jawaban_e";
    public static final String COL_SOAL_JAWABAN_BENAR  = "jawaban_benar";
    public static final String COL_SOAL_GAMBAR  = "gambar";

    public static final String COL_USER_ID           = "id";
    public static final String COL_USER_USERNAME           = "username";
    public static final String COL_USER_PASSWORD           = "password";
    public static final String COL_USER_NAMA           = "nama";

    public static final String COL_HISTORY_ID           = "id";
    public static final String COL_HISTORY_NILAI           = "nilai";
    public static final String COL_HISTORY_IDUSER           = "id_user";
    public static final String COL_HISTORY_NAMA_MATERI           = "nama_materi";
    public static final String COL_HISTORY_TANGGAL           = "tanggal";

    public static DBAdapter        dbInstance;
    public static SQLiteDatabase db;



    /**
     * private Constructor, untuk menggunakan kelas ini gunakan getInstance()
     * @param context
     */


    private DBAdapter(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }


    public  static synchronized DBAdapter getInstance(Context context){

        if (dbInstance == null){
            dbInstance = new DBAdapter(context.getApplicationContext());
            db = dbInstance.getReadableDatabase();
        }

        return dbInstance;
    }

    public SQLiteDatabase ambilDB(){
        db = this.getWritableDatabase();
        return db;


    }

   /* public DBAdapter getInstance(Context context){

        if (dbInstance == null){

            dbInstance = new DBAdapter(context);
            db = dbInstance.getReadableDatabase();

        }

        return  dbInstance;
    }*/



    @Override
    public synchronized void close(){

        super.close();
        if (dbInstance!=null){

            dbInstance.close();
        }
    }


//method untuk mengambil semua data soal
    public List<Quiz> getAllSoal(){

        List<Quiz> listSoal = new ArrayList<Quiz>();

        Cursor cursor = db.query(TABLE_SOAL_INDUKSI,new String[]{

               COL_SOAL_ID,
                COL_SOAL_SOAL,
                COL_SOAL_JAWABAN_A,
                COL_SOAL_JAWABAN_B,
                COL_SOAL_JAWABAN_C,
                COL_SOAL_JAWABAN_D,
                COL_SOAL_JAWABAN_E,
                COL_SOAL_JAWABAN_BENAR,
                COL_SOAL_GAMBAR
                },null,null,null,null,null);//kenapa ada 5 null ya ?

        if (cursor.moveToFirst()){


            do {
                Quiz quiz = new Quiz();

                quiz.setId(cursor.getInt(cursor.getColumnIndexOrThrow(COL_SOAL_ID)));
                quiz.setSoal(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_SOAL)));
                quiz.setJawaban_a(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_JAWABAN_A)));
                quiz.setJawaban_b(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_JAWABAN_B)));
                quiz.setJawaban_c(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_JAWABAN_C)));
                quiz.setJawaban_d(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_JAWABAN_D)));
                quiz.setJawaban_e(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_JAWABAN_E)));
                quiz.setJawaban_benar(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_JAWABAN_BENAR)));
                quiz.setGambar(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_GAMBAR)));



            listSoal.add(quiz);



            }while (cursor.moveToNext());

        }

        return listSoal;
    }

    public List<Quiz> getAllInduksi2(){

        List<Quiz> listSoal = new ArrayList<Quiz>();

        Cursor cursor = db.query(TABLE_SOAL_INDUKSI2,new String[]{

                COL_SOAL_ID,
                COL_SOAL_SOAL,
                COL_SOAL_JAWABAN_A,
                COL_SOAL_JAWABAN_B,
                COL_SOAL_JAWABAN_C,
                COL_SOAL_JAWABAN_D,
                COL_SOAL_JAWABAN_E,
                COL_SOAL_JAWABAN_BENAR,
                COL_SOAL_GAMBAR
        },null,null,null,null,null);//kenapa ada 5 null ya ?

        if (cursor.moveToFirst()){


            do {
                Quiz quiz = new Quiz();

                quiz.setId(cursor.getInt(cursor.getColumnIndexOrThrow(COL_SOAL_ID)));
                quiz.setSoal(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_SOAL)));
                quiz.setJawaban_a(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_JAWABAN_A)));
                quiz.setJawaban_b(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_JAWABAN_B)));
                quiz.setJawaban_c(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_JAWABAN_C)));
                quiz.setJawaban_d(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_JAWABAN_D)));
                quiz.setJawaban_e(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_JAWABAN_E)));
                quiz.setJawaban_benar(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_JAWABAN_BENAR)));
                quiz.setGambar(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_GAMBAR)));



                listSoal.add(quiz);



            }while (cursor.moveToNext());

        }

        return listSoal;
    }

    public List<Quiz> getAllMagnet() {

        List<Quiz> listSoal = new ArrayList<Quiz>();

        Cursor cursor = db.query(TABLE_SOAL_MAGNET,new String[]{

                COL_SOAL_ID,
                COL_SOAL_SOAL,
                COL_SOAL_JAWABAN_A,
                COL_SOAL_JAWABAN_B,
                COL_SOAL_JAWABAN_C,
                COL_SOAL_JAWABAN_D,
                COL_SOAL_JAWABAN_E,
                COL_SOAL_JAWABAN_BENAR,
                COL_SOAL_GAMBAR
        },null,null,null,null,null);//kenapa ada 5 null ya ?

        if (cursor.moveToFirst()){


            do {
                Quiz quiz = new Quiz();

                quiz.setId(cursor.getInt(cursor.getColumnIndexOrThrow(COL_SOAL_ID)));
                quiz.setSoal(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_SOAL)));
                quiz.setJawaban_a(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_JAWABAN_A)));
                quiz.setJawaban_b(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_JAWABAN_B)));
                quiz.setJawaban_c(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_JAWABAN_C)));
                quiz.setJawaban_d(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_JAWABAN_D)));
                quiz.setJawaban_e(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_JAWABAN_E)));
                quiz.setJawaban_benar(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_JAWABAN_BENAR)));
                quiz.setGambar(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_GAMBAR)));

                listSoal.add(quiz);



            }while (cursor.moveToNext());

        }

        return listSoal;
    }

    public List<Quiz> getAllCahaya() {

        List<Quiz> listSoal = new ArrayList<Quiz>();

        Cursor cursor = db.query(TABLE_SOAL_CAHAYA,new String[]{

                COL_SOAL_ID,
                COL_SOAL_SOAL,
                COL_SOAL_JAWABAN_A,
                COL_SOAL_JAWABAN_B,
                COL_SOAL_JAWABAN_C,
                COL_SOAL_JAWABAN_D,
                COL_SOAL_JAWABAN_E,
                COL_SOAL_JAWABAN_BENAR,
                COL_SOAL_GAMBAR
        },null,null,null,null,null);//kenapa ada 5 null ya ?

        if (cursor.moveToFirst()){


            do {
                Quiz quiz = new Quiz();

                quiz.setId(cursor.getInt(cursor.getColumnIndexOrThrow(COL_SOAL_ID)));
                quiz.setSoal(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_SOAL)));
                quiz.setJawaban_a(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_JAWABAN_A)));
                quiz.setJawaban_b(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_JAWABAN_B)));
                quiz.setJawaban_c(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_JAWABAN_C)));
                quiz.setJawaban_d(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_JAWABAN_D)));
                quiz.setJawaban_e(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_JAWABAN_E)));
                quiz.setJawaban_benar(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_JAWABAN_BENAR)));
                quiz.setGambar(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_GAMBAR)));

                listSoal.add(quiz);



            }while (cursor.moveToNext());

        }

        return listSoal;
    }

    public List<Quiz> getAllLensa() {

        List<Quiz> listSoal = new ArrayList<Quiz>();

        Cursor cursor = db.query(TABLE_SOAL_LENSA,new String[]{

                COL_SOAL_ID,
                COL_SOAL_SOAL,
                COL_SOAL_JAWABAN_A,
                COL_SOAL_JAWABAN_B,
                COL_SOAL_JAWABAN_C,
                COL_SOAL_JAWABAN_D,
                COL_SOAL_JAWABAN_E,
                COL_SOAL_JAWABAN_BENAR,
                COL_SOAL_GAMBAR
        },null,null,null,null,null);//kenapa ada 5 null ya ?

        if (cursor.moveToFirst()){


            do {
                Quiz quiz = new Quiz();

                quiz.setId(cursor.getInt(cursor.getColumnIndexOrThrow(COL_SOAL_ID)));
                quiz.setSoal(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_SOAL)));
                quiz.setJawaban_a(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_JAWABAN_A)));
                quiz.setJawaban_b(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_JAWABAN_B)));
                quiz.setJawaban_c(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_JAWABAN_C)));
                quiz.setJawaban_d(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_JAWABAN_D)));
                quiz.setJawaban_e(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_JAWABAN_E)));
                quiz.setJawaban_benar(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_JAWABAN_BENAR)));
                quiz.setGambar(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_GAMBAR)));

                listSoal.add(quiz);



            }while (cursor.moveToNext());

        }

        return listSoal;
    }

    public List<Quiz> getAllKapasitor() {

        List<Quiz> listSoal = new ArrayList<Quiz>();

        Cursor cursor = db.query(TABLE_SOAL_KAPASITOR,new String[]{

                COL_SOAL_ID,
                COL_SOAL_SOAL,
                COL_SOAL_JAWABAN_A,
                COL_SOAL_JAWABAN_B,
                COL_SOAL_JAWABAN_C,
                COL_SOAL_JAWABAN_D,
                COL_SOAL_JAWABAN_E,
                COL_SOAL_JAWABAN_BENAR,
                COL_SOAL_GAMBAR
        },null,null,null,null,null);//kenapa ada 5 null ya ?

        if (cursor.moveToFirst()){


            do {
                Quiz quiz = new Quiz();

                quiz.setId(cursor.getInt(cursor.getColumnIndexOrThrow(COL_SOAL_ID)));
                quiz.setSoal(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_SOAL)));
                quiz.setJawaban_a(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_JAWABAN_A)));
                quiz.setJawaban_b(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_JAWABAN_B)));
                quiz.setJawaban_c(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_JAWABAN_C)));
                quiz.setJawaban_d(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_JAWABAN_D)));
                quiz.setJawaban_e(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_JAWABAN_E)));
                quiz.setJawaban_benar(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_JAWABAN_BENAR)));
                quiz.setGambar(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_GAMBAR)));

                listSoal.add(quiz);



            }while (cursor.moveToNext());

        }

        return listSoal;
    }

    public List<User> getAllUser() {

        List<User> listUser = new ArrayList<User>();

        Cursor cursor = db.query(TABLE_USER,new String[]{

                COL_USER_ID,
                COL_USER_USERNAME,
                COL_USER_PASSWORD,
                COL_USER_NAMA

        },null,null,null,null,null);//kenapa ada 5 null ya ?

        if (cursor.moveToFirst()){


            do {
                User user = new User();

                user.setId(cursor.getInt(cursor.getColumnIndexOrThrow(COL_USER_ID)));
                user.setUsername(cursor.getString(cursor.getColumnIndexOrThrow(COL_USER_USERNAME)));
                user.setPassword(cursor.getString(cursor.getColumnIndexOrThrow(COL_USER_PASSWORD)));
                user.setNama(cursor.getString(cursor.getColumnIndexOrThrow(COL_USER_NAMA)));


                listUser.add(user);



            }while (cursor.moveToNext());

        }

        return listUser;
    }

    public List<HistoryNilai> getAllHistory() {

        List<HistoryNilai> listHistory = new ArrayList<HistoryNilai>();

        Cursor cursor = db.query(TABLE_HISTORY,new String[]{

                COL_HISTORY_ID,
                COL_HISTORY_NILAI,
                COL_HISTORY_IDUSER,
                COL_HISTORY_NAMA_MATERI,
                COL_HISTORY_TANGGAL

        },null,null,null,null,null);//kenapa ada 5 null ya ?

        if (cursor.moveToFirst()){


            do {
                HistoryNilai historyNilai = new HistoryNilai();
                int idUser = cursor.getInt(cursor.getColumnIndexOrThrow(COL_HISTORY_IDUSER));

                if (idUser == SharedVariable.userID){
                    historyNilai.setId(cursor.getInt(cursor.getColumnIndexOrThrow(COL_HISTORY_ID)));
                    historyNilai.setNilai(cursor.getInt(cursor.getColumnIndexOrThrow(COL_HISTORY_NILAI)));
                    historyNilai.setIdUser(cursor.getInt(cursor.getColumnIndexOrThrow(COL_HISTORY_IDUSER)));
                    historyNilai.setNamaMateri(cursor.getString(cursor.getColumnIndexOrThrow(COL_HISTORY_NAMA_MATERI)));
                    historyNilai.setTanggal(cursor.getString(cursor.getColumnIndexOrThrow(COL_HISTORY_TANGGAL)));

                    listHistory.add(historyNilai);
                }



            }while (cursor.moveToNext());

        }

        return listHistory;
    }


}
