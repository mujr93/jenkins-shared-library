package org.test.lib

import java.util.concurrent.*

class ParallelUtils {

    def script

    ParallelUtils(script) {
        this.script = script
    }

    def runPara(environments) {
        def executorService = Executors.newFixedThreadPool(environments.size())

        for (int i = 0; i < environments.size(); i++) {
            def environment = environments[i]
            executorService.submit {
                script.echo environment
            }
        }
    }
}
