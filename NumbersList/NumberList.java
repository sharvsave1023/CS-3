public class NumberList {

    private Integer[] list;
    private int size;
    
    public NumberList(){
        list = new Integer[2];
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        if(size != 0){
            return false;
        }
        else{
            return true;
        }

    }

    public String toString(){
        String result = "[";
        for(int i = 0; i < size; i++){
            if(i != 0){
                result+= ",";
            }
            if(list[i] != null){
                result += list[i].toString();
            }
        }
        return result + "]";
    }

    private void doubleCapacity(){
        Integer[] list2 = new Integer[size * 2];
        for(int i = 0; i < size; i++){
            list2[i] = list[i];
        }
        list = list2;
        size();
    }

    public void add(int index, Integer val){
        if(index < 0 || index > list.length){
            throw new IndexOutOfBoundsException();
        }

        else if(size + 1 >= list.length){
            doubleCapacity();
        }

        else{
            for(int i = size; i > index; i--){
                list[i] = list[i-1];
            }
        }

        list[index] = val; 
        size++;
    }

    public boolean add(Integer element){
        add(size, element);
        return true;
    }

    public Integer get(int index){
        if(index <= size){
            return list[index];
        }
        throw new IndexOutOfBoundsException();
    }

    public Integer set(int index, Integer val){
        if(index <= size){
            int replaced_Integer = list[index];
            list[index] = val;
            return replaced_Integer;
        }
        throw new IndexOutOfBoundsException();
    }

    public Integer remove(int index){
        Integer removed_Integer = list[index];
        if(index < size){
            for(int i = index; i < size-1; i++){
                list[i] = list[i+1];
            }
            size--; return removed_Integer;
        }
            throw new IndexOutOfBoundsException();
    }
}