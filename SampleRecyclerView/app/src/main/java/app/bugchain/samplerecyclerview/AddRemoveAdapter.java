package app.bugchain.samplerecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by POSEIDON on 22/4/2558.
 */
public class AddRemoveAdapter  extends RecyclerView.Adapter<TextItemHolder>{

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_ADD = 1;

    private List<String> items;

    public AddRemoveAdapter(int count){
        items = new ArrayList<String>(count);
        for (int i=0;i<count;++i){
            items.add(String.valueOf(i));
        }
    }

    @Override
    public TextItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(
               viewType == TYPE_ADD ?R.layout.text_add_item : R.layout.text_item,parent,false);

        return new TextItemHolder(view);
    }

    @Override
    public void onBindViewHolder(final TextItemHolder holder, final int position) {

        if(position == items.size()){
            holder.item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addItem();
                }
            });
            return;
        }
        final String text = "Item " + items.get(position);
        holder.item.setText(text);
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeItem(holder.getPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size()+1;
    }

    private void addItem(){
        if(items.size()>0){
            int lastItem = Integer.valueOf(items.get(items.size()-1));
            items.add(String.valueOf(lastItem + 1));
            notifyItemInserted(items.size()-1);
        }else{
            items.add(String.valueOf(0));
            notifyItemInserted(0);
        }

    }

    private void removeItem(int position){
        items.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public int getItemViewType(int position) {
        return position == items.size() ? TYPE_ADD:TYPE_ITEM;
    }
}

