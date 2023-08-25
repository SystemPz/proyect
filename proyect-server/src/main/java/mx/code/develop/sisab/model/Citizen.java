package mx.code.develop.sisab.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.code.develop.sisab.dto.CitizenDetailData;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ciudadano")
public class Citizen {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer id;
    @Column(name = "identificador") private String identifier;
    @Column(name = "nombre") private String name;
    @Column(name = "primer_apellido") private String firstLastName;
    @Column(name = "segundo_apellido") private String secondLastName;
    @Column(name = "sexo") private String gender;

    @OneToMany(mappedBy = "citizen") Set<HomeAddress> homeAddresses;

    public Citizen(CitizenDetailData citizenData) {
        this.id =  citizenData.getId() != null ? citizenData.getId() : null;
        this.identifier = citizenData.getIdentifier();
        this.name = citizenData.getName();
        this.firstLastName = citizenData.getFirstLastName();
        this.secondLastName = citizenData.getSecondLastName();
        this.gender = citizenData.getGender();
    }
}
