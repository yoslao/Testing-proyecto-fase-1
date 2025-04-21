package Consultas;
public class QueueLink<E> {
    private Nodo<E> first;
    private Nodo<E> last;

    public QueueLink() {
        this.first = null;
        this.last = null;
    }

    public QueueLink(String serialized) {
        this.first = null;
        this.last = null;
        String[] items = serialized.replace("QueueLink{", "").replace("}", "").split(", ");
        for (String item : items) {
            enqueue(deserializeElement(item));
        }
    }

    public void enqueue(E x) {
        Nodo<E> aux = new Nodo<>(x);
        if (this.isEmpty()) {
            this.first = aux;
            this.last = aux;
        } else {
            this.last.setNext(aux);
            this.last = aux;
        }
    }

    public E dequeue() {
        if (this.isEmpty()) {
            return null;
        } else {
            E data = first.getData();
            first = first.getNext();
            return data;
        }
    }

    public E back() {
        return last.getData();
    }

    public E front() {
        return first.getData();
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int count() {
        int count = 0;
        Nodo<E> current = first;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Nodo<E> current = first;
        sb.append("QueueLink{");
        while (current != null) {
            sb.append(serializeElement(current.getData()));
            if (current.getNext() != null) {
                sb.append(", ");
            }
            current = current.getNext();
        }
        sb.append("}");
        return sb.toString();
    }

    private String serializeElement(E element) {
        return element.toString();
    }

    private E deserializeElement(String serialized) {
        return (E) serialized;
    }
}
