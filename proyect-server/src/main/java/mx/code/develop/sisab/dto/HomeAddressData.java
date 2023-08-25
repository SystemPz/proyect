package mx.code.develop.sisab.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class HomeAddressData {
    private Integer id;
    private String nameAddress;
    private String location;
    private Boolean status;
}
