package com.learner.learndroid.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.learner.learndroid.R;

/**
 * Expandable and collapsable text view.
 */
public class ExpandableTextView extends androidx.appcompat.widget.AppCompatTextView implements View.OnClickListener {
    /**
     * Max number of lines when collapsed.
     */
    private static final int MAX_LINES = 2;
    /**
     * Current number of max lines.
     */
    private int currentMaxLines = Integer.MAX_VALUE;

    public ExpandableTextView(Context context) {
        super(context);
        setOnClickListener(this);
    }

    public ExpandableTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setOnClickListener(this);
    }

    public ExpandableTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnClickListener(this);
    }

    /**
     * When text changes.
     *
     * @param text         Text
     * @param start        Start position.
     * @param lengthBefore Length before.
     * @param lengthAfter  Length after.
     */
    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        /* If text longer than MAX_LINES set DrawableBottom - I'm using '...' icon */
        post(new Runnable() {
            public void run() {
                if (getLineCount() > MAX_LINES)
                    setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.baseline_more_horiz_black_18dp);
                else
                    setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);

                setMaxLines(MAX_LINES);
            }
        });
    }

    /**
     * Sets max lines.
     *
     * @param maxLines Max lines.
     */
    @Override
    public void setMaxLines(int maxLines) {
        currentMaxLines = maxLines;
        super.setMaxLines(maxLines);
    }

    /**
     * Gets the max lines.
     * NOTE: Custom method because standard getMaxLines() requires API > 16
     *
     * @return Max lines.
     */
    public int getMyMaxLines() {
        return currentMaxLines;
    }

    /**
     * Text view onClick() call back.
     *
     * @param v Text view.
     */
    @Override
    public void onClick(View v) {
        /* Toggle between expanded collapsed states */
        if (getMyMaxLines() == Integer.MAX_VALUE)
            setMaxLines(MAX_LINES);
        else
            setMaxLines(Integer.MAX_VALUE);
    }

}
