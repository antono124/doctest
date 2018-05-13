package com.antogeo.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CompareFilesServiceImpl implements CompareFilesService {

    @Override
    public List<String> readFile(String path) throws IOException {

        List<String> lines = new ArrayList();
        BufferedReader br = new BufferedReader(new FileReader(path));

        String sCurrentLine;

        while ((sCurrentLine = br.readLine()) != null) {
            System.out.println(sCurrentLine);
            lines.add(sCurrentLine);
        }

        return lines;
    }

    @Override
    public void intersectFiles(final List<String> linesOfFile1, final List<String> linesOfFile2, final String pathToFile3) throws IOException{

        //Intersection
        linesOfFile1.retainAll(linesOfFile2);

        //Sorting
        linesOfFile1.sort(String::compareToIgnoreCase);

        //Create output file
        FileWriter writer = new FileWriter(pathToFile3);
        for(String str: linesOfFile1) {
            writer.write(str);
            writer.write(System.getProperty( "line.separator" ));
        }
        writer.close();
    }

}
