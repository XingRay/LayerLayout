package com.ray.lib;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/**
 * @author      : leixing
 * @date        : 2017-11-28
 * Email       : leixing1012@qq.com
 * Version     : 0.0.1
 * <p>
 * Description : xxx
 */

class ViewHelper {
    private ViewHelper() {
        throw new UnsupportedOperationException();
    }

    static void addView(View view, ViewGroup container) {
        ViewParent parent = view.getParent();
        if (parent == null) {
            container.addView(view);
        } else if (parent != container) {
            throw new IllegalArgumentException("this view has parent");
        }
    }

    static View addView(Context context, int layoutId, ViewGroup container) {
        View view = LayoutInflater.from(context).inflate(layoutId, container, false);
        container.addView(view);
        return view;
    }
}
