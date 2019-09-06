package com.ijt002.regexbuilder.entity;

public class RegexEntity {

  final RegexCharacterClass characterClass;

  final RegexQuantifier quantifier;

  RegexEntity(final RegexCharacterClass characterClass, final RegexQuantifier quantifier) {
    this.characterClass = characterClass;
    this.quantifier = quantifier;
  }

  @Override
  public String toString() {
    return characterClass.toString() + quantifier.toString();
  }



}
