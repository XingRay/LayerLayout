package com.ray.switch_layout.pages.main;

import com.ray.switch_layout.pages.single.LayerFrameLayoutActivity;
import com.ray.switch_layout.pages.single.LayerLinearLayoutActivity;
import com.ray.switch_layout.pages.single.LayerRelativeLayoutActivity;

/**
 * Author      : leixing
 * Date        : 2017-11-27
 * Email       : leixing@hecom.cn
 * Version     : 0.0.1
 * <p>
 * Description : xxx
 */

class Functions {
    static final Function[] sFunctions = new Function[]{
            new Function("SwitchFrameLayout", LayerFrameLayoutActivity.class),
            new Function("SwitchLinearLayout", LayerLinearLayoutActivity.class),
            new Function("SwitchRelativeLayout", LayerRelativeLayoutActivity.class)
    };
}
