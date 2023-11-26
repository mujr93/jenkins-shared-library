package org.test.lib

@groovy.lang.Grab('org.codehaus.gpars:gpars:1.2.1')
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
            def list = Collections.synchronizedList(environments)
            [1, 2, 3, 4, 5].eachParallel {
                steps.echo it
            }
        }
    }
}