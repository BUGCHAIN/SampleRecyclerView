package app.bugchain.samplerecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by POSEIDON on 22/4/2558.
 */
public class TextHeaderHolder extends RecyclerView.ViewHolder {

    public TextView header;

    public TextHeaderHolder(View itemView) {
        super(itemView);
        header = (TextView)itemView.findViewById(R.id.textHeader);
    }
}
