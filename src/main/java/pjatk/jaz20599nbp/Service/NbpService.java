package pjatk.jaz20599nbp.Service;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pjatk.jaz20599nbp.Class.Results;
import pjatk.jaz20599nbp.Class.Root;
import pjatk.jaz20599nbp.Repository.NbpRepository;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class NbpService
{
    private final RestTemplate restTemplate;
    private final NbpRepository nbpRepository;

    public NbpService(RestTemplate restTemplate, NbpRepository nbpRepository)
    {
        this.restTemplate = restTemplate;
        this.nbpRepository = nbpRepository;
    }

    public Double getAvgRate(String currency, String start_date, String end_date)
    {
        String url = "http://api.nbp.pl/api/exchangerates/rates/a/" + currency + "/" + start_date +"/" + end_date;
        Root root = restTemplate.getForObject(url, Root.class);
        Double average = root.getRates().stream().mapToDouble(x->x.getMid()).average().orElse(0.0);
        Results results = new Results(root.getCurrency(), start_date, end_date, average, LocalDateTime.now());
        nbpRepository.save(results);
        return average;
    }
}
