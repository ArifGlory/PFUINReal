package Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import myproject.pfuinreal.DBAdapter;
import myproject.pfuinreal.HistoryNilai;
import myproject.pfuinreal.Quiz;
import myproject.pfuinreal.R;


/**
 * Created by Glory on 03/10/2016.
 */
public class RecycleAdapterHistory extends RecyclerView.Adapter<RecycleViewHolderHistory> {


    LayoutInflater inflater;
    Context context;
    Intent i;
    public static List<String> listKeyUser = new ArrayList();
    private List<HistoryNilai> mlistHistory;
    DBAdapter mDB;
    private HistoryNilai mHistory;

    public RecycleAdapterHistory(final Context context) {

        this.context = context;
        inflater = LayoutInflater.from(context);
        mDB = DBAdapter.getInstance(context.getApplicationContext());
        mlistHistory = mDB.getAllHistory();
        Collections.reverse(mlistHistory);

    }




    @Override
    public RecycleViewHolderHistory onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist_historynilai, parent, false);
        //View v = inflater.inflate(R.layout.item_list,parent,false);
        RecycleViewHolderHistory viewHolderChat = new RecycleViewHolderHistory(view);
        return viewHolderChat;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(RecycleViewHolderHistory holder, final int position) {

        Resources res = context.getResources();
        mHistory = mlistHistory.get(position);
        String materi = mHistory.getNamaMateri();

        if (materi.equals("gel_cahaya")){
            materi = "Mengukur panjang gelombang cahaya";
        }else if (materi.equals("pembiasan")){
            materi = "Pembiasan pada lensa";
        }else if (materi.equals("induksi1")){
            materi = "Induksi Elektromagnetik 1";
        }else if (materi.equals("induksi2")){
            materi = "Induksi Elektromagnetik 2";
        }else if (materi.equals("medan_magnet")){
            materi = "Medan Magnet disekitar Kawat Lurus";
        }else if (materi.equals("kapasitor")){
            materi = "Kapasitor";
        }


        holder.txtNilai.setText("Nilai = "+String.valueOf(mHistory.getNilai()));
        holder.txtMateri.setText(materi);
        holder.txtTanggal.setText(mHistory.getTanggal());


        holder.cardlist_item.setOnClickListener(clicklistener);


        holder.txtTanggal.setTag(holder);



    }

    View.OnClickListener clicklistener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            RecycleViewHolderHistory vHolder = (RecycleViewHolderHistory) v.getTag();





        }
    };



    public int getItemCount() {

       return mlistHistory == null ? 0 : mlistHistory.size();
       //return 1;

    }



}
