package com.example.menu;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Menu extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        initView();
        setListener();
        enactment();
    }


    private EditText edit_name;
    private RadioGroup sex;
    private CheckBox cheese, tomato, vegetables;
    private TextView information;
    private Button search, next, all, cancel;
    private ImageView imageView;
    private int no, counter, quantity, i;
    private LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
    private List<Integer> list;
    private List<Food> food_data = new ArrayList<>();

    //對象設定
    public void enactment() {
        quantity = 19;
        Data();

    }

    //初始化控鍵
    public void initView() {
        edit_name = (EditText) findViewById(R.id.edit_name);
        sex = (RadioGroup) findViewById(R.id.sex_group);
        cheese = (CheckBox) findViewById(R.id.cheese);
        tomato = (CheckBox) findViewById(R.id.tomato);
        vegetables = (CheckBox) findViewById(R.id.vegetables);
        information = (TextView) findViewById(R.id.information);
        search = (Button) findViewById(R.id.search);
        next = (Button) findViewById(R.id.next);
        all = (Button) findViewById(R.id.all);
        cancel = (Button) findViewById(R.id.cancel);
        imageView = (ImageView) findViewById(R.id.image_view);
    }
    //EditTextListener
    class EditTextListener implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            setPocket();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }//EditTextListener
    }
    //RadioGroupListener
    class RadioGroupListener implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (group.getChildCount()) {
                case 1:
                case 2:
                    setPocket();
                    break;
            }
        }
    }//RadioGroupListener
    //測試
    {}
    //CheckBoxListener
    class CheckBoxListener implements CompoundButton.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            CheckBox ch_Box = (CheckBox) buttonView;
            switch (ch_Box.getId()) {
                case R.id.cheese:
                case R.id.tomato:
                case R.id.vegetables:
                    setPocket();
                    break;
            }
        }
    }//CheckBoxListener


    //ButtonListener
    class ButtonListener implements Button.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.all:
                    cheese.setChecked(true);
                    tomato.setChecked(true);
                    vegetables.setChecked(true);
                    break;
                case R.id.cancel:
                    cheese.setChecked(false);
                    tomato.setChecked(false);
                    vegetables.setChecked(false);
                    break;
                case R.id.search:
                    linkedHashSet=new LinkedHashSet<>();
                    if (cheese.isChecked()) {
                        for (int i = 0; i < quantity; i++) {
                            if (food_data.get(i).isCheese()) {
                                linkedHashSet.add(i + 1);
                            }
                        }
                    }
                    if (tomato.isChecked()) {
                        for (int i = 0; i < quantity; i++) {
                            if (food_data.get(i).isTomato()) {
                                linkedHashSet.add(i + 1);
                            }
                        }
                    }
                    if (vegetables.isChecked()) {
                        for (int i = 0; i < quantity; i++) {
                            if (food_data.get(i).isVegetables()) {
                                linkedHashSet.add(i + 1);
                            }
                        }
                    }
                    if (cheese.isChecked()&&tomato.isChecked()&&vegetables.isChecked()){
                        for (int i = 0; i < quantity; i++){
                          linkedHashSet.add(i+1);
                        }
                    }


                    list = new ArrayList<Integer>(linkedHashSet);
                    no = list.get(0);
                    find_View();
                    i = 1;
                    counter = list.size();
                    break;
                case R.id.next:
                    if (i < counter) {
                        no = list.get(i);
                        find_View();
                        i++;
                        break;
                    } else {
                        no = 0;
                        find_View();
                    }
            }
        }
    }//ButtonListener

    //setListener
    public void setListener() {
        EditTextListener editTextListener=new EditTextListener();
        edit_name.addTextChangedListener(editTextListener);
        RadioGroupListener radioGroupListener = new RadioGroupListener();
        sex.setOnCheckedChangeListener(radioGroupListener);
        CheckBoxListener checkBoxListener = new CheckBoxListener();
        cheese.setOnCheckedChangeListener(checkBoxListener);
        tomato.setOnCheckedChangeListener(checkBoxListener);
        vegetables.setOnCheckedChangeListener(checkBoxListener);
        ButtonListener buttonListener = new ButtonListener();
        search.setOnClickListener(buttonListener);
        next.setOnClickListener(buttonListener);
        all.setOnClickListener(buttonListener);
        cancel.setOnClickListener(buttonListener);
    }

    //設置Pocket
    public void setPocket() {
        String pocket;
        pocket = edit_name.getText().toString();

        for (int i = 0; i < sex.getChildCount(); i++) {
            RadioButton rb = (RadioButton) sex.getChildAt(i);
            if (rb.isChecked()) {
                pocket = pocket + rb.getText().toString();
                break;
            }
        }

        if (cheese.isChecked()) {
            pocket = pocket + cheese.getText().toString();
        }

        if (tomato.isChecked()) {
            pocket = pocket + tomato.getText().toString();
        }

        if (vegetables.isChecked()) {
            pocket = pocket + vegetables.getText().toString();
        }

        information.setText(pocket);

    }

    //Data
    public void Data() {
        Food food1 = new Food(true, false, true);
        Food food2 = new Food(true, true, false);
        Food food3 = new Food(true, true, false);
        Food food4 = new Food(false, true, true);
        Food food5 = new Food(false, false, true);
        Food food6 = new Food(false, false, false);
        Food food7 = new Food(false, false, false);
        Food food8 = new Food(false, false, true);
        Food food9 = new Food(false, false, false);
        Food food10 = new Food(false, false, false);
        Food food11 = new Food(true, false, true);
        Food food12 = new Food(true, false, false);
        Food food13 = new Food(false, false, true);
        Food food14 = new Food(false, true, true);
        Food food15 = new Food(false, true, true);
        Food food16 = new Food(false, true, true);
        Food food17 = new Food(true, false, true);
        Food food18 = new Food(true, true, true);
        Food food19 = new Food(true, true, true);

        food_data.add(food1);
        food_data.add(food2);
        food_data.add(food3);
        food_data.add(food4);
        food_data.add(food5);
        food_data.add(food6);
        food_data.add(food7);
        food_data.add(food8);
        food_data.add(food9);
        food_data.add(food10);
        food_data.add(food11);
        food_data.add(food12);
        food_data.add(food13);
        food_data.add(food14);
        food_data.add(food15);
        food_data.add(food16);
        food_data.add(food17);
        food_data.add(food18);
        food_data.add(food19);

    }


    //找尋對應圖片
    private void find_View() {
        switch (no) {
            case 1:
                imageView.setImageResource(R.drawable.evm_1_2);
                break;
            case 2:
                imageView.setImageResource(R.drawable.evm_2_2);
                break;
            case 3:
                imageView.setImageResource(R.drawable.evm_3_2);
                break;
            case 4:
                imageView.setImageResource(R.drawable.evm_4_2);
                break;
            case 5:
                imageView.setImageResource(R.drawable.evm_5_2);
                break;
            case 6:
                imageView.setImageResource(R.drawable.evm_6_2);
                break;
            case 7:
                imageView.setImageResource(R.drawable.evm_7_2);
                break;
            case 8:
                imageView.setImageResource(R.drawable.evm_8_2);
                break;
            case 9:
                imageView.setImageResource(R.drawable.evm_9_2);
                break;
            case 10:
                imageView.setImageResource(R.drawable.evm_10_2);
                break;
            case 11:
                imageView.setImageResource(R.drawable.evm_11_2);
                break;
            case 12:
                imageView.setImageResource(R.drawable.evm_12_2);
                break;
            case 13:
                imageView.setImageResource(R.drawable.evm_13_4);
                break;
            case 14:
                imageView.setImageResource(R.drawable.evm_14);
                break;
            case 15:
                imageView.setImageResource(R.drawable.evm_15);
                break;
            case 16:
                imageView.setImageResource(R.drawable.evm_16);
                break;
            case 17:
                imageView.setImageResource(R.drawable.evm_17);
                break;
            case 18:
                imageView.setImageResource(R.drawable.evm_18);
                break;
            case 19:
                imageView.setImageResource(R.drawable.evm_19);
                break;
            default:
                imageView.setImageResource(R.drawable.evm_end);
                break;
        }
    }


}

