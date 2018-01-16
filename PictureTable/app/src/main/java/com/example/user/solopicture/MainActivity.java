package com.example.user.solopicture;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {
        TextView tvMsg;
        GridView gridView;
        TextView tvSoloMsg;
       public int [] mThumbs;
        ImageView ivSoloPicture;
        Button btnBack;
        Bundle myMemoryBundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myMemoryBundle=savedInstanceState;
        setContentView(R.layout.activity_main);
        tvMsg=(TextView)findViewById(R.id.tvMsg);
        mThumbs=new int[]{R.drawable.img10,R.drawable.img_1,R.drawable.img11, R.drawable.img_2,R.drawable.img12,
                R.drawable.img_3,R.drawable.img7,R.drawable.img_4,R.drawable.img13,
                R.drawable.img_5,R.drawable.img8,R.drawable.img_7,R.drawable.img9,R.drawable.img10,R.drawable.img_1};
        gridView=(GridView)findViewById(R.id.gridView);
        gridView.setAdapter(new imageAdapter(this));
        gridView.setOnItemClickListener(this);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class imageAdapter extends BaseAdapter
    {
        private Context mContext;
        public imageAdapter(Context c)
        {
            mContext=c;
        }
        @Override
        public int getCount() {
            return mThumbs.length;
        }

        @Override
        public Object getItem(int position) {
            Toast.makeText(getApplicationContext(),"POS:"+position,Toast.LENGTH_LONG).show();
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if(convertView==null){
                imageView=new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(150,150));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(8, 8, 8, 8);
            }
            else{
                imageView=(ImageView)convertView;
            }
            imageView.setImageResource(mThumbs[position]);
            return imageView;

        }
    }
    public void onItemClick(AdapterView<?>parent,View v,int position,long id){
        tvMsg.setText("Position:"+position+"R.drawable.gallary_image"+(position+1));
        showScreen2(position);
    }
    private void showScreen2(int position){

        Intent intent=new Intent(MainActivity.this,Picture.class);

        Bundle myData = new Bundle();
        myData.putInt("imgposition",position);
        myData.putIntArray("imglist",mThumbs);
       intent.putExtras(myData);
        startActivityForResult(intent, 100);





    }
}
