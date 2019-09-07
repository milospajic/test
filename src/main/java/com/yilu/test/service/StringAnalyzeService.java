package com.yilu.test.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class StringAnalyzeService {


  // the first task
  public Optional<Character> findFirstNonRepeating(String inputString) {

    if (inputString == null) {
      throw new IllegalArgumentException();
    }

    char[] charArray = inputString.toCharArray();

    Map<Character, Integer> charCountMap = createMapWithWithCharacterCounts(charArray);

    for (char c : charArray) {
      if (charCountMap.get(c) == 1) {
        return Optional.of(c);
      }
    }

    return Optional.empty();
  }

  private Map<Character, Integer> createMapWithWithCharacterCounts(char[] charArray) {

    Map<Character, Integer> charCountMap = new HashMap<>();

    for (char c : charArray) {
      if (charCountMap.containsKey(c)) {
        int count = charCountMap.get(c);
        charCountMap.put(c, count + 1);
      } else {
        charCountMap.put(c, 1);
      }
    }

    return charCountMap;
  }

  //the second task
  public boolean isRotation(String str, String rotated) {
    if (str == null || rotated == null) {
      return false;
    }

    if (str.length() != rotated.length()) {
      return false;
    }

    String concatenation = str + str;

    return concatenation.contains(rotated);

  }
}
