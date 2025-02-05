package java16.models;

import jakarta.persistence.*;
import java16.BaseGen;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "comments")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "gen_id", sequenceName = "comment_id", allocationSize = 1)
public class Comment extends BaseGen {
    private String text;
    private LocalDateTime comment_date;

    @ManyToMany(mappedBy = "comments")
    @ToString.Exclude
    private List<User> users = new ArrayList<>();

    @ManyToOne
    @ToString.Exclude
    private Post post;

    @PreUpdate
    @PrePersist
    public void prePersist() {
        comment_date = LocalDateTime.now();
    }

}
