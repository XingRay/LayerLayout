package com.ray.lib.layout;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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

    public LayerFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    public LayerFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LayerFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mDelegate = new LayerLayoutDelegate(context, this, new ViewManager(), true);
    }

    public void add(int layerId, @LayoutRes int layoutId) {
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
