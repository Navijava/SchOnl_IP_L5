package schoolOnline.repositories;

import schoolOnline.entities.Lecture;

public interface LectureRepositoryMeth {
    public void add(Lecture lecture);
    boolean checkSpace();
    Lecture[] increaseSpace();
    public Lecture[] getAll();
    public Lecture getById(int id);
    public boolean deleteById(int id);
    public void showAllId();
}
