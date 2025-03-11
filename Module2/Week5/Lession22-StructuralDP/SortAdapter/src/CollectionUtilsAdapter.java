import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.codegym.CollectionUtils;

public class CollectionUtilsAdapter implements CollectionOperations {
    @Override
    public int findMax(Set<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("Set không được rỗng hoặc null.");
        }
        List<Integer> numberList = new ArrayList<>(numbers);
        return new CollectionUtils().findMax(numberList);
    }
}
