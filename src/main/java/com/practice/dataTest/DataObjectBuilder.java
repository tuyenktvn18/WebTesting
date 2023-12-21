package com.practice.commons;

import com.google.gson.Gson;
import com.practice.constants.GlobalConstants;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

public class DataObjectBuilder {

    public static <T> T buildDataObjectBuilder(String filePath, Class<T> dataType) {
        T returnedData;
        String absoluteFilePath = System.getProperty("user.dir").concat(filePath);
        try (
                Reader reader = Files.newBufferedReader(Paths.get(absoluteFilePath));
        ) {
            Gson gson = new Gson();
            returnedData = gson.fromJson(reader, dataType);
        } catch (NoSuchFileException noSuchFileException) {
            throw new RuntimeException("[ERR] Can't locate the file: ".concat(absoluteFilePath));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        return returnedData;
    }

    public static <T> T buildDataObjectBuilderWithFileName(String fileName, Class<T> dataType) {
        T returnedData;
        String absoluteFilePath = GlobalConstants.getGlobalConstants().getDataTestPath().concat(fileName);
        try (
                Reader reader = Files.newBufferedReader(Paths.get(absoluteFilePath));
        ) {
            Gson gson = new Gson();
            returnedData = gson.fromJson(reader, dataType);
        } catch (NoSuchFileException noSuchFileException) {
            throw new RuntimeException("[ERR] Can't locate the file: ".concat(absoluteFilePath));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        return returnedData;
    }
}