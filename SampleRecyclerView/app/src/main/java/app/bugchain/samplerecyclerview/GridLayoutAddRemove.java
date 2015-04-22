package app.bugchain.samplerecyclerview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class GridLayoutAddRemove extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_layout);

        MarginDecoration marginDecoration = new MarginDecoration(this);
        marginDecoration.setItemMargin(1, 0, 0, 1);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.addItemDecoration(marginDecoration);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new AddRemoveAdapter(10));

    }

}
