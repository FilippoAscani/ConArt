package demo.conart.model.dao.show;

import demo.conart.model.entity.Show;

import java.util.List;

public interface ShowDao {

    void addShow(Show show);
    void updateShow(Show show);
    void deleteShow(Show show);
    List<Show> getShows();
    Show getShow(int id);

}
