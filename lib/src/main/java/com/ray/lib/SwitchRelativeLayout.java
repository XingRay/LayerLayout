package com.ray.lib;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Author      : leixing
 * Date        : 2017-11-27
 * Email       : leixing@hecom.cn
 * Version     : 0.0.1
 * <p>
 * Description : xxx
 */

public class SwitchRelativeLayout extends RelativeLayout {

    private SwitchViewHolder mSwitchViewHolder;

    public SwitchRelativeLayout(Context context) {
        this(context, null);
    }

    public SwitchRelativeLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SwitchRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mSwitchViewHolder = new SwitchViewHolder(context);
    }

    public void add(int layerId, @LayoutRes int layoutId) {
        mSwitchViewHolder.add(layerId, layoutId, this);
    }

    public void add(int layerId, View view) {
        mSwitchViewHolder.add(layerId, view, this);
    }

    public void setCurrentLayerId(int layerId) {
        mSwitchViewHolder.setCurrentLayerId(layerId);
    }
}
