package com;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JavaStreamExample {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Rajesh","Lenin","Aravind","Vasaanth","Deshna","Moshika");
		names.stream()
			 .map(n -> n.toUpperCase())
			 .sorted()
			 .forEach(n -> System.out.println(n));
		
		List<Person> persons = 
			    Arrays.asList(
			        new Person("Rajesh", 29),
			        new Person("Lenin", 36),
			        new Person("Aravind", 29),
			        new Person("Vasanth", 31));
		
		Map<Integer, List<Person>> personByAge = persons
												 .stream()
												 .collect(Collectors.groupingBy(p -> p.age));
		
		personByAge.forEach((k,v) -> System.out.format("Age : %s : %s \n",k,v));
		
		IntSummaryStatistics ageSummary = persons
										  .stream()
										  .collect(Collectors.summarizingInt(p -> p.age));
		
		System.out.println(ageSummary);
		
		IntStream.range(1, 6).map(i -> i*i).forEach(i -> System.out.print(i+" "));

	}
}
