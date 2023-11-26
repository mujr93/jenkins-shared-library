package org.test.lib

import java.util.concurrent.*

class ParallelUtils {

    def script

    ParallelUtils(script) {
        this.script = script
    }

    def runPara(environments) {
        ExecutorService executorService = Executors.newFixedThreadPool(environments.size())
        List<CompletableFuture<Void>> futures = environments
        for (int i = 0; i < environments.size(); i++) {
            def environment = environments[i]
            CompletableFuture<Void> future = CompletableFuture.runAsync({
                try {
                    script.echo environment
                } catch (InterruptedException e) {
                    e.printStackTrace()
                }
            }, executorService)
            futures.add(future)
        }
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join()
        executorService.shutdown()
    }
}
