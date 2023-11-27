import org.test.lib.ParallelUtils

def call() {
  def parallelUtils = new ParallelUtils(this)
  parallelUtils.runPara(['development', 'staging', 'production', 'testing', 'stress', 'pre-production', 'post-production', 'qa'])
}
