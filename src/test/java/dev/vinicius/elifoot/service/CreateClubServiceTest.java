package dev.vinicius.elifoot.service;

import dev.vinicius.elifoot.controller.request.ClubRequest;
import dev.vinicius.elifoot.controller.response.ClubDetailsResponse;
import dev.vinicius.elifoot.controller.response.StadiumResponse;
import dev.vinicius.elifoot.entity.Club;
import dev.vinicius.elifoot.entity.Stadium;
import dev.vinicius.elifoot.mapper.ClubMapper;
import dev.vinicius.elifoot.repository.ClubRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class CreateClubServiceTest {
    @InjectMocks
    CreateClubService createClubService;

    @Mock
    ClubRepository clubRepository;

    @Mock
    ClubMapper clubMapper;

    @Mock
    FindStadiumService findStadiumService;

    @Test
    void execute(){
        ClubRequest clubRequest = ClubRequest.builder()
                .name("Club excepteur pariatur")
                .founded(LocalDate.of(1958, 4, 24))
                .urlImg("http://example.com/image.png")
                .stadiumId(UUID.randomUUID())
                .build();

        Stadium stadium = Stadium.builder()
                .id(UUID.randomUUID())
                .name("est sint consectetur")
                .capacity(25_000)
                .city("et ea")
                .urlImg("https://placehold.co/600x400")
                .build();

        Club club = Club.builder()
                .id(UUID.randomUUID())
                .name(clubRequest.getName())
                .founded(clubRequest.getFounded())
                .urlImg(clubRequest.getUrlImg())
                .createdAt(LocalDateTime.now())
                .stadium(stadium)
                .active(true)
                .build();

        StadiumResponse stadiumResponse = StadiumResponse.builder()
                .id(stadium.getId())
                .name(stadium.getName())
                .city(stadium.getCity())
                .capacity(stadium.getCapacity())
                .urlImg(stadium.getUrlImg())
                .build();

        Mockito.when(this.findStadiumService.findById(clubRequest.getStadiumId().toString())).thenReturn(Optional.of(stadiumResponse));

        Mockito.when(this.clubMapper.toDomain(clubRequest)).thenReturn(club);
        ClubDetailsResponse clubDetailsResponse = this.createClubService.create(clubRequest);


    }
}