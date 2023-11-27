import org.test.lib.ParallelUtils

def call() {
  evaluate(new File("../../../../../scripts/Threads.groovy"))
  def threads = new Threads(["development", "staging", "production", "testing", "stress", "pre-production", "post-production", "qa"])
  //def parallelUtils = new ParallelUtils(this)
  //parallelUtils.runPara(["development", "staging", "production", "testing", "stress", "pre-production", "post-production", "qa"])
}
