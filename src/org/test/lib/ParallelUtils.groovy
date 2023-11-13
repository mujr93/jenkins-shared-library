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

        for (def i = 0; i < environments.size(); i++) {
            def kobe = environments[i]
            def t = new Thread({
                sleep(10000)
                steps.echo kobe
            })
            t.start()
        }
    }
}
