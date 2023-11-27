def environments = ['development', 'staging', 'production', 'testing', 'stress', 'pre-production', 'post-production', 'qa']
def threads = []

for (int i = 0; i < environments.size(); i++) {
  def environment = environments[i]
  threads.add(Thread.start {
    for (int j = 0; j < 100; j++) {
      println "${Thread.currentThread().getName()}: ${environment}"
    }
  })
}

for (int i = 0; i < threads.size(); i++) {
  def thread = threads[i]
  thread.join()
}
