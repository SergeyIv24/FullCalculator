package my.project.fullCalculator;

import java.util.ArrayList;
import java.util.List;

public class Stack <T> {
    private List<T> stack = new ArrayList<>();
    private int stackIterator;
    private int topOfStack = 0;

    public Stack() {
        stackIterator = -1;
    }

    public List<T> getStack() {
        return stack;
    }

    public int getStackIterator() {
        return stackIterator;
    }

    public void push(T item) {
        stack.add(item);
        stackIterator++;
    }

    public T pop() {
        if (stackIterator < 0) return null;
        T stackElem = stack.get(stackIterator);
        stack.remove(stackIterator);
        --stackIterator;
        return stackElem;
    }

}
