package Adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import myproject.pfuinreal.R;

/**
 * Created by Glory on 03/10/2016.
 */
public class RecycleViewHolderHistory extends RecyclerView.ViewHolder {

    public TextView txtMateri,txtNilai,txtTanggal;
    public CardView cardlist_item;


    public RecycleViewHolderHistory(View itemView) {
        super(itemView);

        txtMateri = (TextView) itemView.findViewById(R.id.txtMateri);
        txtNilai = (TextView) itemView.findViewById(R.id.txtNilai);
        txtTanggal = (TextView) itemView.findViewById(R.id.txtTanggal);
        cardlist_item = (CardView) itemView.findViewById(R.id.cardlist_item);


    }
}
