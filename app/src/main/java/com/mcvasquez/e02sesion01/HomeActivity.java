package com.mcvasquez.e02sesion01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HomeActivity extends AppCompatActivity {

    AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent i;
            switch (position) {
                case 0:
                    i = new Intent(getApplicationContext(), OperacionActivity.class);
                    onGoToActivity(i);
                    break;
                case 1:
                    break;
                case 2:
                    i = new Intent(getApplicationContext(), InternetActivity.class);
                    onGoToActivity(i);
                    break;
                default:

            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ListView listView = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.options_listview));
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(onItemClickListener);
    }

    public void onGoToActivity(Intent i) {
        startActivity(i);
    }
}
