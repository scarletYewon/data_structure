package ds;
import java.util.Arrays;

public class ArrayList<E> implements List<E>{
    static int DefaultSize = 10;
    E[] data;
    int listSize;

    public ArrayList(){
        this(DefaultSize);
    }
    public ArrayList(int size){
        listSize = 0;
        data = (E[]) new Object[size];
    }

    public void clear(){
        listSize = 0;
    }
    public void insert(int pos, E item){
        for (int i=listSize; i>pos; i--){
            data[i] = data[i-1];
        }
        data[pos] = item;
        listSize++;
    }
    public void append(E item){
        data[listSize++] = item;
    }
    public void update(int pos, E item){
        data[pos] = item;
    }
    public E getValue(int pos){
        return data[pos];
    }
    public E remove(int pos){
        E ret = data[pos];
        listSize--;
        for (int i=pos; i<listSize; i++){
            data[i] = data[i+1];
        }
        return ret;
    }
    public int length(){
        return listSize;
    }
    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<>();
        myList.append(3);
        System.out.println(Arrays.toString(myList.data));
        myList.append(5);
        System.out.println(Arrays.toString(myList.data));
        myList.insert(0,10);
        System.out.println(Arrays.toString(myList.data));
        myList.remove(2);
        System.out.println(Arrays.toString(myList.data));
        myList.clear();
        System.out.println(Arrays.toString(myList.data));

        ListIterator<Integer> itr = myList.listIterator();
        while(itr.hasNext()){
            System.out.print(itr.next()+" ");
        }

        System.out.println(myList.length());
    }


    public ListIterator<E> listIterator(){
        return new ListIterator<E>() {
            int pos = 0;
            public boolean hasNext(){
                return pos < listSize;
            }
            public E next(){
                return data[pos++];
            }
            public boolean hasPrevious(){
                return pos > 0;
            }
            public E previous() {
                return data[--pos];
            }
        };
    }
}