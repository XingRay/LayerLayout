package com.ray.switch_layout.widget;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.util.AttributeSet;
import android.view.View;

import com.ray.lib.SwitchFrameLayout;
import com.ray.switch_layout.R;

/**
 * Author      : leixing
 * Date        : 2017-11-27
 * Email       : leixing@hecom.cn
 * Version     : 0.0.1
 * <p>
 * Description : xxx
 */

public class StatusSwitchFrameLayout extends SwitchFrameLayout {
    public StatusSwitchFrameLayout(Context context) {
        this(context, null);
    }

    public StatusSwitchFrameLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StatusSwitchFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setStatus(PageStatus.NORMAL);
    }

    public void setStatus(PageStatus status) {
        setCurrentLayerId(status.getLayerId());
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        initNormalLayouts();
        initUnnormalLayouts();
    }

    private void initNormalLayouts() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return;
        }

        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            add(PageStatus.NORMAL, childView);
        }
    }

    private void initUnnormalLayouts() {
        add(PageStatus.EMPTY, R.layout.layout_page_status_empty);
        add(PageStatus.CONNECTION_FAILURE, R.layout.layout_page_status_connection_failure);
    }

    private void add(PageStatus status, View view) {
        add(status.getLayerId(), view);
    }

    private void add(PageStatus status, @LayoutRes int layoutId) {
        add(status.getLayerId(), layoutId);
    }
}
