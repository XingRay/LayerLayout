package com.ray.layerlayout.widget;

import android.content.Context;
import android.util.AttributeSet;

import com.ray.lib.layout.LayerRelativeLayout;
import com.ray.layerlayout.R;

/**
 * @author      : leixing
 * @date        : 2017-11-27
 * Email       : leixing1012@qq.com
 * Version     : 0.0.1
 * <p>
 * Description : xxx
 */

public class StatusLayerRelativeLayout extends LayerRelativeLayout {
    public StatusLayerRelativeLayout(Context context) {
        this(context, null);
    }

    public StatusLayerRelativeLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StatusLayerRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        add(1, R.layout.layout_page_layer_1);
        add(2, R.layout.layout_page_layer_2);
    }
}
