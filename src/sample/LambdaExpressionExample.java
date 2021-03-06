package sample;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LambdaExpressionExample {
	public static void main(String args[]) {
		LambdaExpressionExample lambdaExpressionExample = new LambdaExpressionExample();
//		lambdaExpressionExample.example1();
		 lambdaExpressionExample.example2();
	}

	interface Print {
		int prntAll(int a);
	}

	@FunctionalInterface
	interface GreetingService {
		void sayMessage(String message);
		// void sayMessage1(String message);
	}

	private int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}

	interface MathOperation {
		int operation(int a, int b);
	}

	class Addition implements MathOperation {

		@Override
		public int operation(int a, int b) {
			return a + b;
		}

	}

	private void example1() {
		LambdaExpressionExample lambdaExpressionExample = new LambdaExpressionExample();

		// with type declaration
		MathOperation addition = (int a, int b) -> a + b;

		// with out type declaration
		MathOperation subtraction = (a, b) -> a - b;

		// with return statement along with curly braces
		MathOperation multiplication = (int a, int b) -> {
			return a * b;
		};

		// without return statement and without curly braces
		MathOperation division = (int a, int b) -> a / b;

//		 System.out.println("10 + 5 = " + lambdaExpressionExample.operate(10, 5,
//		 addition));
//		 System.out.println("10 - 5 = " + lambdaExpressionExample.operate(10, 5,
//		 subtraction));
//		 System.out.println("10 x 5 = " + lambdaExpressionExample.operate(10, 5,
//		 multiplication));
//		 System.out.println("10 / 5 = " + lambdaExpressionExample.operate(10, 5,
//		 division));

//		System.out.println("10 + 5 = " + addition.operation(10, 5));
//		System.out.println("10 - 5 = " + subtraction.operation(10, 5));
//		System.out.println("10 x 5 = " + multiplication.operation(10, 5));
//		System.out.println("10 / 5 = " + division.operation(10, 5));

		// with parenthesis
		GreetingService greetService1 = message -> System.out.println("Hello " + message);

		// without parenthesis
		GreetingService greetService2 = (message) -> System.out.println("Hello " + message);

		 greetService1.sayMessage("Mahesh");
		 greetService2.sayMessage("Suresh");
	}

	GreetingService func = (demoData) -> {
		System.out.println("Printing " + demoData + " from Lambda expression.");
	};

	private void example2() {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		 System.out.println("Print all numbers:");
		 evaluate(list, (n)->true);
//		System.out.println("Print all numbers:");
//		list.stream().forEach(System.out::println);

		 System.out.println("Print no numbers:");
		 evaluate(list, (n)->false);
//		System.out.println("Print no numbers:");
//		list.stream().forEach(n -> System.out.println(""));

		 System.out.println("Print even numbers:");
		 evaluate(list, (n)-> n%2 == 0 );
//		System.out.println("Print even numbers:");
//		list.stream().filter(n -> n % 2 == 0).forEach(System.out::println);

		 System.out.println("Print odd numbers:");
		 evaluate(list, (n)-> n%2 == 1 );
//		System.out.println("Print odd numbers:");
//		list.stream().filter(n -> n % 2 != 0).forEach(System.out::println);

		 System.out.println("Print numbers greater than 5:");
		 evaluate(list, (n)-> n > 5 );
//		System.out.println("Print numbers greater than 5:");
//		list.stream().filter(n -> n > 5).forEach(System.out::println);

	}

	private void evaluate(List<Integer> list, Predicate<Integer> predicate) {
		for (Integer n : list) {
			if (predicate.test(n)) {
				System.out.println(n + " ");
			}
		}
	}
}
