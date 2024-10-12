public class Empleado {
    int id;
    String nombre;
    String apellido;
    char genero;
    double salario;

    public Empleado(int id, String nombre, String apellido, char genero, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.salario = salario;
    }

    // Método para mostrar la información del empleado
    public void mostrarEmpleado() {
        System.out.printf("%-5d %-20s %-20s %-10c $%-14.2f\n", id, nombre, apellido, genero, salario);
    }
}
