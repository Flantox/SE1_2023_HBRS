package org.hbrs.se1.ws23.uebung1.control;

import java.util.ArrayList;
import java.util.InputMismatchException;

class ArrayListGenerator {
  ArrayList<String> string = new ArrayList<>();

  public void creater() {
    string.add("eins");
    string.add("zwei");
    string.add("drei");
    string.add("vier");
    string.add("fünf");
    string.add("sechs");
    string.add("sieben");
    string.add("acht");
    string.add("neun");
    string.add("zehn");
  }

  public String translateNumber(int i) {
    if(i > 0 && i < 11) {
      return string.get(i-1);
    } else {
      throw new InputMismatchException("Übersetzung der Zahl " + i + " nicht möglich" + ", " + Translator.version);
    }
  }
}
