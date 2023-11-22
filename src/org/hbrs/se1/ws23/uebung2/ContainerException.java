package org.hbrs.se1.ws23.uebung2;

public class ContainerException extends Exception{
  public ContainerException(Member m) {
    super("Das Member-Objekt mit der ID [" + m.getID() + "] ist bereits vorhanden!");
  }
}
