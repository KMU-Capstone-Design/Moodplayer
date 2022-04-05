package org.techtown.realproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ExpandableListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class List_page extends AppCompatActivity {
    ExpandableListView expandableListView;
    private ArrayList<Parent> arrayGroup = new ArrayList<>();

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
        arrayGroup.add(parent2);

        Parent parent3 = new Parent("신나는");
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