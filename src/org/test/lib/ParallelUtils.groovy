package org.test.lib

import com.cloudbees.groovy.cps.NonCPS
import java.util.stream.*

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

    def test(s) {
        script.echo s
    }
}
