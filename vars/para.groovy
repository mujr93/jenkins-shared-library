def call(scriptPath) {
  withGroovy {
    sh "groovy ${scriptPath}"
  }
}
