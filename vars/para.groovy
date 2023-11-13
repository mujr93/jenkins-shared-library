import org.test.lib.ParallelUtils

def call() {
  def parallelUtils = new ParallelUtils(steps, this)
  parallelUtils.runPara()
}
