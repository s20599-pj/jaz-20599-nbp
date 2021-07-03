package pjatk.jaz20599nbp.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pjatk.jaz20599nbp.Service.NbpService;

@RestController
@RequestMapping("/nbp")
public class NbpController
{
    private NbpService nbpService;

    public NbpController(NbpService nbpService)
    {
        this.nbpService = nbpService;
    }

    @GetMapping("/{currency}/{start_date}/{end_date}")
    public ResponseEntity<Double> getAverageFromSelectedDays(
            @PathVariable String currency,
            @PathVariable String start_date,
            @PathVariable String end_date)
    {
        return ResponseEntity.ok(nbpService.getAvgRate(currency, start_date, end_date));
    }
}
