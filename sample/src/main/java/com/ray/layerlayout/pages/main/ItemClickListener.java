package com.ray.layerlayout.pages.main;

/**
 * @author : leixing
 * @date : 2017-11-27
 * Email       : leixing1012@qq.com
 * Version     : 0.0.1
 * <p>
 * Description : 列表项点击监听器
 */

public interface ItemClickListener<T> {

    /**
     * 列表项点击回调
     *
     * @param t        列表项关联的数据
     * @param position 被点击的列表项的位置
     */
    void onItemClick(T t, int position);
}
