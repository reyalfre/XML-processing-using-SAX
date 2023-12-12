public class Empleado {
    private int id;
    private String nombre;
    private int edad;
    private String sexo;
    private String categoria;

    // Constructor vacío
    public Empleado() {
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Método toString para representar la información del empleado como una cadena
     * @return los empleados
     */
    @Override
    public String toString() {
        // return "ID: " + id + "\nNombre: " + nombre + "\nEdad: " + edad + "\nSexo: " + sexo + "\nCategoría: " + categoria + "\n";
        return "Empleado{id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", sexo=" + sexo + ", categoría= " + categoria + "}";
    }
}