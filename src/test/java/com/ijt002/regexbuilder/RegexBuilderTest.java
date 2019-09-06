package com.ijt002.regexbuilder;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

/**
 * Test for {@link RegexBuilder}.
 */
public class RegexBuilderTest {

  /**
   * Just call the static constructor.
   */
  @SuppressWarnings("static-method")
  @Test
  public void testConstruction() {
    RegexBuilder.make();
  }

  /**
   * Make an empty regex.
   */
  @SuppressWarnings("static-method")
  @Test
  public void testEmptyRegex() {
    final String regex = RegexBuilder.make().build();

    assertThat(regex, equalTo(""));
  }

  /**
   * Make an empty regex.
   */
  @SuppressWarnings("static-method")
  @Test
  public void testAddingSingleString() {
    final String str = "123";
    final String regex = RegexBuilder.make().addString(str).build();

    assertThat(regex, equalTo(str));
  }


  /**
   * Make an empty regex.
   */
  @SuppressWarnings("static-method")
  @Test
  public void testAddingMultipleStrings() {
    final String str = "123";
    final String str2 = "456";
    final String regex = RegexBuilder.make().addString(str).addString(str2).build();

    assertThat(regex, equalTo(str + str2));
  }


  /**
   * Make an empty regex.
   */
  @SuppressWarnings("static-method")
  @Test
  public void testMakeDigitRegex() {
    final String regex = RegexBuilder.make().digit().build();

    assertThat("1".matches(regex), equalTo(Boolean.TRUE));
    assertThat("2".matches(regex), equalTo(Boolean.TRUE));
    assertThat("9".matches(regex), equalTo(Boolean.TRUE));
    assertThat("10".matches(regex), equalTo(Boolean.FALSE));
  }


  /**
   * Make an empty regex.
   */
  @SuppressWarnings("static-method")
  @Test
  public void testMakeDigitCountRegex() {
    final String regex = RegexBuilder.make().digit(2).build();

    assertThat("1".matches(regex), equalTo(Boolean.FALSE));
    assertThat("22".matches(regex), equalTo(Boolean.TRUE));
    assertThat("99".matches(regex), equalTo(Boolean.TRUE));
    assertThat("100".matches(regex), equalTo(Boolean.FALSE));
  }


  /**
   * Make an empty regex.
   */
  @SuppressWarnings("static-method")
  @Test
  public void testMakeDigitRangeRegex() {
    final String regex = RegexBuilder.make().digit(2, 5).build();

    assertThat("1".matches(regex), equalTo(Boolean.FALSE));
    assertThat("23".matches(regex), equalTo(Boolean.TRUE));
    assertThat("99999".matches(regex), equalTo(Boolean.TRUE));
    assertThat("123456".matches(regex), equalTo(Boolean.FALSE));
  }

}
