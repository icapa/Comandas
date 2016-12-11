package com.example.icapa.comandas.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.icapa.comandas.R;
import com.example.icapa.comandas.model.Dish;
import com.example.icapa.comandas.utils.ResourceUtils;

import java.util.LinkedList;

/**
 * Created by icapa on 9/12/16.
 */

public class DishesRecyclerViewAdapter extends RecyclerView.Adapter<DishesRecyclerViewAdapter.DishesViewHolder> {
    private LinkedList<Dish> mDish;
    private Context mContext;
    private OnDishClickListener mOnDishClickListener;

    public DishesRecyclerViewAdapter(LinkedList<Dish> dish, Context context, OnDishClickListener onDishClickListener) {
        super();
        mDish = dish;
        mContext = context;
        mOnDishClickListener = onDishClickListener;
    }



    @Override
    public DishesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_dishes, parent, false);
        return new DishesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DishesViewHolder holder, final int position) {
        holder.bindDish(mDish.get(position), mContext);
        holder.getView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnDishClickListener != null) {
                    mOnDishClickListener.onDishClick(position, mDish.get(position), view);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDish.size();
    }


    // ViewHolder necesario
    protected class DishesViewHolder extends RecyclerView.ViewHolder{

        private TextView mName;     // Nombre del plato
        private TextView mOrden;    // Si es primero, segundo o que
        private ImageView mDishImage;   // Imagen del plato
        private ImageView mAllerImage;  // Imagen del peligro si es alérgico
        private TextView mPrice;

        private View mView;

        public DishesViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            mName = (TextView) mView.findViewById(R.id.dish_name);
            mOrden = (TextView) mView.findViewById(R.id.dish_order);
            mDishImage = (ImageView) mView.findViewById(R.id.dish_image);
            mAllerImage = (ImageView) mView.findViewById(R.id.dish_aler);
            mPrice = (TextView) mView.findViewById(R.id.dish_price);

        }
        public void bindDish(Dish dish,Context context){
            mName.setText(dish.getName());
            mOrden.setText(dish.getDishType().toString());
            mDishImage.setImageResource(ResourceUtils.getResId(dish.getPhoto(), (Activity) context,context.getPackageName()));
            if (dish.getAllergies().size()!=0){
                mAllerImage.setImageResource(R.drawable.alergia);
            }
            mPrice.setText(String.format("%.2f €",dish.getPrice()));
        }

        public View getView() {
            return mView;
        }
    }

    //Interface
    public interface OnDishClickListener {
        public void onDishClick(int position, Dish forecast, View view);
    }

}

