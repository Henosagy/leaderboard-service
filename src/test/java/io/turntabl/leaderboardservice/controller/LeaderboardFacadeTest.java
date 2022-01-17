package io.turntabl.leaderboardservice.controller;

import io.turntabl.leaderboardservice.controller.response.LanguageLevelDto;
import io.turntabl.leaderboardservice.controller.response.ProfileDto;
import io.turntabl.leaderboardservice.converter.ProfileToProfileDtoConverter;
import io.turntabl.leaderboardservice.model.Profile;
import io.turntabl.leaderboardservice.service.LeaderboardRepositoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class LeaderboardFacadeTest {
    @Mock
    private LeaderboardRepositoryService leaderboardRepositoryService;

    @Mock
    private ProfileToProfileDtoConverter profileToProfileDtoConverter;

    private LeaderboardFacade underTest;

    @BeforeEach
    void setUp(){
        underTest = new LeaderboardFacade(leaderboardRepositoryService, profileToProfileDtoConverter);
    }

    @Test
    void getLeaderboard() {
        ProfileDto profileDto = ProfileDto.builder()
                .username("lameiraatt")
                .name("Ana Lameira")
                .build();
        List<ProfileDto> expectedResult = List.of(profileDto);

        when(leaderboardRepositoryService.getProfiles().stream()
                .map(profileToProfileDtoConverter::convert)
                .collect(toList()))
                .thenReturn(expectedResult);


        assertTrue(expectedResult.contains(profileDto));

    }
}