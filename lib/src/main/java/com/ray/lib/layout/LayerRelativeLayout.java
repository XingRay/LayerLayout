package com.ray.lib.layout;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.ray.lib.LayerLayout;
import com.ray.lib.ViewHelper;
import com.ray.lib.ViewManager;

/**
 * Author      : leixing
 * Date        : 2017-11-27
 * Email       : leixing@hecom.cn
 * Version     : 0.0.1
 * <p>
 * Description : xxx
 */

public class LayerRelativeLayout extends RelativeLayout implements LayerLayout {

    public static final int DEFAULT_LAYER_ID = 0;

    private ViewManager mViewManager;
    private Context mContext;
    private boolean mAutoRegister;

    public LayerRelativeLayout(Context context) {
        this(context, null);
    }

    public LayerRelativeLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LayerRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mViewManager = new ViewManager();
        mContext = context;
        mAutoRegister = true;
    }

    public void add(int layerId, @LayoutRes int layoutId) {
        View view = ViewHelper.addView(mContext, layoutId, this);
        mViewManager.register(layerId, view);
    }

    public void add(int layerId, View view) {
        ViewHelper.addView(view, this);
        mViewManager.register(layerId, view);
    }

    public void setCurrentLayerId(int layerId) {
        mViewManager.setCurrentLayerId(layerId);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (mAutoRegister) {
            autoRegister();
        }
    }

    private void autoRegister() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return;
        }

        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            if (mViewManager.isRegistered(childView)) {
                continue;
            }
            mViewManager.register(DEFAULT_LAYER_ID, childView);
        }
    }
}
