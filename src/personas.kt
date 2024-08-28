import java.util.Date

open class Persona(
    val dni: String,
    val nombre: String,
    val apellido: String,
    val fechaNacimiento: Date,
    val direccion: String,
    val ciudadProcedencia: String
)

class Paciente(
    dni: String,
    nombre: String,
    apellido: String,
    fechaNacimiento: Date,
    direccion: String,
    ciudadProcedencia: String,
    val numeroHistoriaClinica: String,
    val sexo: String,
    val grupoSanguineo: String,
    val medicamentosAlergicos: List<String>
) : Persona(dni, nombre, apellido, fechaNacimiento, direccion, ciudadProcedencia)

open class Empleado(
    dni: String,
    nombre: String,
    apellido: String,
    fechaNacimiento: Date,
    direccion: String,
    ciudadProcedencia: String,
    val codigoEmpleado: String,
    val horasExtras: Int,
    val fechaIngreso: Date,
    val area: String,
    val cargo: String
) : Persona(dni, nombre, apellido, fechaNacimiento, direccion, ciudadProcedencia)

open class EmpleadoPlanilla(
    dni: String,
    nombre: String,
    apellido: String,
    fechaNacimiento: Date,
    direccion: String,
    ciudadProcedencia: String,
    codigoEmpleado: String,
    horasExtras: Int,
    fechaIngreso: Date,
    area: String,
    cargo: String,
    val salarioMensual: Double,
    val porcentajeAdicionalHoraExtra: Double
) : Empleado(dni, nombre, apellido, fechaNacimiento, direccion, ciudadProcedencia, codigoEmpleado, horasExtras, fechaIngreso, area, cargo)

class EmpleadoEventual(
    dni: String,
    nombre: String,
    apellido: String,
    fechaNacimiento: Date,
    direccion: String,
    ciudadProcedencia: String,
    codigoEmpleado: String,
    horasExtras: Int,
    fechaIngreso: Date,
    area: String,
    cargo: String,
    val honorariosPorHora: Double,
    val horasTotales: Int,
    val fechaTerminoContrato: Date
) : Empleado(dni, nombre, apellido, fechaNacimiento, direccion, ciudadProcedencia, codigoEmpleado, horasExtras, fechaIngreso, area, cargo)

class Medico(
    dni: String,
    nombre: String,
    apellido: String,
    fechaNacimiento: Date,
    direccion: String,
    ciudadProcedencia: String,
    codigoEmpleado: String,
    horasExtras: Int,
    fechaIngreso: Date,
    area: String,
    cargo: String,
    salarioMensual: Double,
    porcentajeAdicionalHoraExtra: Double,
    val especialidad: String,
    val servicio: String,
    val numeroConsultorio: Int
) : EmpleadoPlanilla(dni, nombre, apellido, fechaNacimiento, direccion, ciudadProcedencia, codigoEmpleado, horasExtras, fechaIngreso, area, cargo, salarioMensual, porcentajeAdicionalHoraExtra)

class CitaMedica(
    val paciente: Paciente,
    val medico: Medico,
    val fecha: Date,
    val hora: String,
    val servicio: String
)

class Hospital {
    val empleados = mutableListOf<Empleado>()
    val pacientes = mutableListOf<Paciente>()
    val medicos = mutableListOf<Medico>()
    val citas = mutableListOf<CitaMedica>()

    fun registrarEmpleado(empleado: Empleado) {
        empleados.add(empleado)
    }

    fun registrarPaciente(paciente: Paciente) {
        pacientes.add(paciente)
    }

    fun registrarMedico(medico: Medico) {
        medicos.add(medico)
    }

    fun registrarCita(cita: CitaMedica) {
        citas.add(cita)
    }

    fun listarMedicosPorEspecialidad(especialidad: String): List<Medico> {
        return medicos.filter { it.especialidad == especialidad }
    }

    fun listarPacientesPorMedico(codigoMedico: String): List<Paciente> {
        val citasDelMedico = citas.filter { it.medico.codigoEmpleado == codigoMedico }
        return citasDelMedico.map { it.paciente }.distinct()
    }
}

