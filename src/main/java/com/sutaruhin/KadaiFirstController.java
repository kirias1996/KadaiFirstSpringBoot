package com.sutaruhin;

import java.util.Calendar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KadaiFirstController {
	@GetMapping("dayofweek/{searchday}")
	public String dispDayOfWeek(@PathVariable String searchday) {
		String result = "";
		int year = Integer.parseInt(searchday.substring(0, 4));
		int month = Integer.parseInt(searchday.substring(4, 6)) - 1;
		int day = Integer.parseInt(searchday.substring(6));

		Calendar cal = Calendar.getInstance();
		cal.set(year, month, day);

		switch (cal.get(Calendar.DAY_OF_WEEK)) {
		case 1:
			result = "Sunday";
			break;
		case 2:
			result = "Monday";
			break;
		case 3:
			result = "Tuesday";
			break;
		case 4:
			result = "Wednesday";
			break;
		case 5:
			result = "Thursday";
			break;
		case 6:
			result = "Friday";
			break;
		case 7:
			result = "Saturday";
			break;
		}
		return result;
	}

	@GetMapping("plus/{num1}/{num2}")
	public String calcPlus(@PathVariable int num1, @PathVariable int num2) {
		int total = 0;
		total = num1 + num2;
		return Integer.valueOf(total).toString();
	}

	@GetMapping("minus/{num1}/{num2}")
	public String calcMinus(@PathVariable int num1, @PathVariable int num2) {
		int total = 0;
		total = num1 - num2;
		return Integer.valueOf(total).toString();
	}

	@GetMapping("times/{num1}/{num2}")
	public String calcTimes(@PathVariable int num1, @PathVariable int num2) {
		int total = 0;
		total = num1 * num2;
		return Integer.valueOf(total).toString();
	}

	@GetMapping("divide/{num1}/{num2}")
	public String calcDivide(@PathVariable int num1, @PathVariable int num2) {
		int total = 0;
		try {
			total = num1 / num2;
		} catch (ArithmeticException e) {
			return "0による除算はできません";
		}
		return Integer.valueOf(total).toString();
	}

}
