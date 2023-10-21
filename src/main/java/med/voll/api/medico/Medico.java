package med.voll.api.medico;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.direccion.DatosDireccion;
import med.voll.api.direccion.Direccion;

@Table(name="medicos")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of= "id")
public class Medico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String email;
	private String telefono;
	private String documento;
	@Enumerated(EnumType.STRING)
	private Especialidad especialidad;
	@Embedded//acoplade //armado 
	private Direccion direccion;
	 
	public Medico(DatosRegistroMedico datosRegistroMedico) {
		this.nombre = datosRegistroMedico.nombre();
		this.email = datosRegistroMedico.email();
		this.telefono = datosRegistroMedico.telefono();
		this.documento = datosRegistroMedico.documento();
		this.especialidad = datosRegistroMedico.especialidad();
		this.direccion = new Direccion(datosRegistroMedico.direccion());
	}

}
