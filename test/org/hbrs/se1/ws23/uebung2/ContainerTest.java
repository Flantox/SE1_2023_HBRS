package org.hbrs.se1.ws23.uebung2;

import org.hbrs.se1.ws23.uebung2.*;
import org.junit.jupiter.api.*;

import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.*;

public class ContainerTest {
  Member m1 = new ConcreteMember(1);
  Member m2 = new ConcreteMember(2);
  Member m3 = new ConcreteMember(null);
  Container c = new SingletonContainer();

  @Test
  void testSize() {
    assertEquals(0, c.size());
  }

  @Test
  void testAdd() throws ContainerException {
    c.addMember(m1);
    assertEquals(1, c.size());
  }

  @Test
  void testAdd1() throws ContainerException {
    c.addMember(m1);
    c.addMember(m2);
    assertEquals(2, c.size());
  }

  @Test
  void testAdd2() throws ContainerException {
    c.addMember(m1);
    c.addMember(m2);
    assertThrows(ContainerException.class, () -> c.addMember(m2));
  }

  @Test
  void testAdd3() throws ContainerException {
    assertThrows(ContainerException.class, () -> c.addMember(m3));
  }

  @Test
  void delete() throws ContainerException {
    c.addMember(m1);
    c.addMember(m2);
    assertEquals("Der Member mit der ID 8 konnte nicht gefunden werden", c.deleteMember(8));
  }

  @Test
  void delete2() throws ContainerException {
    c.addMember(m1);
    c.addMember(m2);
    assertEquals("Der Member mit der ID 2 wurde entfernt", c.deleteMember(2));
  }

  @Test
  void delete3() throws ContainerException {
    c.addMember(m1);
    c.addMember(m2);
    assertEquals("Der Member mit der ID 1 wurde entfernt", c.deleteMember(1));
    assertEquals("Der Member mit der ID 2 wurde entfernt", c.deleteMember(2));
  }


}
