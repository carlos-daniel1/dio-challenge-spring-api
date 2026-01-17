package dio.web.api.service;

import dio.web.api.DTO.bank.BankResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "bankAPI", url = "https://brasilapi.com.br/api/banks/v1")
public interface BankService {
    @GetMapping("/{codBank}")
    BankResponseDTO getInfoBank(@PathVariable("codBank") Integer code);
}
