package com.liguanjia.myapplication;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.liguanjia.myapplication.databinding.ActivityDataBindTextBinding;

public class DataBindTextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityDataBindTextBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_data_bind_text);

        UserBeen user = new UserBeen();
        user.setName("seen");
        user.setAge("18");
        user.setChecked(true);
        binding.setBeen(user);

        if(binding.getBeen() .equals(user)){
            Log.i("sdfasdf","asdfsdf1");
        }
    }
}
