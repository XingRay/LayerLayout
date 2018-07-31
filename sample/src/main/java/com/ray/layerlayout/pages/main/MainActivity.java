package com.ray.layerlayout.pages.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ray.layerlayout.R;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 主界面
 *
 * @author leixing
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_list)
    RecyclerView rvList;
    private FunctionAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initVariables();
        initView();
        loadData();
    }

    private void initVariables() {
        mAdapter = new FunctionAdapter(this);
    }

    private void initView() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        rvList.setLayoutManager(new LinearLayoutManager(this));
        rvList.setAdapter(mAdapter);

        mAdapter.setItemClickListener(new ItemClickListener<Function>() {
            @Override
            public void onItemClick(Function function, int position) {
                gotoFunctionPage(function);
            }
        });
    }

    private void gotoFunctionPage(Function function) {
        function.exec(this);
    }

    private void loadData() {
        mAdapter.set(Arrays.asList(Functions.FUNCTIONS));
    }
}
