package examplesFX.teopropsjfx.model.data;

// classe para gerir os dados (no caso concreto um inteiro que varia entre 0 e 100)

public class MyModel {
    private int value;

    public MyModel(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = Math.min(Math.max(0,value),100);
    }

    public void inc() {
        if (value < 100)
            value++;
    }

    public void dec() {
        if (value > 0)
            value--;
    }
}
