package com.doombox.vocabuilder.Adapters;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chauthai.swipereveallayout.SwipeRevealLayout;
import com.chauthai.swipereveallayout.ViewBinderHelper;
import com.doombox.vocabuilder.DataModels.VocabListModel;
import com.doombox.vocabuilder.MyDataBaseHelper;
import com.doombox.vocabuilder.R;
import com.doombox.vocabuilder.UpdateVocabActivity;
import com.doombox.vocabuilder.VocabListActivity;

import java.util.List;

public class AdapterVocabList extends RecyclerView.Adapter<AdapterVocabList.MyViewHolder> {

    private final Context context;
    Activity activity;
    private final List<VocabListModel> vocabList;

    VocabListActivity vocabListActivity;


    private final ViewBinderHelper viewBinderHelper = new ViewBinderHelper();

    public AdapterVocabList(Activity activity, Context context,List<VocabListModel> vocabList) {
        this.activity = activity;
        this.context = context;
        this.vocabList = vocabList;

        vocabListActivity = (VocabListActivity) context;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.vocablist_item_view,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        final VocabListModel vocabListModel = vocabList.get(position);
        if (vocabListModel==null){
            return;
        }

        final String tableId = vocabListModel.getTableId();

        viewBinderHelper.bind(holder.swipeRevealLayout, vocabListModel.getId());

        holder.wordText.setText(vocabListModel.getWord());
        holder.meaningText.setText(vocabListModel.getMeaning());
        holder.exampleText.setText(vocabListModel.getExample());

        if (!vocabListActivity.is_in_action_mode){
            holder.itemCard.setBackgroundResource(0);
            holder.isClicked = true;

        }

        holder.itemCard.setOnClickListener(v -> {


            if (vocabListActivity.is_in_action_mode){

                if (holder.isClicked){


                    if (vocabListActivity.counter>4){

                        Toast.makeText(context, "You can not get more then 5 words", Toast.LENGTH_SHORT).show();


                    } else {

                        vocabListActivity.clickSelected(holder.getAdapterPosition());
                        holder.itemCard.setBackgroundResource(R.drawable.bg_vocablist_item_selected);
                        holder.isClicked = false;
                    }

                } else {

                    vocabListActivity.clickDeSelected(holder.getAdapterPosition());
                    holder.itemCard.setBackgroundResource(R.drawable.bg_vocablist_item_deselected);
                    holder.isClicked = true;

                }


            } else {


                Dialog dialog = new Dialog(v.getRootView().getContext());
                dialog.setContentView(R.layout.dialog_single_flashcard);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

                TextView wordText = dialog.findViewById(R.id.wordText);
                TextView meaningText = dialog.findViewById(R.id.meaningText);
                TextView exampleText = dialog.findViewById(R.id.exampleText);
                View editButton = dialog.findViewById(R.id.editButtonId);

                wordText.setText(vocabListModel.getWord());
                meaningText.setText(vocabListModel.getMeaning());
                exampleText.setText(vocabListModel.getExample());

                editButton.setOnClickListener(v1 -> {
                    Intent intent = new Intent(context, UpdateVocabActivity.class);
                    intent.putExtra("tableName",vocabListModel.getTableId());
                    intent.putExtra("id",vocabListModel.getId());
                    intent.putExtra("word",vocabListModel.getWord());
                    intent.putExtra("meaning",vocabListModel.getMeaning());
                    intent.putExtra("example",vocabListModel.getExample());
                    activity.startActivityForResult(intent,1);

                });

            }






        });
        if (tableId.equals("1")){


            holder.learnedBtn.setOnClickListener(v -> {


                MyDataBaseHelper myDataBaseHelper = new MyDataBaseHelper(context);
                String dataPosition = String.valueOf((vocabListModel.getId()));


                myDataBaseHelper.deleteOneRowToLearn(dataPosition);
                myDataBaseHelper.insertDataLearned(vocabListModel.getWord(),vocabListModel.getMeaning(),vocabListModel.getExample());
                vocabList.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());

            });

            holder.deleteBtn.setOnClickListener(v -> {

                MyDataBaseHelper myDataBaseHelper = new MyDataBaseHelper(context);
                String dataPosition = String.valueOf((vocabListModel.getId()));


                myDataBaseHelper.deleteOneRowToLearn(dataPosition);
                vocabList.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());

            });

        }
        else if (tableId.equals("2")){

            holder.learnedBtn.setVisibility(View.GONE);

            holder.deleteBtn.setOnClickListener(v -> {

                MyDataBaseHelper myDataBaseHelper = new MyDataBaseHelper(context);
                String dataPosition = String.valueOf((vocabListModel.getId()));

                myDataBaseHelper.deleteOneRowLearned(dataPosition);

                vocabList.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());

            });


        }




    }

    @Override
    public int getItemCount() {
        return vocabList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private final SwipeRevealLayout swipeRevealLayout;
        private final Button learnedBtn;
        private final Button deleteBtn;
        TextView wordText, meaningText, exampleText;
        public View itemCard;

        boolean isClicked = true;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            swipeRevealLayout = itemView.findViewById(R.id.swipeRevealLayout);
            learnedBtn = itemView.findViewById(R.id.learnedBtnId);
            deleteBtn = itemView.findViewById(R.id.deleteBtnId);
            itemCard = itemView.findViewById(R.id.clickLayoutId);

            wordText = itemView.findViewById(R.id.wordTextId);
            meaningText = itemView.findViewById(R.id.meaningTextId);
            exampleText = itemView.findViewById(R.id.exampleTextId);


        }
    }



}
