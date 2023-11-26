package org.test.lib

class ParallelUtils {

    def script

    ParallelUtils(script) {
        this.script = script
    }

    def runPara(environments) {
        environments.stream()
            .parallel()
            .forEach { script.log.info("${it}") }
    }
}
