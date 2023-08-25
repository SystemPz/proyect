package mx.code.develop.sisab.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
public class CitizenDetailData {
    private Integer id;
    private String identifier;
    private String name;
    private String firstLastName;
    private String secondLastName;
    private String gender;
    private List<HomeAddressData> address;
}
