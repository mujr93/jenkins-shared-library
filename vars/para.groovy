import org.test.lib.ParallelUtils

def call(scriptPath) {
  withGroovy {
    sh "groovy ${scriptPath}"
  }
}
