package app.bugchain.samplerecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by POSEIDON on 22/4/2558.
 */
public class TextItemHolder extends RecyclerView.ViewHolder {

    public TextView item;

    public TextItemHolder(View itemView) {
        super(itemView);
        item = (TextView)itemView.findViewById(R.id.textItem);
    }
}
