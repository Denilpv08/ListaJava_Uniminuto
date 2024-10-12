import java.util.Arrays;

public class ListaEmpleados {
    private Nodo cabeza;

    // Método para agregar un empleado a la lista
    public void agregarEmpleado(Empleado empleado) {
        Nodo nuevoNodo = new Nodo(empleado);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo temp = cabeza;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevoNodo;
        }
    }

    // Método para mostrar la lista de empleados
    public void mostrarLista() {
        Nodo temp = cabeza;
        System.out.printf("%-5s %-20s %-20s %-10s %-15s\n", "ID", "Nombre", "Apellido", "Género", "Salario");
        while (temp != null) {
            temp.empleado.mostrarEmpleado();
            temp = temp.siguiente;
        }
    }

    // Método para obtener los salarios en un array
    private double[] obtenerSalarios() {
        int n = obtenerTamaño();
        double[] salarios = new double[n];
        Nodo temp = cabeza;
        int i = 0;
        while (temp != null) {
            salarios[i++] = temp.empleado.salario;
            temp = temp.siguiente;
        }
        return salarios;
    }

    // Método para obtener el tamaño de la lista
    private int obtenerTamaño() {
        int contador = 0;
        Nodo temp = cabeza;
        while (temp != null) {
            contador++;
            temp = temp.siguiente;
        }
        return contador;
    }

    // Método para ordenar los empleados por salario
    public void ordenarPorSalario() {
        double[] salarios = obtenerSalarios();
        Arrays.sort(salarios);
        Nodo temp = cabeza;
        int i = 0;
        while (temp != null) {
            temp.empleado.salario = salarios[i++];
            temp = temp.siguiente;
        }
    }

    // Búsqueda lineal por salario
    public Nodo buscarPorSalario(double salario) {
        Nodo temp = cabeza;
        while (temp != null) {
            if (temp.empleado.salario == salario) {
                return temp;
            }
            temp = temp.siguiente;
        }
        return null;
    }

    // Búsqueda binaria por salario
    public Nodo busquedaBinaria(double salario) {
        double[] salarios = obtenerSalarios();
        Arrays.sort(salarios);
        int resultado = Arrays.binarySearch(salarios, salario);
        if (resultado >= 0) {
            return buscarPorSalario(salarios[resultado]);
        } else {
            return null;
        }
    }
}
