package com.ssde.tutorials.restmvc.bootstrap;

import com.ssde.tutorials.restmvc.entities.Beer;
import com.ssde.tutorials.restmvc.entities.Customer;
import com.ssde.tutorials.restmvc.model.BeerStyle;
import com.ssde.tutorials.restmvc.repositories.BeerRepository;
import com.ssde.tutorials.restmvc.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * Created by jra, SSDE, Inc
 * on Wed 1/10/24 at 4:54 PM. rest-mvc
 */
@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private final BeerRepository beerRepository;
    private final CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        loadBeerData();
        loadCustomerData();

        System.out.println("In bootstrap");
        System.out.println("Beer count: "+beerRepository.count());
        System.out.println("Customer count: "+customerRepository.count());
    }

    private void loadCustomerData(){
        if(customerRepository.count()==0) {
            Customer customer1 = Customer.builder()
                    .name("Customer 1")
                    .createdDate(LocalDateTime.now())
                    .lastModifiedDate(LocalDateTime.now())
                    .build();

            Customer customer2 = Customer.builder()
                    .name("Customer 2")
                    .createdDate(LocalDateTime.now())
                    .lastModifiedDate(LocalDateTime.now())
                    .build();

            Customer customer3 = Customer.builder()
                    .name("Customer 3")
                    .createdDate(LocalDateTime.now())
                    .lastModifiedDate(LocalDateTime.now())
                    .build();

            customerRepository.saveAll(Arrays.asList(customer1,customer2,customer3));
        }
    }

    private void loadBeerData(){
        if(beerRepository.count()==0){
            Beer beer1 = Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle(BeerStyle.PALE_ALE)
                    .upc("12356")
                    .price(new BigDecimal("12.99"))
                    .quantityOnHand(122)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            Beer beer2 = Beer.builder()
                    .beerName("Crank")
                    .beerStyle(BeerStyle.PALE_ALE)
                    .upc("12356222")
                    .price(new BigDecimal("11.99"))
                    .quantityOnHand(392)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            Beer beer3 = Beer.builder()
                    .beerName("Sunshine City")
                    .beerStyle(BeerStyle.IPA)
                    .upc("12356")
                    .price(new BigDecimal("13.99"))
                    .quantityOnHand(144)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            Beer beer4 = Beer.builder()
                    .beerName("Guiness")
                    .beerStyle(BeerStyle.STOUT)
                    .upc("123456")
                    .price(new BigDecimal("9.99"))
                    .quantityOnHand(50)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            beerRepository.saveAll(Arrays.asList(beer1,beer2,beer3,beer4));
        }
    }
}
