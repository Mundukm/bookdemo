package bookdemo.domain;

import javax.persistence.*;

/**
 * Table disc in database.
 */
@Entity
@Table(name = "disc")
public class Book {

    /**
     * Auto generated id column.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * The book name.
     */
    @Column(name = "name")
    private String name;

    /**
     * Many to one relation with genre.
     */
    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    private Genre genre;

    /**
     * Default constructor.
     */
    public Book() {
    }

    /**
     * Getter for genre.
     *
     * @return genre
     */
    public Genre getGenre() {
        return genre;
    }

    /**
     * Setter for genre.
     *
     * @param genre to set genre
     */
    public void setGenre(Genre genre) {
        this.genre = genre;
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
     * Shows name and genre of the book.
     */
    @Override
    public String toString() {
        return "Book{" + "name='" + name + '\'' + ", genre=" + genre + '}';
    }

}
