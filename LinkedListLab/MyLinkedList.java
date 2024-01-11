import java.util.*;
public class MyLinkedList {
    ListNode head;
    int size;
    private class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){ this.val = val;}
        @Override
        public String toString(){return "" + this.val;}
    }
    public MyLinkedList(){head = null;}
    public MyLinkedList(int val){head = new ListNode(val); size++;}
    void add(int newVal){
        if(head == null){
            head = new ListNode(newVal);
        }
        else{
            ListNode foo = this.head;
            while(foo.next != null){
                foo = foo.next;
            }
            ListNode bar = new ListNode(newVal);
            foo.next = bar;
        }
        size++;
    }
    boolean contains(int target){
        boolean does = false;
        ListNode foo = head;
        while(foo.val != target){
            if(foo.next == null){
                does = false;
                break;
            }
            foo = foo.next;
        }
        if(foo.val == target){
            does = true;
        }


        return head.val == target || does;
    }
    int get(int index){
        if(index > size){
            throw new IndexOutOfBoundsException();
        }
        else{
            ListNode foo = head;
            for(int i = 0; i < index; i++){
                foo = foo.next;
            }
            return foo.val;
        }
    }
    int indexOf(int target){
        int bar = 0;
        ListNode foo = head;
        while(foo.val != target){
            if(foo.next == null){
                return -1;
            }
            foo = foo.next;
            bar++;
        }
        return bar;
    }
    void set(int newVal, int index){
        if(index > size){
            throw new IndexOutOfBoundsException();
        }
        ListNode foo = head;
        for(int i = 0; i < index; i++){
            foo = foo.next;
        }
        foo.val = newVal;
    }
    int size(){
        return size;
    }
    int sizeRecursive(ListNode node){
        if(node == null) return 0;
        return 1 + sizeRecursive(node.next);
    }
    boolean isEmpty(){
        return size == 0;
    }
    int remove(int index){
        if(index > size){
            throw new IndexOutOfBoundsException();
        }
        int ret;
        if(index == 0){
            ret = head.val;
            head = head.next;
        }
        else{
            ListNode foo = head;
            for(int i = 0; i < index - 1; i++){
                foo = foo.next;
            }
            ret = foo.next.val;
            foo.next = foo.next.next;
        }
        size--;
        return ret;
    }
    void add (int newVal, int index){
        if(index > size){
            throw new IndexOutOfBoundsException();
        }
        ListNode foo = new ListNode(newVal);
        if(index == 0){
            foo.next = head;
            head = foo;
        }
        else{
            if(index != size){
                ListNode count = head;
                for(int i = 0; i < index - 1; i++){
                    count = count.next;
                }
                foo.next = count.next;
                count.next = foo;


            }
            if(index == size){
                ListNode count = head;
                for(int i = 0; i < size - 1; i++){
                    count=count.next;
                }
                count.next = foo;
            }
        }
        size++;
    }
    @Override
    public String toString(){
        String ret = "[";
        ListNode foo = head;
        while(foo != null){
            ret += (foo) + (foo.next != null ? ", " : "");
            foo = foo.next;
        }
        return ret + "]";
    }


}




