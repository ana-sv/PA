package examples.HashSet_HashCode;

import java.util.HashSet;

class ItemA {
    int i;

    public ItemA(int i) {
        this.i = i;
    }

    @Override
    public int hashCode() {
        return i;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ItemA other = (ItemA) obj;
        if (i != other.i)
            return false;
        return true;
    }

    public static void main(String[] args) {
        HashSet<ItemA> set = new HashSet<>();
        System.out.println(set.add(new ItemA(1))); // true
        System.out.println(set.add(new ItemA(2))); // true
        System.out.println(set.add(new ItemA(1))); // false
        System.out.println(set.size()); // 2
    }
}