def environments = ['development', 'staging', 'production', 'testing', 'stress', 'pre-production', 'post-production', 'qa']

def threads = []

for (int i = 0; i < environments.size(); i++) {
  def environment = environments[i]
  threads.add(Thread.start {
    println "During: ${Thread.currentThread().getName()} - ${environment}"
  })
}

for (int i = 0; i < threads.size(); i++) {
  def thread = threads[i]
  thread.join()
}
