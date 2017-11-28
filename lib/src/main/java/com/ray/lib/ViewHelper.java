package com.ray.lib;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/**
 * Author      : leixing
 * Date        : 2017-11-28
 * Email       : leixing@hecom.cn
 * Version     : 0.0.1
 * <p>
 * Description : xxx
 */

public class ViewHelper {
    private ViewHelper() {
        throw new UnsupportedOperationException();
    }

    public static void addView(View view, ViewGroup container) {
        ViewParent parent = view.getParent();
        if (parent == null) {
            container.addView(view);
        } else if (parent != container) {
            throw new IllegalArgumentException("this view has parent");
        }
    }

    public static View addView(Context context, int layoutId, ViewGroup container) {
        View view = LayoutInflater.from(context).inflate(layoutId, container, false);
        container.addView(view);
        return view;
    }
}
