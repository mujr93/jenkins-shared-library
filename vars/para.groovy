def call(script) {
  withGroovy {
    sh "groovy src/org/test/lib/${scriptPath}"
  }
}
