package ir.hajkarami.advancedrecyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ir.hajkarami.advancedrecyclerview.R;
import ir.hajkarami.advancedrecyclerview.model.PlanetsCards;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    private Context context;
    private ArrayList<PlanetsCards> arrayList;

    public CardAdapter(Context context , ArrayList<PlanetsCards> arrayList) {
        this.context = context ;
        this.arrayList = arrayList ;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNameCard , txtDistanceCard , txtGravityCard , txtDiameterCard ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNameCard = itemView.findViewById(R.id.txtNameCard);
            txtDiameterCard = itemView.findViewById(R.id.txtDiameterCard);
            txtGravityCard = itemView.findViewById(R.id.txtGravityCard);
            txtDistanceCard = itemView.findViewById(R.id.txtDistanceCard);
        }
        void SetDetails (PlanetsCards planetsCards){
            if (planetsCards != null) {
                txtNameCard.setText(planetsCards.getPlanetName2());
                txtDistanceCard.setText(String.valueOf(planetsCards.getDistanceFromSun2()));
                txtGravityCard.setText(String.valueOf(planetsCards.getGravityFromSun2()));
                txtDiameterCard.setText(String.valueOf(planetsCards.getDiameters2()));
            }
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_card , parent , false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull CardAdapter.ViewHolder holder, int position) {
        holder.SetDetails(arrayList.get(position));
    }
    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
