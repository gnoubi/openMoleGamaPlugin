import sbt._
import Keys._
import com.typesafe.sbt.osgi.SbtOsgi.{OsgiKeys, osgiSettings}


object GamaBuild extends Build {

  lazy val openmoleVersion = "4.1"

  val gamaSettings = settings ++ osgiSettings ++ Seq(
    OsgiKeys.importPackage := Seq("*"),
    OsgiKeys.privatePackage := Seq("!scala.*"),
    resolvers += "ISC-PIF Release" at "http://maven.iscpif.fr/public/",
    resolvers += Resolver.sonatypeRepo("snapshots"),
    libraryDependencies ++= Seq("org.openmole.core" %% "org-openmole-core-dsl" % openmoleVersion),
    unmanagedBase := baseDirectory.value / "../lib",
    name := "openmole-gama",
    organization := "org.openmole",
    version := "4.1",
    scalaVersion := "2.11.5"
  )

  lazy val core = Project(
    id = "openmole-gama",
    base = file("./org.openmole.plugin.task.gama/"),
    settings = gamaSettings ++ Seq(
      name := "task.gama",
      libraryDependencies += "org.openmole.core" %% "org-openmole-plugin-task-external" % openmoleVersion,
      OsgiKeys.exportPackage := Seq("org.openmole.plugin.task.gama.*"),
      OsgiKeys.bundleActivator := Some("org.openmole.plugin.task.gama.Activator")
    )
  )

}
