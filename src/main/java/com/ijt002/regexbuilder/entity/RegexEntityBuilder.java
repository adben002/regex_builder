package com.ijt002.regexbuilder.entity;

import org.apache.commons.lang3.math.NumberUtils;

import com.google.common.base.Preconditions;

/**
 * Create a single "unit" of regex. The toString() method outputs this regex which should work with
 * Java's String matching. Can be passed to RegexBuilder to build up larger regex strings.
 *
 * @author Isaac
 *
 */
public final class RegexEntityBuilder {

  private RegexCharacterClass characterClass;

  private RegexQuantifier quantifier;

  public RegexEntityBuilder characterClass(final RegexCharacterClass characterClass) {
    Preconditions.checkNotNull(characterClass, "Character class should not be null.");
    this.characterClass = characterClass;
    return this;
  }

  public RegexEntityBuilder quantity(final RegexQuantifier quantifier) {
    Preconditions.checkNotNull(quantifier, "Quantifier should not be null.");
    this.quantifier = quantifier;
    return this;
  }

  public RegexEntity build() {
    if (quantifier == null) {
      quantifier = RegexQuantifier.exactly(NumberUtils.INTEGER_ONE);
    }
    return new RegexEntity(characterClass, quantifier);
  }

}
