package java16.models;

import jakarta.persistence.*;
import java16.BaseGen;
import java16.enums.Gender;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "profile")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "gen_id", sequenceName = "profile_id", allocationSize = 1)
public class Profile extends BaseGen {
    private String fullName;
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String biography;
}
