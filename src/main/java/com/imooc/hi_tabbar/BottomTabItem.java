package com.imooc.hi_tabbar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

/**
 * 底部导航菜单Item 封装
 */
public abstract class BottomTabItem {

    private Builder mBuilder;
    public BottomTabItem(Builder builder) {
        mBuilder = builder;
        createTabBottom();
    }

    private void createTabBottom() {
        // 绑定参数
        attachNavigationParams();
    }
    /**
     * 绑定参数
     */
    public void attachNavigationParams() {
        // 设置文本
        Map<Integer,CharSequence> textMaps = mBuilder.mTextMaps;
        for (Map.Entry<Integer, CharSequence> entry : textMaps.entrySet()) {
            TextView textView = findViewById(entry.getKey());
            textView.setTextSize(16);
            textView.setText(entry.getValue());
        }
        // 设置点击事件
        Map<Integer,Integer> icons = mBuilder.mIcons;
        for (Map.Entry<Integer, Integer> entry : icons.entrySet()) {
            ImageView imageView = findViewById(entry.getKey());
            imageView.setImageResource(entry.getValue());
        }
    }
    protected View getTabView(){
        if (mBuilder.mTabItemView==null){
            mBuilder.mTabItemView = LayoutInflater.from(mBuilder.mContext)
                    .inflate(mBuilder.mLayoutId,null);
        }
        return mBuilder.mTabItemView;
    }

    /**
     * 查找view
     * @param viewId
     * @param <T>
     * @return
     */
    protected <T> T findViewById(int viewId){
        return (T) mBuilder.mTabItemView.findViewById(viewId);
    }
    /**
     * 是否选中
     * @param selected
     */
    protected abstract void setSelected(boolean selected);

    protected abstract static class Builder{
        private Context mContext;
        // BottomItem View
        private View mTabItemView;
        // 布局
        private int mLayoutId;

        // 设置底部菜单栏名称集合
        public Map<Integer,CharSequence> mTextMaps;
        // 设置底部菜单栏按钮图标集合
        public Map<Integer,Integer> mIcons;

        public Builder(Context context, int layoutId) {
            this.mContext = context;
            this.mTabItemView = LayoutInflater.from(context).inflate(layoutId,null);
            this.mLayoutId = layoutId;

            mTextMaps = new HashMap<>();
            mIcons = new HashMap<>();
        }

        /**
         * 设置名称
         * @param viewId
         * @param text
         * @return
         */
        public Builder setText(int viewId,String text){
            mTextMaps.put(viewId,text);
            return this;
        }
        /**
         * 设置Icon
         * @param viewId
         * @param icon
         * @return
         */
        public Builder setIcon(int viewId,int icon){
            mIcons.put(viewId,icon);
            return this;
        }
        protected abstract BottomTabItem  create();
    }
}
