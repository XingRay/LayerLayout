package com.ray.lib;

import android.view.View;

/**
 * @author : leixing
 * @date : 2017-11-28
 * Email       : leixing1012@qq.com
 * Version     : 0.0.1
 * <p>
 * Description : 层次布局，用于界面层次切换
 */

public interface LayerLayout {

    /**
     * 默认层次ID
     */
    int DEFAULT_LAYER_ID = 0;

    /**
     * 添加层次布局
     *
     * @param layerId  层次的ID
     * @param layoutId 布局资源文件ID
     */
    void add(int layerId, int layoutId);

    /**
     * 添加层次视图
     *
     * @param layerId 层次的ID
     * @param view    视图
     */
    void add(int layerId, View view);

    /**
     * 根据ID删除层次
     *
     * @param layerId 层次ID
     */
    void remove(int layerId);

    /**
     * 根据ID设置当前有效的层次
     *
     * @param layerId 层次ID
     */
    void setLayer(int layerId);
}
