package Devops_Test.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.vcs.GitVcsRoot

object Devops_Test_TraderSharpSDK : GitVcsRoot({
    uuid = "dafcf830-346a-4617-8931-cbeeceddd7b5"
    id = "Devops_Test_TraderSharpSDK"
    name = "TraderSharpSDK"
    url = "https://github.com/linedata/trader-sharp-sdk.git"
    authMethod = password {
        userName = "zchandrahasan"
        password = "credentialsJSON:ec1bbde8-2dd0-4ea3-b02f-f8436eeaa7c4"
    }
})
