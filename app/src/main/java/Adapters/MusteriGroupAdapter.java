package Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mehmet.cafemmm.R;

import FirebaseDataList.FirebaseList;

public class MusteriGroupAdapter extends BaseAdapter {
    private Context context;


    public MusteriGroupAdapter(Context context) {
        setContext(context);
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }


    @Override
    public int getCount() {
        return FirebaseList.getMenuList().getMenuHashMapKey().size();
    }

    @Override
    public Object getItem(int position) {
        return FirebaseList.getMenuList().getMenuHashMapKey(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) { //R.layout.row_menu_group, parent, false
        View layout = LayoutInflater.from(getContext()).inflate(R.layout.row_customer_menu_group, viewGroup, false);
       // View layout = LayoutInflater.from(getContext()).inflate(R.layout.row_customer_menu_group, viewGroup, false);
        TextView nameTextView = layout.findViewById(R.id.nameTextView);
        TextView countTextView = layout.findViewById(R.id.countTextView);

        nameTextView.setText(FirebaseList.getMenuList().getMenuHashMapKey(position));
        countTextView.setText(String.valueOf(FirebaseList.getMenuList().getUrunIsimList(position).size()));

        return layout;
    }


}
