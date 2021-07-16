package com.example.programm.myapplication_2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import static com.example.programm.myapplication_2.Fragment2.TAG;

public class CustomListAdapter  extends BaseAdapter {
    private List<MyNew> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListAdapter(Context aContext,  List<MyNew> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private ViewHolder holder;
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_item_layout, null);
            holder = new ViewHolder();
            holder.imgView = (ImageView) convertView.findViewById(R.id.imageView_flag);
            holder.titleView = (TextView) convertView.findViewById(R.id.textView_countryName);
            holder.dateView = (TextView) convertView.findViewById(R.id.textView_population);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        MyNew myNew = this.listData.get(position);
        holder.titleView.setText(myNew.getTitle());
        holder.dateView.setText("Date: " + myNew.getDate());

        new ThreadImgMyNews().execute(myNew.getImgLink());

        return convertView;
    }

    static class ViewHolder {
        ImageView imgView;
        TextView titleView;
        TextView dateView;
    }

//    @SuppressLint("StaticFieldLeak")
    private class ThreadImgMyNews extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... mynews) {
//            Log.i(TAG + "AsyncTask", mynews);
            String myNewURLImg = mynews[0];

            Log.i(TAG + "AsyncTask", myNewURLImg);
            Bitmap bitmap =null;
            try {
                URL url = new URL(myNewURLImg);
                HttpURLConnection httpConn = null;
                httpConn = (HttpURLConnection) url.openConnection();


                httpConn.connect();
                int resCode = httpConn.getResponseCode();

                if (resCode == HttpURLConnection.HTTP_OK) {
                    InputStream in = httpConn.getInputStream();
                    bitmap = BitmapFactory.decodeStream(in);

                    return bitmap;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitmap;
        }
        @Override
        protected void onPostExecute(Bitmap bitmap) {
//            Log.i(TAG,"onPostExecute is working");
            holder.imgView.setImageBitmap(bitmap);
        }

    }
}
