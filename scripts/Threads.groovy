import org.test.lib.ParallelUtils

def environments = ['development', 'staging', 'production', 'testing', 'stress', 'pre-production', 'post-production', 'qa']
def threads = []

for (int i = 0; i < environments.size(); i++) {
  def environment = environments[i]
  threads.add(Thread.start {
    Thread.sleep(30000)
    println "${Thread.currentThread().getName()}: ${environment}"
  })
}

for (int i = 0; i < threads.size(); i++) {
  def thread = threads[i]
  thread.join()
}

def parallelUtils = new ParallelUtils(this)
parallelUtils(environments)
