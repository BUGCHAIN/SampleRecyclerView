package app.bugchain.samplerecyclerview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class GridHeader extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_layout);

        final List<HeaderItem> items = new HeaderItem().getItems();

        MarginDecoration marginDecoration = new MarginDecoration(this);
        marginDecoration.setItemMargin(1, 0, 0, 1);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        GridLayoutManager manager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(marginDecoration);

        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new HeaderItemAdapter(items));

        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return items.get(position).getIsHeader() ? 2:1;
            }
        });

    }

}
