package com

import groovy.yaml.YamlBuilder

class ConfigParser {
    static void main(String[] args) {
        String inputFilePath = "./input/application.groovy"
        String outputPath = "./output"

        if(args.size() > 0){
            inputFilePath = args[0]
        }
        if(args.size() > 1){
            outputPath = args[1]
        }
        convertGroovyToYamlConfig(inputFilePath, outputPath);
    }

    static void convertGroovyToYamlConfig(String inputFilePath, String outputPath) {
        println("Converting Groovy to yaml... input file path: "+ inputFilePath)
        String[] envs = ['development', 'test', 'staging', 'production']
        for (String env : envs) {
            println("===== Converting groovy for environment: "+ env)
            def config = new ConfigSlurper(env).parse(new File(inputFilePath).toURL());
            def yb = new YamlBuilder()
            yb config
            println(yb.toString())

            String outputFileName = outputPath+"/applicaton-"+ env+".yaml";
            println("... Writing output file to : " + outputFileName);
            File file = new File(outputFileName)
            file.write yb.toString()
            println("==============================")
        }
    }
}
