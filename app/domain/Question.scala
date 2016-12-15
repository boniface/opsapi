package domain

import play.api.libs.json.Json

/**
  * Created by Administrator on 11/18/2016.
  */
case class Question (
                    id : SerialVersionUID,
                    author : Organization,
                    title : String,
                    description : String,
                    date : String = Date,
                    dateAnswered : String = Date,
                    answer : String,
                    questionOf : String,
                    relatedItem : String
                    )

object Question {
  implicit val questionFmt = Json.format[Question]
}