package com.ray.layerlayout.pages.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ray.layerlayout.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author      : leixing
 * @date        : 2017-11-27
 * Email       : leixing1012@qq.com
 * Version     : 0.0.1
 * <p>
 * Description : xxx
 */

public class FunctionAdapter extends RecyclerView.Adapter<FunctionAdapter.FunctionViewHolder> {

    private final List<Function> mFunctions;
    private final LayoutInflater mInflater;
    private ItemClickListener<Function> mItemClickListener;

    FunctionAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        mFunctions = new ArrayList<>();
    }

    void set(List<Function> functions) {
        mFunctions.clear();
        if (functions != null) {
            mFunctions.addAll(functions);
        }
        notifyDataSetChanged();
    }

    @Override
    public FunctionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.view_function_list_item, parent, false);
        return new FunctionViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final FunctionViewHolder holder, int position) {
        final Function function = mFunctions.get(position);
        holder.btButton.setText(function.getName());
        holder.btButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mItemClickListener != null) {
                    mItemClickListener.onItemClick(function, holder.getAdapterPosition());
                }
            }
        });
    }

    void setItemClickListener(ItemClickListener<Function> listener) {
        mItemClickListener = listener;
    }

    @Override
    public int getItemCount() {
        return mFunctions.size();
    }

    static class FunctionViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.bt_button)
        Button btButton;

        FunctionViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
