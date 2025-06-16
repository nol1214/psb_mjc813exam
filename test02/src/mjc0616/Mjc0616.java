package mjc0616;
import java.util.ArrayList;
import java.util.List;

public class Board{
    private String title;
    private String content;

    public Board(String title, String content){
        this.title = title;
        this.content = content;
    }
    public String getTitle(){return title;}
    public String getContent(){return content;}
}
public class Mjc0616 {
    public static void main(String[] args) {
        BoardDao dao = new BoardDao();
        List<Board> list = dao.getBoardList();
        for(Board board : list) {
            System.out.println(board.getTitle()+ "-" + board.getContent());
        }
    }
}
public class BoardDao {
    public List<Board> getBoardList() {
        List<Board> list = new ArrayList<>();
        list.add(new Board("공지", "정상수업."));
        list.add(new Board("과제", "과제입니다."));
        return list;
    }
}