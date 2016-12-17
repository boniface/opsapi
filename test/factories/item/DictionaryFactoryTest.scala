package factories.item

import domain.Item.Dictionary
import factories.Item.DictionaryFactory
import org.scalatest.FunSuite

/**
  * Created by AidenP on 2016/12/13.
  */
class DictionaryFactoryTest extends FunSuite {
  test("testCreateDictionary"){
    val dictionary = new DictionaryFactory

    val values = Map("id" -> "test",
      "latitude" -> "1",
      "longitude" -> "test",
      "elevation" -> "test"
    )

    val dict = dictionary.createDictionary(values)

    assert(dict == Dictionary(id = "test",
      latitude = "1",
      longitude = "test",
      elevation = "test"))
  }
}

