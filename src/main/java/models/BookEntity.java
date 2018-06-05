package models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "BOOKS")
@Getter
@Setter
public class BookEntity extends  BaseEntity {
    @Column(name = "TITLE", nullable = false, length = 20)
    private String title;

    @Column(name = "AUTHOR", nullable = false, length = 20)
    private String author;

    @Column(name = "PRICE", nullable = false)
    private int price;

    @Override
    public String toString() {
        return "BookEntity{" + super.toString() +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                "} \n";
    }
}
