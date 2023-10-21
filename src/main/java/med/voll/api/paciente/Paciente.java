package med.voll.api.paciente;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import med.voll.api.direccion.Direccion;

@Entity(name = "Paciente")
@Table(name = "pacientes")
public class Paciente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String documentoIdentidad;
	private String telefono;
	@Embedded
	private Direccion direcion;
	
	public Paciente(DatosRegistroPaciente datos) {
		
		this.nombre = datos.nombre();
		this.documentoIdentidad = datos.documentoIdentidad();
		this.telefono = datos.telefono();
		this.direcion = new Direccion(datos.direccion());
	}

}
//se agraga nuevo campo en la base de datos mediante FLyway