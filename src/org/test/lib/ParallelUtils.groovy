def environments = ["development", "staging", "production", "testing", "stress", "pre-production", "post-production", "qa"]

for (def i = 0; i < environments.size(); i++) {
    def kobe = environments[i]
    Thread.start {
        sleep(1000)
        logger.info kobe
    }
}
