package dev.vinicius.elifoot.mapper;

import dev.vinicius.elifoot.controller.request.StadiumRequest;
import dev.vinicius.elifoot.controller.response.StadiumResponse;
import dev.vinicius.elifoot.entity.Stadium;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class StadiumMapperTest {
    private final StadiumMapper mapper = Mappers.getMapper(StadiumMapper.class);

    @Test
    @DisplayName("It should map stadium to stadium response correctly")
    void toResponse() {
        Stadium stadium = Stadium.builder()
                .id(UUID.randomUUID())
                .name("est sint consectetur")
                .capacity(25_000)
                .city("et ea")
                .urlImg("https://placehold.co/600x400")
                .build();
        StadiumResponse stadiumResponse = this.mapper.toResponse(stadium);

        assertNotNull(stadiumResponse);
        assertEquals(stadium.getId(), stadiumResponse.getId());
        assertEquals(stadium.getName(), stadiumResponse.getName());
        assertEquals(stadium.getCapacity(), stadiumResponse.getCapacity());
        assertEquals(stadium.getCity(), stadiumResponse.getCity());
        assertEquals(stadium.getUrlImg(), stadiumResponse.getUrlImg());
    }

    @Test
    @DisplayName("It should map stadium to stadium domain correctly")
    void toDomain() {
        StadiumRequest stadiumRequest = StadiumRequest.builder()
                .name("est sint consectetur")
                .capacity(25_000)
                .city("et ea")
                .urlImg("https://placehold.co/600x400")
                .build();

        Stadium stadium = this.mapper.toDomain(stadiumRequest);

        assertNotNull(stadium);
        assertEquals(stadium.getName(), stadiumRequest.getName());
        assertEquals(stadium.getCapacity(), stadiumRequest.getCapacity());
        assertEquals(stadium.getCity(), stadiumRequest.getCity());
        assertEquals(stadium.getUrlImg(), stadiumRequest.getUrlImg());


    }
}