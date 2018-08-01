package com.ray.lib;

import android.util.SparseArray;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

/**
 * @author : leixing
 * @date : 2017-11-27
 * Email       : leixing1012@qq.com
 * Version     : 0.0.1
 * <p>
 * Description : xxx
 */

@SuppressWarnings("WeakerAccess")
public class ViewManager {
    private SparseArray<List<View>> mViewLists;
    private int mCurrentLayerId;

    public ViewManager() {
        mViewLists = new SparseArray<>();
    }

    public void removeLayer(int layerId) {
        List<View> views = mViewLists.get(layerId);
        if (views == null) {
            return;
        }
        views.clear();
        mViewLists.remove(layerId);
    }

    public void register(int layerId, List<View> viewList) {
        if (viewList == null) {
            return;
        }

        List<View> views = mViewLists.get(layerId);
        if (views == null) {
            views = new ArrayList<>();
            mViewLists.put(layerId, views);
        }
        views.addAll(viewList);
        for (View view : viewList) {
            view.setVisibility((mCurrentLayerId == layerId) ? VISIBLE : GONE);
        }
    }

    public void register(int layerId, View view) {
        if (view == null) {
            return;
        }

        List<View> views = mViewLists.get(layerId);
        if (views == null) {
            views = new ArrayList<>();
            mViewLists.put(layerId, views);
        }

        views.add(view);
        view.setVisibility((mCurrentLayerId == layerId) ? VISIBLE : GONE);
    }

    @SuppressWarnings("unused")
    public boolean unregister(View view) {
        for (int i = 0, size = mViewLists.size(); i < size; i++) {
            int key = mViewLists.keyAt(i);
            List<View> views = mViewLists.get(key);
            if (views == null) {
                continue;
            }
            if (views.contains(view)) {
                views.remove(view);
                return true;
            }
        }

        return false;
    }

    public void setCurrentLayerId(int layerId) {
        if (mCurrentLayerId == layerId) {
            return;
        }
        updateVisibility(mCurrentLayerId, GONE);
        mCurrentLayerId = layerId;
        updateVisibility(mCurrentLayerId, VISIBLE);
    }

    private void updateVisibility(int layerId, int visibility) {
        List<View> views = mViewLists.get(layerId);
        if (views == null) {
            return;
        }

        for (View view : views) {
            view.setVisibility(visibility);
        }
    }

    public void update() {
        for (int i = 0, size = mViewLists.size(); i < size; i++) {
            int key = mViewLists.keyAt(i);
            List<View> views = mViewLists.get(key);
            if (views == null) {
                continue;
            }

            int visibility = key == mCurrentLayerId ? VISIBLE : GONE;
            for (View view : views) {
                view.setVisibility(visibility);
            }
        }
    }

    public boolean isRegistered(View view) {
        for (int i = 0, size = mViewLists.size(); i < size; i++) {
            int key = mViewLists.keyAt(i);
            List<View> views = mViewLists.get(key);
            if (views == null) {
                continue;
            }
            if (views.contains(view)) {
                return true;
            }
        }
        return false;
    }

    public List<View> getViews(int layerId) {
        return mViewLists.get(layerId);
    }
}
