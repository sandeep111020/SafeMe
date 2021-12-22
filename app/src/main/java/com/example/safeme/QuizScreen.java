package com.example.safeme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class QuizScreen extends AppCompatActivity {

    ArrayList<String> qes= new ArrayList<>();
    ArrayList<String> op1= new ArrayList<>();
    ArrayList<String> op2= new ArrayList<>();
    ArrayList<String> op3= new ArrayList<>();
    ArrayList<String> op4= new ArrayList<>();
    ArrayList<String> ans= new ArrayList<>();
    ArrayList<String> ansget= new ArrayList<>();

    TextView count,question;
    Button submit;
    LinearLayout layout;
    RadioButton r1,r2,r3,r4;
    RadioGroup radioGroup;
    int temp=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_screen);
        qes.add("In which of the following, a person is constantly followed/chased by another person or group of several peoples?");
        op1.add("Phishing");
        op2.add("Bulling");
        op3.add("Stalking");
        op4.add("Identity theft");
        ans.add("Stalking");
        qes.add("Which one of the following can be considered as the class of computer threats?");
        op1.add("Dos Attack");
        op2.add("Phishing");
        op3.add("Soliciting");
        op4.add("Both A and C");
        ans.add("Dos Attack");
        qes.add("Which of the following is considered as the unsolicited commercial email?");
        op1.add("Virus");
        op2.add("Malware");
        op3.add("Spam");
        op4.add("All of the Above");
        ans.add("Spam");
        qes.add("Which of the following usually observe each activity on the internet of the victim, gather all information in the background, and send it to someone else?");
        op1.add("Malware");
        op2.add("Spyware");
        op3.add("Adware");
        op4.add("All of the Above");
        ans.add("Spyware");
        qes.add("Which one of the following is a type of antivirus program?");
        op1.add("Quick heal");
        op2.add("Mcafee");
        op3.add("Kaspersky");
        op4.add("All of the above");
        ans.add("All of the above");

        radioGroup = (RadioGroup)findViewById(R.id.radio);
        count= findViewById(R.id.textView);
        question=findViewById(R.id.textView2);
        submit= findViewById(R.id.button);
        r1=findViewById(R.id.radioButton1);
        r2=findViewById(R.id.radioButton2);
        r3=findViewById(R.id.radioButton3);
        layout = findViewById(R.id.layout);
        r4=findViewById(R.id.radioButton4);
        question.setText(qes.get(0).toString()+" ");

        r1.setText(op1.get(0).toString()+ " ");
        r2.setText(op2.get(0)+" ");
        r3.setText(op3.get(0)+" ");
        r4.setText(op4.get(0)+" ");
        Toast.makeText(QuizScreen.this,
                op1.get(0)+" ebhwb",
                Toast.LENGTH_SHORT)
                .show();
        count.setText("1:");

        // Uncheck or reset the radio buttons initially

        // Add the Listener to the RadioGroup
        radioGroup.setOnCheckedChangeListener(
                new RadioGroup
                        .OnCheckedChangeListener() {
                    @Override

                    // The flow will come here when
                    // any of the radio buttons in the radioGroup
                    // has been clicked

                    // Check which radio button has been clicked
                    public void onCheckedChanged(RadioGroup group,
                                                 int checkedId)
                    {

                        // Get the selected Radio Button
                        RadioButton
                                radioButton
                                = (RadioButton)group
                                .findViewById(checkedId);
                    }
                });

        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {

                // When submit button is clicked,
                // Ge the Radio Button which is set
                // If no Radio Button is set, -1 will be returned
                int selectedId = radioGroup.getCheckedRadioButtonId();
                if (selectedId == -1) {
                    Toast.makeText(QuizScreen.this,
                            "No answer has been selected",
                            Toast.LENGTH_SHORT)
                            .show();
                }
                else {

                    RadioButton radioButton
                            = (RadioButton)radioGroup
                            .findViewById(selectedId);
                    ansget.add(radioButton.getText().toString());

                    // Now display the value of selected item
                    // by the Toast message
                    if(temp==4){
                        MyListData[] myListData = new MyListData[]{
                                new MyListData(qes.get(0),op1.get(0),op2.get(0),op3.get(0),op4.get(0),ans.get(0),ansget.get(0)),
                                new MyListData(qes.get(1),op1.get(1),op2.get(1),op3.get(1),op4.get(1),ans.get(1),ansget.get(1)),
                                new MyListData(qes.get(2),op1.get(2),op2.get(2),op3.get(2),op4.get(2),ans.get(2),ansget.get(2)),
                                new MyListData(qes.get(3),op1.get(3),op2.get(3),op3.get(3),op4.get(3),ans.get(3),ansget.get(3)),
                                new MyListData(qes.get(4),op1.get(4),op2.get(4),op3.get(4),op4.get(4),ans.get(4),ansget.get(4)),

                        };
                        layout.setVisibility(View.GONE);
                        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
                        MyListAdapter adapter = new MyListAdapter(myListData);
                        recyclerView.setLayoutManager(new LinearLayoutManager(QuizScreen.this));
                        recyclerView.setAdapter(adapter);
                    }else{
                        temp++;

                        r1.setText(op1.get(temp));
                        r2.setText(op2.get(temp));
                        r3.setText(op3.get(temp));
                        r4.setText(op4.get(temp));
                        question.setText(qes.get(temp));
                        count.setText(String.valueOf(temp+1));
                        Toast.makeText(QuizScreen.this,
                                radioButton.getText()+"   "+temp,
                                Toast.LENGTH_SHORT)
                                .show();
                    }

                }
            }
        });







    }
}