package com.example.safeme;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;


public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder>{
    private MyListData[] listdata;

    // RecyclerView recyclerView;
    public MyListAdapter(MyListData[] listdata) {
        this.listdata = listdata;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final MyListData myListData = listdata[position];
        holder.question.setText("@ "+listdata[position].getQuestion());
        holder.op1.setText("a. "+listdata[position].getOp1());
        holder.op2.setText("b. "+listdata[position].getOp2());
        holder.op3.setText("c. "+listdata[position].getOp3());
        holder.op4.setText("d. "+listdata[position].getOp4());
        holder.ans.setText("Ans: "+listdata[position].getAns());
        if(listdata[position].getYourans().equals(listdata[position].getOp1())){
            holder.op1.setTextColor(R.color.green);
        }else  if(listdata[position].getYourans().equals(listdata[position].getOp2())){
            holder.op2.setTextColor(R.color.green);

        }else  if(listdata[position].getYourans().equals(listdata[position].getOp3())){
            holder.op3.setTextColor(R.color.green);

        }else  if(listdata[position].getYourans().equals(listdata[position].getOp4())){
            holder.op4.setTextColor(R.color.green);

        }

    }


    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView question,op1,op2,op3,op4,ans;
        public ViewHolder(View itemView) {
            super(itemView);
            this.question = (TextView) itemView.findViewById(R.id.textView3);
            this.op1 = (TextView) itemView.findViewById(R.id.textView4);
            this.op2 = (TextView) itemView.findViewById(R.id.textView5);
            this.op3 = (TextView) itemView.findViewById(R.id.textView6);
            this.op4 = (TextView) itemView.findViewById(R.id.textView7);
            this.ans = (TextView) itemView.findViewById(R.id.textView8);
        }
    }
}