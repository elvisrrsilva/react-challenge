package com.workana.challenge.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.workana.challenge.domain.PeriodicElement;
import com.workana.challenge.domain.Word.WordResult;
import com.workana.challenge.domain.Word.WordResult.WordHighlight;
import com.workana.challenge.domain.Word.WordResult.WordHighlight.WordHighlightRange;

/**
 * Created by: Elvis Ribeiro
 */
@Service
public class PeriodicElementServiceImpl implements PeriodicElementService {
	private final Map<String, PeriodicElement> SYMBOLS = PeriodicElement.map(); 

	@Override
	public WordResult match(String firstName, String lastName) {
		var symbols = Arrays.stream(PeriodicElement.values())
                .sorted(Comparator.comparing(PeriodicElement::symbolLength).reversed())
                .map(PeriodicElement::symbol)
//                .map(String::toLowerCase)
                .collect(Collectors.joining("|"));
        var pattern = Pattern.compile("(" + symbols + ")");
		
		var firstNameWordHighlight = match(pattern, firstName);
        var lastNameWordHighlight = match(pattern, lastName);

        return new WordResult(firstNameWordHighlight, lastNameWordHighlight);
	}

	private WordHighlight match(Pattern pattern, String word) {
		Matcher matcher = pattern.matcher(word);
//		Matcher matcher = pattern.matcher(word.toLowerCase());
		WordHighlight wordResult = new WordHighlight(word, new ArrayList<>());

		while (matcher.find()) {
			wordResult.ranges().add(new WordHighlightRange(word.substring(matcher.start(), matcher.end()),
					matcher.start(), matcher.end(), SYMBOLS.get(matcher.group())));
		}

		return wordResult;
	}
	

}
