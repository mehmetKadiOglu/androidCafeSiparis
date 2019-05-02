package Adapters;

import android.content.Context;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.mehmet.cafemmm.CafeMenuGroup;
import com.example.mehmet.cafemmm.Customer;

public class Fasat {
    private GroupAdapter groupAdapter;
    private MusicAdapter musicAdapter;
    private AdminTableAdapter tableAdapter;
    private AdminMenuAdapter adminMenuAdapter;

    private static Fasat fasat;

    private Fasat(){}

    public static Fasat getNesne()
    {
        if ( fasat == null )
            fasat = new Fasat();
        return fasat;
    }

    public GroupAdapter getgroupAdapter (){return  groupAdapter;}
    public MusicAdapter getmusicAdapter (){return  musicAdapter;}
    public AdminTableAdapter gettableAdapter (){return  tableAdapter;}
    public AdminMenuAdapter getAdminMenuAdapter(){return  adminMenuAdapter;}


    public void musicAdapter(ListView listView, Context context)
    {
        musicAdapter = new MusicAdapter(context);
        listView.setAdapter(musicAdapter);
    }
    public void tableAdapter(ListView listView, Context context)
    {
        tableAdapter = new AdminTableAdapter(context);
        listView.setAdapter(tableAdapter);
    }
    public void groupAdapter(ListView listView, Context context, CafeMenuGroup cafeMenuGroup)
    {
        groupAdapter = new GroupAdapter(context, cafeMenuGroup);
        listView.setAdapter(groupAdapter);
    }
    public void customerGroupAdapter(Spinner spinner, Context context)
    {
        MusteriGroupAdapter musteriGroupAdapter = new MusteriGroupAdapter(context);
        spinner.setAdapter(musteriGroupAdapter);
    }
    public void customerMenuAdapter(ListView listView, Context context, int key, Customer customer)
    {
        CustomerMenu customerMenu = new CustomerMenu(context, key, customer);
        listView.setAdapter(customerMenu);
    }
    public void hesapAdapter(ListView listView, Context context)
    {
        HesapAdapter hesapAdapter = new HesapAdapter(context);
        listView.setAdapter(hesapAdapter);

    }
    public void adminMenu(ListView listView, Context context, int key)
    {
        adminMenuAdapter = new AdminMenuAdapter(context, key);
        listView.setAdapter(adminMenuAdapter);
    }

}
