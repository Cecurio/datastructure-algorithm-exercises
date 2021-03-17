
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 哈希函数：链地址法
 * 冲突处理
 * 扩容
 */
public class MyHashSet {
    // 为什么选取769这个数字？
    private static final int BASE = 769;
    private LinkedList<Integer>[] data;


    public MyHashSet(){
        data = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            data[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key){
        int h = hash(key);
        Iterator<Integer> iterator = data[h].iterator();
        while (iterator.hasNext()){
            Integer elem = iterator.next();
            if(elem == key) {
                return ;
            }
        }
        data[h].offerLast(key);
    }


    public void remove(int key){
        int h = hash(key);
        Iterator<Integer> iterator = data[h].iterator();
        while (iterator.hasNext()){
            Integer elem = iterator.next();
            if(elem == key){
                data[h].remove(elem);
                return;
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int h = hash(key);
        Iterator<Integer> iterator = data[h].iterator();
        while (iterator.hasNext()){
            Integer elem = iterator.next();
            if(elem == key){
                return true;
            }
        }
        return false;
    }

    // 哈希函数的实现
    private static int hash(int key) {
        return key % BASE;
    }


    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();
        set.add(1);
        set.add(1);
        set.add(1);
        set.add(770);
        System.out.println("done");
    }
}
