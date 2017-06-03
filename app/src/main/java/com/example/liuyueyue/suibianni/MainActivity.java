package com.example.liuyueyue.suibianni;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;

public class MainActivity extends AppCompatActivity {
    private Banner banner;
    String[] images = new String[]{
            "http://218.192.170.132/BS80.jpg",
            "http://img.zcool.cn/community/0166c756e1427432f875520f7cc838.jpg",
            "http://img.zcool.cn/community/018fdb56e1428632f875520f7b67cb.jpg",
            "http://img.zcool.cn/community/01c8dc56e1428e6ac72531cbaa5f2c.jpg",
            "http://img.zcool.cn/community/01fda356640b706ac725b2c8b99b08.jpg",
            "http://img.zcool.cn/community/01fd2756e142716ac72531cbf8bbbf.jpg",
            "http://img.zcool.cn/community/0114a856640b6d32f87545731c076a.jpg"
    };
    String[] titles = new String[]{
            "十大星级品牌联盟,全场两折起", "全场两折起", "十大星级品牌联盟", "嗨购5折不要停", "12趁现在", "嗨购5折不要停，12.12趁现在", "实打实大顶顶顶顶"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        banner = (Banner) findViewById(R.id.banner);
        //显示圆形指示器和标题
        banner.setBannerStyle(Banner.CIRCLE_INDICATOR_TITLE);
        //指示器居中
        banner.setIndicatorGravity(banner.CENTER);
        //
        banner.setBannerTitle(titles);
        //是否自动轮播
        banner.isAutoPlay(true);
        //设置轮播间隔时间
        banner.setDelayTime(3000);
        //自定义图片加载框
        banner.setImages(images, new Banner.OnLoadImageListener() {
            @Override
            public void OnLoadImage(ImageView view, Object url) {
                System.out.println("加载中");
                Glide.with(getApplicationContext()).load(url).into(view);
                System.out.println("加载完");
            }
        });
        banner.setOnBannerClickListener(new Banner.OnBannerClickListener() {


            @Override
            public void OnBannerClick(View view, int position) {
                Toast.makeText(getApplicationContext(),"你点击了："+position,Toast.LENGTH_LONG).show();;

            }
        });


    }
}