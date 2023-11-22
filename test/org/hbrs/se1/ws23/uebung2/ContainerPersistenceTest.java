package org.hbrs.se1.ws23.uebung2;

import static org.junit.jupiter.api.Assertions.*;

import org.hbrs.se1.ws23.uebung2.*;
import org.hbrs.se1.ws23.uebung3.persistence.*;


import org.junit.jupiter.api.Test;


import java.util.List;


public class ContainerPersistenceTest {
  private final Container container = new SingletonContainer();
  private final PersistenceStrategyStream<Member> psS = new PersistenceStrategyStream<>();
  private final PersistenceStrategyMongoDB<Member> psMongoDB = new PersistenceStrategyMongoDB<>();

  @Test
  void testStrategyNotSet() {
    assertThrows(NullPointerException.class, () -> container.store());
    assertThrows(NullPointerException.class, () -> container.load());
  }

  @Test
  void testMongoDBStrategy() {
    container.setPersistenceStrategy(psMongoDB);
    assertThrows(UnsupportedOperationException.class, () -> container.store());
    assertThrows(UnsupportedOperationException.class, () -> container.load());
  }

  @Test
  void testInvalidStreamLocation() {
    psS.setLocation("invalid/directory/test");
    container.setPersistenceStrategy(psS);
    assertThrows(PersistenceException.class, () -> container.store());
    assertThrows(PersistenceException.class, () -> container.load());
  }

  @Test
  void testRoundTrip() throws ContainerException, PersistenceException {
    Member member1 = new ConcreteMember(1);
    Member member2 = new ConcreteMember(2);
    container.setPersistenceStrategy(psS);

    container.addMember(member1);
    container.addMember(member2);
    container.store();
    container.load();
    container.deleteMember(1);

    List<Member> currentList = container.getCurrentList();
    assertEquals(1, currentList.size());
    assertFalse(currentList.contains(member1));
    assertTrue(container.idEnthalten(2));
  }
}