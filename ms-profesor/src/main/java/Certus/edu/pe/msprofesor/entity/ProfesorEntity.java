package Certus.edu.pe.msprofesor.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Entity
@Table(name="profesor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesor")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "sexo")
    private char sexo ;

    @Column(name = "estado")
    private Boolean estado ;
}
