package com.ijt002.regexbuilder.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.math.NumberUtils;

import com.google.common.base.Preconditions;

/**
 * Quantifier class for regex character classes.
 *
 * @author Isaac
 *
 */
public final class RegexQuantifier {

  /**
   * The minimum number of times for the specified character to occur.
   */
  final Integer minimum;

  /**
   * The maximum number of times for the specified character to occur, note that if this is null
   * then there is no presumed to be no maximum.
   */
  Integer maximum;

  /**
   * The modifier of this quantifier, either greedy, reluctant or possessive.
   */
  RegexQuantifierModifier modifier;

  /**
   * Initialise the RegexQuantifier, sets the minimum value of this quantifier to the input value
   * and sets the modifier to a default of greedy.
   *
   * @param minimum the minimum value to set.
   */
  private RegexQuantifier(final Integer minimum) {
    this.minimum = minimum;
    maximum = null;
    modifier = RegexQuantifierModifier.GREEDY;
  }

  /**
   * Static factory method to create a RegexQuantifier with the input minimum and no maximum. Note
   * that greedy is the default modifier.
   *
   * @param minimum the minimum value to set.
   * @return an instance of RegexQuantifier.
   */
  public static RegexQuantifier atLeast(final Integer minimum) {
    Preconditions.checkNotNull(minimum, "Minimum should not be null.");
    Preconditions.checkArgument(minimum >= 0,
        "Minimum must be an integer value that is 0 or more.");
    return new RegexQuantifier(minimum);
  }

  /**
   * Gives this quantifier the maximum value of the input.
   *
   * @param maximum the maximum value to set.
   * @return this
   */
  public RegexQuantifier butNotMoreThan(@SuppressWarnings("hiding") final Integer maximum) {
    Preconditions.checkNotNull(maximum, "Maximum should not be null.");
    Preconditions.checkArgument(maximum >= minimum,
        "Maximum must be an integer that is greater than or equal to the minimum value.");
    this.maximum = maximum;
    return this;
  }

  public static RegexQuantifier zeroOrMore() {
    return atLeast(NumberUtils.INTEGER_ZERO);
  }

  public static RegexQuantifier oneOrMore() {
    return atLeast(NumberUtils.INTEGER_ONE);
  }

  public static RegexQuantifier exactly(final Integer value) {
    Preconditions.checkNotNull(value, "Value should not be null.");
    return atLeast(value).butNotMoreThan(value);
  }


  public RegexQuantifier greedy() {
    modifier = RegexQuantifierModifier.GREEDY;
    return this;
  }

  public RegexQuantifier reluctant() {
    modifier = RegexQuantifierModifier.RELUCTANT;
    return this;
  }

  public RegexQuantifier possessive() {
    modifier = RegexQuantifierModifier.POSSESSIVE;
    return this;
  }

  @Override
  public String toString() {
    final StringBuilder toStringBuilder = new StringBuilder("{" + minimum + ",");
    if (hasMaximum()) {
      toStringBuilder.append(maximum);
    }
    toStringBuilder.append("}");
    switch (modifier) {
      case GREEDY:
        // Default for regex
        break;
      case POSSESSIVE:
        toStringBuilder.append("?");
        break;
      case RELUCTANT:
        toStringBuilder.append("+");
        break;
      default:
        break;
    }
    return toStringBuilder.toString();
  }

  private boolean hasMaximum() {
    return maximum != null;
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 31).append(maximum).append(minimum).append(modifier)
        .toHashCode();
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
    final RegexQuantifier rhs = (RegexQuantifier) obj;
    return new EqualsBuilder().append(maximum, rhs.maximum).append(minimum, rhs.minimum)
        .append(modifier, rhs.modifier).isEquals();
  }



  private enum RegexQuantifierModifier {
    GREEDY, POSSESSIVE, RELUCTANT
  }
}
