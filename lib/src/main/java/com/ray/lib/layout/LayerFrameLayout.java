package com.ray.lib.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.ray.lib.LayerLayout;
import com.ray.lib.LayerLayoutDelegate;
import com.ray.lib.ViewManager;


/**
 * Author      : leixing
 * Date        : 2017-07-09
 * Email       : leixing@hecom.cn
 * Version     : 0.0.1
 * <p>
 * Description : xxx
 */

public class LayerFrameLayout extends FrameLayout implements LayerLayout {

    private LayerLayoutDelegate mDelegate;

    public LayerFrameLayout(Context context) {
        this(context, null);
    }

    public LayerFrameLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LayerFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mDelegate = new LayerLayoutDelegate(context, this, new ViewManager(), true);
    }

    public void add(int layerId, int layoutId) {
        mDelegate.add(layerId, layoutId);
    }

    public void add(int layerId, View view) {
        mDelegate.add(layerId, view);
    }

    public void setCurrentLayerId(int layerId) {
        mDelegate.setCurrentLayerId(layerId);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mDelegate.onFinishInflate();
    }
}
