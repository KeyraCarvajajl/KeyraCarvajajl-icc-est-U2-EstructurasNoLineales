import Materia.controllers.ArbolBinario;

public class App {
    public static void main(String[] args) {
        ArbolBinario ab = new ArbolBinario();

        // Insertar los valores iniciales
        ab.insertar(9);
        ab.insertar(14);
        ab.insertar(17);
        ab.insertar(19);
        ab.insertar(23);
        ab.insertar(50);
        ab.insertar(54);
        ab.insertar(76);

        ab.imprimirTodo();
    }
}

