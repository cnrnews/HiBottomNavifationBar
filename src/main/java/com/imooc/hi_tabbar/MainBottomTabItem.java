package com.imooc.hi_tabbar;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * 每一个TabItem
 */
public class MainBottomTabItem extends BottomTabItem {

    public MainBottomTabItem(BottomTabItem.Builder builder) {
        super(builder);
    }

    @Override
    protected void setSelected(boolean selected) {
        ImageView tabIcon  = findViewById(R.id.tab_icon);
        TextView tabText  = findViewById(R.id.tab_name);

        tabIcon.setSelected(selected);
        tabText.setSelected(selected);
    }
    public static class Builder extends BottomTabItem.Builder{
        public Builder(Context context) {
            super(context,R.layout.tab_main_bottom_item);
        }

        public Builder name(String name){
            setText(R.id.tab_name,name);
            return this;
        }
        public Builder icon(int icon){
            setIcon(R.id.tab_icon,icon);
            return this;
        }
        @Override
        public BottomTabItem create() {
            return new MainBottomTabItem(this);
        }
    }

}
