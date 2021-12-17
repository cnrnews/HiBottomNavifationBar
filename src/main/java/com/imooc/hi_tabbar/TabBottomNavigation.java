package com.imooc.hi_tabbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

/**
 * 底部导航栏封装
 */
public class TabBottomNavigation extends LinearLayout {

    private List<BottomTabItem> mTabItems;
    private int mCurrentIndex = 0;
    public TabBottomNavigation(Context context) {
        this(context,null);
    }

    public TabBottomNavigation(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TabBottomNavigation(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(HORIZONTAL);

        mTabItems = new ArrayList<>();
    }

    /**
     * 添加条目
     * @param items
     */
    public void addTabItem(List<BottomTabItem> items){
        mTabItems.clear();
        mTabItems.addAll(items);

        for (int i=0;i<items.size();i++) {

            BottomTabItem item = items.get(i);
            View tabView = item.getTabView();
            addView(tabView);

            LayoutParams layoutParams = (LayoutParams) tabView.getLayoutParams();
            layoutParams.weight = 1;
            layoutParams.gravity = Gravity.CENTER;
            tabView.setLayoutParams(layoutParams);

            // 设置点击事件
            setItemClickListener(tabView,i);

        }

        // 默认第一个选中
        mTabItems.get(0).setSelected(true);
    }

    private void setItemClickListener(View tabView, final int position) {
        tabView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCurrentIndex != position){
                    mTabItems.get(mCurrentIndex).setSelected(false);
                    mCurrentIndex = position;
                    mTabItems.get(mCurrentIndex).setSelected(true);

                    // 通知外部点击了哪个Item
                    if (mOnItemClickListener!=null){
                        mOnItemClickListener.onItemClick(position);
                    }
                }
            }
        });
    }

    private OnItemClickListener mOnItemClickListener;

    /**
     * 设置点击事件监听
     * @param listener
     */
    public void  setOnItemClickListener(OnItemClickListener listener){
        mOnItemClickListener = listener;
    }
    public static interface OnItemClickListener{
        void onItemClick(int position);
    }

}
