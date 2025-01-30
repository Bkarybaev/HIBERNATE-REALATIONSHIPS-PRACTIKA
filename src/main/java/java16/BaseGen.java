package java16;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@Getter
@MappedSuperclass
public class BaseGen {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_id")
    protected Long id;
}
