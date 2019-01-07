package Benchmark

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations._

@State(Scope.Thread)
class NuHtmlCheckerBenchmark {
  val htmlChecker = NuHtmlChecker()

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @OutputTimeUnit(TimeUnit.SECONDS)
  @Fork(1)
  def valid(): Unit = {
    // Enter here a more complex body to benchmark
    htmlChecker.isValidHtmlBody(NuHtmlChecker.validBody)
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @OutputTimeUnit(TimeUnit.SECONDS)
  @Fork(1)
  def invalid(): Unit = {
    // Enter here a more complex body to benchmark
    htmlChecker.isValidHtmlBody(NuHtmlChecker.invalidBody)
  }
}
