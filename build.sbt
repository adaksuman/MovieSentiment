name := "SocialSentiment"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
"org.apache.httpcomponents" % "httpmime" % "4.3.3",
"commons-io" % "commons-io" % "2.2",
"com.google.code.gson" % "gson" % "2.2.4",
  javaJdbc,
  javaEbean,
  cache
)     

play.Project.playJavaSettings
