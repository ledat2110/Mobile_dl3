package com.example.students.Activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.students.DTO.Student;
import com.example.students.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<Student> listStudent;
    static private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getObject();
        initListStudent();
        showListStudent();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                index = position;
                String mssv = listStudent.get(position).get_mssv();
                String name= listStudent.get(position).get_name();
                Intent intent = new Intent(MainActivity.this,DetailedInfomation.class);
                intent.putExtra("mssv",mssv);
                intent.putExtra("name",name);
                startActivityForResult(intent,10);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = this.getMenuInflater();
        inflater.inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_add:
                Intent intent = new Intent(MainActivity.this,AddStudent.class);
                startActivityForResult(intent,11);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 10:
                if (resultCode == 0){
                    listStudent.remove(index);
                    showListStudent();


                }
                else if (resultCode == 1){
                    String mssv = data.getExtras().getString("mssv");
                    String name = data.getExtras().getString("name");
                    listStudent.get(index).set_mssv(mssv);
                    listStudent.get(index).set_name(name);
                    showListStudent();
                }

                break;
            case 11:
                if(resultCode == 1){
                    String mssv = data.getExtras().getString("mssv");
                    String name = data.getExtras().getString("name");
                    listStudent.add(new Student(mssv,name));
                    showListStudent();
                }
                break;

        }
    }

    private void showListStudent() {
        if (listStudent != null){
            ArrayList<String> mssv = new ArrayList<>();
            for (int i=0;i < listStudent.size();i++){
                mssv.add(listStudent.get(i).get_mssv());
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,mssv);
            listView.setAdapter(adapter);
        }
    }

    private void initListStudent() {
        listStudent = new ArrayList<Student>();
        listStudent.add(new Student("123","sdafsadf"));
    }

    private void getObject() {
        listView = this.findViewById(R.id.lv_student);
    }
}
