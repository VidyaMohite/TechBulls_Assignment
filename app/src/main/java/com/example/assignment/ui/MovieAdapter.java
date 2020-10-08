package com.example.assignment.ui;
/*
 * Dev - Vidya Jadav - 07/10/2020
 * */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.assignment.R;
import com.example.assignment.model.MovieData;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> implements Filterable {
    private ArrayList<MovieData> mArrayListMovieData;
    private ArrayList<MovieData> mFilteredListMovieData;
    private Context mContext;

    public MovieAdapter(ArrayList<MovieData> arrayList, Context context) {
        mArrayListMovieData = arrayList;
        mFilteredListMovieData = arrayList;
        this.mContext = context;
    }

    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_card, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieAdapter.ViewHolder viewHolder, int i) {
        viewHolder.tv_movie_name.setText(mFilteredListMovieData.get(i).getName());
        viewHolder.tv_movie_year.setText(mFilteredListMovieData.get(i).getYear());
        Glide.with(mContext)
                .load(mFilteredListMovieData.get(i).getImage())
                .error(R.drawable.ic_search)
                .into(viewHolder.imageViewMovieBanner);
    }

    @Override
    public int getItemCount() {
        return mFilteredListMovieData.size();
    }

    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    mFilteredListMovieData = mArrayListMovieData;
                } else {
                    ArrayList<MovieData> filteredList = new ArrayList<>();
                    for (MovieData movieData : mArrayListMovieData) {
                        if (movieData.getName().toLowerCase().contains(charString)) {
                            filteredList.add(movieData);
                        }
                    }
                    mFilteredListMovieData = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = mFilteredListMovieData;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mFilteredListMovieData = (ArrayList<MovieData>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_movie_name,tv_movie_year;
        private ImageView imageViewMovieBanner;
        public ViewHolder(View view) {
            super(view);
            tv_movie_name = (TextView)view.findViewById(R.id.tv_movie_name);
            tv_movie_year = (TextView)view.findViewById(R.id.tv_moview_year);
            imageViewMovieBanner = (ImageView) view.findViewById(R.id.imageViewMoviewBanner);
        }
    }

}
