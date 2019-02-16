package Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import myproject.pfuinreal.R;


/**
 * Created by Glory on 03/10/2016.
 */
public class RecycleAdapterInduksi2 extends RecyclerView.Adapter<RecycleViewHolderGelCahaya> {


    LayoutInflater inflater;
    Context context;
    Intent i;
    String[] namaAlat ={"Multimeter Digital","Kumparan 500 Lilitan ","Kumparan 1000 Lilitan ","Inti I",
            "Multimedia Digital ","Kabel Penghubung"};
    String[] kodeAlat ={"KAL 60/50 A","PEF 356","PEF 357 ","PEF 331 02","GME 240","KAL 99"};
    String[] jmlAlat ={"1","1","1","1","2","2","4"};

    int[] gambarAlat = {R.drawable.multimeter_digital,R.drawable.kumparan500,R.drawable.kumparan1000,R.drawable.report
            ,R.drawable.report, R.drawable.kabelpenghubung,};


    public RecycleAdapterInduksi2(final Context context) {

        this.context = context;
        inflater = LayoutInflater.from(context);


    }




    @Override
    public RecycleViewHolderGelCahaya onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist_percoban_gel_cahaya, parent, false);
        //View v = inflater.inflate(R.layout.item_list,parent,false);
        RecycleViewHolderGelCahaya viewHolderChat = new RecycleViewHolderGelCahaya(view);
        return viewHolderChat;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(RecycleViewHolderGelCahaya holder, final int position) {

        Resources res = context.getResources();


        holder.txtKodeAlat.setText(kodeAlat[position]);
        holder.txtNamaAlat.setText(namaAlat[position]);
        holder.txtJml.setText(jmlAlat[position]+" Unit");
        holder.imgIcon.setImageResource(gambarAlat[position]);


        holder.cardlist_item.setOnClickListener(clicklistener);

        holder.cardlist_item.setTag(holder);
        holder.txtJml.setTag(holder);
        holder.txtNamaAlat.setTag(holder);
        holder.txtKodeAlat.setTag(holder);
        holder.imgIcon.setTag(holder);


    }

    View.OnClickListener clicklistener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            RecycleViewHolderGelCahaya vHolder = (RecycleViewHolderGelCahaya) v.getTag();
            int position = vHolder.getPosition();

            LayoutInflater minlfater = LayoutInflater.from(context);
            View v2 = minlfater.inflate(R.layout.dialog_detail_gambar, null);
            final android.app.AlertDialog dialog = new android.app.AlertDialog.Builder(context).create();
            dialog.setView(v2);

            final ImageView imgDetail=  v2.findViewById(R.id.imgDetail);
            imgDetail.setImageResource(gambarAlat[position]);

            dialog.show();


        }
    };



    public int getItemCount() {

       return namaAlat.length;
       //return 1;

    }



}
