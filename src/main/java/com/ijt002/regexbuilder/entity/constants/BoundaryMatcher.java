package com.ijt002.regexbuilder.entity.constants;

public enum BoundaryMatcher {
  LINE_START("^"), LINE_END("$"), WORD("\\b"), NON_WORD("\\B"), BEGINNING_OF_INPUT(
      "\\A"), END_OF_PREVIOUS_MATCH("\\G"), END_OF_INPUT_EXCEPT_FINAL_TERMINATOR_IF_ANY(
          "\\Z"), END_OF_INPUT("\\z");

  private final String value;

  private BoundaryMatcher(final String value) {
    this.value = value;
  }

  public String value() {
    return value;
  }
}
