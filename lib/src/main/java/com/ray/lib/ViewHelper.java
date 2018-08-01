package com.ray.lib;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : leixing
 * @date : 2017-11-28
 * Email       : leixing1012@qq.com
 * Version     : 0.0.1
 * <p>
 * Description : xxx
 */

class ViewHelper {
    private ViewHelper() {
        throw new UnsupportedOperationException();
    }

    static void inflate(View view, ViewGroup container) {
        ViewParent parent = view.getParent();
        if (parent == null) {
            container.addView(view);
        } else if (parent != container) {
            throw new IllegalArgumentException("this view has parent");
        }
    }

    static List<View> inflate(Context context, int layoutId, ViewGroup container) {
        List<View> before = getChildren(container);
        LayoutInflater.from(context).inflate(layoutId, container, true);
        List<View> after = getChildren(container);
        after.removeAll(before);
        return after;
    }

    private static List<View> getChildren(ViewGroup container) {
        List<View> views = new ArrayList<>();
        for (int i = 0, size = container.getChildCount(); i < size; i++) {
            views.add(container.getChildAt(i));
        }
        return views;
    }
}
