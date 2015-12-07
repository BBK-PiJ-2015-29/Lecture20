package src;

/**
 * Created by ocouls01 on 07/12/2015.
 */
public class Student {
    private int id;
    private String name;
    private double score;

    public Student(int id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Id = " + getId() + " Name: " + getName() + " Score: " + getScore();
    }

    @Override
    public boolean equals(Object o) {
        if (o != null) {
            if (o instanceof Student)
                return this.getId() == ((Student) o).getId();
        }
        return false;
    }


}
