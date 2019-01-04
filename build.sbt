name := "nu-html-checker-benchmark"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies += "nu.validator" % "validator" % "18.11.5"

enablePlugins(JmhPlugin)

Compile/mainClass := Some("Benchmark")
