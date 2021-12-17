# HiBottomNavifationBar

#### 介绍
通用BottomNavigationBar 

#### 软件架构
使用Builder构建者模式构建底部菜单项

使用迭代器封装底部菜单项的属性



#### 使用说明

1.  布局

```
 <com.imooc.hi_tabbar.TabBottomNavigation
        android:id="@+id/tabBottom"
        android:layout_width="match_parent"
        android:layout_height="60dp"
        />
```

2.  添加菜单项

```
 List<BottomTabItem> items = new ArrayList<>();
 items.add(new MainBottomTabItem.Builder(this).name("首页").icon(R.drawable.main_tab_item).create());
 items.add(new MainBottomTabItem.Builder(this).name("发现").icon(R.drawable.find_tab_item).create());
 items.add(new MainBottomTabItem.Builder(this).name("新鲜").icon(R.drawable.refresh_tab_item).create());
 items.add(new MainBottomTabItem.Builder(this).name("消息").icon(R.drawable.msg_tab_item).create());

 tabBottomNavigation.addTabItem(items);
```

3.  事件监听

```
   tabBottomNavigation.setOnItemClickListener(new TabBottomNavigation.OnItemClickListener() {
       @Override
       public void onItemClick(int position) {
           Toast.makeText(TabBottomActivity.this,"点击了:"+position,Toast.LENGTH_SHORT).show();
       }
   });
```
