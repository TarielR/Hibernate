package models;

import lombok.Data;

import javax.persistence.*;

@MappedSuperclass
@Data
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", unique = true, nullable = false, precision = 5, scale = 0)
    private Long id;

    @Override
    public String toString() {
        return "id = " + id ;
    }
}
