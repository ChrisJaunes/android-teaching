package com.chrisjaunes.android_teaching.database1.example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.chrisjaunes.android_teaching.database1.R;

import java.util.Arrays;
import java.util.List;

public class Exp2Activity extends AppCompatActivity implements View.OnClickListener {
    private Exp2Database db;
    private EditText tv_name;
    private EditText tv_age;
    private EditText tv_phone;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp2);
        db = Room.databaseBuilder(getApplicationContext(), Exp2Database.class, "Exp2")
                .allowMainThreadQueries()
                .build();
        tv_name = findViewById(R.id.tv_name);
        tv_age = findViewById(R.id.tv_age);
        tv_phone = findViewById(R.id.tv_phone);
        Button button1 = findViewById(R.id.btn_exp1_ins);
        button1.setOnClickListener(this);

        Button button2 = findViewById(R.id.btn_exp1_upt);
        button2.setOnClickListener(this);

        Button button3 = findViewById(R.id.btn_exp1_del);
        button3.setOnClickListener(this);

        Button button4 = findViewById(R.id.btn_exp1_queAll);
        button4.setOnClickListener(this);

        listView = findViewById(R.id.btn_exp1_queList);
    }
    @Override
    public void onClick(View view){
        String user_name = tv_name.getText().toString();
        int user_age = "".equals(tv_age.getText().toString()) ? 20 : Integer.parseInt(tv_age.getText().toString());
        String user_phone = tv_phone.getText().toString();
        switch (view.getId()) {
            case R.id.btn_exp1_ins:
                Log.i("Exp1", String.format("Exp1Activity 插入了一条数据: (%s,%d,%s)",user_name, user_age,user_phone));
                long[] res1 = db.Exp2Dao().insertUsers(new Exp2UserEntity(user_name, user_age, user_phone));
                Log.i("Exp1", "插入的rowID" + Arrays.toString(res1));
                break;
            case R.id.btn_exp1_upt:
                Log.d("Exp1", String.format("Exp1Activity 更新了一条数据: (%s,%d,%s)",user_name, user_age,user_phone));
                long res2 = db.Exp2Dao().updateUsers(new Exp2UserEntity(user_name, user_age, user_phone));
                Log.i("Exp1", "受影响的行数" + res2);
                break;
            case R.id.btn_exp1_del:
                Log.d("Exp1", String.format("Exp1Activity 删除了一条数据: (%s)",user_name));
                long res3 = db.Exp2Dao().deleteUsers(new Exp2UserEntity(user_name, user_age, user_phone));
                Log.i("Exp1", "受影响的行数" + res3);
                break;
            case R.id.btn_exp1_queAll:
                Log.d("Exp1", "Exp1Activity 查询了所有用户");
                List<Exp2UserEntity> res4 = db.Exp2Dao().queryAllUsers();
                listView.setAdapter(new ArrayAdapter<Exp2UserEntity>(Exp2Activity.this, R.layout.item_user, res4) {
                    @SuppressLint("DefaultLocale")
                    @Override
                    public View getView(int pos, View convertView, ViewGroup parent) {
                        Exp2UserEntity user = getItem(pos);
                        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_user, parent, false);
                        TextView tv_name = view.findViewById(R.id.tv_name);
                        TextView tv_age = view.findViewById(R.id.tv_age);
                        TextView tv_phone = view.findViewById(R.id.tv_phone);
                        assert user != null;
                        tv_name.setText(String.format("用户姓名: %s", user.name));
                        tv_age.setText(String.format("年龄: %d" , user.age));
                        tv_phone.setText(String.format("电话: %s" , user.phone));
                        return view;
                    }
                });
                break;
        }
    }

}