package com.workana.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workana.challenge.domain.Word.WordResult;
import com.workana.challenge.domain.Word.WordResult.WordHighlight.WordHighlightRange;
import com.workana.challenge.service.PeriodicElementService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

/**
 * Created by: Elvis Ribeiro
 */
@RestController
@RequestMapping("/api")
@Validated
public class PeriodicElementController {
	private static final String STATUS_OK = "200";
	private static final String STATUS_BAD_REQUEST = "400";

	private final PeriodicElementService periodicElementService;

	@Autowired
	public PeriodicElementController(final PeriodicElementService periodicElementService) {
		this.periodicElementService = periodicElementService;
	}

	@Operation(summary = "Process the word checking the matches with periodic table")
	@ApiResponses(value = { @ApiResponse(responseCode = STATUS_OK), @ApiResponse(responseCode = STATUS_BAD_REQUEST), })
	@PostMapping("/process")
	public Response calculate(@RequestBody @Valid final Request request) {
		return new Response(periodicElementService.match(request.firstName(), request.lastName()));
	}

	@Schema(name = "Request")
	public record Request(@NotBlank(message = "cant be null") String firstName,
			@NotBlank(message = "cant be null") String lastName) {
	}

	@Schema(name = "Response")
	public record Response(ResponseWord firstName, ResponseWord lastName) {

		public Response(final WordResult result) {
			this(new ResponseWord(result.firstName().word(),
					result.firstName().ranges().stream()
							.map(ResponseWord.ResponseWordRange::new).toList()),
					new ResponseWord(result.lastName().word(),
							result.lastName().ranges().stream()
									.map(ResponseWord.ResponseWordRange::new).toList()));
		}

		public record ResponseWord(String word, List<ResponseWordRange> highlights) {
			public record ResponseWordRange(String substring, int startIndex, int endIndex,
					String periodicElementSymbol, int periodicElementAtomicNumber) {
				ResponseWordRange(final WordHighlightRange wordHighlightRange) {
					this(wordHighlightRange.substring(), wordHighlightRange.startIndex(), wordHighlightRange.endIndex(),
							wordHighlightRange.periodicElementSymbol(),
							wordHighlightRange.periodicElementAtomicNumber());
				}
			}
		}
	}
}
