package com.sapuglha.espressotips;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListActivity extends AppCompatActivity {

    @BindView(R.id.list_activity_listview)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ButterKnife.bind(this);

        listView.setAdapter(getArrayAdapter());
    }

    private ArrayAdapter<String> getArrayAdapter() {
        List<String> listItems = new ArrayList<>();
        listItems.add("Item 0");
        listItems.add("Item 1");
        listItems.add("Item 2");
        listItems.add("Item 3");
        listItems.add("Item 4");
        listItems.add("Item 5");
        listItems.add("Item 6");
        listItems.add("Item 7");
        listItems.add("Item 8");
        listItems.add("Item 9");

        return new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItems);
    }
}
