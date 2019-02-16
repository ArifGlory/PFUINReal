package myproject.pfuinreal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import Adapter.RecycleAdapterHistory;

public class HistoryActivity extends AppCompatActivity {

    RecyclerView recyclerHistory;
    RecycleAdapterHistory adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        recyclerHistory = findViewById(R.id.recyclerHistory);
        adapter = new RecycleAdapterHistory(this);
        recyclerHistory.setAdapter(adapter);
        recyclerHistory.setLayoutManager(new LinearLayoutManager(this));
    }
}
