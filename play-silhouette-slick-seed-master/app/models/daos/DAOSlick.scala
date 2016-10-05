package models.daos

import com.mohiva.play.silhouette.api.LoginInfo
import slick.driver.JdbcProfile
import play.api.db.slick.HasDatabaseConfigProvider

/**
 * Trait that contains generic slick db handling code to be mixed in with DAOs
 */
trait DAOSlick extends DBTableDefinitions with HasDatabaseConfigProvider[JdbcProfile]