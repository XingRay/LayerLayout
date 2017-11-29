package com.ray.layer_layout.widget;

import android.content.Context;
import android.util.AttributeSet;

import com.ray.lib.layout.LayerLinearLayout;
import com.ray.layer_layout.R;

/**
 * Author      : leixing
 * Date        : 2017-11-27
 * Email       : leixing@hecom.cn
 * Version     : 0.0.1
 * <p>
 * Description : xxx
 */

public class StatusLayerLinearLayout extends LayerLinearLayout {
    public StatusLayerLinearLayout(Context context) {
        this(context, null);
    }

    public StatusLayerLinearLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StatusLayerLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        add(1, R.layout.layout_page_layer_1);
        add(2, R.layout.layout_page_layer_2);
    }
}
