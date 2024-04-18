package hotel.demo.domain;
import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "hoteles")
public class Hoteles implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "ubicacion", nullable = false)
    private String ubicacion;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    public Hoteles() {
    }

    public Hoteles(String nombre, String ubicacion, String descripcion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
    }

}
