package orgExample;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParseTest {
    ClassLoader cl = ParseTest.class.getClassLoader();
    @Test
    void paraTest() throws Exception {
        ZipFile zipFile = new ZipFile(new File("src/test/resources/archive.zip"));
        ZipInputStream zipInputStream = new ZipInputStream(cl.getResourceAsStream("archive.zip"));
        ZipEntry zipEntry;
        String pdfName = "Guide.pdf";
        String xlsName = "Sample.xls";
        String csvName = "Book.csv";
    }
    @Test
    void ZipTest() throws Exception {
        ZipFile zipFile = new ZipFile(new File("src/test/resources/archive.zip"));
        ZipInputStream is = new ZipInputStream(cl.getResourceAsStream("archive.zip"));
        ZipEntry entry;
        while ((entry = is.getNextEntry()) != null) {
            switch (entry.getName()) {
                case ("Sample.xlsx"):
                    assertEquals(entry.getName(), "Sample.xlsx");
                    try (InputStream inputStream = zipFile.getInputStream(entry)) {
                        assert inputStream != null;
                        XLS xls = new XLS(inputStream);
                        assertThat(xls.excel
                                .getSheetAt(1)
                                .getRow(1)
                                .getCell(1)
                                .getStringCellValue()).contains("1917");
                    }
                    break;
                case ("Book.csv"):
                    assertEquals(entry.getName(), "Book.csv");
                    try (InputStream inputStream = zipFile.getInputStream(entry)) {
                        assert inputStream != null;
                        try (CSVReader reader = new CSVReader(new InputStreamReader(inputStream))) {
                            List<String[]> content = reader.readAll();
                            assertThat(content.get(0)).contains("Milk;Guns");
                        }
                    }
                    break;
                case ("Guide.pdf"):
                    assertEquals(entry.getName(), "Guide.pdf");
                    try (InputStream inputStream = zipFile.getInputStream(entry)) {
                        assert inputStream != null;
                        PDF pdf = new PDF (inputStream);
                        assertThat(pdf.text).contains("Установщик");
                    }
                    break;
            }
        }
    }
    @Test
    void jsonTest() {
        InputStream is = cl.getResourceAsStream("Mauser.json");
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(new InputStreamReader(is), JsonObject.class);
        assertThat(jsonObject.get("model").getAsString()).isEqualTo("MauserC96");
        assertThat(jsonObject.get("isMauser").getAsBoolean()).isTrue();
    }
}
