package com.firstlinecode.ui.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.firstlinecode.R;

import java.util.List;

/**
 * Created by chensc on 2018/3/2.
 */

public class FruitAdapter extends BaseAdapter {
    private List<Fruit>fruitList;
    private Context context;
    public FruitAdapter(Context context,List<Fruit> fruitList){
        this.fruitList=fruitList;
        this.context=context;
    }
    @Override
    public int getCount() {
        return fruitList.size();
    }

    @Override
    public Fruit getItem(int position) {
        return fruitList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Fruit fruit=getItem(position);
        View view;
        ViewHolder holder;
        if (convertView==null) {
            view = LayoutInflater.from(context).inflate(R.layout.fruititem, parent, false);
            holder=new ViewHolder();
            holder.fruitName=view.findViewById(R.id.fruit_name);
            holder.fruitImage=view.findViewById(R.id.fruit_image);
            view.setTag(holder);
        }else {
            view=convertView;
            holder= (ViewHolder) view.getTag();
        }
        holder.fruitImage.setImageResource(fruit.getId());
        holder.fruitName.setText(fruit.getName());
        return view;
    }
    class ViewHolder {
        private TextView fruitName;
        private ImageView fruitImage;
    }
}
