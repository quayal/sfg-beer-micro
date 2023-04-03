package dev.adriangrzebyk.sfgbeermicro.bootstrap;

import dev.adriangrzebyk.sfgbeermicro.domain.Beer;
import dev.adriangrzebyk.sfgbeermicro.repositories.BeerRepository;
import dev.adriangrzebyk.sfgbeermicro.web.model.BeerStyle;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if (beerRepository.count() == 0) {
            beerRepository.save(Beer.builder()
                    .beerName("Mango Bobs")
                    .beerStyle(BeerStyle.IPA)
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(3370100000001L)
                    .price(new BigDecimal("12.95"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle(BeerStyle.PALE_ALE)
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(3370100000002L)
                    .price(new BigDecimal("11.95"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Thunder Ace")
                    .beerStyle(BeerStyle.IPA)
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(3370100000003L)
                    .price(new BigDecimal("10.95"))
                    .build());
        }

        System.out.println("Loaded beers: " + beerRepository.count());
    }
}
