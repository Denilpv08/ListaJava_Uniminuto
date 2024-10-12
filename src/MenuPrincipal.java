import java.util.Scanner;

public class MenuPrincipal {
    private ListaEmpleados listaEmpleados;

    public MenuPrincipal() {
        listaEmpleados = new ListaEmpleados();
        inicializarEmpleados();
    }

    // Método para inicializar los empleados en la lista
    private void inicializarEmpleados() {
        listaEmpleados.agregarEmpleado(new Empleado(1, "Carlos Alberto", "Martínez Rodríguez", 'M', 2952670.00));
        listaEmpleados.agregarEmpleado(new Empleado(2, "Teresa", "Nicolás Otaño", 'F', 2338617.00));
        listaEmpleados.agregarEmpleado(new Empleado(3, "Rosa Alquidia", "Lázala Polanco", 'F', 2355228.00));
        listaEmpleados.agregarEmpleado(new Empleado(4, "Ivelisse", "Estévez Ventura", 'M', 1801728.00));
        listaEmpleados.agregarEmpleado(new Empleado(5, "Margarita", "Núñez de la Cruz", 'F', 3124269.00));
        listaEmpleados.agregarEmpleado(new Empleado(6, "Belkis Josefina", "Hernández", 'F', 2975450.00));
        listaEmpleados.agregarEmpleado(new Empleado(7, "Ruth", "Ortega", 'F', 2306902.00));
        listaEmpleados.agregarEmpleado(new Empleado(8, "Lourdes", "Florentino de la Cruz", 'F', 2583729.00));
        listaEmpleados.agregarEmpleado(new Empleado(9, "Luisa", "Mejía", 'F', 2160378.00));
        listaEmpleados.agregarEmpleado(new Empleado(10, "Cándido Mercedes", "Vargas", 'M', 1961114.00));
    }

    // Método para pausar y esperar el "Enter"
    private void esperarEnter() {
        System.out.println("\nPresiona Enter para continuar...");
        Scanner sc = new Scanner(System.in);
        sc.nextLine(); // Lee el Enter para continuar
    }

    // Método para mostrar el menú de opciones
    public void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\nMenú de opciones:");
            System.out.println("1. Mostrar empleados");
            System.out.println("2. Ordenar empleados por salario");
            System.out.println("3. Búsqueda lineal por salario");
            System.out.println("4. Búsqueda binaria por salario");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    listaEmpleados.mostrarLista();
                    esperarEnter();
                    break;
                case 2:
                    listaEmpleados.ordenarPorSalario();
                    System.out.println("Empleados ordenados por salario.");
                    listaEmpleados.mostrarLista();
                    esperarEnter();
                    break;
                case 3:
                    System.out.print("Ingrese el salario a buscar (búsqueda lineal): ");
                    double salarioBuscadoLineal = sc.nextDouble();
                    Nodo resultadoLineal = listaEmpleados.buscarPorSalario(salarioBuscadoLineal);
                    if (resultadoLineal != null) {
                        System.out.printf("Empleado encontrado: %s %s con salario $%.2f\n", resultadoLineal.empleado.nombre, resultadoLineal.empleado.apellido, resultadoLineal.empleado.salario);
                    } else {
                        System.out.println("No se encontró un empleado con ese salario.");
                    }
                    esperarEnter();
                    break;
                case 4:
                    System.out.print("Ingrese el salario a buscar (búsqueda binaria): ");
                    double salarioBuscadoBinario = sc.nextDouble();
                    Nodo resultadoBinario = listaEmpleados.busquedaBinaria(salarioBuscadoBinario);
                    if (resultadoBinario != null) {
                        System.out.printf("Empleado encontrado: %s %s con salario $%.2f\n", resultadoBinario.empleado.nombre, resultadoBinario.empleado.apellido, resultadoBinario.empleado.salario);
                    } else {
                        System.out.println("No se encontró un empleado con ese salario.");
                    }
                    esperarEnter();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    esperarEnter();
                    break;
            }
        } while (opcion != 5);

        sc.close();
    }
}
