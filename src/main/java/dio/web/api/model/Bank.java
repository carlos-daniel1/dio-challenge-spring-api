package dio.web.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "code")
@Entity
@Table(name = "banks")
public class Bank {
    private String ispb;
    private String name;
    @Id
    private Integer code;
    private String fullName;
}
