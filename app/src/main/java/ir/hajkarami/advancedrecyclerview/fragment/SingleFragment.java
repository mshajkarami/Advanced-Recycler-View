package ir.hajkarami.advancedrecyclerview.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ir.hajkarami.advancedrecyclerview.R;
import ir.hajkarami.advancedrecyclerview.adapter.CardAdapter;
import ir.hajkarami.advancedrecyclerview.adapter.SingleAdapter;
import ir.hajkarami.advancedrecyclerview.model.Employee;

public class SingleFragment extends Fragment {
    private RecyclerView recyclerView;
    private SingleAdapter adapter;
    private ArrayList<Employee> employees;

    public SingleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_single_view, container, false);
        InitializeCardView(view);
        return view;
    }

    private void InitializeCardView(View view) {
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        employees = new ArrayList<>();

        adapter = new SingleAdapter(getContext(), employees);
        recyclerView.setAdapter(adapter);

        CreateDataForList();
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (adapter.getSelected() != null){
//                    ShowToast(adapter.getSelected().getName());
//                }
//                else
//                    ShowToast("No Selection");
//            }
//        });

    }

    private void CreateDataForList() {
        employees = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Employee employee = new Employee();
            employee.setName("Employee " + (i + 1));
            employees.add(employee);
        }
        adapter.SetEmployees(employees);

    }

    private void ShowToast(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
