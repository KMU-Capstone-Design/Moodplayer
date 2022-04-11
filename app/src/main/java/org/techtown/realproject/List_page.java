package org.techtown.realproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class List_page extends AppCompatActivity {
    ArrayList<Parent> arrayGroup = new ArrayList<>();
    ExpandableListView expandableListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Intent intent = getIntent();
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        makeData();
        expandableAdaptor adaptor = new expandableAdaptor(this,arrayGroup);
        expandableListView.setAdapter(adaptor);
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int groupPosition, int childPosition, long id) {
                String url = (String) arrayGroup.get(groupPosition).child.get(childPosition).getUrl();
                Intent intent = new Intent(List_page.this,SongWebView.class);
                intent.putExtra("url",url);
                startActivity(intent);
                return false;
            }
        });
    }
    public void makeData(){
        Parent parent1 = new Parent("설레는");
        parent1.child.add(new Child("아이유 - 금요일에 만나요","https://youtu.be/EiVmQZwJhsA"));
        parent1.child.add(new Child("버스커버스커 - 벚꽃엔딩","https://youtu.be/tXV7dfvSefo"));
        arrayGroup.add(parent1);

        Parent parent2 = new Parent("슬픈");
        parent2.child.add(new Child("알리 - 지우개","https://www.youtube.com/watch?v=BKq7C2vdvq0"));
        arrayGroup.add(parent2);

        Parent parent3 = new Parent("신나는");
        parent3.child.add(new Child("김연자 - 아모르파티","https://www.youtube.com/watch?v=YLwJr8ZsGHw"));
        arrayGroup.add(parent3);
    }
    public void backspaceClicked(View v){
        Intent intent = new Intent(getApplicationContext(),Select_page.class);
        startActivity(intent);
        finish();
    }
    public void homeClicked(View v){
        Intent intent = new Intent(getApplicationContext(),Select_page.class);
        startActivity(intent);
        finish();
    }
}