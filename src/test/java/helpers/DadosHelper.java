package helpers;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DadosHelper {

	public static HashMap<String,String> storeValues = new HashMap();


	public static List<HashMap<String,String>> data()
	{


		List<HashMap<String,String>> dados = new ArrayList<>();
		try
		{

			FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//testData/MassaDeTestes.xlsx");
			XSSFWorkbook pastaTrabalho = new XSSFWorkbook(fs);
			XSSFSheet planilha = pastaTrabalho.getSheet("TestData");
			Row cabecalho = planilha.getRow(0);

			for(int i=1;i<planilha.getPhysicalNumberOfRows();i++)
			{
				Row linhaAtual = planilha.getRow(i);
				HashMap<String,String> hashCorrente = new HashMap<String,String>();
				for(int j=0;j<linhaAtual.getPhysicalNumberOfCells();j++)
				{
					Cell celularAtual = linhaAtual.getCell(j);

					switch (celularAtual.getCellType())
					{
					case Cell.CELL_TYPE_STRING:
						System.out.print(celularAtual.getStringCellValue() + "\t");

						hashCorrente.put(cabecalho.getCell(j).getStringCellValue(), celularAtual.getStringCellValue());
						break;
					}

				}
				dados.add(hashCorrente);
			}

			fs.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return dados;

	}

}
