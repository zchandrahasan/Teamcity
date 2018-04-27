package Devops_Test.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.vcs.GitVcsRoot

object Devops_Test_TeamcitySettings : GitVcsRoot({
    uuid = "309bcaed-695e-45db-891e-4301a54f47d3"
    id = "Devops_Test_TeamcitySettings"
    name = "TeamcitySettings"
    url = "https://github.com/zchandrahasan/Teamcity.git"
    authMethod = password {
        userName = "zchandrahasan"
        password = "credentialsJSON:ec1bbde8-2dd0-4ea3-b02f-f8436eeaa7c4"
    }
})
