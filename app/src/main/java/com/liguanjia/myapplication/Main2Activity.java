package com.liguanjia.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.liguanjia.myapplication.fragments.FourthFragment;
import com.liguanjia.myapplication.fragments.HomeFragment;
import com.liguanjia.myapplication.fragments.SecendFragment;
import com.liguanjia.myapplication.fragments.ThirdFragment;

public class Main2Activity extends AppCompatActivity {

    private Button[] btns;
    private Fragment[] fs;
    private FragmentManager fm;
    private int currentPosition = 0;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initView();
        initFraments();
    }


    private void initView() {
        Button btnHome = (Button) findViewById(R.id.btn_home);
        Button btnSecend = (Button) findViewById(R.id.btn_secend);
        Button btnThird = (Button) findViewById(R.id.btn_third);
        Button btnFourth = (Button) findViewById(R.id.btn_fourth);

        btns = new Button[]{btnHome, btnSecend, btnThird, btnFourth};
        btns[0].setSelected(true);
    }

    private void initFraments() {

        HomeFragment homeFragment = new HomeFragment();
        SecendFragment secendFragment = new SecendFragment();
        ThirdFragment thirdFragment = new ThirdFragment();
        FourthFragment fourthFragment = new FourthFragment();

        fs = new Fragment[]{homeFragment, secendFragment, thirdFragment, fourthFragment};
        fm = getSupportFragmentManager();

        fm.beginTransaction()
                .add(R.id.content, fs[0]).show(fs[0])
                .add(R.id.content, fs[1]).hide(fs[1])
                .add(R.id.content, fs[2]).hide(fs[2])
                .add(R.id.content, fs[3]).hide(fs[3])
                .commit();

    }


    public void bottomTabClick(View view) {
        switch (view.getId()) {
            case R.id.btn_home:
                currentPosition = 0;
                break;
            case R.id.btn_secend:
                currentPosition = 1;
                break;
            case R.id.btn_third:
                currentPosition = 2;
                break;
            case R.id.btn_fourth:
                currentPosition = 3;
                break;
        }

        if (index != currentPosition) {

            if(currentPosition>index){
                fm.beginTransaction()
                        .setCustomAnimations(R.anim.fragment_slide_right_in,
                                R.anim.fragment_slide_left_out)
                        .show(fs[currentPosition]).hide(fs[index]).commit();

            }else {
                fm.beginTransaction()
                        .setCustomAnimations(R.anim.fragment_slide_left_in,
                                R.anim.fragment_slide_right_out)
                        .show(fs[currentPosition]).hide(fs[index]).commit();
            }

            btns[currentPosition].setSelected(true);
            btns[index].setSelected(false);
            index = currentPosition;
        }

    }

}
