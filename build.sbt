scalaVersion := "3.2.2"

Global / onChangedBuildSource := ReloadOnSourceChanges

assembly / mainClass := Some("com.example.Main")

libraryDependencies ++= Seq(
  "com.amazonaws" % "aws-lambda-java-core" % "1.2.2",
  "com.amazonaws" % "aws-lambda-java-events" % "3.11.1"
)
