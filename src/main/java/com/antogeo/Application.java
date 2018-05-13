package com.antogeo;

import com.antogeo.service.CompareFilesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class Application implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    private CompareFilesService compareFilesService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        for (String name : args.getOptionNames()){
            logger.info(name + "=" + args.getOptionValues(name));
        }
        try {
            List<String> linesOfFile1 = compareFilesService.readFile(args.getOptionValues("file1").get(0));
            List<String> linesOfFile2 = compareFilesService.readFile(args.getOptionValues("file2").get(0));
            compareFilesService.intersectFiles(linesOfFile1, linesOfFile2, args.getOptionValues("file3").get(0));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
