package com.solar4america;

import com.kangaroohy.milo.service.MiloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class JavaMyreportsPcApplicationTests {

    @Autowired
    MiloService miloService;

    @Test
    public void writeToOpcUa() throws Exception {
//        System.out.println(miloService.readFromOpcUa("EM20300").getValue());
        System.out.println("ok");
    }

}
