package com.ijt002.regexbuilder.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.ijt002.regexbuilder.entity.constants.PredefinedCharacterClass;

public final class RegexCharacterClass {

  private String regexString;

  public String getCharacterClassString() {
    return regexString;
  }

  private RegexCharacterClass(final String characterClassString) {
    regexString = characterClassString;
  }

  public static RegexCharacterClass digit() {
    return new RegexCharacterClass(PredefinedCharacterClass.DIGIT.stringValue());
  }

  public static RegexCharacterClass nonDigit() {
    return new RegexCharacterClass(PredefinedCharacterClass.NON_DIGIT.stringValue());
  }

  public static RegexCharacterClass range(final Character start, final Character end) {
    return new RegexCharacterClass(classify(start + "-" + end));
  }

  public static RegexCharacterClass anyOf(final String string) {
    return new RegexCharacterClass(classify(string));
  }

  public RegexCharacterClass union(final RegexCharacterClass characterClass) {
    regexString = classify(getCharacterClassString(), characterClass.getCharacterClassString());
    return this;
  }

  public RegexCharacterClass not() {
    regexString = classify("^", regexString);
    return this;
  }

  public RegexCharacterClass intersect(final RegexCharacterClass characterClass) {
    regexString =
        classify(getCharacterClassString(), "&&", characterClass.getCharacterClassString());
    return this;
  }

  public RegexCharacterClass subtract(final RegexCharacterClass characterClass) {
    return intersect(characterClass.not());
  }

  private static String classify(final CharSequence firstString,
      final CharSequence... remainingStrings) {
    final StringBuilder returnValue = new StringBuilder("[" + firstString);
    for (final CharSequence string : remainingStrings) {
      returnValue.append(string);
    }
    returnValue.append("]");
    return returnValue.toString();
  }

  @Override
  public String toString() {
    return regexString;
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 31).append(regexString).toHashCode();
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final RegexCharacterClass rhs = (RegexCharacterClass) obj;
    return new EqualsBuilder().append(regexString, rhs.regexString).isEquals();
  }

}
