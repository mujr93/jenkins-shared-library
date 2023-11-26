package org.test.lib

@Grab('org.codehaus.gpars:gpars:1.2.1')
import groovyx.gpars.GParsPool

class ParallelUtils {

    def steps
    def script

    ParallelUtils(steps, script) {
        this.steps = steps
        this.script = script
    }

    def runPara(environments) {
        GParsPool.withPool(environments.size()) {
            environments.eachParallel {
                steps.echo it
            }
        }
    }
}