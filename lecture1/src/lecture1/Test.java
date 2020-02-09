package lecture1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		numbers.add(10);
		numbers.add(1);
		numbers.add(2);
		numbers.add(5);
		numbers.add(7);
		System.out.println(numbers);
		Collections.sort(numbers);
		System.out.println(numbers);
		Collections.reverse(numbers);
		System.out.println(numbers);
	}

}
