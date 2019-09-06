package com.ijt002.regexbuilder;

import com.ijt002.regexbuilder.entity.RegexEntityBuilder;

/**
 * The main regex builder class.
 */
public final class RegexBuilder {

  private static final String LINE_START = "^";
  private static final String LINE_END = "$";
  private static final String DIGIT = "\\d";


  /** Hold the logical construction of the regex, so we can provide a facade pattern. */
  private final RegexConstruction rCons;

  /**
   * Static constructor for RegexBuilder.
   *
   * @return Newly constructed RegexBuilder.
   */
  public static RegexBuilder make() {
    return new RegexBuilder();
  }

  /**
   * Private default constructor.
   */
  private RegexBuilder() {
    rCons = RegexConstructionImpl.make();
  }


  /**
   * Add a string to the regex.
   *
   * @param str String to add to the regex construction.
   *
   * @return Regex builder
   */
  public RegexBuilder addString(final String str) {
    rCons.addString(str);
    return this;
  }


  /**
   * Add a number to the regex.
   *
   * @return Regex builder
   */
  public RegexBuilder lineStart() {
    rCons.addString(LINE_START);
    return this;
  }


  /**
   * Add a number to the regex.
   *
   * @return Regex builder
   */
  public RegexBuilder lineEnd() {
    rCons.addString(LINE_END);
    return this;
  }


  /**
   * Add a number to the regex.
   *
   * @return Regex builder
   */
  public RegexBuilder digit() {
    rCons.addString(DIGIT);
    return this;
  }


  /**
   * Add a number to the regex.
   *
   * @param count The number of digits to match.
   *
   * @return Regex builder
   */
  public RegexBuilder digit(final int count) {
    rCons.addStringWithCount(DIGIT, count);
    return this;
  }


  /**
   * Add at least countStart digits but not more than countEnd.
   *
   * @param countStart Start count range for number of digits.
   * @param countEnd End count range for number of digits.
   *
   * @return Regex builder
   */
  public RegexBuilder digit(final int countStart, final int countEnd) {
    rCons.addStringWithRange(DIGIT, countStart, countEnd);
    return this;
  }


  /**
   * Finalise a build of the
   *
   * @return Built regex string.
   */
  public String build() {
    return rCons.getString();
  }

  public void add(final RegexEntityBuilder regexEntity) {
    rCons.addString(regexEntity.toString());
  }

}
