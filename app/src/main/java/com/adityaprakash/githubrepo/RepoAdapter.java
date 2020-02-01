package com.adityaprakash.githubrepo;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.MyViewHolder> {
    private List<Githubrepo> itemsArrayList;
    LayoutInflater mInflater;
    private Context mContext;


        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder
        public static class MyViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            public TextView repoName,repoDescripton;
            public CardView mCardView;
            public MyViewHolder(View v) {
                super(v);
                repoName = v.findViewById(R.id.repoName);
                repoDescripton = v.findViewById(R.id.repoDescription);

                mCardView = v.findViewById(R.id.mCardView);

            }
        }

        // Provide a suitable constructor (depends on the kind of dataset)
        public RepoAdapter(Context context, List<Githubrepo> itemsArrayList) {
            this.itemsArrayList = itemsArrayList;
            mContext =context;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public RepoAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.repo, parent, false);

            MyViewHolder vh = new MyViewHolder(v);
            return vh;


        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            final Githubrepo item = itemsArrayList.get(position);
            holder.repoName.setText(item.getName());
            holder.repoDescripton.setText(item.getDescription());


        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return itemsArrayList.size();
        }
    }

