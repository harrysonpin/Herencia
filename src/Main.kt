//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.text.SimpleDateFormat
import java.util.Date


fun main() {
    val hospital = Hospital()
    val dateFormat = SimpleDateFormat("dd/MM/yyyy")

    while (true) {
        println("\n--- Sistema Hospitalario ---")
        println("1. Registrar empleado")
        println("2. Registrar paciente")
        println("3. Registrar médico")
        println("4. Registrar cita médica")
        println("5. Listar médicos por especialidad")
        println("6. Listar pacientes por médico")
        println("0. Salir")
        print("Seleccione una opción: ")

        when (readLine()?.toIntOrNull()) {
            1 -> registrarEmpleado(hospital, dateFormat)
            2 -> registrarPaciente(hospital, dateFormat)
            3 -> registrarMedico(hospital, dateFormat)
            4 -> registrarCita(hospital, dateFormat)
            5 -> listarMedicosPorEspecialidad(hospital)
            6 -> listarPacientesPorMedico(hospital)
            0 -> {
                println("Gracias por usar el Sistema Hospitalario.")
                return
            }
            else -> println("Opción no válida. Intente de nuevo.")
        }
    }
}
