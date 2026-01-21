package dio.web.api.entity;

import dio.web.api.DTO.bank.BankResponseDTO;
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

    public Bank(BankResponseDTO data) {
        this.ispb = data.ispb();
        this.name = data.name();
        this.code = data.code();
        this.fullName = data.fullName();
    }
}
