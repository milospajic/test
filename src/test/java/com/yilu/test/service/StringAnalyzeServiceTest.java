package com.yilu.test.service;

import org.junit.Test;

public class StringAnalyzeServiceTest {

  private StringAnalyzeService stringAnalyzeService =new StringAnalyzeService();

  //first task tests
  @Test
  public void thatFirstNonRepeatedCharacterIsFound()
  {
    assert stringAnalyzeService.findFirstNonRepeating("milosmil").get() ==  'o';
  }

  @Test
  public void thatInputStringDoesntHaveNonRepeatingCharacter()
  {
    assert stringAnalyzeService.findFirstNonRepeating("milosmilos").isEmpty();

    assert stringAnalyzeService.findFirstNonRepeating("").isEmpty();
  }

  @Test(expected = IllegalArgumentException.class)
  public void thatNullObjectIsInvalidInput()
  {
    stringAnalyzeService.findFirstNonRepeating(null);
  }

  ///////////
  // second task
  @Test
  public void thatIfOneOfTheInputStringsIsNullItsNotRotation()
  {
    assert !stringAnalyzeService.isRotation(null, null);
    assert !stringAnalyzeService.isRotation(null, "not null");
    assert !stringAnalyzeService.isRotation("not null", null);
  }

  @Test
  public void thatIfStringsAreNotTheSameLengthItsNotRotation()
  {
    assert !stringAnalyzeService.isRotation("a", "ab");
  }

  @Test
  public void thatStringIsRotationOfItself() {
    assert stringAnalyzeService.isRotation("abc", "abc");
  }

  @Test
  public void thatStringsAreNotRotation()
  {
    assert !stringAnalyzeService.isRotation("abcde", "edcba");
    assert !stringAnalyzeService.isRotation("abcde", "eabcde");
  }

  @Test
  public void thatStringsAreRotation()
  {
    assert stringAnalyzeService.isRotation("abcde", "eabcd");
    assert stringAnalyzeService.isRotation("abcde", "deabc");
    assert stringAnalyzeService.isRotation("abcde", "cdeab");
    assert stringAnalyzeService.isRotation("abcde", "bcdea");
  }

}
