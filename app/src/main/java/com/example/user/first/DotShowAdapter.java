package com.example.user.first;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 명윤 on 2018-01-23.
 */

public class DotShowAdapter extends BaseAdapter {
    private ArrayList<DotShowItem> girdViewItemList = new ArrayList<DotShowItem>();
    public DotShowAdapter(){
    }
    //Adapter에 사용 되는 데이터의 개수를 리턴. : 필수 구현
    @Override
    public int getCount(){return girdViewItemList.size();}

    public View getView(int position, View convertView, ViewGroup parent){
        final int pos = position;
        final Context context = parent.getContext();

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //외부 XML 파일에 있는 resource로 부터 가져옴.
            //요 밑에 줄 file_find 수정 해야됨. xml 따로 만들어서 해야함.
            convertView = inflater.inflate(R.layout.dot_show,parent, false);
        }

        //화면에 표시될 View(Layout 이 inflate된)으로 부터 위젯에 대한 참조 획득
        ImageView iconImageView = (ImageView)convertView.findViewById(R.id.Dot_img);
        TextView titleTextView = (TextView) convertView.findViewById(R.id.Dot_txt);

        ImageView iconImageView2 = (ImageView)convertView.findViewById(R.id.Dot_img2);
        ImageView iconImageView3 = (ImageView)convertView.findViewById(R.id.Dot_img3);
        TextView titleTextView2 = (TextView) convertView.findViewById(R.id.Dot_txt2);

        //Data Set(ListViewItemList) 에서 position 에 위치한 데이터 참조 획득
        DotShowItem listViewItem = girdViewItemList.get(position);

        //아이템 내 각 위젯에 데이터 반영
        iconImageView.setImageDrawable(listViewItem.getIcon());
        titleTextView.setText(listViewItem.getTitle());

        return convertView;
    }
    //지정한 위치에 있는 데이터와 관계된 아이템의 ID를 리턴 : 필수 구현
    @Override
    public long getItemId(int position) {
        return position;
    }

    //지정한 위치에 있는 데이터 리턴 : 필수 구현
    @Override
    public DotShowItem getItem(int position) {
        return girdViewItemList.get(position);
    }

    //addItem 에다가 type int 라는 변수를 추가해서 이미지뷰를 1개 사용할지, 2개 사용할지 결정해서 add 할거임.
    //아이템 데이터 추가를 위한 함수, 개발자가 원하는대로 작성 가능
    public void addItem(Drawable icon, String title) {
        DotShowItem item = new DotShowItem();

        item.setIcon(icon);
        item.setTitle(title);
        girdViewItemList.add(item);
    }
}
