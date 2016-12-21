package adt.linkedList;

import java.util.Arrays;

public class SingleLinkedListImpl<T extends Comparable<T>> implements LinkedList<T> {
 
    protected SingleLinkedListNode<T> head;
     
    public SingleLinkedListImpl() {
        this.head = new SingleLinkedListNode<T>();
    }
 
    @Override
    public boolean isEmpty() {
        return this.head.isNIL();
    }
 
    @Override
    public int size() {
    	if(this.isEmpty()) {
    		return 0;
    	}
    	
        int count = 1;
        SingleLinkedListNode<T> aux = head.getNext();
        while (!aux.equals(head)) {
            ++count;
            aux = aux.getNext();
        }
        return count;
    }
 
    @Override
    public T search(T element) {
        SingleLinkedListNode<T> aux = head;
        
        if(aux.getData().equals(element)) {
        	return aux.getData();
        }
        
        aux = aux.getNext();
       
        while (!aux.getData().equals(element) && !aux.getData().equals(this.head.getData())) {
            aux = aux.getNext();
        }
        
        if (aux.getData().equals(this.head.getData())) {
        	return null;
        } else {
        	
        	return aux.getData();
        }
        
    }
 
    @Override
    public void insert(T element) {
        SingleLinkedListNode<T> newNode = new SingleLinkedListNode(element, new SingleLinkedListNode<>());
        
        if (isEmpty()) {
        	this.head = newNode; 
        	this.head.setNext(newNode);
        } else {
            SingleLinkedListNode<T> aux = head;
           
            while (!aux.getNext().equals(this.head)) {
            	aux = aux.getNext();            	
            }
            aux.setNext(newNode);
            newNode.setNext(this.head);
        }
    }
 
    @Override
    public void remove(T element) {
    	if (this.size() == 1) {
    		this.head.setData(null);;
    		this.getHead().setNext(new SingleLinkedListNode<>());
    	}
        if (!isEmpty()) {
 
            if (this.head.getData().equals(element)) {
                this.head = this.head.getNext();
            }
 
            SingleLinkedListNode<T> prev = head;
            SingleLinkedListNode<T> aux = head.getNext();
            
            
            while (!aux.equals(this.getHead()) && !aux.getData().equals(element)) {
                prev = aux;
                aux = aux.getNext();
            }
            
 
            if (!aux.equals(this.getHead())){
                prev.setNext(aux.getNext());
                return;
             }
        }
    }
     
    @Override
    public T[] toArray(){
        T[] array = (T[]) new Comparable[this.size()];
        
        if(this.isEmpty()) {
        	return array;
        }
        
        int count = 0;
        array[count++] = this.head.getData();
        SingleLinkedListNode<T> aux = head.getNext();
        while (!aux.equals(head)) {
            array[count] = aux.getData();
            aux = aux.getNext();
            count++;
        }
         
        return array;
         
    }
 
    public SingleLinkedListNode<T> getHead() {
        return head;
    }
 
    public void setHead(SingleLinkedListNode<T> head) {
        this.head = head;
    }
 
     
}
