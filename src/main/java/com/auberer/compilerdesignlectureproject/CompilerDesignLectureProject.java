package com.auberer.compilerdesignlectureproject;

import org.apache.commons.cli.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CompilerDesignLectureProject {
  private static final Logger log = LoggerFactory.getLogger(CompilerDesignLectureProject.class);

  public static void main(String[] args) {
    Options cliOptions = new Options()
        .addOption("h", "help", false, "Print this help text");

    DefaultParser cliParser = new DefaultParser();
    try {
      CommandLine cli = cliParser.parse(cliOptions, args);
      if (cli.hasOption('h')) {
        new HelpFormatter().printHelp("tinf-compiler args...", cliOptions);
        System.exit(0);
      }

      if (args.length == 0) {
        System.out.println("No file path provided!");
        System.exit(1);
      }

      String[] positionalArgs = cli.getArgs();
      Path path = Paths.get(positionalArgs[0]).toAbsolutePath();

      try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
        int character;
        while ((character = reader.read()) != -1) {
          System.out.print((char) character);
        }
      } catch (IOException e) {
        log.error("Error reading the file: " + path, e);
      }

    } catch (ParseException e) {
      new HelpFormatter().printHelp("tinf-compiler args...", cliOptions);
    } catch (Exception e) {
      log.error("An error occurred", e);
    }
  }
}