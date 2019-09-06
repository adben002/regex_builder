package com.ijt002.regexbuilder.entity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Ignore;
import org.junit.Test;

public class RegexEntityTest {

  @SuppressWarnings("static-method")
  @Ignore
  @Test
  public void regexSandbox() {
    final RegexEntity entity =
        new RegexEntityBuilder().characterClass(RegexCharacterClass.range('A', 'Z'))
            .quantity(RegexQuantifier.atLeast(0).butNotMoreThan(4)).build();
  }

  @SuppressWarnings("static-method")
  @Test
  public void testSingleDigit() {
    final RegexEntity digit =
        new RegexEntityBuilder().characterClass(RegexCharacterClass.digit()).build();
    final String digitString = digit.toString();
    assertThat(NumberUtils.INTEGER_ONE.toString().matches(digitString), equalTo(Boolean.TRUE));
    assertThat("12".matches(digitString), equalTo(Boolean.FALSE));
    assertThat("A".matches(digitString), equalTo(Boolean.FALSE));
    assertThat("Ab".matches(digitString), equalTo(Boolean.FALSE));
    assertThat(StringUtils.EMPTY.matches(digitString), equalTo(Boolean.FALSE));
  }
}
