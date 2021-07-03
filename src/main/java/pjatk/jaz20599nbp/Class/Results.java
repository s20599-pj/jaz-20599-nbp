package pjatk.jaz20599nbp.Class;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Results
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String currency;
    private String start_date;
    private String end_date;
    private double average;
    private LocalDateTime query_date;

    public Results(String currency, String start_date, String end_date, double average, LocalDateTime query_date)
    {
        this.currency = currency;
        this.start_date = start_date;
        this.end_date = end_date;
        this.average = average;
        this.query_date = query_date;
    }

    public Results()
    {
    }

    public Results(Long id, String currency, String start_date, String end_date, double average, LocalDateTime query_date)
    {
        this.id = id;
        this.currency = currency;
        this.start_date = start_date;
        this.end_date = end_date;
        this.average = average;
        this.query_date = query_date;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getCurrency()
    {
        return currency;
    }

    public void setCurrency(String currency)
    {
        this.currency = currency;
    }

    public String getStart_date()
    {
        return start_date;
    }

    public void setStart_date(String start_date)
    {
        this.start_date = start_date;
    }

    public String getEnd_date()
    {
        return end_date;
    }

    public void setEnd_date(String end_date)
    {
        this.end_date = end_date;
    }

    public double getAverage()
    {
        return average;
    }

    public void setAverage(double average)
    {
        this.average = average;
    }

    public LocalDateTime getQuery_date()
    {
        return query_date;
    }

    public void setQuery_date(LocalDateTime query_date)
    {
        this.query_date = query_date;
    }
}
