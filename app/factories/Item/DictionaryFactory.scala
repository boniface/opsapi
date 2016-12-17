package factories.Item

import domain.Item.Dictionary

/**
  * Created by AidenP on 2016/11/30.
  */
class DictionaryFactory {

  def createDictionary(values: Map[String, String]):Dictionary =
                      {Dictionary(
                       id = values("id"),
                        latitude = values("latitude"),
                        longitude = values("longitude"),
                        elevation = values("elevation")
    )}

}


