package java16.models;

import jakarta.persistence.*;
import java16.BaseGen;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "posts")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "gen_id", sequenceName = "post_id", allocationSize = 1)
public class Post extends BaseGen {
    private String imageUrl;
    @Column(length = 1000)
    private String description;
    private LocalDate createdAt;

    public Post(String imageUrl, String description) {
        this.imageUrl = imageUrl;
        this.description = description;
    }

    @ManyToOne
    @ToString.Exclude
    private User owner;

    @OneToMany(mappedBy = "post")
    @ToString.Exclude
    private List<Comment> comments = new ArrayList<>();

    @PrePersist
    @PreUpdate
    public void prePersist() {
        createdAt = LocalDate.now();
    }
}
