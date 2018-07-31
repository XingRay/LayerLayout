package com.ray.layerlayout.pages.single;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.ray.layerlayout.R;
import com.ray.lib.LayerLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author      : leixing
 * @date        : 2017-11-27
 * Email       : leixing1012@qq.com
 * Version     : 0.0.1
 * <p>
 * Description : xxx
 */

public class LayerFrameLayoutActivity extends Activity {
    @BindView(R.id.slfl_status)
    LayerLayout slflStatus;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initVariables();
        initView();
        loadData();
    }

    private void initVariables() {

    }

    @SuppressLint("SetTextI18n")
    private void initView() {
        setContentView(R.layout.activity_switch_frame_layout);
        ButterKnife.bind(this);

        slflStatus.add(3, R.layout.layout_page_layer_3);
        TextView textView = new TextView(this);
        textView.setText("layer 4");
        slflStatus.add(4, textView);
    }

    private void loadData() {

    }

    @OnClick({R.id.bt_0, R.id.bt_1, R.id.bt_2, R.id.bt_3, R.id.bt_4})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_0:
                switchTo(0);
                break;
            case R.id.bt_1:
                switchTo(1);
                break;
            case R.id.bt_2:
                switchTo(2);
                break;
            case R.id.bt_3:
                switchTo(3);
                break;

            case R.id.bt_4:
                switchTo(4);
                break;

            default:
        }
    }

    private void switchTo(int layerId) {
        slflStatus.setLayer(layerId);
    }
}
