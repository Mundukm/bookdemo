package bookdemo.domain;

import javax.persistence.*;

/**
 * Table genre in database.
 */
@Entity
@Table(name = "genre")
public class Genre {

    /**
     * Auto generated id column.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * The genre name.
     */
    @Column(name = "name")
    private String name;

    /**
     * Default constructor.
     */
    public Genre() {
    }

    /**
     * Getter for id.
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for id.
     *
     * @param id to set id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for name.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name.
     *
     * @param name to set name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Shows name of the genre.
     */
    @Override
    public String toString() {
        return "Genre{" + "name='" + name + '\'' + '}';
    }
}
