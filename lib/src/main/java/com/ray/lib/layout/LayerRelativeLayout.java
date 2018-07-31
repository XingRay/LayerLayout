package com.ray.lib.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.ray.lib.LayerLayout;
import com.ray.lib.LayerLayoutDelegate;
import com.ray.lib.ViewManager;

/**
 * @author      : leixing
 * @date        : 2017-11-27
 * Email       : leixing1012@qq.com
 * Version     : 0.0.1
 * <p>
 * Description : 分层相对布局
 */

public class LayerRelativeLayout extends RelativeLayout implements LayerLayout {

    public static final int DEFAULT_LAYER_ID = 0;

    private LayerLayoutDelegate mDelegate;

    public LayerRelativeLayout(Context context) {
        this(context, null);
    }

    public LayerRelativeLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LayerRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
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
    public void remove(int layerId) {
        mDelegate.remove(layerId);
    }

    @Override
    public void setLayer(int layerId) {
        mDelegate.setLayer(layerId);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mDelegate.onFinishInflate();
    }
}
