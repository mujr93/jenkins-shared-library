package org.test.lib

class ParallelUtils {
    
    def steps
    def script

    def ParallelUtils(steps, script) {
        this.steps = steps
        this.script = script
    }

    def runPara() {
        def environments = ["development", "staging", "production", "testing", "stress", "pre-production", "post-production", "qa"]
        def threads = []
        
        for (def i = 0; i < environments.size(); i++) {
            def kobe = environments[i]
            threads[i] = Thread.start {
                sleep(10000)
                println kobe
            }
        }

        for (def i = 0; i < threads.size(); i++) {
            threads[i].join()
        }
    }
}
