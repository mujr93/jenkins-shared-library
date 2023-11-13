import org.test.lib

def call() {
  def parallelUtils = new ParallelUtils(steps, this)
  parallelUtils.runPara()
}