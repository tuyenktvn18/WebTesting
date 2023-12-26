package com.practice.dataTest;

import com.google.gson.Gson;
import com.practice.commons.GlobalConstants;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

import static com.practice.commons.GlobalConstants.getGlobalConstants;

public class DataObjectBuilder {

    public static <T> T buildDataObjectBuilder(String filePath, Class<T> dataType) {
        T returnedData;
        String absoluteFilePath = getGlobalConstants().getDataTestPath().concat(filePath);
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
        String absoluteFilePath = getGlobalConstants().getDataTestPath().concat(fileName);
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