package FirebaseDataList;

import java.util.ArrayList;
import java.util.List;

public class MusicListParent extends ParentLists {
    private List<Integer> vote; // oy
    public void listClear()
    {
        super.listClear();
        vote.clear();
    }

    public  int getVote(int Id) {
        return vote.get(Id);
    }

    public List<Integer> getVote() {
        return vote;
    }

    public  void setVote() {
        vote = new ArrayList<Integer>();
    }

    public  void setVote(int Vote) {
        vote.add(Vote);
    }
}
