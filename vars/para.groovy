def call() {
  withGroovy {
    sh "groovy src/org/test/lib/ParallelUtils.groovy 1,2,3,4 foo bar"
  }
}
