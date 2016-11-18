package domain

import play.api.libs.json.Json

/**
  * Created by aidenp on 2016/11/18.
  */
case class Lot (id: String,
                title:String,
                description:String,
                value:Value,
                guarantee:Guarantee,
                date:String,
                minimalStep:Value,
                auctionPeriod:Period,
                auctionUrl:url,
                status:String)

object Lot{
  implicit val lotFmt = Json.format[Lot]
}

