package Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mehmet.cafemmm.R;

import FirebaseDataList.FirebaseList;
import de.hdodenhof.circleimageview.CircleImageView;

public class MusicAdapter extends BaseAdapter {

    Context context;
    public MusicAdapter(Context context)
    {
        this.context = context;
    }
    @Override
    public int getCount() {
        return FirebaseList.getMusicList().getValueName().size();
    }

    @Override
    public String getItem(int position) {
        return FirebaseList.getMusicList().getFirebaseKey(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View layout = LayoutInflater.from(this.context).inflate(R.layout.row_music, viewGroup, false);
        TextView textView = layout.findViewById(R.id.listTextId);
        textView.setText(FirebaseList.getMusicList().getValueName(position));
        CircleImageView imageView = layout.findViewById(R.id.simge);
        Glide.with(context).load(R.drawable.music).into(imageView);
        return layout;
    }
}
