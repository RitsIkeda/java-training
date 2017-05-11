package jpl.ch14.ex02;

class SingleLinkQueue<E> {
    class Cell {
        private Cell next;
        private E element;
        public Cell(E element) {
            this.element = element;
        }
        public Cell(E element, Cell next) {
            this.element = element;
            this.next = next;
        }
        public E getElement() {
            return element;
        }
        public Cell getNext() {
            return next;
        }
        public Cell setNext(Cell next) {
            this.next = next;
            return next;
        }
    }
    protected Cell head;
    protected Cell tail;

    public void add(E item) {
        Cell cell = new Cell(item);
        if(tail == null) {
            head = tail = cell;
        } else {
            tail.setNext(cell);
            tail = cell;
        }

    }
    public E remove() {
        if(head == null) {
            return null;
        }
        Cell cell = head;
        head = head.getNext();
        if(head == null) {
            tail = null;
        }
        return cell.getElement();
    }
    public int size() {
        int size = 0;
        if(head != null) {
            size++;
        } else {
            return 0;
        }
        Cell temp = head;
        while(temp != tail) {
            temp = temp.getNext();
        }
        return size;
    }

}
