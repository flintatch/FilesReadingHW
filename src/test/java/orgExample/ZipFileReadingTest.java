package orgExample;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

// public class ZipFileReadingTest {

  //  ClassLoader cl = ZipFileReadingTest.class.getClassLoader();
  //  @DisplayName("PDF Reading Test")
  //  @Test
  //  void zipTest1() throws Exception {
   //     InputStream is = cl.getResourceAsStream("archive.zip");
    //    ZipInputStream tis = new ZipInputStream(is);
     //   ZipEntry entry;
     //   ZipFile zfile = new ZipFile(new File("src/test/resources/" + "archive.zip"));
     //   while ((entry = tis.getNextEntry()) != null) {
       //     String name = entry.getName();
       //     if (name.endsWith(".pdf")) {
       //         try (InputStream resourceAsStream = zfile.getInputStream(entry)) {
        //            PDF pdf = new PDF(resourceAsStream);
       //             assertThat(pdf.text).contains("Установщик");
        //        }
       //     }
      //      if (zipEntry.getName().equals(xlsName)) {
       //         InputStream inputStream = zfile.getInputStream(ZipEntry);
      //              ArchiveXls = new ArchiveXls(inputStream);
       //             assertThat(xls.text);
        //        }
        //    }
       // if (entry.getName().contains(".csv")) {
       //         try (InputStream inputStream = zfile.getInputStream(entry)){
   //         }
  //      }
  //  }
//}
