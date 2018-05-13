package com.antogeo.service;

import java.io.IOException;
import java.util.List;

public interface CompareFilesService {

     List<String> readFile(String path) throws IOException;

     void intersectFiles(List<String> linesOfFile1, List<String> linesOfFile2, String pathToFile3) throws IOException;

}
