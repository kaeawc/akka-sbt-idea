name := "akka remote master"

version := "1.0"

scalaVersion := "2.10.2"

resolvers ++= Seq(
  "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
  "SonaType" at "https://oss.sonatype.org/content/groups/public/org/scalatest/"
)

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.2.1",
  "com.typesafe.akka" %% "akka-remote" % "2.2.1",
  "com.typesafe.akka" %% "akka-testkit" % "2.2.0",
  "org.scalatest" %% "scalatest" % "1.9.1" % "test",
  "junit" % "junit" % "4.11" % "test",
  "com.novocode" % "junit-interface" % "0.7" % "test->default"
)

testOptions += Tests.Argument(TestFrameworks.JUnit, "-v")
