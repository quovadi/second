
package com.mycompany.labt2;



class Node<T> {
        
        Node(T data) {
            this.data = data;
        }
        
        public T data;
        public Node nextLink;
    }



public class MyList<T> {
    
    public Node firstElement;
    public Node lastElement;
    public int number = 1;
    
    
    
        
    
    public MyList(T data) { //конструктор
        Node newNode = new Node(data);
        firstElement = newNode;
        lastElement = newNode;      
    }
    
    public MyList(MyList<T> copyList) { //конструктор копирования
        firstElement = new Node(copyList.firstElement.data);
        Node copyNode = copyList.firstElement;
        Node current = firstElement;
        while (copyNode.nextLink != null) {
            current.nextLink = new Node (copyNode.nextLink.data);
            current = current.nextLink;
            if (current.nextLink == null)
               lastElement = current;
            copyNode = copyNode.nextLink;
        }
        this.number = copyList.number;
    }
    
    
    public <S> void addToTop (S data) {
        Node crutch = lastElement;
        Node newNode = new Node(data);
        newNode.nextLink = firstElement;
        firstElement = newNode;
        if (crutch != null) {
            crutch.nextLink = null;
            lastElement = crutch;
            crutch = null;
        }
        number++;
    }
    
    public <S> void addToEnd (S data) {
        Node newNode = new Node(data);
        lastElement.nextLink = newNode;
        lastElement = newNode;
        number++;
    }
    
    public void deleteFromTop() {
        firstElement = firstElement.nextLink;
        number--;
        System.out.println("Элемент на вершине списка удалён");
    }
    
    public <S> void deleteValue(S compare) {
        boolean found = true;
        Node currentNode = firstElement;
        Node previousNode = firstElement;
        if (currentNode == null)
            System.out.println("Список пуст");
        else {
            while(!(currentNode.data.equals(compare))) {
                if (currentNode.nextLink == null) {
                    System.out.println("Элемент не найден");
                    found = false;
                    break;
                }    
                else {
                    previousNode = currentNode;
                    currentNode = currentNode.nextLink;
                }                
            }
            /*с помощью цикла while нашли, где находится искомый узел, который нужно удалить,
            поставили ссылки на него и на предыдущий*/
            if (found) {
                if (currentNode == firstElement)
                    firstElement = firstElement.nextLink;
                else if (currentNode == lastElement) {
                    previousNode.nextLink = null;
                    lastElement = previousNode;
                }    
                else
                    previousNode.nextLink = currentNode.nextLink;
                number--;
                System.out.println("Элемент с заданным значением удалён");
            }
        }    
    }
    
    public void deleteAll() {
        while (firstElement != null) {
            deleteFromTop();
        }
        number = 0;
        System.out.println("Все элементы списка удалены");
    }
    
    
    public int howMuch() {
        return number;
    }
    
    public void printList() {
        Node current = firstElement;
        System.out.println("first element: " + firstElement.data + " " + firstElement + " " + firstElement.nextLink);
        System.out.println("last element: " + lastElement.data + " " + lastElement + " " + lastElement.nextLink);
        for (int i = 0; i < howMuch(); i++) {
            System.out.println(current.data + " " + current + " " + current.nextLink);
            current = current.nextLink;           
        }
        System.out.println(number + " элементов всего в связном списке");
    }
    
}
