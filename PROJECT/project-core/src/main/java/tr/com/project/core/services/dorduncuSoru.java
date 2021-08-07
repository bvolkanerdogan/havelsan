package tr.com.project.core.services;

import java.util.Stack;

public interface dorduncuSoru {
    Stack<Integer> deleteMidWithValues();

    Stack<Integer> deleteMid(Stack<Integer> stack, int size, int current);

    boolean isValid(Stack<Integer> stack, int size, int current);

    boolean isEven(int size);
}
