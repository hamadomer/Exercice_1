package org.example;

import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class CsvHandler {

    private static final Logger logger = LogManager.getLogger("CSVErrorLogger");
    ArrayList <Data> dataList = new ArrayList<>();

    public Data csvToData(String path, int index) throws IOException, CsvValidationException, NullPointerException {
        try (FileReader fileReader = new FileReader(path);
             CSVReaderHeaderAware csvReader = new CSVReaderHeaderAware(fileReader)) {

            Map<String, String> values;
            while ((values = csvReader.readMap()) != null) {
                String Title;
                if ("paiement".equals(values.get("Title"))) {
                    Title = "Demande de paiement de facture";
                } else if ("Acquittement".equals(values.get("Title"))) {
                    Title = "Acquittement de facture";
                } else {
                    String errorMsg = String.format("%s;%s", path, "Type of facture isn't supported");
                    logger.error(errorMsg);
                    Title = "empty";
                }
                dataList.add(new Data(Title, values.get("nom"), values.get("prenom"), values.get("numero"), values.get("date"), values.get("objet"), values.get("montant")));
            }
        } catch (NullPointerException e) {
            String errorMsg = String.format("%s;%s", path, "empty Csv file");
            logger.error(errorMsg);
        }

        if (!dataList.isEmpty()) {
            return dataList.get(index);
        } else {
            return new Data("empty", "empty", "empty", "empty", "empty", "empty", "empty");
        }
    }

    public void dataToCsv(Data data, String path) throws IOException {
        try (FileWriter outputfile = new FileWriter(path)) {
            CSVWriter writer = new CSVWriter(outputfile);
            String[] header = {"Title", "Nom", "Prénom", "Facture", "Date", "Objet", "Montant"};
            writer.writeNext(header);
            String[] info = {data.getTitle(), data.getNom(), data.getPrenom(), data.getFacture(), data.getDate(), data.getObjet(), data.getMontant()};
            writer.writeNext(info);
        }
    }

}

