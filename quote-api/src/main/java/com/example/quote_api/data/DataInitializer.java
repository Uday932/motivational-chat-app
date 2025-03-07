package com.example.quote_api.data;

import java.util.List;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import com.example.quote_api.model.Quote;
import com.example.quote_api.repository.QuoteRepository;

@Component
public class DataInitializer {

	private final QuoteRepository quoteRepository;

    public DataInitializer(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }
    
    @PostConstruct
    public void init() {
        if (quoteRepository.count() == 0) {
            quoteRepository.saveAll(List.of(
                    new Quote("Le succès n'est pas la clé du bonheur. Le bonheur est la clé du succès."),
                    new Quote("La vie est un mystère qu'il faut vivre, et non un problème à résoudre."),
                    new Quote("Le courage n'est pas l'absence de peur, mais la capacité de vaincre ce qui fait peur."),
                    new Quote("La meilleure façon de réaliser l'impossible est de croire que c'est possible."),
                    new Quote("Le succès est souvent atteint par ceux qui ne savent pas que l'échec est inévitable."),
                    new Quote("La vie commence à la fin de votre zone de confort."),
                    new Quote("Le plus grand échec est de ne jamais avoir essayé."),
                    new Quote("La seule façon de faire du bon travail est d'aimer ce que vous faites."),
                    new Quote("Le succès est la somme de petits efforts, répétés jour après jour."),
                    new Quote("Ce n'est pas parce que les choses sont difficiles que nous n'osons pas, c'est parce que nous n'osons pas qu'elles sont difficiles."),
                    new Quote("Le meilleur moyen de prédire l'avenir est de le créer."),
                    new Quote("La vie est un défi à relever, un bonheur à mériter, une aventure à tenter."),
                    new Quote("Le plus grand risque est de ne prendre aucun risque."),
                    new Quote("La seule limite à notre épanouissement de demain sera nos doutes d'aujourd'hui."),
                    new Quote("Le bonheur n'est pas quelque chose de tout fait. Il vient de vos propres actions."),
                    new Quote("Ce qui ne te tue pas te rend plus fort."),
                    new Quote("La persévérance est la clé du succès."),
                    new Quote("Chaque jour est une nouvelle opportunité."),
                    new Quote("Ne rêve pas ta vie, vis tes rêves."),
                    new Quote("Le succès, c'est tomber sept fois, se relever huit."),
                    new Quote("La vie est un mystère qu'il faut vivre, et non un problème à résoudre."),
                    new Quote("Le courage n'est pas l'absence de peur, mais la capacité de vaincre ce qui fait peur."),
                    new Quote("La meilleure façon de réaliser l'impossible est de croire que c'est possible."),
                    new Quote("Le succès n'est pas la clé du bonheur. Le bonheur est la clé du succès."),
                    new Quote("La vie commence à la fin de votre zone de confort."),
                    new Quote("Le plus grand échec est de ne jamais avoir essayé."),
                    new Quote("La seule façon de faire du bon travail est d'aimer ce que vous faites.")
            ));
        }
    }
}
