package com.ray.layerlayout.pages.main;

import android.app.Activity;
import android.content.Intent;

/**
 * @author      : leixing
 * @date        : 2017-04-14
 * Email       : leixing1012@gmail.cn
 * Version     : 0.0.1
 * <p>
 * Description : xxx
 */

@SuppressWarnings({"unused", "WeakerAccess"})
public class Function {
    private String name;
    private Class<? extends Activity> page;

    Function(String name, Class<? extends Activity> page) {
        this.name = name;
        this.page = page;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class<? extends Activity> getPage() {
        return page;
    }

    public void setPage(Class<? extends Activity> page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "Function{" +
                "name='" + name + '\'' +
                ", page=" + page +
                '}';
    }

    @SuppressWarnings("WeakerAccess")
    public void exec(final Activity activity) {
        Intent intent = new Intent();
        intent.setClass(activity, page);
        activity.startActivity(intent);
    }
}
