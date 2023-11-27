package org.test.lib

import com.cloudbees.groovy.cps.NonCPS

class ParallelUtils {

    def script

    ParallelUtils(script) {
        this.script = script
    }

    def runPara(environments) {
        def threads = []

        for (int i = 0; i < environments.size(); i++) {
            threads.add(Thread.start {
                def environment = environments[i]
                script.echo "During: ${Thread.currentThread().getName()} - ${environment}"
            })
        }

        for (int i = 0; i < threads.size(); i++) {
            def thread = threads[i]
            thread.join()
        }
    }
}
