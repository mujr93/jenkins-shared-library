package org.test.lib

import com.cloudbees.groovy.cps.NonCPS

class ParallelUtils {

    def script

    ParallelUtils(script) {
        this.script = script
    }

    @NonCPS
    def runPara(environments) {
        for (def i = 0; i < environments.size(); i++) {
            def environment = environments[i]
            Thread.start {
                script.echo environment
            }
        }
    }

    def test(s) {
        script.echo s
    }
}
