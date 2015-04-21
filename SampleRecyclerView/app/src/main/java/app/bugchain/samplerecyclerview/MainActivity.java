package app.bugchain.samplerecyclerview;

import android.content.Context;
import android.content.Intent;
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


public class MainActivity extends ActionBarActivity {

    private RecyclerView recyclerView;

    private MarginDecoration marginDecoration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_layout);


        ItemClass[] itemClass = {
                new ItemClass(this,LinearLayoutVertical.class,"Linear layout (Vertical)"),
                new ItemClass(this,LinearLayoutHorizontal.class,"Linear layout (Horizontal)"),
                new ItemClass(this,LinearLayoutVertical.class,"Linear layout (Vertical)")
        };

        marginDecoration = new MarginDecoration(this);
        marginDecoration.setItemMargin(0,0,0,1);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(marginDecoration);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ItemAdapter(itemClass));

    }

    class ItemAdapter extends RecyclerView.Adapter<ViewHolder>{

        private ItemClass[] items;

        public ItemAdapter(ItemClass[] items){
            this.items = items;
        }
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int position) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_item,parent,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder,final int position) {
            holder.textItem.setText(items[position].title);
            holder.textItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = holder.textItem.getContext();
                    context.startActivity(new Intent(context,items[position].activityClass));
                }
            });
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

    public static class ItemClass{

        public final Class<?> activityClass;
        public final String title;

        public ItemClass(Context context,Class<?> activityClass,String title){
            this.activityClass = activityClass;
            this.title = title;
        }
    }
}
