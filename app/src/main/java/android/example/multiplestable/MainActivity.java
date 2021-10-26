package android.example.multiplestable;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

     TextView textView;
     ListView listView;
     SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        listView = findViewById(R.id.listView);
        seekBar = findViewById(R.id.seekBar);

        seekBar.setMax(30);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    Toast.makeText(MainActivity.this, "The progress is: "+ progress, Toast.LENGTH_SHORT).show();
                    populate(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void populate(int table){

        ArrayList<String> multipleTable = new ArrayList<>();
        for (int i = 1; i<= 10; i++){
            multipleTable.add(table + " X " + i + " = " + table*i);
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, multipleTable);
        listView.setAdapter(arrayAdapter);
        textView.setText("Multiplication Table of " + table);

    }

//        ListView mylistView = findViewById(R.id.listView);
//        ArrayList<String> Tables = new ArrayList<>();
//
//        Tables.add(" 1 * 1 = 1 ");
//        Tables.add(" 1 * 2 = 2 ");
//        Tables.add(" 1 * 3 = 3 ");
//        Tables.add(" 1 * 4 = 4 ");
//        Tables.add(" 1 * 5 = 5 ");
//        Tables.add(" 1 * 6 = 6 ");
//        Tables.add(" 1 * 7 = 7 ");
//        Tables.add(" 1 * 8 = 8 ");
//        Tables.add(" 1 * 9 = 9 ");
//        Tables.add(" 1 *10 = 10");
//
//        Tables.add(" 2 * 1 = 2 ");
//        Tables.add(" 2 * 2 = 4 ");
//        Tables.add(" 2 * 3 = 6 ");
//        Tables.add(" 2 * 4 = 8 ");
//        Tables.add(" 2 * 5 = 10");
//        Tables.add(" 2 * 6 = 12");
//        Tables.add(" 2 * 7 = 14");
//        Tables.add(" 2 * 8 = 16");
//        Tables.add(" 2 * 9 = 18");
//        Tables.add(" 2 *10 = 20");
//
//
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, Tables);
//        mylistView.setAdapter(arrayAdapter);
//
//        mylistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//        });


}