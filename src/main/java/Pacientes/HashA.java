package Pacientes;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class HashA<E extends Comparable<E>> implements Serializable {

    class Element {
        int mark;
        private Register<E> reg;
        ArbolAVL<Register<E>> tree;

        public Element(int mark, Register<E> reg) {
            this.mark = mark;
            this.reg = reg;
            this.tree = new ArbolAVL<>();
        }
    }

    ArrayList<Element> table;
    private int m;

    // Método para obtener el tamaño de la tabla
    public int getM() {
        return this.m;
    }

    public HashA(int n) {
        this.m = findPrimoCercano(n);
        this.table = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            this.table.add(new Element(0, null));
        }
    }

    private int functionHash(int key) {
        double A = (Math.sqrt(5) - 1) / 2;
        return (int) Math.floor(m * (key * A % 1));
    }

    public void insert(int key, E value) {
        int dressHash = functionHash(key);
        Register<E> rNew = new Register<>(key, value);

        Element element = this.table.get(dressHash);
        if (element.mark == 1) {
            if (element.reg.equals(rNew) || element.tree.buscarNodo(rNew) != null) {
                System.out.println("Duplicated key");
            } else {
                element.tree.insertar(rNew);
            }
        } else {
            this.table.set(dressHash, new Element(1, rNew));
        }
    }

    public void delete(int key) {
        int dressHash = functionHash(key);
        Element element = this.table.get(dressHash);

        if (element.mark == 1) {
            Register<E> rToDelete = new Register<>(key, null);

            if (element.reg.equals(rToDelete)) {
                if (element.tree.isEmpty() || element.tree.buscarNodo(rToDelete) == null) {
                    element.mark = 0;
                    element.reg = null;
                } else {
                    element.reg = element.tree.buscarNodo(rToDelete).getValor();
                    element.tree.eliminar(rToDelete);
                }
            } else if (!element.tree.isEmpty() && element.tree.buscarNodo(rToDelete) != null) {
                element.tree.eliminar(rToDelete);
            }
        }
    }

    public E search(int key) {
        int dressHash = functionHash(key);
        Element element = this.table.get(dressHash);

        if (element.mark == 1) {
            Register<E> rToSearch = new Register<>(key, null);

            if (element.reg.equals(rToSearch)) {
                return element.reg.getValue();
            } else if (!element.tree.isEmpty()) {
                ArbolAVL.NodoAVL<Register<E>> node = element.tree.buscarNodo(rToSearch);
                if (node != null) {
                    return node.getValor().getValue();
                }
            }
        }

        return null;
    }

    public Set<Integer> keys() {
        Set<Integer> keys = new HashSet<>();
        for (Element element : this.table) {
            if (element.mark == 1) {
                keys.add(element.reg.getKey());
                if (!element.tree.isEmpty()) {
                    for (ArbolAVL.NodoAVL<Register<E>> node : element.tree.inOrder()) {
                        keys.add(node.getValor().getKey());
                    }
                }
            }
        }
        return keys;
    }

    public void mostrarTabla() {
        System.out.println("Tabla Hash:");
        for (int i = 0; i < m; i++) {
            Element element = table.get(i);
            System.out.print("Posición " + i + ": ");
            if (element.mark == 1) {
                System.out.println(element.reg);
                if (!element.tree.isEmpty()) {
                    System.out.println("Colisiones: " + element.tree);
                }
            } else {
                System.out.println("Vacía");
            }
        }
    }

    private boolean esPrimo(int num) {
        if (num <= 1) return false;
        if (num <= 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        return true;
    }

    private int findPrimoCercano(int num) {
        if (num <= 1) return 2;
        int prime = num + 1;
        while (true) {
            if (esPrimo(prime)) {
                return prime;
            }
            prime++;
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("D.real\tD.hash\tRegistro\tLista\n");
        int dirReal = 0;
        for (Element item : this.table) {
            str.append(dirReal++).append("-->\t");
            if (item.mark == 1) {
                str.append(functionHash(item.reg.getKey())).append("\t").append(item.reg).append("\t");

                // Append AVL tree elements to show collision handling
                str.append("[");
                appendAVLTree(item.tree.raiz, str);
                str.append("]\n");
            } else {
                str.append("empty\n");
            }
        }
        return str.toString();
    }

    private void appendAVLTree(ArbolAVL.NodoAVL<Register<E>> node, StringBuilder str) {
        if (node != null) {
            appendAVLTree(node.izquierdo, str);
            str.append(node.getValor()).append(", ");
            appendAVLTree(node.derecho, str);
        }
    }

    // Save method
    public void save(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this.table);
        }
    }

    // Load method
    @SuppressWarnings("unchecked")
    public void load(String filename, Class<E> clazz) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            this.table = (ArrayList<Element>) ois.readObject();
        }
    }

    // Nueva función para obtener todos los objetos en la tabla hash
    public List<E> getAllElements() {
        List<E> elements = new ArrayList<>();
        for (Element element : this.table) {
            if (element.mark == 1) {
                elements.add(element.reg.getValue());
                if (!element.tree.isEmpty()) {
                    for (ArbolAVL.NodoAVL<Register<E>> node : element.tree.inOrder()) {
                        elements.add(node.getValor().getValue());
                    }
                }
            }
        }
        return elements;
    }
}
