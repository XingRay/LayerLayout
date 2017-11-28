package com.ray.lib;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.view.ViewGroup;

/**
 * Author      : leixing
 * Date        : 2017-11-28
 * Email       : leixing@hecom.cn
 * Version     : 0.0.1
 * <p>
 * Description : xxx
 */

@SuppressWarnings("WeakerAccess")
public class LayerLayoutDelegate {
    public static final int DEFAULT_LAYER_ID = 0;

    private final Context mContext;
    private final ViewGroup mContainer;
    private final ViewManager mViewManager;
    private final boolean mAutoRegister;

    public LayerLayoutDelegate(Context context, ViewGroup container, ViewManager viewManager, boolean autoRegister) {
        mContext = context;
        mContainer = container;
        mViewManager = viewManager;
        mAutoRegister = autoRegister;
    }

    public void add(int layerId, @LayoutRes int layoutId) {
        View view = ViewHelper.addView(mContext, layoutId, mContainer);
        mViewManager.register(layerId, view);
    }

    public void add(int layerId, View view) {
        ViewHelper.addView(view, mContainer);
        mViewManager.register(layerId, view);
    }

    public void setCurrentLayerId(int layerId) {
        mViewManager.setCurrentLayerId(layerId);
    }

    public void onFinishInflate() {
        if (mAutoRegister) {
            autoRegister();
        }
    }

    private void autoRegister() {
        int childCount = mContainer.getChildCount();
        if (childCount == 0) {
            return;
        }

        for (int i = 0; i < childCount; i++) {
            View childView = mContainer.getChildAt(i);
            if (mViewManager.isRegistered(childView)) {
                continue;
            }
            mViewManager.register(DEFAULT_LAYER_ID, childView);
        }
    }
}
