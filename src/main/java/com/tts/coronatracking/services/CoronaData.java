package com.tts.coronatracking.services;

import com.tts.coronatracking.stats.StateStats;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CoronaData {
    private String RAW_VIRUS_DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_daily_reports_us/02-03-2021.csv";
    private ArrayList<StateStats> statList = new ArrayList<>();

    public ArrayList<StateStats> getStatList() {
        return statList;
    }

    @PostConstruct
    //@Scheduled(cron = "001000")
    public void fetchCoronaData() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(RAW_VIRUS_DATA_URL)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        // System.out.print(response.body());
        StringReader reader = new StringReader(response.body());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);
        for (CSVRecord record : records) {
            StateStats statsByState = new StateStats();
            statsByState.setState(record.get("Province_State"));
            statsByState.setCountry(record.get("Country_Region"));
            statsByState.setUpdatedCases(Integer.parseInt(record.get("Confirmed")));
            statsByState.setDeaths(record.get("Deaths"));
            statsByState.setRecoveries(record.get("Recovered"));
            System.out.println(statsByState + "\n");
            statList.add(statsByState);
        }

    }

}
