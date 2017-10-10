package com.serviceinfotech;

import com.serviceinfotech.utils.DateConvertor;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;


@RunWith(SpringRunner.class)
@EnableAutoConfiguration
public class DateConversionIntegrationTest {

    @Autowired
    DateConvertor dateConvertor;

    @Test
    public void shouldConvertDateToXMLDate() throws Exception {
        XMLGregorianCalendar xmlGregorianCalendar = dateConvertor.format(new Date());
        Assertions.assertThat(xmlGregorianCalendar.getYear()).isEqualTo(2017);

    }
}




