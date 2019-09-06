package com.ijt002.regexbuilder;

/**
 * Logic for constructing the regex.
 */
interface RegexConstruction {

  /**
   * Add a string to the regex.
   *
   * @param str String to add to the regex.
   */
  void addString(final String str);


  /**
   * Add a string to the regex.
   *
   * @param str String to add to the regex.
   * @param count Count for number of strings.
   */
  void addStringWithCount(final String str, final int count);


  /**
   * Add a string to the regex.
   *
   * @param str String to add to the regex.
   * @param countStart Start count range for number of strings.
   * @param countEnd End count range for number of strings.
   */
  void addStringWithRange(final String str, final int countStart, final int countEnd);


  /**
   * Get the constructed regex string.
   *
   * @return The constructed regex string.
   */
  String getString();

}
