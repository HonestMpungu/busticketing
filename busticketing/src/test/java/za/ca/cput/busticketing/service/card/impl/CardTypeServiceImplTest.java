package za.ca.cput.busticketing.service.card.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import za.ca.cput.busticketing.entity.card.Card;
import za.ca.cput.busticketing.repository.card.CardRepository;
import za.ca.cput.busticketing.service.card.CardService;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CardTypeServiceImplTest {

    @Mock
    private CardRepository repository;

    private CardService service;
    private Card card;

    @BeforeEach
    void setup() {
        assertNotNull(repository);
        //this.card = CardFactory.build("Yellow", "Card ");
        //service = new CardServiceImpl(repository);
    }

    @Test
    void getAll() {
    }

    @Test
    void getByID() {
    }

    @Test
    void save() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}