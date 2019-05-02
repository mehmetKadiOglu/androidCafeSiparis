package FirebaseDataList;

public class MusicList extends MusicListParent {

    private static MusicList ListMusic;

    private MusicList(){}

    public static MusicList getMusicList()
    {
        if(ListMusic == null)
            ListMusic = new MusicList();
        return ListMusic;
    }
}
