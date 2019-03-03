package br.com.maildesign.aprendabrincando_animaisdafazenda.adapters;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import br.com.maildesign.aprendabrincando_animaisdafazenda.R;
import br.com.maildesign.aprendabrincando_animaisdafazenda.interfaces.AnimalClickListener;
import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> mImages;
    private Context mContext;
    private AnimalClickListener animalClickListener;

    private int getmImagesPosition (String imgPosition){
        return mImages.indexOf(imgPosition);
    }

    public RecyclerViewAdapter(ArrayList<String> images, Context context, AnimalClickListener clickListener) {
        mImages = images;
        mContext = context;
        animalClickListener = clickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_list_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        Glide.with(mContext)
                .asBitmap()
                .load(mImages.get(position))
                .into(viewHolder.circleImageView);
    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        CircleImageView circleImageView;
        //    RelativeLayout parentLayout;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            circleImageView = itemView.findViewById(R.id.circle_image);
            circleImageView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int clickPosition = getAdapterPosition();
            animalClickListener.onClickAnimal(clickPosition);
        }
    }
}
