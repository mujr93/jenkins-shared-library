package org.test.lib

import com.cloudbees.groovy.cps.NonCPS

import java.util.concurrent.*

class ParallelUtils {

    def script

    ParallelUtils(script) {
        this.script = script
    }

    @NonCPS
    def runPara(environments) {
        script.echo "Before: ${Thread.currentThread().getName()}"

        def executorService = Executors.newFixedThreadPool(environments.size())

        for (int i = 0; i < environments.size(); i++) {
            def environment = environments[i]
            executorService.submit {
                script.echo "During: ${Thread.currentThread().getName()} - ${environment}"
            }
        }

        script.echo "After: ${Thread.currentThread().getName()}"
    }
}
