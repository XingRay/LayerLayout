package com.ray.lib;

import android.view.View;

/**
 * Author      : leixing
 * Date        : 2017-11-28
 * Email       : leixing@hecom.cn
 * Version     : 0.0.1
 * <p>
 * Description : xxx
 */

public interface LayerLayout {
    void add(int layerId, int layoutId);

    void add(int layerId, View view);

    void setCurrentLayerId(int layerId);
}
