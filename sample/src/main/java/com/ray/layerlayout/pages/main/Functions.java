package com.ray.layerlayout.pages.main;

import com.ray.layerlayout.pages.single.LayerFrameLayoutActivity;
import com.ray.layerlayout.pages.single.LayerLinearLayoutActivity;
import com.ray.layerlayout.pages.single.LayerRelativeLayoutActivity;

/**
 * @author      : leixing
 * @date        : 2017-11-27
 * Email       : leixing1012@qq.com
 * Version     : 0.0.1
 * <p>
 * Description : xxx
 */

class Functions {
    static final Function[] FUNCTIONS = new Function[]{
            new Function("SwitchFrameLayout", LayerFrameLayoutActivity.class),
            new Function("SwitchLinearLayout", LayerLinearLayoutActivity.class),
            new Function("SwitchRelativeLayout", LayerRelativeLayoutActivity.class)
    };
}
