package com.example.students.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.students.R;

public class DetailedInfomation extends AppCompatActivity {
    private EditText edt_mssv;
    private EditText edt_name;
    private Button update;
    private Button delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_infomation);
        getObject();
        showInfo();
        update.setOnClickListener(new View.OnClickListener() {
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
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                setResult(0,intent);
                finish();
            }
        });
    }

    private void showInfo() {
        Intent intent = getIntent();
        String mssv = intent.getExtras().getString("mssv");
        String name = intent.getExtras().getString("name");
        edt_mssv.setText(mssv);
        edt_name.setText(name);
    }

    private void getObject() {
        edt_name = this.findViewById(R.id.edt_name);
        edt_mssv = this.findViewById(R.id.edt_mssv);
        update = this.findViewById(R.id.bt_update);
        delete = this.findViewById(R.id.bt_del);
    }

}
