package org.test.lib

import com.cloudbees.groovy.cps.NonCPS

class ParallelUtils {

    def script

    ParallelUtils(script) {
        this.script = script
    }

    def runPara(environments) {
        environments.stream()
            .parallel()
            .forEach({ test("${it}") })
    }

    @NonCPS
    def test(s) {
        script.echo s
    }
}
