package pl.coderslab;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 200)
    private String title;
    //(max. 200 znaków)

    @OneToOne
    private Author author;
    //    (powiązanie relacją do klasy Author)
    //    artykuł może mieć tylko jednego autora

    @OneToMany
    private List<Category> categories;
    //    (powiązanie relacją do klasy Category)
    //    artykuł może należeć do wielu kategorii

    private String content;

    private LocalDateTime created;

    private LocalDateTime updated;

    @PrePersist
    public void prePersist() {
        created = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updated = LocalDateTime.now();
    }
}
