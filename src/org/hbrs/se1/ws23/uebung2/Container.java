package org.hbrs.se1.ws23.uebung2;

import org.hbrs.se1.ws23.uebung3.persistence.PersistenceException;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceStrategy;

import java.util.ArrayList;
import java.util.List;

public class Container {
  public ArrayList<Member> list = new ArrayList<>();
  private PersistenceStrategy<Member> ps;

  public void setPersistenceStrategy(PersistenceStrategy<Member> psS) {
    ps = psS;
  }

  public void addMember(Member m) throws ContainerException {
    if (m.getID() == null) {
      throw new ContainerException(m);
    }
    for (Member n : list) {
      if (m.getID() == (n.getID())) {
        throw new ContainerException(m);
      }
    }
    list.add(m);
  }

  public String deleteMember(Integer id) {
    if (idEnthalten(id)) {
      for (Member m : list) {
          list.remove(m);
          return "Der Member mit der ID " + id + " wurde erfolgreich entfernt.";
      }
    }
    return "Es wurde kein Member mit der ID " + id + " gefunden.";
  }

  public boolean idEnthalten(Integer idToFind) {
    for (Member m : list) {
      if (m.getID().equals(idToFind)) {
        return true;
      }
    }
    return false;
  }

  public int size() {
    return list.size();
  }

  public void store() throws PersistenceException {
    try {
      ps.openConnection();
      ps.save(list);
    } finally {

    }
  }

  public void load() throws PersistenceException {
    try {
      List<Member> loadedMember = ps.load();
      list.clear();
      list.addAll(loadedMember);
    } finally {
      ps.closeConnection();
    }
  }

  public List<Member> getCurrentList() {
    return this.list;
  }
}
