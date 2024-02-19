import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¡Bienvenido al portal de alumnos BCA!");
        System.out.println("¿Deseas seguir con el registro al portal de alumnos BCA? (si/no)");
        String respuesta = scanner.nextLine();

        if (respuesta.equalsIgnoreCase("no")) {
            System.out.println("Gracias por visitarnos. ¡Hasta luego!");
            System.exit(0);
        } else if (respuesta.equalsIgnoreCase("si")) {
            // Continuar con el registro
            System.out.println("¡Empecemos el registro!");

            // Solicitar datos del alumno
            System.out.print("Ingrese nombres: ");
            String nombres = scanner.nextLine();
            System.out.print("Ingrese apellidos: ");
            String apellidos = scanner.nextLine();
            System.out.print("Ingrese CURP: ");
            String curp = scanner.nextLine();
            System.out.print("Ingrese teléfono: ");
            String telefono = scanner.nextLine();
            System.out.print("Ingrese dirección: ");
            String direccion = scanner.nextLine();
            System.out.print("Ingrese correo electrónico: ");
            String correo = scanner.nextLine();

            // Crear objeto Alumno con los datos ingresados
            Alumno nuevoAlumno = new Alumno(nombres, apellidos, curp, telefono, direccion, correo);

            // Confirmar datos del alumno
            System.out.println("\nDatos ingresados:");
            System.out.println("Nombres: " + nuevoAlumno.getNombres());
            System.out.println("Apellidos: " + nuevoAlumno.getApellidos());
            System.out.println("CURP: " + nuevoAlumno.getCurp());
            System.out.println("Teléfono: " + nuevoAlumno.getTelefono());
            System.out.println("Dirección: " + nuevoAlumno.getDireccion());
            System.out.println("Correo electrónico: " + nuevoAlumno.getCorreo());

            // Cargar materias
            cargarMaterias(nuevoAlumno, scanner);

            // Continuar con el proceso de registro (especialidad, pagos, etc.)
        } else {
            System.out.println("Respuesta no válida. Por favor, ingresa 'si' o 'no'.");
        }
    }

    private static void cargarMaterias(Alumno alumno, Scanner scanner) {
        List<String> materiasDisponibles = Arrays.asList(
                "Matemáticas",
                "Física",
                "Química",
                "Biología",
                "Historia",
                "Geografía",
                "Literatura",
                "Inglés"
        // Agregar más materias si es necesario
        );

        System.out.println("\nMaterias disponibles:");
        for (int i = 0; i < materiasDisponibles.size(); i++) {
            System.out.println((i + 1) + ". " + materiasDisponibles.get(i));
        }

        System.out.println("9. Cerrar carga académica");

        while (alumno.getMateriasACargar().size() < 8) {
            System.out.print("Seleccione una materia (1-9): ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            if (opcion == 9) {
                break;
            }

            if (opcion < 1 || opcion > materiasDisponibles.size()) {
                System.out.println("Opción inválida. Por favor, seleccione una materia válida.");
                continue;
            }

            String materiaSeleccionada = materiasDisponibles.get(opcion - 1);
            alumno.agregarMateriasACargar(materiaSeleccionada);
            System.out.println("Materia '" + materiaSeleccionada + "' agregada correctamente.");
        }

        System.out.println("\nMaterias cargadas:");
        for (String materia : alumno.getMateriasACargar()) {
            System.out.println("- " + materia);
        }
    }
}
