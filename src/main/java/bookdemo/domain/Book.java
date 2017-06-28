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

    /**
     * Overridden method to check if instances of this class are equal.
     *
     * @param o object to compare
     * @return true if equals, false if not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        if (getId() != book.getId()) return false;
        if (getName() != null ? !getName().equals(book.getName()) : book.getName() != null) return false;
        return getGenre() != null ? getGenre().equals(book.getGenre()) : book.getGenre() == null;
    }

    /**
     * Overridden method to generate hashcode.
     *
     * @return hashcode of current instance
     */
    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getGenre() != null ? getGenre().hashCode() : 0);
        return result;
    }
}
