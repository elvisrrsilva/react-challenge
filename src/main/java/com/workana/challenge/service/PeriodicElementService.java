package com.workana.challenge.service;

import com.workana.challenge.domain.Word.WordResult;

public interface PeriodicElementService {
	WordResult match(String firstName, String lastName);
}
