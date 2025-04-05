    package utils;

    import org.apache.poi.xssf.usermodel.XSSFRow;
    import org.apache.poi.xssf.usermodel.XSSFSheet;
    import org.apache.poi.xssf.usermodel.XSSFWorkbook;

    import java.io.FileInputStream;
    import java.io.FileOutputStream;
    import java.io.IOException;
    import java.util.Arrays;
    import java.util.List;

    public class ExcelUtil {
        /*
        *   ValidUsername
            ValidPassword
            IncorrectPassword
            NewValidPassword
            ValidEmail
            FirstName
            LastName
            MobileNumber
        * */
        String FilePath = null;
        int sheetNum;

        ExcelUtil(String FilePath, int sheetNum){
            this.FilePath = FilePath;
            this.sheetNum = sheetNum;
            System.out.println(FilePath);
        }

        public Object readFromExcel(String key) {
            try(XSSFWorkbook workbook = new XSSFWorkbook(FilePath)){
                XSSFSheet sheet = workbook.getSheetAt(sheetNum);
                int rowCount = sheet.getPhysicalNumberOfRows();
                for(int i=0;i<rowCount;i++){
                    if(key.equals(sheet.getRow(i).getCell(0).getStringCellValue())){
                        if(sheet.getRow(i).getCell(1).getCellType().toString().equals("NUMERIC")){
                            return (int)(sheet.getRow(i).getCell(1).getNumericCellValue());
                        }else{
                            return sheet.getRow(i).getCell(1).getStringCellValue();
                        }

                    }
                }
            }catch(IOException e){
                e.printStackTrace();
            }

            return key;
        }

        public void createExcel() throws IOException {
            List<String> header = Arrays.asList("Name","Department","Salary");

            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet();
            XSSFRow headerRow = sheet.createRow(0);
            final int[] cellIndex = {0};
            header.forEach(h-> {
                        headerRow.createCell(cellIndex[0]).setCellValue(h);
                        cellIndex[0]++;
                    }
            );
            XSSFRow dataRow = sheet.createRow(1);
            dataRow.createCell(0).setCellValue("AMAN");
            dataRow.createCell(1).setCellValue("IT");
            dataRow.createCell(2).setCellValue("100000");

            FileOutputStream fout = new FileOutputStream("TestData.xlsx");
            workbook.write(fout);
        }

        public void writeInExcel(String key,String value){
            try(FileInputStream fis = new FileInputStream(FilePath)){
                XSSFWorkbook workbook = new XSSFWorkbook(fis);
                XSSFSheet sheet = workbook.getSheetAt(sheetNum);
                int rowCount = sheet.getPhysicalNumberOfRows();
                for(int i=0;i<rowCount;i++){
                    if(key.equals(sheet.getRow(i).getCell(0).getStringCellValue())){
                        sheet.getRow(0).getCell(1).setCellValue(value);
                    }
                }


                try(FileOutputStream fout = new FileOutputStream(FilePath)){
                    workbook.write(fout);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
