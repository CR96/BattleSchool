package com.corey.endersgame.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.corey.endersgame.R;
import com.corey.endersgame.activity.ConfirmActivity;

/**
 * Populates the RecyclerView in the main activity using a ViewHolder pattern.
 */
public class ArmyAdapter extends RecyclerView.Adapter<ArmyAdapter.ViewHolder> {

    private Context mContext;

    private final String[] mNames;
    private final String[] mDescs;
    private final TypedArray mImages;
    private final int[] mColors;

    /**
     * Static ViewHolder matching the root LinearLayout in activity_main.xml
     */
    static class ViewHolder extends RecyclerView.ViewHolder {
        final LinearLayout mLinearLayout;
        ViewHolder(LinearLayout v) {
            super(v);
            mLinearLayout = v;
        }
    }

    /**
     * Populates the list of armies.
     * @param names the string array containing each army's name
     * @param descs the string array containing each army's description
     * @param images the typed array containing each army's logo
     * @param colors the integer array containing each army's color
     */
    public ArmyAdapter(
            String[] names,
            String[] descs,
            TypedArray images,
            int[] colors) {
        mNames = names;
        mDescs = descs;
        mImages = images;
        mColors = colors;
    }

    @Override
    public ArmyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();

        View v = LayoutInflater.from(mContext)
                .inflate(R.layout.item_army, parent, false);
        return new ViewHolder((LinearLayout) v);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    /**
     * Populate each entry in the RecyclerView and start ConfirmActivity when an entry is clicked
     * @param holder the custom {@link ArmyAdapter.ViewHolder} object
     * @param position the position in the list
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        LinearLayout layout = holder.mLinearLayout;
        ImageView image = (ImageView) layout.findViewById(R.id.img_army);
        TextView text = (TextView) layout.findViewById(R.id.txt_name);

        image.setImageResource(mImages.getResourceId(position, -1));
        text.setText(mNames[position]);
        text.setTextColor(mColors[position]);

        layout.setOnClickListener(v -> {
            Intent i = new Intent(mContext, ConfirmActivity.class);
            i.putExtra("army_name", mNames[position]);
            i.putExtra("army_descs", mDescs[position]);
            i.putExtra("army_image", mImages.getResourceId(position, -1));

            mContext.startActivity(i);
        });
    }

    /**
     * Fills the RecyclerView with the correct number of items.
     * @return the number of armies that appear in the list
     */
    @Override
    public int getItemCount() {
        return mNames.length;
    }
}
