package com.example.students.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.students.R;

public class AddStudent extends AppCompatActivity {
    private EditText edt_mssv;
    private EditText edt_name;
    private Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        getObject();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mssv = edt_mssv.getText().toString();
                String name = edt_name.getText().toString();
                if (mssv != "" && name != "")
                {
                    Intent intent = new Intent();
                    intent.putExtra("mssv",mssv);
                    intent.putExtra("name",name);
                    setResult(1,intent);
                    finish();
                }
            }
        });
    }

    private void getObject() {
        edt_name = this.findViewById(R.id.edt_add_name);
        edt_mssv = this.findViewById(R.id.edt_add_mssv);
        add = this.findViewById(R.id.bt_add);
    }
}
