import java.text.SimpleDateFormat
import java.util.*

fun registrarEmpleado(hospital: Hospital, dateFormat: SimpleDateFormat) {
    println("\n--- Registrar Empleado ---")
    print("CC: ")
    val dni = readLine() ?: ""
    print("Nombre: ")
    val nombre = readLine() ?: ""
    print("Apellido: ")
    val apellido = readLine() ?: ""
    print("Fecha de nacimiento (dd/MM/yyyy): ")
    val fechaNacimiento = dateFormat.parse(readLine())
    print("Dirección: ")
    val direccion = readLine() ?: ""
    print("Ciudad de procedencia: ")
    val ciudadProcedencia = readLine() ?: ""
    print("Código de empleado: ")
    val codigoEmpleado = readLine() ?: ""
    print("Horas extras: ")
    val horasExtras = readLine()?.toIntOrNull() ?: 0
    print("Fecha de ingreso (dd/MM/yyyy): ")
    val fechaIngreso = dateFormat.parse(readLine())
    print("Área: ")
    val area = readLine() ?: ""
    print("Cargo: ")
    val cargo = readLine() ?: ""
    print("Tipo de empleado (1: Planilla, 2: Eventual): ")
    when (readLine()?.toIntOrNull()) {
        1 -> {
            print("Salario mensual: ")
            val salarioMensual = readLine()?.toDoubleOrNull() ?: 0.0
            print("Porcentaje adicional por hora extra: ")
            val porcentajeAdicional = readLine()?.toDoubleOrNull() ?: 0.0
            val empleado = EmpleadoPlanilla(dni, nombre, apellido, fechaNacimiento, direccion, ciudadProcedencia,
                codigoEmpleado, horasExtras, fechaIngreso, area, cargo, salarioMensual, porcentajeAdicional)
            hospital.registrarEmpleado(empleado)
        }
        2 -> {
            print("Honorarios por hora: ")
            val honorariosPorHora = readLine()?.toDoubleOrNull() ?: 0.0
            print("Horas totales trabajadas: ")
            val horasTotales = readLine()?.toIntOrNull() ?: 0
            print("Fecha de término de contrato (dd/MM/yyyy): ")
            val fechaTermino = dateFormat.parse(readLine())
            val empleado = EmpleadoEventual(dni, nombre, apellido, fechaNacimiento, direccion, ciudadProcedencia,
                codigoEmpleado, horasExtras, fechaIngreso, area, cargo, honorariosPorHora, horasTotales, fechaTermino)
            hospital.registrarEmpleado(empleado)
        }
        else -> println("Tipo de empleado no válido.")
    }
    println("Empleado registrado con éxito.")
}

fun registrarPaciente(hospital: Hospital, dateFormat: SimpleDateFormat) {
    println("\n--- Registrar Paciente ---")
    print("CC: ")
    val dni = readLine() ?: ""
    print("Nombre: ")
    val nombre = readLine() ?: ""
    print("Apellido: ")
    val apellido = readLine() ?: ""
    print("Fecha de nacimiento (dd/MM/yyyy): ")
    val fechaNacimiento = dateFormat.parse(readLine())
    print("Dirección: ")
    val direccion = readLine() ?: ""
    print("Ciudad de procedencia: ")
    val ciudadProcedencia = readLine() ?: ""
    print("Número de historia clínica: ")
    val numeroHistoriaClinica = readLine() ?: ""
    print("Sexo: ")
    val sexo = readLine() ?: ""
    print("Grupo sanguíneo: ")
    val grupoSanguineo = readLine() ?: ""
    print("Medicamentos alérgicos (separados por coma): ")
    val medicamentosAlergicos = readLine()?.split(",")?.map { it.trim() } ?: listOf()

    val paciente = Paciente(dni, nombre, apellido, fechaNacimiento, direccion, ciudadProcedencia,
        numeroHistoriaClinica, sexo, grupoSanguineo, medicamentosAlergicos)
    hospital.registrarPaciente(paciente)
    println("Paciente registrado con éxito.")
}

fun registrarMedico(hospital: Hospital, dateFormat: SimpleDateFormat) {
    println("\n--- Registrar Médico ---")
    print("CC: ")
    val dni = readLine() ?: ""
    print("Nombre: ")
    val nombre = readLine() ?: ""
    print("Apellido: ")
    val apellido = readLine() ?: ""
    print("Fecha de nacimiento (dd/MM/yyyy): ")
    val fechaNacimiento = dateFormat.parse(readLine())
    print("Dirección: ")
    val direccion = readLine() ?: ""
    print("Ciudad de procedencia: ")
    val ciudadProcedencia = readLine() ?: ""
    print("Código de empleado: ")
    val codigoEmpleado = readLine() ?: ""
    print("Horas extras: ")
    val horasExtras = readLine()?.toIntOrNull() ?: 0
    print("Fecha de ingreso (dd/MM/yyyy): ")
    val fechaIngreso = dateFormat.parse(readLine())
    print("Área: ")
    val area = readLine() ?: ""
    print("Cargo: ")
    val cargo = readLine() ?: ""
    print("Salario mensual: ")
    val salarioMensual = readLine()?.toDoubleOrNull() ?: 0.0
    print("Porcentaje adicional por hora extra: ")
    val porcentajeAdicional = readLine()?.toDoubleOrNull() ?: 0.0
    print("Especialidad: ")
    val especialidad = readLine() ?: ""
    print("Servicio: ")
    val servicio = readLine() ?: ""
    print("Número de consultorio: ")
    val numeroConsultorio = readLine()?.toIntOrNull() ?: 0

    val medico = Medico(dni, nombre, apellido, fechaNacimiento, direccion, ciudadProcedencia,
        codigoEmpleado, horasExtras, fechaIngreso, area, cargo, salarioMensual, porcentajeAdicional,
        especialidad, servicio, numeroConsultorio)
    hospital.registrarMedico(medico)
    println("Médico registrado con éxito.")
}

fun registrarCita(hospital: Hospital, dateFormat: SimpleDateFormat) {
    println("\n--- Registrar Cita Médica ---")
    print("CC del paciente: ")
    val dniPaciente = readLine() ?: ""
    print("Código del médico: ")
    val codigoMedico = readLine() ?: ""
    print("Fecha de la cita (dd/MM/yyyy): ")
    val fechaCita = dateFormat.parse(readLine())
    print("Hora de la cita: ")
    val horaCita = readLine() ?: ""
    print("Servicio: ")
    val servicio = readLine() ?: ""

    // Aquí deberías buscar el paciente y el médico en las listas del hospital
    // Por simplicidad, crearemos objetos nuevos. En una implementación real, deberías buscarlos.
    val paciente = Paciente(dniPaciente, "", "", Date(), "", "", "", "", "", listOf())
    val medico = Medico(
        "", "", "", Date(), "", "", codigoMedico, 0, Date(), "", "",
        0.0, 0.0, "", servicio, 0
    )

    val cita = CitaMedica(paciente, medico, fechaCita, horaCita, servicio)
    hospital.registrarCita(cita)
    println("Cita médica registrada con éxito.")
}

fun listarMedicosPorEspecialidad(hospital: Hospital) {
    print("Ingrese la especialidad: ")
    val especialidad = readLine() ?: ""
    val medicos = hospital.listarMedicosPorEspecialidad(especialidad)
    if (medicos.isEmpty()) {
        println("No se encontraron médicos con esa especialidad.")
    } else {
        println("Médicos de la especialidad $especialidad:")
        medicos.forEach { println("${it.nombre} ${it.apellido} - Consultorio: ${it.numeroConsultorio}") }
    }
}

fun listarPacientesPorMedico(hospital: Hospital) {
    print("Ingrese el código del médico: ")
    val codigoMedico = readLine() ?: ""
    val pacientes = hospital.listarPacientesPorMedico(codigoMedico)
    if (pacientes.isEmpty()) {
        println("No se encontraron pacientes para este médico.")
    } else {
        println("Pacientes atendidos por el médico con código $codigoMedico:")
        pacientes.forEach { println("${it.nombre} ${it.apellido}") }
    }
}