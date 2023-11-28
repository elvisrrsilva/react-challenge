package com.workana.challenge.service;

import com.workana.challenge.domain.Word;
import com.workana.challenge.domain.PeriodicElement;
import com.workana.challenge.junit.AbstractIntegrationTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by: Elvis Ribeiro
 */
class PeriodicElementServiceTest extends AbstractIntegrationTest {

	@Autowired
	private PeriodicElementService periodicElementService;

	@Test
	@DisplayName("Test if the Correct result is Returned")
	void testBreakingBadResult() {
		var firstName = "Breaking";
		var lastName = "Bad";

		var result = periodicElementService.match(firstName, lastName);

		var firstNameWordHighlight = result.firstName();
		var firstNameWordHighlightRanges = firstNameWordHighlight.ranges();
		var firstNameWordHighlightRangeExpected = List.of(
				new Word.WordResult.WordHighlight.WordHighlightRange("Br", 0, 2, PeriodicElement.BROMINE),
				new Word.WordResult.WordHighlight.WordHighlightRange("k", 4, 5, PeriodicElement.POTASSIUM),
				new Word.WordResult.WordHighlight.WordHighlightRange("in", 5, 7, PeriodicElement.INDIUM));

		assertEquals(firstName, firstNameWordHighlight.word());
		assertEquals(firstNameWordHighlightRangeExpected, firstNameWordHighlightRanges);

		var lastNameWordHighlight = result.lastName();
		var lastNameWordHighlightRanges = lastNameWordHighlight.ranges();
		var lastNameHighlightRangeExpected = List
				.of(new Word.WordResult.WordHighlight.WordHighlightRange("Ba", 0, 2, PeriodicElement.BARIUM));

		assertEquals(lastName, lastNameWordHighlight.word());
		assertEquals(lastNameHighlightRangeExpected, lastNameWordHighlightRanges);
	}

	@Test
	@DisplayName("Test if all elements are matched in upper case")
	void testFullResultUpperCase() {
		var firstName = "HHELI";
		var lastName = "NOF";

		var result = periodicElementService.match(firstName, lastName);

		var firstNameWordHighlight = result.firstName();
		var firstNameWordHighlightRanges = firstNameWordHighlight.ranges();
		var firstNameWordHighlightRangeExpected = List.of(
				new Word.WordResult.WordHighlight.WordHighlightRange("H", 0, 1, PeriodicElement.HYDROGEN),
				new Word.WordResult.WordHighlight.WordHighlightRange("HE", 1, 3, PeriodicElement.HELIUM),
				new Word.WordResult.WordHighlight.WordHighlightRange("LI", 3, 5, PeriodicElement.LITHIUM));

		assertEquals(firstName, firstNameWordHighlight.word());
		assertEquals(firstNameWordHighlightRangeExpected, firstNameWordHighlightRanges);

		var lastNameWordHighlight = result.lastName();
		var lastNameWordHighlightRanges = lastNameWordHighlight.ranges();
		var lastNameHighlightRangeExpected = List.of(
				new Word.WordResult.WordHighlight.WordHighlightRange("NO", 0, 2, PeriodicElement.NOBELIUM),
				new Word.WordResult.WordHighlight.WordHighlightRange("F", 2, 3, PeriodicElement.FLUORINE));

		assertEquals(lastName, lastNameWordHighlight.word());
		assertEquals(lastNameHighlightRangeExpected, lastNameWordHighlightRanges);
	}

	@Test
	@DisplayName("Test if all elements are matched in lower case")
	void testFullResultLowerCase() {
		var firstName = "hheli";
		var lastName = "nof";

		var result = periodicElementService.match(firstName, lastName);

		var firstNameWordHighlight = result.firstName();
		var firstNameWordHighlightRanges = firstNameWordHighlight.ranges();
		var firstNameWordHighlightRangeExpected = List.of(
				new Word.WordResult.WordHighlight.WordHighlightRange("h", 0, 1, PeriodicElement.HYDROGEN),
				new Word.WordResult.WordHighlight.WordHighlightRange("he", 1, 3, PeriodicElement.HELIUM),
				new Word.WordResult.WordHighlight.WordHighlightRange("li", 3, 5, PeriodicElement.LITHIUM));

		assertEquals(firstName, firstNameWordHighlight.word());
		assertEquals(firstNameWordHighlightRangeExpected, firstNameWordHighlightRanges);

		var lastNameWordHighlight = result.lastName();
		var lastNameWordHighlightRanges = lastNameWordHighlight.ranges();
		var lastNameHighlightRangeExpected = List.of(
				new Word.WordResult.WordHighlight.WordHighlightRange("no", 0, 2, PeriodicElement.NOBELIUM),
				new Word.WordResult.WordHighlight.WordHighlightRange("f", 2, 3, PeriodicElement.FLUORINE));

		assertEquals(lastName, lastNameWordHighlight.word());
		assertEquals(lastNameHighlightRangeExpected, lastNameWordHighlightRanges);
	}

	@Test
	@DisplayName("Test if no matches")
	void testEmptyResult() {
		var firstName = "qxm";
		var lastName = "qxm";

		var result = periodicElementService.match(firstName, lastName);

		var firstNameWordHighlight = result.firstName();
		var firstNameWordHighlightRanges = firstNameWordHighlight.ranges();
		var firstNameWordHighlightRangeExpected = List.of();

		assertEquals(firstName, firstNameWordHighlight.word());
		assertEquals(firstNameWordHighlightRangeExpected, firstNameWordHighlightRanges);

		var lastNameWordHighlight = result.lastName();
		var lastNameWordHighlightRanges = lastNameWordHighlight.ranges();
		var lastNameHighlightRangeExpected = List.of();

		assertEquals(lastName, lastNameWordHighlight.word());
		assertEquals(lastNameHighlightRangeExpected, lastNameWordHighlightRanges);
	}
}