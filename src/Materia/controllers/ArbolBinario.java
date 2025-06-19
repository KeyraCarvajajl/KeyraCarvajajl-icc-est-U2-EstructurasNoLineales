package Materia.controllers;

import Materia.models.Node;

public class ArbolBinario {

    private Node root;

    public ArbolBinario() {
        this.root = null;
    }

    public void insertar(int valor) {
        root = insertarNodo(root, valor);
    }

    private Node insertarNodo(Node nodo, int valor) {
        if (nodo == null) return new Node(valor);

        if (valor < nodo.getValue()) {
            nodo.setLeft(insertarNodo(nodo.getLeft(), valor));
        } else if (valor > nodo.getValue()) {
            nodo.setRight(insertarNodo(nodo.getRight(), valor));
        } else {
            return nodo;
        }

        nodo.setHeight(1 + Math.max(altura(nodo.getLeft()), altura(nodo.getRight())));
        int balance = balance(nodo);

        if (balance > 1 && valor < nodo.getLeft().getValue()) return rotarDerecha(nodo);
        if (balance < -1 && valor > nodo.getRight().getValue()) return rotarIzquierda(nodo);
        if (balance > 1 && valor > nodo.getLeft().getValue()) {
            nodo.setLeft(rotarIzquierda(nodo.getLeft()));
            return rotarDerecha(nodo);
        }
        if (balance < -1 && valor < nodo.getRight().getValue()) {
            nodo.setRight(rotarDerecha(nodo.getRight()));
            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    private int altura(Node nodo) {
        return (nodo == null) ? 0 : nodo.getHeight();
    }

    private int balance(Node nodo) {
        return (nodo == null) ? 0 : altura(nodo.getLeft()) - altura(nodo.getRight());
    }

    private Node rotarDerecha(Node y) {
        Node x = y.getLeft();
        Node temp = x.getRight();

        x.setRight(y);
        y.setLeft(temp);

        y.setHeight(1 + Math.max(altura(y.getLeft()), altura(y.getRight())));
        x.setHeight(1 + Math.max(altura(x.getLeft()), altura(x.getRight())));

        System.out.println("Rotación derecha en nodo " + y.getValue());
        return x;
    }

    private Node rotarIzquierda(Node x) {
        Node y = x.getRight();
        Node temp = y.getLeft();

        y.setLeft(x);
        x.setRight(temp);

        x.setHeight(1 + Math.max(altura(x.getLeft()), altura(x.getRight())));
        y.setHeight(1 + Math.max(altura(y.getLeft()), altura(y.getRight())));

        System.out.println("Rotación izquierda en nodo " + x.getValue());
        return y;
    }

    private void imprimirInOrder(Node nodo) {
        if (nodo != null) {
            imprimirInOrder(nodo.getLeft());
            System.out.print(nodo.getValue() + ", ");
            imprimirInOrder(nodo.getRight());
        }
    }

    private void imprimirAlturas(Node nodo) {
        if (nodo != null) {
            imprimirAlturas(nodo.getLeft());
            System.out.print(nodo.getValue() + "(h=" + nodo.getHeight() + "), ");
            imprimirAlturas(nodo.getRight());
        }
    }

    private void imprimirBalance(Node nodo) {
        if (nodo != null) {
            imprimirBalance(nodo.getLeft());
            int bf = nodo.getBalanceFactor();
            System.out.print(nodo.getValue() + "(bf=" + bf + "), ");
            imprimirBalance(nodo.getRight());
        }
    }

    private void mostrarDesequilibrados(Node node) {
        if (node != null) {
            mostrarDesequilibrados(node.getLeft());
            int bf = node.getBalanceFactor();
            if (Math.abs(bf) > 1) {
                System.out.print(node.getValue() + "(fE = " + bf + "), ");
            }
            mostrarDesequilibrados(node.getRight());
        }
    }

    private int contarNodos(Node node) {
        if (node == null) return 0;
        return 1 + contarNodos(node.getLeft()) + contarNodos(node.getRight());
    }

    private boolean imprimirNodosDesequilibrados(Node nodo) {
        if (nodo == null) return false;

        boolean izq = imprimirNodosDesequilibrados(nodo.getLeft());
        boolean actual = false;
        int bf = nodo.getBalanceFactor();
        if (Math.abs(bf) > 1) {
            System.out.print(nodo.getValue() + "(fE = " + bf + "), ");
            actual = true;
        }
        boolean der = imprimirNodosDesequilibrados(nodo.getRight());

        return izq || actual || der;
    }

    public void imprimirTodo() {
        System.out.println("Nombre: Keyra Cavajal\n");

        System.out.println("Peso del arbol = " + contarNodos(root));
        System.out.println("Altura es = " + altura(root) + "\n");

        System.out.println("Arbol InOrder");
        imprimirInOrder(root);
        System.out.println("\n");

        System.out.println("Arbol InOrder con alturas");
        imprimirAlturas(root);
        System.out.println("\n");

        System.out.println("Arbol InOrder con factor de equilibrio");
        imprimirBalance(root);
        System.out.println("\n");

        System.out.print("Nodos desequilibrados: ");
        imprimirNodosDesequilibrados(root);
        System.out.println("\n");
    }


} 
