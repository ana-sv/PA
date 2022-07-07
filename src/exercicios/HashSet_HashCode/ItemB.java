package exercicios.HashSet_HashCode;

import java.util.HashSet;

class ItemB {
    private static int count = 0;
    int i;

    public ItemB(int i) {
        this.i = i;
    }

    @Override
    public int hashCode() {
        return count++;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ItemB other = (ItemB) obj;
        if (i != other.i)
            return false;
        return true;
    }

    public static void main(String[] args) {
        HashSet<ItemB> set = new HashSet<>();
        System.out.println(set.add(new ItemB(1))); // true
        System.out.println(set.add(new ItemB(2))); // true
        System.out.println(set.add(new ItemB(1))); // true
        System.out.println(set.size()); // 3
    }
}