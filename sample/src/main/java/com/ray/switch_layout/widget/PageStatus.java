package com.ray.switch_layout.widget;

/**
 * Author      : leixing
 * Date        : 2017-11-27
 * Email       : leixing@hecom.cn
 * Version     : 0.0.1
 * <p>
 * Description : xxx
 */

public enum PageStatus {
    NORMAL(0),

    EMPTY(1),

    CONNECTION_FAILURE(2);

    private int layerId;

    PageStatus(int layerId) {
        this.layerId = layerId;
    }

    public int getLayerId() {
        return layerId;
    }
}
