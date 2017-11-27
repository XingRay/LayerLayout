package com.ray.switch_layout.pages.single;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.ray.switch_layout.R;
import com.ray.switch_layout.widget.PageStatus;
import com.ray.switch_layout.widget.StatusSwitchFrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Author      : leixing
 * Date        : 2017-11-27
 * Email       : leixing@hecom.cn
 * Version     : 0.0.1
 * <p>
 * Description : xxx
 */

public class SwitchFrameLayoutActivity extends Activity {
    @BindView(R.id.ssf_status)
    StatusSwitchFrameLayout ssfStatus;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initVariables();
        initView();
        loadData();
    }

    private void initVariables() {

    }

    private void initView() {
        setContentView(R.layout.activity_switch_frame_layout);
        ButterKnife.bind(this);
    }

    private void loadData() {

    }

    @OnClick({R.id.bt_normal, R.id.bt_empty, R.id.bt_connection_failure})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_normal:
                switchTo(PageStatus.NORMAL);
                break;
            case R.id.bt_empty:
                switchTo(PageStatus.EMPTY);
                break;
            case R.id.bt_connection_failure:
                switchTo(PageStatus.CONNECTION_FAILURE);
                break;
        }
    }

    private void switchTo(PageStatus status) {
        ssfStatus.setStatus(status);
    }
}
