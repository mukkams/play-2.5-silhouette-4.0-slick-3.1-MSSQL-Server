package models

import java.sql.Timestamp

import org.joda.time.DateTime
import org.joda.time.format.ISODateTimeFormat
import play.api.libs.json.Json._
import play.api.libs.json.{ Format, JsResult, JsValue }
import slick.driver.JdbcProfile

/**
 * Created by obioham on 14/03/2016.
 */
trait TimeStampFormatting {

  def timestampToDateTime(t: Timestamp): DateTime = new DateTime(t.getTime)

  def dateTimeToTimestamp(dt: DateTime): Timestamp = new Timestamp(dt.getMillis)

  implicit val pmtimestampFormat = new Format[Timestamp] {
    def writes(t: Timestamp): JsValue = toJson(timestampToDateTime(t))

    def reads(json: JsValue): JsResult[Timestamp] = {
      println("The js string value is:")
      println(json.as[String])
      val parsedDate = DateTime.parse(json.as[String], ISODateTimeFormat.dateTime())
      println(parsedDate)
      //fromJson[DateTime](json).map(dateTimeToTimestamp)
      fromJson[String](json).map(d => dateTimeToTimestamp(DateTime.parse(d, ISODateTimeFormat.dateTime())))
      //dateTimeToTimestamp(DateTime.parse(json.as[String], ISODateTimeFormat.dateTime()))
    }
  }
}

trait DateTimeFormatting {

  def timestampToDateTime(t: Timestamp): DateTime = new DateTime(t.getTime)

  def dateTimeToTimestamp(dt: DateTime): Timestamp = new Timestamp(dt.getMillis)

  implicit val dateTimeFormat = new Format[DateTime] {
    def writes(t: DateTime): JsValue = toJson(t)

    def reads(json: JsValue): JsResult[DateTime] = {
      fromJson[String](json).map(d => DateTime.parse(d, ISODateTimeFormat.dateTime()))
    }
  }
}

trait DateTimeMappedColumn {
  protected val driver: JdbcProfile

  import driver.api._

  object DateUtils {
    implicit def jdateColumnType =
      MappedColumnType.base[DateTime, Timestamp](
        dt => new Timestamp(dt.getMillis),
        ts => new DateTime(ts.getTime)
      )
  }
}