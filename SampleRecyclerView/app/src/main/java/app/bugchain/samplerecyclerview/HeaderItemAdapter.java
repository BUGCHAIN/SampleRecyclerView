package app.bugchain.samplerecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by POSEIDON on 22/4/2558.
 */
public class HeaderItemAdapter extends RecyclerView.Adapter<HeaderItemAdapter.ViewHolder>{

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    private List<HeaderItem> items;

    public HeaderItemAdapter(List<HeaderItem> items){
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == TYPE_HEADER){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_header,parent,false);
            return new ViewHolder(view,viewType);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_item,parent,false);
        return new ViewHolder(view,viewType);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        HeaderItem headerItem = items.get(position);
        if(headerItem.getIsHeader()){
            holder.header.setText(headerItem.getHeaderName());
            return;
        }
        holder.item.setText(headerItem.getTitle());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        return items.get(position).getIsHeader() ? TYPE_HEADER : TYPE_ITEM;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView header;
        public TextView item;

        public ViewHolder(View itemView,int viewType) {
            super(itemView);
            if(viewType == TYPE_HEADER){
                header = (TextView)itemView.findViewById(R.id.textHeader);
            }else if(viewType == TYPE_ITEM){
                item = (TextView)itemView.findViewById(R.id.textItem);
            }
        }
    }
}
