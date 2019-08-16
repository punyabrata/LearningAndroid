package com.learner.learndroid.view.main;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;

public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
    private int spanCount;
    private int spacing;

    public GridSpacingItemDecoration(int spanCount, int spacing) {
        this.spanCount = spanCount;
        this.spacing = spacing;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view);
        int spanIndex = ((StaggeredGridLayoutManager.LayoutParams) (view.getLayoutParams())).getSpanIndex();
        
        if (spanIndex == 0) {
            outRect.left = spacing;
        }
        outRect.right = spacing;

        if (position < spanCount) {
            outRect.top = spacing;
        }
        outRect.bottom = spacing;
    }
}
