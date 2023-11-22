package org.hbrs.se1.ws23.uebung4.prototype.controller;

import org.hbrs.se1.ws23.uebung4.prototype.model.Container;
import org.hbrs.se1.ws23.uebung4.prototype.model.UserStory;

import java.util.*;
import java.util.stream.Collectors;

public class Util {
  public static List<UserStory> liste = Container.getInstance().getCurrentList();

  /**
   * Liefert eine bestimmte UserStory zurück
   *
   * @param id
   * @return
   */
  public static UserStory getUserStory(int id) {
    for (UserStory userStory : liste) {
      if (id == userStory.getId()) {
        return userStory;
      }
    }
    return null;
  }

  /**
   * Prüft, ob eine UserStory bereits vorhanden ist
   *
   * @param userStory
   * @return
   */
  public static boolean contains(UserStory userStory) {
    int ID = userStory.getId();
    for (UserStory userStory1 : liste) {
      if (userStory1.getId() == ID) {
        return true;
      }
    }
    return false;
  }

  public static List<UserStory> UserStoryFilter(String project) {
    List<UserStory> listMitName = liste.stream()
      .filter(userstory -> userstory.getProject().equals(project))
      .filter(userstory -> userstory.getRisk() <=5)
      .collect(Collectors.toList());
    return listMitName;
  }
}
