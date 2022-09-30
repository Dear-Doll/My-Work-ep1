---
title: 类微信界面ep1

tags: 
  - 安卓
---

## 1\.设计目标
ep1实现的内容比较基础，即通过fragment的切换实现拥有四个底栏可选项的界面切换效果。
![](https://img1.imgtp.com/2022/09/30/6vnkLlks.png)

## 2\.功能说明
主要代码实现的功能基本上都围绕着这个底栏和四个Fragment展开
![](https://img1.imgtp.com/2022/09/30/9XpbWJ2A.png)

**主要功能**：通过点击底部的四个控件，从而实现**底部ImageView变色**（即实现被选中效果），**切换FrameLayout中显示内容**的效果。
_具体功能的实现和解析放入代码解析部分中详解。_

## 3\.代码解析
### 主要文件以及主页布局：
> - 四个Fragment.java用于处理四个Fragment的onCreate事件
> - Fragment_1-4.xml存放四个分页面的布局，由FrameLayout作为其容器
> - buttom.xml放置底栏的控件，top.xml为顶栏，通过include引入到Activity_Main.xml中

![](https://img1.imgtp.com/2022/09/30/FcTE5YWA.png)

### XML文件
#### **activity_main.xml**
这个文件主要需要注意的地方就是，include过来的控件需要将layout_wideth设置成0dp，从而使得控件能完全平铺。

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <include
        android:id="@+id/include2"
        layout="@layout/buttom"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="1.0"
        app:layout_constraintStart_toStartOf="parent" />

    <include
        android:id="@+id/include"
        layout="@layout/top"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <FrameLayout
        android:id="@+id/frameLayout"
        android:layout_width="409dp"
        android:layout_height="618dp"
        app:layout_constraintBottom_toTopOf="@+id/include2"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/include">

    </FrameLayout>
</androidx.constraintlayout.widget.ConstraintLayout>
```

#### **top.xml**
顶栏，额外创建了一个垂直的LinearLayout将一个view和textview同列显示，目的是为了设置一个底栏的边界下横线。

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">


    <LinearLayout
        android:id="@+id/container"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="top"
        android:orientation="vertical">

        <TextView
            android:id="@+id/textView5"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:background="#00000000"
            android:gravity="center"
            android:text="Work"
            android:textColor="@color/black"
            android:textSize="35dp" />

        <View
            android:id="@+id/black_line"
            android:layout_width="match_parent"
            android:layout_height="1dp"
            android:background="#808080" />


    </LinearLayout>
</LinearLayout>
```

#### **buttom.xml**
底栏和顶栏类似，同样做了一个上边界线的处理。

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="wrap_content">

    <LinearLayout
        android:id="@+id/container"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="bottom"
        android:orientation="vertical">

        <View
            android:id="@+id/black_line"
            android:layout_width="match_parent"
            android:layout_height="1dp"
            android:background="#808080" />

        <View
            android:id="@+id/trasnperent_line"
            android:layout_width="match_parent"
            android:layout_height="3dp"
            android:background="#00000000" />

        <LinearLayout
            android:id="@+id/LinearLayout0"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent">


            <LinearLayout
                android:id="@+id/LinearLayout1"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:orientation="vertical">

                <ImageView
                    android:id="@+id/imageView"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    app:srcCompat="@drawable/wechat" />

                <TextView
                    android:id="@+id/textView"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:gravity="center"
                    android:text="@string/wechat" />
            </LinearLayout>

            <LinearLayout
                android:id="@+id/LinearLayout2"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:orientation="vertical">

                <ImageView
                    android:id="@+id/imageView2"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    app:srcCompat="@drawable/wodewo" />

                <TextView
                    android:id="@+id/textView2"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:gravity="center"
                    android:text="@string/txl" />
            </LinearLayout>

            <LinearLayout
                android:id="@+id/LinearLayout3"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:orientation="vertical">

                <ImageView
                    android:id="@+id/imageView3"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    app:srcCompat="@drawable/faxian" />

                <TextView
                    android:id="@+id/textView3"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:gravity="center"
                    android:text="@string/found" />
            </LinearLayout>

            <LinearLayout
                android:id="@+id/LinearLayout4"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:orientation="vertical">

                <ImageView
                    android:id="@+id/imageView4"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    app:srcCompat="@drawable/wo" />

                <TextView
                    android:id="@+id/textView4"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:gravity="center"
                    android:text="@string/me" />
            </LinearLayout>
        </LinearLayout>
    </LinearLayout>
</LinearLayout>
```

#### **fragment_example.xml**

```xml
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Fragment1">

    <!-- TODO: Update blank fragment layout -->
    <TextView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:textSize="45sp"
        android:gravity="center"
        android:text="@string/wechat"/>



</FrameLayout>
```

#### **avg.xml**
安卓项目中不能直接使用avg矢量图片作为图标来使用，但是可以导入avg文件为xml文件来使用，同时可以设置一些属性。
通常可以设置的有：
> android:strokeColor="@color/white" 路径颜色
> android:strokeWidth="30"           路径宽度
> android:fillColor="@color/default_grey" 填充颜色

```xml
<vector xmlns:android="http://schemas.android.com/apk/res/android"
    android:width="32dp"
    android:height="32dp"
    android:viewportWidth="1024"
    android:viewportHeight="1024">
  <path
      android:pathData="M512,85.3c235.6,0 426.7,191 426.7,426.7S747.6,938.7 512,938.7 85.3,747.6 85.3,512 276.4,85.3 512,85.3zM512,149.3c-200.3,0 -362.7,162.4 -362.7,362.7s162.4,362.7 362.7,362.7 362.7,-162.4 362.7,-362.7 -162.4,-362.7 -362.7,-362.7zM661.2,308.2a42.7,42.7 0,0 1,54.6 54.6L637.6,579.8a96,96 0,0 1,-57.8 57.8l-217,78.1a42.7,42.7 0,0 1,-54.6 -54.6l78.1,-217a96,96 0,0 1,57.8 -57.8zM640.2,383.8l-174.3,62.8a32,32 0,0 0,-19.3 19.3l-62.8,174.3 174.3,-62.8a32,32 0,0 0,19.3 -19.3l62.8,-174.3z"
      android:fillColor="@color/default_grey"

      />
</vector>

```

### Java代码
#### **onCreate()**
- 在主页面被创建时，将定义的所有变量根据id寻找到对应的组件
- ``if(getSupportActionBar()!=null){getSupportActionBar().hide();}``
用于隐藏标题栏项目
- 为四个linearLayout设置setOnClickListener
- initial()及其后面部分代码是用于四个Fragment的初始化，以及初始隐藏三个其他的页面。

```java
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getSupportActionBar()!=null){
            getSupportActionBar().hide();
//            getWindow().setFlags(
//                    WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                    WindowManager.LayoutParams.FLAG_FULLSCREEN
//            );          #隐藏状态栏
        }   # 隐藏项目的标题栏

        linearLayout1=findViewById(R.id.LinearLayout1);
        linearLayout2=findViewById(R.id.LinearLayout2);
        linearLayout3=findViewById(R.id.LinearLayout3);
        linearLayout4=findViewById(R.id.LinearLayout4);

        fragment1=new Fragment1();
        fragment2=new Fragment2();
        fragment3=new Fragment3();
        fragment4=new Fragment4();

        imageView1=findViewById(R.id.imageView);
        imageView2=findViewById(R.id.imageView2);
        imageView3=findViewById(R.id.imageView3);
        imageView4=findViewById(R.id.imageView4);

        manager=getSupportFragmentManager();

        initial();

        transaction=manager.beginTransaction()
                .hide(fragment2)
                .hide(fragment3)
                .hide(fragment4);
        transaction.commit();

        linearLayout1.setOnClickListener(this);
        linearLayout2.setOnClickListener(this);
        linearLayout3.setOnClickListener(this);
        linearLayout4.setOnClickListener(this);

    }
```

#### **initial()**
初始化四个fragment，将四个fragment放入framelayout中展现，onCreate中，initial后会隐藏其他三个fragment，防止重叠。

```java
private void initial() {
        transaction=manager.beginTransaction()
                .add(R.id.frameLayout,fragment1)
                .add(R.id.frameLayout,fragment2)
                .add(R.id.frameLayout,fragment3)
                .add(R.id.frameLayout,fragment4);
        transaction.commit();
    }
```

#### **onclick() for LinearLayout**
四个LinearLayout的onclick函数重写，showfragment()和onchosen()函数如下

```java
# showfragment()用于显示传回的fragment
private void showfragment(Fragment fragment) {transaction.show(fragment);}
# onchosen()用于改变imageView的颜色，做出选中的效果
private void onchosen(ImageView imageView) {imageView.setColorFilter(getColor(R.color.wechat_green));}
```
swich 根据点击的LinearLayout执行select()

在select()中i对应4个点击

```java
@Override
public void onClick(View view) {
    switch (view.getId()){
        case R.id.LinearLayout1:select(1);
            break;
        case R.id.LinearLayout2:select(2);
            break;
        case R.id.LinearLayout3:select(3);
            break;
        case R.id.LinearLayout4:select(4);
            break;
    };
}

private void select( int i) {

    hidden();

    switch (i){
        case 1:showfragment(fragment1);
            onchosen(imageView1);
            break;
        case 2:showfragment(fragment2);
            onchosen(imageView2);
            break;
        case 3:showfragment(fragment3);
            onchosen(imageView3);
            break;
        case 4:showfragment(fragment4);
            onchosen(imageView4);
            break;
    }
}
```

#### **hidden()**
隐藏所有的Fragment，用于点击后的隐藏重显示效果
同时将所有imageView的颜色归为默认

```java
private void hidden() {
    transaction=manager.beginTransaction()
            .hide(fragment1)
            .hide(fragment2)
            .hide(fragment3)
            .hide(fragment4);
    transaction.commit();
    imageView1.setColorFilter(getColor(R.color.default_grey));
    imageView2.setColorFilter(getColor(R.color.default_grey));
    imageView3.setColorFilter(getColor(R.color.default_grey));
    imageView4.setColorFilter(getColor(R.color.default_grey));
}
```

## 4\.运行展示截图
![](https://img1.imgtp.com/2022/09/30/6vnkLlks.png)
## 5\.源码仓库地址
[https://github.com/Dear-Doll/My-Work-ep1/tree/master](https://github.com/Dear-Doll/My-Work-ep1/tree/master)
