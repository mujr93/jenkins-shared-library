package org.test.lib

import com.cloudbees.groovy.cps.NonCPS
import java.util.stream.*

class ParallelUtils {

    def script

    ParallelUtils(script) {
        this.script = script
    }

    @NonCPS
    def runPara(environments) {
        Stream.of("a", "b", "c", "a1", "b1", "c1", "a2", "b2", "c2")
            .parallel()
            .forEach({ script.echo "${it}" })
    }
}
