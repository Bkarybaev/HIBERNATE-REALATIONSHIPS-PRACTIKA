package java16.models;

import jakarta.persistence.*;
import java16.BaseGen;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@SequenceGenerator(name = "gen_id", sequenceName = "user_id", allocationSize = 1)
public class User extends BaseGen {
    private String username;
    private String password;
    private String email;
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE}, fetch = FetchType.LAZY)
    private Profile profile;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    private List<Post>  post;

    @ManyToMany()
    @ToString.Exclude
    private List<Comment> comments;
}
