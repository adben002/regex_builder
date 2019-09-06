package com.ijt002.regexbuilder.entity.constants;

public enum PredefinedCharacterClass {
  DIGIT("\\d"), NON_DIGIT("\\D"), WHITESPACE("\\s"), NON_WHITESPACE("\\S"), WORD("\\w"), NON_WORD(
      "\\W"), LOWERCASE_ALPHABET("\\p{Lower}"), UPPERCASE_ALPHABET("\\p{Upper}"), ASCII(
          "\\p{ASCII}"), ALPHABET("\\p{Alpha}"), ALPHANUMERIC("\\p{Alnum}"), PUNCTUATION(
              "\\p{Punct}"), GRAPH("\\p{Graph}"), PRINT("\\p{Print}"), BLANK("\\p{Blank}"), CONTROL(
                  "\\p{Cntrl}"), HEX_DIGIT("\\p{XDigit}");

  private final String value;

  private PredefinedCharacterClass(final String value) {
    this.value = value;
  }

  public String stringValue() {
    return value;
  }
}

