package com.ray.lib.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.ray.lib.LayerLayout;
import com.ray.lib.LayerLayoutDelegate;
import com.ray.lib.ViewManager;

/**
 * Author      : leixing
 * Date        : 2017-11-27
 * Email       : leixing@hecom.cn
 * Version     : 0.0.1
 * <p>
 * Description : xxx
 */

public class LayerLinearLayout extends LinearLayout implements LayerLayout {

    private LayerLayoutDelegate mDelegate;

    public LayerLinearLayout(Context context) {
        this(context, null);
    }

    public LayerLinearLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LayerLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mDelegate = new LayerLayoutDelegate(context, this, new ViewManager(), true);
    }

    @Override
    public void add(int layerId, int layoutId) {
        mDelegate.add(layerId, layoutId);
    }

    @Override
    public void add(int layerId, View view) {
        mDelegate.add(layerId, view);
    }

    @Override
    public void setCurrentLayerId(int layerId) {
        mDelegate.setCurrentLayerId(layerId);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mDelegate.onFinishInflate();
    }
}
