package com.ijt002.regexbuilder;

/**
 * Default implementation of {@link RegexConstruction}.
 */
class RegexConstructionImpl implements RegexConstruction {

  /** String builder for holding the regex. */
  private final StringBuilder stringBuilder;

  /**
   * @return Newly constructed RegexConstructionImpl.
   */
  public static RegexConstructionImpl make() {
    return new RegexConstructionImpl();
  }

  /**
   * Private constructor for RegexConstructionImpl, initialise the {@link StringBuilder}.
   */
  private RegexConstructionImpl() {
    stringBuilder = new StringBuilder();
  }

  @Override
  public void addString(final String str) {
    stringBuilder.append(str);
  }

  @Override
  public void addStringWithCount(final String str, final int count) {
    stringBuilder.append(str + "{" + count + "}");
  }

  @Override
  public void addStringWithRange(final String str, final int countStart, final int countEnd) {
    stringBuilder.append(str + "{" + countStart + "," + countEnd + "}");
  }

  @Override
  public String getString() {
    return stringBuilder.toString();
  }

}
