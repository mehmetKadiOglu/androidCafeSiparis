package Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.mehmet.cafemmm.CafeMenuGroup;
import com.example.mehmet.cafemmm.R;

import FirebaseDataList.FirebaseList;
import de.hdodenhof.circleimageview.CircleImageView;

public class GroupAdapter extends BaseAdapter {
    CafeMenuGroup cafeMenuGroup;
    Context context;
    public GroupAdapter(Context context, CafeMenuGroup cafeMenuGroup)
    {

        setContext(context);
        setCafeMenuGroup(cafeMenuGroup);

    }

    private CafeMenuGroup getCafeMenuGroup() {
        return cafeMenuGroup;
    }

    private void setCafeMenuGroup(CafeMenuGroup cafeMenuGroup) {
        this.cafeMenuGroup = cafeMenuGroup;
    }

    private Context getContext() {
        return context;
    }

    private void setContext(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {return FirebaseList.getMenuList().getMenuHashMapKey().size();}

    @Override
    public String getItem(int position) {
        return  FirebaseList.getMenuList().getMenuHashMapKey(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) { //R.layout.row_menu_group, parent, false
        View layout = LayoutInflater.from(getContext()).inflate(R.layout.row_menu_group, viewGroup, false);
        Button button = layout.findViewById(R.id.addButton);
        final TextView  nameTextView = layout.findViewById(R.id.nameTextView);
        TextView countTextView = layout.findViewById(R.id.countTextView);
        CircleImageView groupImg = layout.findViewById(R.id.groupImgId);

        nameTextView.setText(FirebaseList.getMenuList().getMenuHashMapKey(position));
        countTextView.setText(String.valueOf(FirebaseList.getMenuList().getUrunIsimList(position).size()));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cafeMenuGroup.menuGir(nameTextView.getText().toString(), position);
            }
        });
        return layout;
    }
}
