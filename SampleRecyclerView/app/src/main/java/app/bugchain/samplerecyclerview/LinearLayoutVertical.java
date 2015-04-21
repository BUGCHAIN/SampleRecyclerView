package app.bugchain.samplerecyclerview;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class LinearLayoutVertical extends ActionBarActivity {

    private String[] items = new String[50];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_layout);

        for(int i=0;i<items.length;i++){
            items[i] = "Item " + (i+1);
        }

        MarginDecoration marginDecoration = new MarginDecoration(this);
        marginDecoration.setItemMargin(0, 0, 0, 1);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(marginDecoration);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new ItemAdapter());

    }

    class ItemAdapter extends RecyclerView.Adapter<ViewHolder>{

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int position) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_item,parent,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
                holder.textItem.setText(items[position]);
        }

        @Override
        public int getItemCount() {
            return items.length;
        }
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textItem;

        public ViewHolder(View itemView) {
            super(itemView);
            textItem = (TextView)itemView.findViewById(R.id.textItem);
        }
    }
}
