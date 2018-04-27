package Devops_Test.buildTypes

import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.buildSteps.DotnetBuildStep
import jetbrains.buildServer.configs.kotlin.v2017_2.buildSteps.VSTestStep
import jetbrains.buildServer.configs.kotlin.v2017_2.buildSteps.dotnetBuild
import jetbrains.buildServer.configs.kotlin.v2017_2.buildSteps.vstest

object Devops_Test_TraderSharpSdk : BuildType({
    uuid = "85319817-0d8b-4049-b879-1ca7ee7a0b93"
    id = "Devops_Test_TraderSharpSdk"
    name = "Trader_Sharp_SDK"

    vcs {
        root(Devops_Test.vcsRoots.Devops_Test_TraderSharpSDK)

    }

    steps {
        step {
            name = "Duplicate Code"
            type = "dotnet-tools-dupfinder"
            param("jetbrains.resharper-clt.clt-path", "%teamcity.tool.jetbrains.resharper-clt.DEFAULT%")
        }
        step {
            name = "Code Inspection"
            type = "dotnet-tools-inspectcode"
            param("dotnet-tools-inspectcode.solution", "src/trader-sharp-sdk.sln")
            param("jetbrains.resharper-clt.clt-path", "%teamcity.tool.jetbrains.resharper-clt.DEFAULT%")
        }
        dotnetBuild {
            name = "Build"
            projects = "**/trader-sharp-sdk.sln"
            workingDir = "src"
            configuration = "Release"
            logging = DotnetBuildStep.Verbosity.Normal
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%")
        }
        vstest {
            name = "Test"
            vstestPath = "%teamcity.dotnet.vstest.15.0%"
            includeTestFileNames = "**/*.Test.dll"
            platform = VSTestStep.Platform.x64
            coverage = dotcover {
                toolPath = "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%"
                assemblyFilters = """
                    +:*
                    -:*.Test
                    -:xunit*
                """.trimIndent()
            }
            param("dotNetCoverage.NCover3.platformBitness", "x64")
        }
    }
})
