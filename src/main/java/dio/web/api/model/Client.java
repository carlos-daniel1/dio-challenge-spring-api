package dio.web.api.model;

import dio.web.api.DTO.client.ClientRequestDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "clients")
@EqualsAndHashCode(of = "id")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @ManyToOne
    private Bank bancoDoCliente;

    public Client(ClientRequestDTO data) {
        this.name = data.name();
        this.bancoDoCliente = data.bancoDoCliente();
    }

    public void updateFromDTO(ClientRequestDTO data) {
        this.name = data.name();
        this.bancoDoCliente = data.bancoDoCliente();
    }
}
