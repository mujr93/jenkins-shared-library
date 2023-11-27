def environments = ['development', 'staging', 'production', 'testing', 'stress', 'pre-production', 'post-production', 'qa']

def threads = []

for (int i = 0; i < environments.size(); i++) {
  threads.add(Thread.start {
    def environment = environments[i]
    println "During: ${Thread.currentThread().getName()} - ${environment}"
  })
}

for (int i = 0; i < threads.size(); i++) {
  def thread = threads[i]
  thread.join()
}
