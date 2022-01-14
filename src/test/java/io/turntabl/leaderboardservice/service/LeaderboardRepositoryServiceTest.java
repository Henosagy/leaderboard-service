package io.turntabl.leaderboardservice.service;

import io.turntabl.leaderboardservice.model.Profile;
import io.turntabl.leaderboardservice.repository.ProfileRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static  org.mockito.Mockito.mock;
import static  org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LeaderboardRepositoryServiceTest {
    @Mock
    private ProfileRepository profileRepository;

    private LeaderboardRepositoryService underTest;

    @BeforeEach
    void setUp(){
        underTest = new LeaderboardRepositoryService(profileRepository);
    }

    @Test
    void shouldGetProfiles() {
        Profile profile1 = mock(Profile.class);
        Profile profile2 = mock(Profile.class);
        when(profileRepository.findAll()).thenReturn(List.of(profile1, profile2));

//        assertEquals(profileRepository.findAll(), underTest.getProfiles());
        List<Profile> result = underTest.getProfiles();

        assertThat(result).containsExactlyInAnyOrder(profile1,profile2);
    }
}