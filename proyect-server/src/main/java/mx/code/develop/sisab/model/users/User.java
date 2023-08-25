package mx.code.develop.sisab.model.users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "usuario")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer id;
    @Column(name = "username") private String username;
    @Column(name = "password") private String password;
    @Column(name = "nombre") private String name;
    @Column(name = "primer_apellido") private String firstLastName;
    @Column(name = "segundo_apellido") private String secondLastName;
    @Column(name = "estatus") private Integer stateSign;

}
