package Data;

import Browser.Browser;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class Excel extends Browser
{
    @DataProvider
    public Object [][] Info() throws IOException
    {
        XSSFWorkbook workbook = new XSSFWorkbook("C:\\Users\\PRAMOD KOKATE\\OneDrive\\Desktop\\DATA.xlsx");
        XSSFSheet sheet = workbook.getSheetAt(2);
        int NoOfRows = sheet.getLastRowNum();
        int NoOfColumn = sheet.getRow(0).getLastCellNum();

        Object [][] data = new Object[NoOfRows][NoOfColumn];

        for (int i=0;i<NoOfRows;i++)
        {
            for (int j=0;j<NoOfColumn;j++)
            {
                DataFormatter df = new DataFormatter();
                data[i][j] = df.formatCellValue(sheet.getRow(i+1).getCell(j));
            }
        }
        return data;
    }
}
