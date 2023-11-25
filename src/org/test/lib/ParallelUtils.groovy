package org.test.lib

import groovyx.gpars.GParsPool

class ParallelUtils {

    def steps
    def script

    def ParallelUtils(steps, script) {
        this.steps = steps
        this.script = script
    }

    def runPara(environments) {
        GParsPool.withPool {
            environments.eachParallel {
                steps.echo it
            }
        }
    }
}