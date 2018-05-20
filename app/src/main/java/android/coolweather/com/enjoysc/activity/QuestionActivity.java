package android.coolweather.com.enjoysc.activity;

import android.coolweather.com.enjoysc.R;
import android.coolweather.com.enjoysc.utils.ToastUtil;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

/**
 * Author:Mao
 * Time:2018/4/15  15:33
 * Description:QuestionActivity
 */
public class QuestionActivity extends BaseActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private EditText question_desc;
    private CheckBox question_type_question;
    private CheckBox question_type_suggestion;
    private Button question_submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        initView();
    }

    private void initView() {
        question_desc=(EditText)findViewById(R.id.question_desc);
        question_type_question=(CheckBox) findViewById(R.id.question_type_question);
        question_type_suggestion=(CheckBox)findViewById(R.id.question_type_suggestion);
        question_submit=(Button)findViewById(R.id.question_submit);
        question_type_question.setOnCheckedChangeListener(this);
        question_type_suggestion.setOnCheckedChangeListener(this);
        question_submit.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        //提交按钮的点击事件处理
        String type="";
        if (question_type_question.isChecked()){
            type="question";
        }
        else {
            type="suggesstion";
        }
        String desc=question_desc.getText().toString();
        if (TextUtils.isEmpty(desc)){
            ToastUtil.toast(this,"问题描述不可为空！");
        }else {
            ToastUtil.toast(this,"已经提交   "+"desc:"+desc+"type:"+type);
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()){
            case R.id.question_type_question:
                if (isChecked){
                    question_type_suggestion.setChecked(false);
                }
                break;
            case R.id.question_type_suggestion:
                if (isChecked){
                    question_type_question.setChecked(false);
                }
                break;
        }
    }

}
