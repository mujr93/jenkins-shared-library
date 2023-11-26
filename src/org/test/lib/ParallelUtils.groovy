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
            list.eachParallel {
                steps.echo it
            }
        }
    }
}