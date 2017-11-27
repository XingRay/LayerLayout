package com.ray.lib;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;


/**
 * Author      : leixing
 * Date        : 2017-07-09
 * Email       : leixing@hecom.cn
 * Version     : 0.0.1
 * <p>
 * Description : xxx
 */

public class SwitchFrameLayout extends FrameLayout {

    private LayoutInflater mInflater;
    private SwitchViewHolder mSwitchViewHolder;
    private Context mContext;

    public SwitchFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    public SwitchFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SwitchFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
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
