ThisBuild / scalaVersion := "2.13.6"
ThisBuild / organization := "org.hmrc"

lazy val shoppingCardApplication = (project in file("."))
  .settings(
    name := "ShoppingCardApplication",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.12" % Test,

)
