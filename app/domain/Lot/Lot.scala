package domain.Lot

import domain.{Guarantee, Period, Value}
import play.api.libs.json.Json


/**
  * Created by aidenp on 2016/11/18.
  */
case class Lot (id: String,
                title:String,
                description:String,
                //value:String, //Value Id
                //guarantee:String, //Guarantee Id
                date:String,
                //minimalStep:String, //Value Id
                //auctionPeriod:String, //Period Id
                auctionUrl:String,
                status:String)

object Lot{
  implicit val lotFmt = Json.format[Lot]
}

