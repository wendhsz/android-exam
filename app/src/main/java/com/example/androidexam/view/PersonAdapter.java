package com.example.androidexam.view;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidexam.PersonActivity;
import com.example.androidexam.R;
import com.example.androidexam.databinding.ItemPersonBinding;
import com.example.androidexam.model.Person;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder>{

    private Context context;
    private ArrayList<Person> personList;

    public PersonAdapter(Context context, ArrayList<Person> personList) {
        this.context = context;
        this.personList = personList;
    }

    public void setData(ArrayList<Person> newPersonList) {
        personList = newPersonList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPersonBinding binding =DataBindingUtil
                .inflate(
                        LayoutInflater.from(parent.getContext()),
                        R.layout.item_person,
                        parent,
                        false);

        return new PersonViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        Person person = personList.get(position);
        holder.itemPersonBinding.setPerson(person);
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder{
        private ItemPersonBinding itemPersonBinding;


        public PersonViewHolder(ItemPersonBinding itemPersonBinding) {
            super(itemPersonBinding.getRoot());
            this.itemPersonBinding = itemPersonBinding;
            itemPersonBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, PersonActivity.class);
                    intent.putExtra("person", itemPersonBinding.getPerson());
                    context.startActivity(intent);
                }
            });
        }
    }
}
