package tr.com.project.core.services.ServiceImps;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.project.core.services.dorduncuSoru;

import java.util.Stack;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class dorduncuSoruImp implements dorduncuSoru {


    @Override
    public Stack<Integer> deleteMidWithValues() {
        Stack<Integer> stack = dummyData();
        return deleteMid(stack, stack.size(), 0);

    }


    @Override
    public Stack<Integer> deleteMid(Stack<Integer> stack, int size, int current) {
        if (!isValid(stack, size, current) || isEven(size)) {
            return stack;
        }
        Integer pop = stack.pop();
        stack = deleteMid(stack, size, current + 1);
        if (current * 2 != (size - 1)) {
            stack.push(pop);
        }
        return stack;
    }


    @Override
    public boolean isValid(Stack<Integer> stack, int size, int current) {
        if (stack.isEmpty() || size == current)
            return false;
        return true;
    }

    @Override
    public boolean isEven(int size) {
        if (size % 2 == 0)
            return true;
        return false;
    }

    public Stack<Integer> dummyData() {
        Stack<Integer> data = new Stack<>();
        for (int i = 0; i < 9; i++) {
            data.push(i);
        }
        return data;
    }

}
