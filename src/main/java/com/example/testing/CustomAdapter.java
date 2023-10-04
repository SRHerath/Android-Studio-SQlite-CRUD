package com.example.testing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.testing.Sql.ItemModel;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<ItemModel> userModelArrayList;

    public CustomAdapter(Context context, ArrayList<ItemModel> userModelArrayList) {

        this.context = context;
        this.userModelArrayList = userModelArrayList;
    }


    @Override
    public int getCount() {
        return userModelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return userModelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.lv_item, null, true);

            holder.tvcode = (TextView) convertView.findViewById(R.id.code);
            holder.tvdes = (TextView) convertView.findViewById(R.id.des);
            holder.tvqua = (TextView) convertView.findViewById(R.id.quan);


            convertView.setTag(holder);
        }else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder)convertView.getTag();
        }

        holder.tvcode.setText("Code: "+userModelArrayList.get(position).getItemCode());
        holder.tvdes.setText("Description: "+userModelArrayList.get(position).getItemDes());
        holder.tvqua.setText("Quantity: "+userModelArrayList.get(position).getItemQuan());

        return convertView;
    }

    private class ViewHolder {

        protected TextView tvcode, tvdes,tvqua;
    }

}

