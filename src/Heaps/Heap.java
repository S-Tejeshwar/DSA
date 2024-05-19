package Heaps;

import java.util.ArrayList;

public class Heap<T extends Comparable<T>> {

    private ArrayList<T> list;
    public Heap() {
      list = new ArrayList<>();
    }

    private int parent(int num){
        return (num - 1) / 2;
    }

    private int left(int index) {
        return index*2 + 1;
    }

    private int right(int index) {
        return index*2 + 2;
    }

    private void swap(int index1, int index2) {
        T temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }

    private void upHeap(int index) {
        if (index == 0) {
            return;
        }

        int parent = parent(index);
        if(list.get(index).compareTo(list.get(parent)) < 0) {
            swap(index,parent);
            upHeap(parent);
        }
    }

    public void downHead(int index) {


        int min = index;
        int left = left(index);
        int right = right(index);

        if (left < list.size() && list.get(min).compareTo(list.get(left)) > 0) {
            min = left;
        }

        if (right < list.size() && list.get(min).compareTo(list.get(right)) > 0) {
            min = right;
        }
         if (min != index) {
             swap(index, min);
             downHead(min);
         }

    }


    public void insert(T value) {
        list.add(value);
        upHeap(list.size() - 1);
    }

    public T remove()  throws Exception {
        if (list.isEmpty()) {
            throw new Exception("Removing from an empty heap!");
        }
        T temp = list.get(0);
        T last = list.remove(list.size() - 1);
        if (!list.isEmpty()) {
            list.set(0, last);
            downHead(0);
        }
        return temp;
    }

    public ArrayList<T> heapSort() throws Exception {
        ArrayList<T> data = new ArrayList<>();
        while(!list.isEmpty()) {
            data.add(this.remove());
        }
        return data;
    }
}
