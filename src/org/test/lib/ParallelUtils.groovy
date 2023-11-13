def environments = ["development", "staging", "production", "testing", "stress", "pre-production", "post-production", "qa"]

for (def i = 0; i < environments.size(); i++) {
    def environment = environments[i]
    Thread.start {
        println environment
    }
}
