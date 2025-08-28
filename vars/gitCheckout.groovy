def call(Map config) {
   echo "URL: ${config.url}"
   echo "BRANCH: ${config.branch}"
    if (config.branch == "main") {
        checkout([
            $class: 'GitSCM',
            branches: [[name: config.branch]],
            userRemoteConfigs: [[
                    url: config.url,
                    credentialsId: config.credentialsId
            ]]
        ])
    } else {
        error "Branch '${config.branch}' is not allowed. Only 'main' branch can be checked out."
    }
}