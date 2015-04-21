package app.bugchain.samplerecyclerview;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by POSEIDON on 21/4/2558.
 */
public class MarginDecoration extends RecyclerView.ItemDecoration {

    private int left = 0,top = 0,right = 0,bottom = 0;

    public MarginDecoration(Context context){

    }

    public void setItemMargin(int left,int top,int right,int bottom){
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.set(left,top,right,bottom);
    }
}
