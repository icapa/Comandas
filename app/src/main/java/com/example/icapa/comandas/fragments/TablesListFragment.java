package com.example.icapa.comandas.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.icapa.comandas.R;
import com.example.icapa.comandas.model.Table;
import com.example.icapa.comandas.model.TablesRoom;

/**
 * Created by icapa on 8/12/16.
 * Fragment para representar la lista de las mesas
 */

public class TablesListFragment extends Fragment {


    private OnTableSelectedListener mOnCTableSelectedListener;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        if (TablesRoom.getSize()==0){
            TablesRoom.createTables();
        }

        View root = inflater.inflate(R.layout.fragment_table_list,container,false);
        ListView list = (ListView) root.findViewById(android.R.id.list);

        // El modelo
        //final TablesRoom tablesRoom = new TablesRoom();

        // Adaptador que pone en común el modelo y la vista
        ArrayAdapter<Table> tablesRoomArrayAdapter = new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                TablesRoom.getTables()
                );

        // Fijamos el adaptador
        list.setAdapter(tablesRoomArrayAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (mOnCTableSelectedListener != null){
                    mOnCTableSelectedListener.onTableSelectedLister(TablesRoom.getTable(position),position);
                }
            }
        });
        return root;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (getActivity() instanceof  OnTableSelectedListener) {
            mOnCTableSelectedListener = (OnTableSelectedListener) getActivity();
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (getActivity() instanceof  OnTableSelectedListener) {
            mOnCTableSelectedListener = (OnTableSelectedListener) getActivity();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mOnCTableSelectedListener = null;
    }

    public interface OnTableSelectedListener{
        void onTableSelectedLister(Table table,int position);
    }
}
