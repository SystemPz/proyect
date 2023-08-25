package mx.code.develop.sisab.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.code.develop.sisab.dto.HomeAddressData;

import javax.persistence.*;
import java.util.Date;
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "domicilio")
public class HomeAddress {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer id;
    @Column(name = "create_at", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") private Date timestamp;
    @Column(name = "nombre") private String nameAddress;
    @Column(name = "localidad") private String location;
    @Column(name = "estatus") private Boolean status;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "ciudadano_id") private Citizen citizen;

    public HomeAddress(HomeAddressData address, Citizen citizen) {
        this.id = address.getId() != null ? address.getId() : null;
        this.nameAddress = address.getNameAddress();
        this.location = address.getLocation();
        this.status = address.getStatus();
        this.citizen = citizen;
    }
}
