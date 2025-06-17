package Materia.controllers;

import Materia.models.Node;

public class ArbolBinario {

    private Node root;

    public ArbolBinario() {
        this.root = null;
    }

    public void insertar(int valor) {
        root = insertRec(root, valor);
    }

    // Método para insertar un nodo en el árbol binario
    private Node insertRec(Node padre, int value) {
        if (padre == null) {
            return new Node(value);
        }

        if (value < padre.getValue()) {
            padre.setLeft(insertRec(padre.getLeft(), value));
        } else if (value > padre.getValue()) {
            padre.setRight(insertRec(padre.getRight(), value));
        }

        return padre;
    }

    // Método público: imprime inOrden
    public void imprimirArbol() {
        imprimirArbol(root); // llama al método recursivo usando la raíz
        System.out.println();
    }

    // Método recursivo privado
    private void imprimirArbol(Node node) {
        if (node != null) {
            imprimirArbol(node.getLeft());
            System.out.print(node.getValue() + ", ");
            imprimirArbol(node.getRight());
        }   
    }

    // Método público: imprime en preOrden
    public void imprimirArbolPreOrden() {
        imprimirArbolPreOrden(root); 
        System.out.println();
    }

    // Mé todo recursivo privado
    private void imprimirArbolPreOrden(Node node) {
        if (node != null) {
            System.out.print(node.getValue() + ", ");
            imprimirArbolPreOrden(node.getLeft());
            imprimirArbolPreOrden(node.getRight());
        }
    }
}


