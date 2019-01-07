# [Nu Html Checker](https://github.com/validator/validator) Benchmark

> :warning: Use it at your own risk

Small benchmark to measure the efficiency of the Nu Html Checker.

## Output example

In the _sbt shell_ type `jmh:run` and the following output should appear:

```
[info] Running (fork) org.openjdk.jmh.Main 
[info] # JMH version: 1.21
[info] # VM version: JDK 1.8.0_181, Java HotSpot(TM) 64-Bit Server VM, 25.181-b13
[info] # VM invoker: /Library/Java/JavaVirtualMachines/jdk1.8.0_181.jdk/Contents/Home/jre/bin/java
[info] # VM options: <none>
[info] # Warmup: 5 iterations, 10 s each
[info] # Measurement: 5 iterations, 10 s each
[info] # Timeout: 10 min per iteration
[info] # Threads: 1 thread, will synchronize iterations
[info] # Benchmark mode: Throughput, ops/time
[info] # Benchmark: Benchmark.NuHtmlCheckerBenchmark.invalid
[info] # Run progress: 0.00% complete, ETA 00:03:20
[info] # Fork: 1 of 1
[info] # Warmup Iteration   1: 16640.140 ops/s
[info] # Warmup Iteration   2: 18195.628 ops/s
[info] # Warmup Iteration   3: 18756.446 ops/s
[info] # Warmup Iteration   4: 18713.077 ops/s
[info] # Warmup Iteration   5: 18859.915 ops/s
[info] Iteration   1: 18778.313 ops/s
[info] Iteration   2: 18126.067 ops/s
[info] Iteration   3: 18354.945 ops/s
[info] Iteration   4: 17346.412 ops/s
[info] Iteration   5: 17403.110 ops/s
[info] Result "Benchmark.NuHtmlCheckerBenchmark.invalid":
[info]   18001.770 ±(99.9%) 2382.339 ops/s [Average]
[info]   (min, avg, max) = (17346.412, 18001.770, 18778.313), stdev = 618.686
[info]   CI (99.9%): [15619.430, 20384.109] (assumes normal distribution)
[info] # JMH version: 1.21
[info] # VM version: JDK 1.8.0_181, Java HotSpot(TM) 64-Bit Server VM, 25.181-b13
[info] # VM invoker: /Library/Java/JavaVirtualMachines/jdk1.8.0_181.jdk/Contents/Home/jre/bin/java
[info] # VM options: <none>
[info] # Warmup: 5 iterations, 10 s each
[info] # Measurement: 5 iterations, 10 s each
[info] # Timeout: 10 min per iteration
[info] # Threads: 1 thread, will synchronize iterations
[info] # Benchmark mode: Throughput, ops/time
[info] # Benchmark: Benchmark.NuHtmlCheckerBenchmark.valid
[info] # Run progress: 50.00% complete, ETA 00:01:41
[info] # Fork: 1 of 1
[info] # Warmup Iteration   1: 17315.646 ops/s
[info] # Warmup Iteration   2: 19710.819 ops/s
[info] # Warmup Iteration   3: 19956.166 ops/s
[info] # Warmup Iteration   4: 19740.078 ops/s
[info] # Warmup Iteration   5: 19881.306 ops/s
[info] Iteration   1: 19289.406 ops/s
[info] Iteration   2: 19972.903 ops/s
[info] Iteration   3: 19923.832 ops/s
[info] Iteration   4: 19958.139 ops/s
[info] Iteration   5: 19870.783 ops/s
[info] Result "Benchmark.NuHtmlCheckerBenchmark.valid":
[info]   19803.013 ±(99.9%) 1115.872 ops/s [Average]
[info]   (min, avg, max) = (19289.406, 19803.013, 19972.903), stdev = 289.788
[info]   CI (99.9%): [18687.141, 20918.885] (assumes normal distribution)
[info] # Run complete. Total time: 00:03:23
[info] REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
[info] why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
[info] experiments, perform baseline and negative tests that provide experimental control, make sure
[info] the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
[info] Do not assume the numbers tell you what you want them to tell.
[info] Benchmark                                  Mode  Cnt      Score      Error  Units
[info] Benchmark.NuHtmlCheckerBenchmark.invalid  thrpt    5  18001.770 ± 2382.339  ops/s
[info] Benchmark.NuHtmlCheckerBenchmark.valid    thrpt    5  19803.013 ± 1115.872  ops/s
[success] Total time: 205 s, completed Jan 7, 2019 4:34:46 PM
```