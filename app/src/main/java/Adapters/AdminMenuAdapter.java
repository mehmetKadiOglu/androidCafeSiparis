package Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.mehmet.cafemmm.Customer;
import com.example.mehmet.cafemmm.R;

import FirebaseDataList.FirebaseList;
import de.hdodenhof.circleimageview.CircleImageView;

public class AdminMenuAdapter extends BaseAdapter {
    private int key;
    private Context context;

    public AdminMenuAdapter(Context context, int key) {
        this.setContext(context);
        this.setKey(key);
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return FirebaseList.getMenuList().getUrunIsimList(this.getKey()).size();
    }

    @Override
    public String getItem(int position) {
        return FirebaseList.getMenuList().getUrunIsim(this.getKey(), position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View layout = LayoutInflater.from(this.context).inflate(R.layout.row_admin_menu, viewGroup, false);
        final TextView nameTextView = layout.findViewById(R.id.nameTextView);
        final TextView countTextView = layout.findViewById(R.id.costTextView);
        CircleImageView groupImg = layout.findViewById(R.id.groupImgId);
        Button button = layout.findViewById(R.id.SiparisVerButton);
        nameTextView.setText(FirebaseList.getMenuList().getUrunIsim(this.getKey(), position));
        countTextView.setText("Fiyat= " + FirebaseList.getMenuList().getUrunFiyat(this.getKey(), position));

        return layout;
    }

}
