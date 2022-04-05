package org.techtown.realproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class expandableAdaptor extends BaseExpandableListAdapter {
    private LayoutInflater inflater = null;
    private Context context;
    public ArrayList<Parent> data;
    public HashMap<String,String> h = new HashMap<>();

    public expandableAdaptor(Context context, ArrayList<Parent> data) {
        this.context = context;
        this.data = data;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getGroupCount() {
        return data.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return data.get(groupPosition).child.size();

    }

    @Override
    public Object getGroup(int groupPosition) {
        return data.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return data.get(groupPosition).child.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean b, View view, ViewGroup parent) {
        if (view == null) {
            view = inflater.inflate(R.layout.parent_list,parent,false);
        }
        TextView tv_parent = (TextView) view.findViewById(R.id.tv_parent);
        tv_parent.setText(data.get(groupPosition).getTv_parent());

        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean b, View view, ViewGroup parent) {
        String childName = data.get(groupPosition).child.get(childPosition).getTv_child();
        if(view == null){
            view = inflater.inflate(R.layout.child_list,parent,false);
        }
        TextView tv_child = (TextView) view.findViewById(R.id.tv_child);
        tv_child.setText(childName);
        String url = data.get(groupPosition).child.get(childPosition).getUrl();
        h.put(childName,url);

        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
