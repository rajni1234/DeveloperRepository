package com.example.rajninegi.proofofconcept;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class RowAdapter extends RecyclerView.Adapter<RowAdapter.ViewHolder> {

    private final Context context;
    /**
     * Rows array
     */
    private Rows[] rows;
    /**
     * Constant for Tag
     */
    private static final String TAG = RowAdapter.class.getSimpleName();

    public RowAdapter(Context context, Rows[] rows) {
        this.context = context;
        this.rows = rows;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.single_row, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Rows myRows = rows[position];
        holder.textTitle.setText(myRows.getTitle());
        holder.textDesc.setText(myRows.getDescription());
        /*
          Picasso is a third party library used for downloading image from image url.
         */
        Picasso.with(context)
                .load(myRows.getImageHref()).error(R.drawable.picture)
                .into(holder.mImage, new Callback() {
                    @Override
                    public void onSuccess() {
                        Log.d(TAG, context.getString(R.string.downLoadSuccess));
                    }

                    @Override
                    public void onError() {
                        Log.d(TAG, context.getString(R.string.downLoadFailure));

                    }
                });


    }

    @Override
    public int getItemCount() {
        if (rows == null) {
            return 0;
        }
        return rows.length;

    }

    /**
     * Method to set rows
     * Also notify change in data
     *
     * @param rows : list row
     */
    public void setDataSource(Rows[] rows) {
        this.rows = rows;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        /**
         * Views to show json data
         */
        public final TextView textTitle;
        public final TextView textDesc;
        public final ImageView mImage;

        public ViewHolder(View itemView) {
            super(itemView);

            textTitle = itemView.findViewById(R.id.rowTitle);
            textDesc = itemView.findViewById(R.id.rowDescription);
            mImage = itemView.findViewById(R.id.rowImage);
        }
    }

}
