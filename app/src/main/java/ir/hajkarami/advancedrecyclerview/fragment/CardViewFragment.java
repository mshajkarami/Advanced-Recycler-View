package ir.hajkarami.advancedrecyclerview.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import ir.hajkarami.advancedrecyclerview.R;
import ir.hajkarami.advancedrecyclerview.adapter.CardAdapter;
import ir.hajkarami.advancedrecyclerview.model.PlanetsCards;

public class CardViewFragment extends Fragment {
    private RecyclerView recyclerView;
    private CardAdapter adapter;
    private ArrayList<PlanetsCards> planetsArrayList;

    public CardViewFragment() {
        // Required empty public constructor
    }

    public static CardViewFragment newInstance(String param1, String param2) {
        CardViewFragment fragment = new CardViewFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_card_view, container, false);
        InitializeCardView(view);
        return view;
    }
    private void InitializeCardView(View view) {
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        planetsArrayList = new ArrayList<>();

        adapter = new CardAdapter(getContext(), planetsArrayList);
        recyclerView.setAdapter(adapter);

        CreateDataForCards();


    }
    private void CreateDataForCards() {
        PlanetsCards planet = new PlanetsCards("Earth", 150,10,12750);
        planetsArrayList.add(planet);
        // Adding some other info
        planet = new PlanetsCards("Jupiter", 778, 26, 143000);
        planetsArrayList.add(planet);
        planet = new PlanetsCards("Mars", 228, 4, 6800);
        planetsArrayList.add(planet);
        planet = new PlanetsCards("Pluto", 5900, 1, 2320);
        planetsArrayList.add(planet);
        planet = new PlanetsCards("Venus", 108, 9, 12750);
        planetsArrayList.add(planet);
        planet = new PlanetsCards("Saturn", 1429, 11, 120000);
        planetsArrayList.add(planet);
        planet = new PlanetsCards("Mercury", 58, 4, 4900);
        planetsArrayList.add(planet);
        planet = new PlanetsCards("Neptune", 4500, 12, 50500);
        planetsArrayList.add(planet);
        planet = new PlanetsCards("Uranus", 2870, 9, 52400);
        planetsArrayList.add(planet);

        adapter.notifyDataSetChanged();

    }
}