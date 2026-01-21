package dio.web.api.DTO.bank;

import dio.web.api.entity.Bank;

public record BankResponseDTO( String ispb, String name, Integer code,
String fullName) {

    public BankResponseDTO(Bank bank) {
        this(bank.getIspb(), bank.getName(), bank.getCode(), bank.getFullName());
    }
}
