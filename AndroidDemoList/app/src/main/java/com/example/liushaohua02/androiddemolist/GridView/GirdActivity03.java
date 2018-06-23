package com.example.liushaohua02.androiddemolist.GridView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

import com.example.liushaohua02.androiddemolist.BaseActivity;
import com.example.liushaohua02.androiddemolist.GridView.Adaptor.GridAdaptor03;
import com.example.liushaohua02.androiddemolist.GridView.Model.ImageInfo;
import com.example.liushaohua02.androiddemolist.R;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GirdActivity03 extends BaseActivity {



    private GridView gridView;
    private List<String> imgList;
    private List<ImageInfo> imageInfoList;
    private GridAdaptor03 gridAdapter;

    ImageLoadTask imageLoadTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_activity03);

        setupUI();

        initData();
    }

    private void initData() {
        imgList=new ArrayList<String>();
        imgList.add("http://img5.duitang.com/uploads/item/201406/26/20140626164837_dzKds.jpeg");
        imgList.add("http://img2.imgtn.bdimg.com/it/u=3980629563,3881837630&fm=21&gp=0.jpg");
        imgList.add("http://img5q.duitang.com/uploads/item/201505/08/20150508155052_XJaNW.jpeg");
        imgList.add("http://img4.duitang.com/uploads/item/201407/02/20140702105736_FdN5P.jpeg");
        imgList.add("http://img2.imgtn.bdimg.com/it/u=2866652161,3841912673&fm=21&gp=0.jpg");
        imgList.add("http://img4.imgtn.bdimg.com/it/u=883757693,2063816225&fm=21&gp=0.jpg");
        imgList.add("http://cdn.duitang.com/uploads/item/201309/26/20130926110955_QtUdX.jpeg");
        imgList.add("http://zjimg.5054399.com/allimg/160815/14_160815161625_9.jpg");
        imgList.add("http://i-7.vcimg.com/trim/09ce7067d2467c54cf05bbd271ee3ec8430415/trim.jpg");
        imageInfoList=new ArrayList<ImageInfo>();
        for(int i=0;i<9;i++)
        {
            ImageInfo imageInfo=new ImageInfo();
            imageInfo.setImagePath(imgList.get(i));
            imageInfo.setText("图片"+i);
            imageInfoList.add(imageInfo);
        }
        gridAdapter=new GridAdaptor03(GirdActivity03.this,imageInfoList);
        gridView.setAdapter(gridAdapter);

        // 下载对象 用第三方库 就不用这个了
//        imageLoadTask =new ImageLoadTask(this,gridAdapter);
//        imageLoadTask.execute("");

    }


    private void setupUI() {
        gridView = findViewById(R.id.gridView03);
    }


    private Bitmap getImageFromNet(String path) {

        try {
            URL url = new URL(path);

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoInput(true);
            urlConnection.connect();
            InputStream inputStream = urlConnection.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
            return bitmap;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }


    public class ImageLoadTask extends AsyncTask<String,Void,Void> {

        private GridAdaptor03 gridAdapter;

        public ImageLoadTask(Context context, GridAdaptor03 gridAdapter) {
            this.gridAdapter = gridAdapter;
        }

        @Override
        protected Void doInBackground(String... params) {

            for (int i = 0; i < gridAdapter.getCount(); i++) {
                // 拿到数据
                ImageInfo imageInfo = (ImageInfo) gridAdapter.getItem(i);
                String imagePath = imageInfo.getImagePath();
                // 下载图片
                Bitmap bitmap = getImageFromNet(imagePath);
                imageInfo.setBitmap(bitmap);
                // 通知刷新UI
                publishProgress();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
            Log.e("Main", "刷新");
            // 通知gridAdapter 去刷新界面
            // 在主线程
            gridAdapter.notifyDataSetChanged();

        }
    }




}
