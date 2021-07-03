package pjatk.jaz20599nbp.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pjatk.jaz20599nbp.Class.Root;

@Service
public class NbpService
{
    private final RestTemplate restTemplate;

    public NbpService(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

    public Double getAvgRate(String currency, String start_date, String end_date)
    {
        String url = "http://api.nbp.pl/api/exchangerates/rates/a/" + currency + "/" + start_date +"/" + end_date;
        Root root = restTemplate.getForObject(url, Root.class);
        return root.getRates()
                .stream()
                .mapToDouble(x->x.getMid())
                .average().orElse(0.0);
    }
}
