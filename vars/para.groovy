def call() {
  withGroovy {
    sh "groovy src/org/test/lib/ParallelUtils.groovy foo bar"
  }
}
