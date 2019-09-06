package com.ijt002.regexbuilder.entity.constants;

public enum SpecialCharacter {

  TAB("\\t"), NEWLINE("\\n"), CARRIAGE_RETURN("\\r"), FORM_FEED("\\f"), ALERT("\\a"), ESCAPE("\\e");

  private final String value;

  private SpecialCharacter(final String value) {
    this.value = value;
  }

  public String value() {
    return value;
  }
}
