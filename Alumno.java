import java.util.*;

class Alumno {
    private String nombres, apellidos, curp, telefono, especialidad, direccion, correo;
    private int matricula, semestre;
    private double pagosRealizados, pagosPendientes;
    private ArrayList<String> materiasACargar;
    private ArrayList<String> materiasCargadas;
    private ArrayList<Double> calificaciones;
    private ArrayList<Double> historialPagos;

    public Alumno(String nombres, String apellidos, String curp, String telefono, String direccion, String correo) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.curp = curp;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.especialidad = "";
        this.matricula = 0;
        this.semestre = 1;
        this.pagosRealizados = 0.0;
        this.pagosPendientes = 0.0;
        this.materiasACargar = new ArrayList<>();
        this.materiasCargadas = new ArrayList<>();
        this.calificaciones = new ArrayList<>();
        this.historialPagos = new ArrayList<>();
        generarMatricula();
    }

    private void generarMatricula() {
        Random random = new Random();
        boolean matriculaExistente = true;
        while (matriculaExistente) {
            this.matricula = random.nextInt(5000) + 1000;
            // Validar si la matrícula ya existe
            matriculaExistente = false;
        }
    }

    public void agregarMateriasACargar(String materia) {
        this.materiasACargar.add(materia);
    }

    public String getNombres() {
        return nombres;
    }

    public ArrayList<String> getMateriasACargar() {
        return materiasACargar;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCurp() {
        return curp;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getCorreo() {
        return correo;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public ArrayList<Double> getCalificaciones() {
        return calificaciones;
    }

    public ArrayList<Double> getHistorialPagos() {
        return historialPagos;
    }

    public double getPagosRealizados() {
        return pagosRealizados;
    }

    public double getPagosPendientes() {
        return pagosPendientes;
    }

    public void setPagosRealizados(double pagosRealizados) {
        this.pagosRealizados = pagosRealizados;
    }

    public void setPagosPendientes(double pagosPendientes) {
        this.pagosPendientes = pagosPendientes;
    }
}