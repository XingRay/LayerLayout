package com.ray.lib;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Author      : leixing
 * Date        : 2017-11-27
 * Email       : leixing@hecom.cn
 * Version     : 0.0.1
 * <p>
 * Description : xxx
 */

public class SwitchLinearLayout extends LinearLayout {

    private SwitchViewHolder mSwitchViewHolder;

    public SwitchLinearLayout(Context context) {
        this(context, null);
    }

    public SwitchLinearLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SwitchLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
