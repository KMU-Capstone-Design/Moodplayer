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
import java.util.Collections;
import java.util.Comparator;
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
        searchKeyword();
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

        Parent parent4 = new Parent("감성적인");
        parent4.child.add(new Child("치즈 - 무드 인디고","https://www.youtube.com/watch?v=LsLUz7ArmGI"));
        arrayGroup.add(parent4);

        Parent parent5 = new Parent("시원한");
        parent5.child.add(new Child("쿨 - 해변의 여인","https://www.youtube.com/watch?v=x28aE-d2chY"));
        arrayGroup.add(parent5);

        Parent parent6 = new Parent("행복한");
        parent6.child.add(new Child("백예린 - Square","https://www.youtube.com/watch?v=4iFP_wd6QU8"));
        arrayGroup.add(parent6);

        Parent parent7 = new Parent("애절한");
        parent7.child.add(new Child("신예영 - 우리 왜 헤어져야 해","https://www.youtube.com/watch?v=FIdFoxVnGgE"));
        arrayGroup.add(parent7);
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
    public void searchKeyword(){
        SearchView searchView;
        searchView = (SearchView) findViewById((R.id.search_view));
        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchView.setIconified(false);
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) { //입력받은 문자열 처리하는 이벤트
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) { //입력란의 문자열이 바뀔 때 발생하는 이벤트
                ArrayList<Parent> filterKeyword = new ArrayList<>();
                for(int i=0; i<arrayGroup.size();i++){
                    Parent parent = arrayGroup.get(i);
                    if(parent.getTv_parent().toLowerCase().contains(s.toLowerCase())) {
                        filterKeyword.add(parent);
                    }
                }
                expandableAdaptor adapter = new expandableAdaptor(getApplicationContext(),filterKeyword);
                expandableListView.setAdapter(adapter);
                return true;
            }
        });
    }
}