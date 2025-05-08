package ir.hajkarami.advancedrecyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ir.hajkarami.advancedrecyclerview.R;
import ir.hajkarami.advancedrecyclerview.model.Employee;
import ir.hajkarami.advancedrecyclerview.model.PlanetsCards;

public class SingleAdapter extends RecyclerView.Adapter<SingleAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Employee> arrayList;
    private int checkedPosition = 0;

    public SingleAdapter(Context context , ArrayList<Employee> arrayList) {
        this.context = context ;
        this.arrayList = arrayList ;
    }

    public void SetEmployees(ArrayList<Employee> employees){
        this.arrayList = employees;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName ;
        ImageView mImageView ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
        void SetDetails (final Employee employee){
            mImageView = itemView.findViewById(R.id.imageView);
            txtName = itemView.findViewById(R.id.emp_name);
            if (checkedPosition == -1){
                mImageView.setVisibility(View.GONE);
            }else {
                if (checkedPosition == getAdapterPosition()){
                    mImageView.setVisibility(View.VISIBLE);
                }else {
                    mImageView.setVisibility(View.GONE);
                }
            }
            txtName.setText(employee.getName());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mImageView.setVisibility(View.VISIBLE);
                    if (checkedPosition != getAdapterPosition()){
                        notifyItemChanged(checkedPosition);
                        checkedPosition = getAdapterPosition();
                    }
                }
            });
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_employee , parent , false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull SingleAdapter.ViewHolder holder, int position) {
        holder.SetDetails(arrayList.get(position));
    }
    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public Employee getSelected(){
        if (checkedPosition != -1){
            return arrayList.get(checkedPosition);
        }
        return null;
    }
}
