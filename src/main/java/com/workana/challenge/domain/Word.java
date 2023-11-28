package com.workana.challenge.domain;

import java.util.List;

/**
 * Created by: Elvis Ribeiro
 */
public interface Word {
    record WordResult(WordHighlight firstName, WordHighlight lastName) {
        public record WordHighlight(String word, List<WordHighlightRange> ranges) {

            public record WordHighlightRange(String substring,
                                             int startIndex,
                                             int endIndex,
                                             PeriodicElement periodicElement) {

                public String periodicElementSymbol() {
                    return periodicElement.symbol();
                }

                public int periodicElementAtomicNumber() {
                    return periodicElement.atomicNumber();
                }
            }
        }
    }
}
