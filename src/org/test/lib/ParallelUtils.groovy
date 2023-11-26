package org.test.lib

import com.cloudbees.groovy.cps.NonCPS
@groovy.lang.Grab('org.codehaus.gpars:gpars:1.2.1')
import groovyx.gpars.GParsPool

class ParallelUtils {

    def script

    ParallelUtils(script) {
        this.script = script
    }

    @NonCPS
    def runPara(environments) {
        try {
            GParsPool.withPool(environments.size()) {
                environments.eachParallel {
                    script.log.info "${it}"
                }
            }
        } catch (ignored) {
            script.log.error 'Cannot run in parallel'
        }
    }
}