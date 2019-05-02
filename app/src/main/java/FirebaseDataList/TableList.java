package FirebaseDataList;

public class TableList extends TableListParent {

    private static TableList ListTable;

    private TableList(){}
    public static TableList getTableObje()
    {
        if( ListTable == null)
            ListTable = new TableList();
        return ListTable;
    }


}
